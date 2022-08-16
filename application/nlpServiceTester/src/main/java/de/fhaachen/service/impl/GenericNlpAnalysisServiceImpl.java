package de.fhaachen.service.impl;

import de.fhaachen.api.DefaultApi;
import de.fhaachen.constants.LoggerConstants;
import de.fhaachen.model.generated.AnalyzeRequest;
import de.fhaachen.model.generated.AnalyzeResponse;
import de.fhaachen.model.generated.AnyOfAnalyzeResponseEntitiesItems;
import de.fhaachen.model.generated.TokenBasedEntity;
import de.fhaachen.model.login.LoginResult;
import de.fhaachen.service.AnalysisService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

/**
 * This Service class defines methods for analyzing data by calling the nlp services.
 */
@Service
public class GenericNlpAnalysisServiceImpl implements AnalysisService {

    private static final Logger LOGGER = Logger.getLogger(GenericNlpAnalysisServiceImpl.class);

    private final DefaultApi defaultApi;

    @Autowired
    public GenericNlpAnalysisServiceImpl(DefaultApi defaultApi) {
        this.defaultApi = defaultApi;
    }

    @Override
    public List<AnalyzeResponse> analyzeData(List<AnalyzeRequest> analyzeRequests,
                                             LoginResult loginResult,
                                             String projectId,
                                             String serviceName) {
        List<AnalyzeResponse> responses = new ArrayList<>();
        analyzeRequests.forEach(value -> {
            AnalyzeResponse analyzeResponses=null;
            try {
                LOGGER.info(LoggerConstants.SEPARATOR);
                LOGGER.info("# Sending Text: ");
                LOGGER.info("# " + value.getText());
                LOGGER.info("#");
                analyzeResponses = defaultApi.analyzeAnalyzePost(value, loginResult, projectId, serviceName).get(0);
                LOGGER.info("# Received Results from NLP Service:");
                boolean first = true;
                for (AnyOfAnalyzeResponseEntitiesItems item : analyzeResponses.getEntities()) {
                    first = false;
                    TokenBasedEntity tokenBasedEntity = (TokenBasedEntity) item;
                    LOGGER.info("# Detected Text: " + tokenBasedEntity.getText() + " - Label: " + tokenBasedEntity.getLabel());
                }
                if (first) {
                    LOGGER.info(LoggerConstants.SEPARATOR);
                }
            } catch (ResourceAccessException e) {
                LOGGER.error("Nlp-Service is not available. Check URL and your network connection.");
                System.exit(0);
            } catch (HttpClientErrorException e) {
                LOGGER.error("No deployed Nlp-Service is not available. Check service name and project id");
                System.exit(0);
            }
            responses.add(analyzeResponses);
        });

        return responses;
    }
}
