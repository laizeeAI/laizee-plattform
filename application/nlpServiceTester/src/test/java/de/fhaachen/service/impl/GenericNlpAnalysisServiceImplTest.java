package de.fhaachen.service.impl;

import de.fhaachen.api.DefaultApi;
import de.fhaachen.handler.ApiClient;
import de.fhaachen.model.Data;
import de.fhaachen.model.Entity;
import de.fhaachen.model.InputText;
import de.fhaachen.model.Result;
import de.fhaachen.model.generated.*;
import de.fhaachen.service.AnalysisService;
import de.fhaachen.service.DataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class GenericNlpAnalysisServiceImplTest {

    private List<AnalyzeRequest> analyzeRequests;
    private List<AnalyzeResponse> analyzeResponses;
    private Data dataObject1;
    private AnalyzeResponse response1;


    RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

    @Autowired
    private AnalysisService analysisService;

    @Autowired
    private DataService dataService;

    @Autowired
    private DefaultApi defaultApi;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);

        prepareTestData();
    }

    @Test
    public void should_analyzeRequests() {
        ResponseEntity<AnalyzeResponse> responseEntity = new ResponseEntity<>(response1, HttpStatus.OK);

        List<Data> testData = new ArrayList(Arrays.asList(dataObject1));

        List<AnalyzeRequest> analyzeRequests =
                dataService.prepareData(testData);

        when(restTemplate.exchange(
                Mockito.any(),
                ArgumentMatchers.<ParameterizedTypeReference<AnalyzeResponse>>any()
        )).thenReturn(responseEntity);

        ApiClient apiClient = new ApiClient(restTemplate);
        defaultApi = new DefaultApi(apiClient);
        apiClient.setBasePath("https://localhost:8080/");
        //defaultApi.setAuthentication("");

        ResponseEntity<List<AnalyzeResponse>> responses =
                new ResponseEntity<>(new ArrayList<>(Arrays.asList(response1)), HttpStatus.OK);
        when(defaultApi.analyzeAnalyzePostWithHttpInfo(analyzeRequests.get(0), null, "1", "test")).thenReturn(responses);

//        List<AnalyzeResponse> response = analysisService.analyzeData(analyzeRequests, null);
//
//        assertThat(response.get(0), not(equalTo(null)));
//        assertThat(response.get(0).getText(), equalTo(dataObject1.getInputText().getMessage()));
//        assertThat(response.get(0).getEntities().size(), equalTo(5));
    }

    private AnalyzeRequest prepareData(Data data) {
        AnalyzeRequest request = new AnalyzeRequest();
        request.setText(data.getInputText().getMessage());
        request.setTasks(Arrays.asList(TaskEnum.NER));
        return request;
    }

    private void prepareTestData() {
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
        AnalyzeRequest analyzeRequest1 = prepareData(dataObject1);
        analyzeRequests = new ArrayList<>();
        analyzeRequests.add(analyzeRequest1);

        TokenBasedEntity response1Token1 = new TokenBasedEntity();
        response1Token1.setText("Cologne");
        response1Token1.setLabel("place");
        TokenBasedEntity response1Token2 = new TokenBasedEntity();
        response1Token2.setText("Hamburg");
        response1Token2.setLabel("place");
        TokenBasedEntity response1Token3 = new TokenBasedEntity();
        response1Token3.setText("31.08.1972");
        response1Token3.setLabel("dateTime");
        TokenBasedEntity response1Token4 = new TokenBasedEntity();
        response1Token4.setText("December");
        response1Token4.setLabel("dateTime");
        TokenBasedEntity response1Token5 = new TokenBasedEntity();
        response1Token5.setText("first class");
        response1Token5.setLabel("product");

        Category response1Category = new Category();
        response1Category.setScore(new BigDecimal(1.0));
        response1Category.setLabel("dissatisfied");

        response1 = new AnalyzeResponse();
        response1.setText(dataObject1.getInputText().getMessage());
        response1.setEntities(Arrays.asList(
                response1Token1,
                response1Token2,
                response1Token3,
                response1Token4,
                response1Token5
        ));
        response1.setCategories(List.of(response1Category));

        analyzeResponses = new ArrayList<>();
        analyzeResponses.add(response1);
    }

    @Configuration
    public static class GenericNlpAnalysisServiceImplTestConfig {

        @Bean
        public DataService dataService() {
            return new GenericDataServiceImpl();
        }

        @MockBean
        DefaultApi defaultApi;

        @Bean
        public AnalysisService analysisService(DefaultApi defaultApi) {
            return new GenericNlpAnalysisServiceImpl(defaultApi);
        }
    }
}