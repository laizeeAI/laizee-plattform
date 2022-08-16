package de.fhaachen.service.impl;

import de.fhaachen.model.Entity;
import de.fhaachen.model.ResponseResultPair;
import de.fhaachen.model.Result;
import de.fhaachen.model.generated.AnalyzeResponse;
import de.fhaachen.model.generated.AnyOfAnalyzeResponseEntitiesItems;
import de.fhaachen.model.generated.TokenBasedEntity;
import de.fhaachen.service.ResultMappingService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This Service class defines methods for result mapping.
 */
@Service
public class GenericResultMappingServiceImpl implements ResultMappingService {

    private static final Logger LOGGER = Logger.getLogger(GenericResultMappingServiceImpl.class);

    public List<ResponseResultPair> mapResultsToOwnDataModel(List<AnalyzeResponse> responses, List<String> labels) {
        //LOGGER.info(LoggerConstants.SEPARATOR);
        //LOGGER.info("# Mapping results to data model...");
        List<ResponseResultPair> results = new ArrayList<>();
        responses.forEach(value -> {
            List<AnyOfAnalyzeResponseEntitiesItems> anyOfAnalyzeResponseEntitiesItems = value.getEntities();
            Result resultActual = new Result();

            anyOfAnalyzeResponseEntitiesItems.stream().map(item -> (TokenBasedEntity) item).forEach(tokenBasedEntity -> {
                String labelName = tokenBasedEntity.getLabel();
                String mappedLabel = mapLabel(labels, labelName);
                if (mappedLabel != null) {
                    resultActual.addAttribute(mappedLabel, new Entity(tokenBasedEntity.getText()));
                } else{
                    resultActual.addAttribute(labelName, new Entity(tokenBasedEntity.getText()));
                }
            });
            if (resultActual.getAttributeMap().size() == 0) {
                results.add(new ResponseResultPair(value, resultActual, false));
            } else {
                results.add(new ResponseResultPair(value, resultActual));
            }
        });


        //LOGGER.info("# Mapping complete!");
        //LOGGER.info(LoggerConstants.SEPARATOR);
        return results;
    }

    private String mapLabel(List<String> labels, String labelName) {
        if (labels.contains(labelName)) {
            return labelName;
        }
        return null;
    }

}
