package de.fhaachen.service.impl;

import de.fhaachen.model.Data;
import de.fhaachen.model.generated.AnalyzeRequest;
import de.fhaachen.model.generated.TaskEnum;
import de.fhaachen.service.DataService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * This Service class defines methods for data preparation and extraction.
 */
@Service
public class GenericDataServiceImpl implements DataService {
    @Override
    public List<AnalyzeRequest> prepareData(Collection<Data> dataCollection) {
        List<AnalyzeRequest> analyzeRequests = new ArrayList<>();
        dataCollection.forEach(data -> {
            AnalyzeRequest request = new AnalyzeRequest();
            request.setText(data.getInputText().getMessage());
            request.setTasks(Arrays.asList(TaskEnum.NER));
            analyzeRequests.add(request);
        });
        return analyzeRequests;
    }

    @Override
    public List<String> getDataLabels(Collection<Data> testData) {
        List<String> labels = new ArrayList<>();

        testData.forEach(data -> {
            Set<String> keySet = data.getResult().getAttributeMap().keySet();
            keySet.forEach(key -> {
                if (!labels.contains(key)) {
                    labels.add(key);
                }
            });
        });

        return labels;
    }
}
