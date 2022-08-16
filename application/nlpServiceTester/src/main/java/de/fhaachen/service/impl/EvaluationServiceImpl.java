package de.fhaachen.service.impl;

import de.fhaachen.constants.LoggerConstants;
import de.fhaachen.model.Data;
import de.fhaachen.model.Entity;
import de.fhaachen.model.ResponseResultPair;
import de.fhaachen.model.Result;
import de.fhaachen.service.EvaluationService;
import de.fhaachen.util.ListUtil;
import org.apache.commons.lang3.tuple.Triple;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * This Service class defines methods for result evaluation.
 */
@Service
public class EvaluationServiceImpl implements EvaluationService {

    private static final Logger LOGGER = Logger.getLogger(EvaluationServiceImpl.class);

    @Override
    public List<Triple<Data, ResponseResultPair, Boolean>> evaluateMappedResults(List<Data> data,
                                                                                 List<ResponseResultPair> resultsToCompare) {
        //LOGGER.info("# Evaluating results...");
        List<Triple<Data, ResponseResultPair, Boolean>> finalResults = new ArrayList<>();
        IntStream.range(0, data.size()).forEachOrdered(i -> {
            ResponseResultPair responseResultPair = resultsToCompare.get(i);
            Result resultExpected = responseResultPair.getRight();
            Data dataActual = data.get(i);
            Result resultActual = dataActual.getResult();
            boolean comparisonResult = compareActualWithExpected(resultActual, resultExpected);
            finalResults.add(Triple.of(dataActual, responseResultPair, comparisonResult));
        });
        //LOGGER.info("# Evaluation complete!");
        return finalResults;
    }

    @Override
    public void printFinalResults(List<Triple<Data, ResponseResultPair, Boolean>> finalResults) {
        LOGGER.info(LoggerConstants.SEPARATOR);
        // LOGGER.info("# Printing final results...");
        AtomicInteger correctResultsCounter = new AtomicInteger();
        finalResults.forEach(data -> {
            if (data.getRight()) {
                correctResultsCounter.getAndIncrement();
            }
        });
        int amountData = finalResults.size();
        LOGGER.info("# " + "Analyzed " + amountData + " Datasets!");
        LOGGER.info("# " + correctResultsCounter + " of " + amountData + " Datasets correct!");

        AtomicInteger currentResultCounter = new AtomicInteger(1);
        finalResults.forEach(data -> {
            LOGGER.info(LoggerConstants.SEPARATOR);
            LOGGER.info("# Analyzed Text:");
            LOGGER.info("# " + data.getLeft().getInputText().getMessage());
            LOGGER.info(LoggerConstants.SEPARATOR);
            LOGGER.info("# Results for Dataset " + currentResultCounter);

            if (!data.getRight()) {
                printDifferences(data.getLeft().getResult(), data.getMiddle().getRight());
            }
            currentResultCounter.getAndIncrement();
            if (currentResultCounter.get() == finalResults.size() + 1) {
                LOGGER.info(LoggerConstants.SEPARATOR);
            }
        });
    }

    private boolean compareActualWithExpected(Result resultActual, Result resultExpected) {
        if (resultExpected.getAttributeMap().size() == 0) {
            return false;
        }
        return resultActual.equals(resultExpected);
    }

    private void printDifferences(Result resultExpected, Result resultActual) {
        Map<String, List<Entity>> actualResults = resultActual.getAttributeMap();
        Map<String, List<Entity>> expectedResults = resultExpected.getAttributeMap();

        if (expectedResults.size() == 0) {
            LOGGER.info("# No Results provided.");
        }

        expectedResults.forEach((key, entities) -> {
            LOGGER.info("# Results for Label '" + key + "':");
            LOGGER.info("# Expected: " + ListUtil.entityListToString(entities));
            LOGGER.info("# Got: " + ListUtil.entityListToString(actualResults.get(key)));
        });

    }

}
