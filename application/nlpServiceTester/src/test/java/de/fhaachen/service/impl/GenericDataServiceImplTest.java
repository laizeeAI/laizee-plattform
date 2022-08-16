package de.fhaachen.service.impl;

import de.fhaachen.model.Data;
import de.fhaachen.model.Entity;
import de.fhaachen.model.InputText;
import de.fhaachen.model.Result;
import de.fhaachen.model.generated.AnalyzeRequest;
import de.fhaachen.model.generated.TaskEnum;
import de.fhaachen.service.DataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class GenericDataServiceImplTest {

    @Autowired
    private DataService dataService;

    private Data dataObject1, dataObject2;

    private AnalyzeRequest analyzeRequest1, analyzeRequest2;

    private List<Data> dataCollection;
    private List<AnalyzeRequest> analyzeRequests;
    private List<String> labels;

    @BeforeEach
    void init() {
        prepareData();
    }

    @Test
    public void should_prepare_data() {
        List<AnalyzeRequest> list = dataService.prepareData(dataCollection);

        assertThat(list, equalTo(analyzeRequests));
    }

    @Test
    public void should_not_prepare_data_emptyList() {
        List<AnalyzeRequest> list = dataService.prepareData(new ArrayList<>());

        assertThat(list, equalTo(new ArrayList<>()));
    }

    @Test
    public void should_get_dataLabels() {
        List<String> labelExtracted = dataService.getDataLabels(dataCollection);

        assertThat(labelExtracted, equalTo(labels));
    }

    @Test
    public void should_not_get_dataLabels_emptyList() {
        List<String> labelExtracted = dataService.getDataLabels(new ArrayList<>());

        assertThat(labelExtracted, equalTo(new ArrayList<>()));
    }

    private void prepareData() {
        Result result1 = new Result();
        result1.addAttribute("place", new Entity("Cologne"));
        result1.addAttribute("place", new Entity("Hamburg"));
        result1.addAttribute("dateTime", new Entity("31.08.1972"));
        result1.addAttribute("dateTime", new Entity("December"));
        result1.addAttribute("product", new Entity("first class"));
        dataObject1 = new Data(
                new InputText("Yesterday, 31.08.1972, I was travelling from Cologne to Hamburg first class. Next time I will travel in December"),
                result1
        );
        Result result2 = new Result();
        result1.addAttribute("place", new Entity("New York"));
        result1.addAttribute("product", new Entity("good-night ticket"));
        dataObject2 = new Data(
                new InputText("I will go to New York with good-night ticket"),
                result2
        );

        analyzeRequest1 = prepareData(dataObject1);
        analyzeRequest2 = prepareData(dataObject2);

        labels = new ArrayList<>(Arrays.asList("place", "dateTime", "product"));
        dataCollection = new ArrayList<>(Arrays.asList(dataObject1, dataObject2));
        analyzeRequests = new ArrayList<>(Arrays.asList(analyzeRequest1, analyzeRequest2));
    }

    private AnalyzeRequest prepareData(Data data) {
        AnalyzeRequest request = new AnalyzeRequest();
        request.setText(data.getInputText().getMessage());
        request.setTasks(Arrays.asList(TaskEnum.NER));
        return request;
    }


    @Configuration
    public static class GenericDataServiceImplTestConfig {

        @Bean
        public DataService dataService() {
            return new GenericDataServiceImpl();
        }
    }
}