package de.laizee.service;

import de.laizee.model.ResponseResultPair;
import de.laizee.model.generated.AnalyzeResponse;

import java.util.List;

/**
 * This interface defines methods for result mapping.
 */
public interface ResultMappingService {

    /**
     * Maps the results from nlp service received results with labels to own data model and returns them as list.
     *
     * @param responses given results from the nlp service
     * @param labels    given labels
     * @return list of {@link ResponseResultPair}
     */
    List<ResponseResultPair> mapResultsToOwnDataModel(List<AnalyzeResponse> responses, List<String> labels);

}
