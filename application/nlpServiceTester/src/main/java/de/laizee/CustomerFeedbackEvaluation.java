package de.laizee;


import de.laizee.model.Data;
import de.laizee.model.ResponseResultPair;
import de.laizee.model.generated.AnalyzeRequest;
import de.laizee.model.generated.AnalyzeResponse;
import de.laizee.model.login.LoginRequest;
import de.laizee.model.login.LoginResult;
import de.laizee.service.*;
import org.apache.commons.lang3.tuple.Triple;
import org.apache.log4j.Logger;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.List;

/**
 * Main class of this application.
 */
@SpringBootApplication
public class CustomerFeedbackEvaluation implements CommandLineRunner {

    private static final CommandLineArguments ARGUMENTS = new CommandLineArguments();

    private static final Logger LOGGER = Logger.getLogger(CustomerFeedbackEvaluation.class);

    private final AnalysisService analysisService;

    private final EvaluationService evaluationService;

    private final JsonService jsonService;

    private final ResultMappingService resultMappingService;

    private final DataService dataService;

    private final FileService fileService;

    private final LoginService loginService;

    @Bean
    static CommandLineArguments arguments() {
        return ARGUMENTS;
    }

    @Autowired
    public CustomerFeedbackEvaluation(AnalysisService analysisService,
                                      EvaluationService evaluationService,
                                      JsonService jsonService,
                                      ResultMappingService resultMappingService,
                                      DataService dataService,
                                      FileService fileService,
                                      LoginService loginService) {
        this.analysisService = analysisService;
        this.evaluationService = evaluationService;
        this.jsonService = jsonService;
        this.resultMappingService = resultMappingService;
        this.dataService = dataService;
        this.fileService = fileService;
        this.loginService = loginService;
    }

    /**
     * Main entry point of this application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            new CmdLineParser(ARGUMENTS).parseArgument(args);
        } catch (CmdLineException e) {
            LOGGER.info("Could not parse command line arguments.", e);
            return;
        }
        SpringApplication.run(CustomerFeedbackEvaluation.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Authenticates user with given credentials
        LoginResult loginResult = loginService.authUserLogin(
                new LoginRequest(ARGUMENTS.getUsername(), ARGUMENTS.getPassword()));

        // Read given file
        File file = fileService.getFileFromName(ARGUMENTS.getFileName());

        // Extract data from file
        List<Data> testData = jsonService.readJsonFromFile(file);

        // Extract labels of data
        List<String> labels = dataService.getDataLabels(testData);

        // Prepares the data for analysis
        List<AnalyzeRequest> analyzeRequests = dataService.prepareData(testData);

        // Sends data to nlp server and receives analyzed data
        List<AnalyzeResponse> processedTestData = analysisService.analyzeData(analyzeRequests, loginResult, ARGUMENTS.getProjectId(), ARGUMENTS.getServiceName());

        // Maps the analyzed data to own data-model
        List<ResponseResultPair> mappedResults = resultMappingService.mapResultsToOwnDataModel(processedTestData, labels);

        // Evaluates actual results with expected results
        List<Triple<Data, ResponseResultPair, Boolean>> finalResults =
                evaluationService.evaluateMappedResults(testData, mappedResults);

        // Prints the final analysis result
        evaluationService.printFinalResults(finalResults);
    }

}