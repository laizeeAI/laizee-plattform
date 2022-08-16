package de.fhaachen;


import de.fhaachen.model.Data;
import de.fhaachen.model.ResponseResultPair;
import de.fhaachen.model.generated.AnalyzeRequest;
import de.fhaachen.model.generated.AnalyzeResponse;
import de.fhaachen.model.login.LoginRequest;
import de.fhaachen.model.login.LoginResult;
import de.fhaachen.service.*;
import lombok.SneakyThrows;
import org.apache.commons.lang3.tuple.Triple;
import org.apache.log4j.Logger;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * Main class of this application.
 */
@SpringBootApplication
public class CustomerFeedbackEvaluation implements CommandLineRunner {

    private static final CommandLineArguments ARGUMENTS = new CommandLineArguments();

    private static final Logger LOGGER = Logger.getLogger(CustomerFeedbackEvaluation.class);

    @Autowired
    private AnalysisService analysisService;

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private JsonService jsonService;

    @Autowired
    private ResultMappingService resultMappingService;

    @Autowired
    private DataService dataService;

    @Autowired
    private FileService fileService;

    @Autowired
    private LoginService loginService;

    @Bean
    static CommandLineArguments arguments() {
        return ARGUMENTS;
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
            LOGGER.error("Could not parse command line arguments.", e);
            logAdditionalInfo();
            return;
        }
        SpringApplication.run(CustomerFeedbackEvaluation.class, args);
    }

    @SneakyThrows(IOException.class)
    private static void logAdditionalInfo() {
        String decodedString;
        try (ByteArrayOutputStream outStream = new ByteArrayOutputStream()) {
            new CmdLineParser(ARGUMENTS).printUsage(outStream);
            decodedString = outStream.toString(StandardCharsets.UTF_8);
        }
        Arrays.stream(decodedString.split("\n")).forEach(LOGGER::info);
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