package de.fhaachen.service;

import de.fhaachen.model.generated.AnalyzeRequest;
import de.fhaachen.model.generated.AnalyzeResponse;
import de.fhaachen.model.login.LoginResult;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * This interface defines methods for analyzing data by calling the nlp services.
 */
public interface AnalysisService {

    /**
     * Sends a request to the nlp backend to analyze data.
     *
     * @param analyzeRequests given data to analyze
     * @param loginResult given login information
     * @param projectId given project id
     * @param serviceName given service name
     *
     * @return a list of analyzed data
     */
    List<AnalyzeResponse> analyzeData(List<AnalyzeRequest> analyzeRequests,
                                      LoginResult loginResult,
                                      String projectId,
                                      String serviceName);


}
