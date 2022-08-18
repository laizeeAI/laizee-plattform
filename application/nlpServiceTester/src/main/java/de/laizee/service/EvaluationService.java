package de.laizee.service;

import de.laizee.model.Data;
import de.laizee.model.ResponseResultPair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

/**
 * This interface defines methods for result evaluation.
 */
public interface EvaluationService {

    /**
     * Evaluates and returns a list of triple consisting of {@link Data}, {@link ResponseResultPair} and a {@link Boolean}.
     * The returned list shows weather the expected and actual results match.
     *
     * @param resultsToCompare given results to compare
     * @return List of Triple
     */
    List<Triple<Data, ResponseResultPair, Boolean>> evaluateMappedResults(List<Data> data,
                                                                          List<ResponseResultPair> resultsToCompare);

    /**
     * Prints all results on the console.
     *
     * @param finalResults given results to print
     */
    void printFinalResults(List<Triple<Data, ResponseResultPair, Boolean>> finalResults);
}
