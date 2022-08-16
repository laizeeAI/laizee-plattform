package de.fhaachen.service;

import de.fhaachen.model.Data;
import de.fhaachen.model.generated.AnalyzeRequest;

import java.util.Collection;
import java.util.List;

/**
 * This interface defines methods for data preparation and extraction.
 */
public interface DataService {

    /**
     * Prepares {@link de.fhaachen.model.Result} data from given data, converts them into an {@link AnalyzeRequest}
     * and returns a list of the converted data.
     *
     * @param dataCollection given data
     * @return List AnalyzeRequests
     */
    List<AnalyzeRequest> prepareData(Collection<Data> dataCollection);

    /**
     * Extract Labels as String from given data and returns it as list.
     *
     * @param testData given data
     * @return list of labels
     */
    List<String> getDataLabels(Collection<Data> testData);
}
