package de.laizee.service.impl;

import de.laizee.model.Entity;
import de.laizee.model.ResponseResultPair;
import de.laizee.model.Result;
import de.laizee.model.generated.AnalyzeResponse;
import de.laizee.model.generated.Category;
import de.laizee.model.generated.TokenBasedEntity;
import de.laizee.service.ResultMappingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class SpecificResultMappingServiceImplTest {

    @Autowired
    private ResultMappingService resultMappingService;

    private List<String> labels = new ArrayList<>(Arrays.asList("place", "dateTime", "product"));
    private List<AnalyzeResponse> responses;
    private List<ResponseResultPair> responseResultPairs;

    @BeforeEach
    void init() {
        prepareData();
    }

    @Test
    void should_MapResults() {
        List<ResponseResultPair> pairs = resultMappingService.mapResultsToOwnDataModel(responses, labels);

        assertThat(pairs.get(0).getLeft(), equalTo(responseResultPairs.get(0).getLeft()));
        assertThat(pairs.get(0).getRight(), equalTo(responseResultPairs.get(0).getRight()));
    }

    private void prepareData(){
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

        AnalyzeResponse response1 = new AnalyzeResponse();
        response1.setText("Yesterday, 31.08.1972, I was travelling from Cologne to Hamburg first class. Next time I will travel in December");
        response1.setEntities(Arrays.asList(
                response1Token1,
                response1Token2,
                response1Token3,
                response1Token4,
                response1Token5
        ));
        response1.setCategories(List.of(response1Category));
        responses = new ArrayList<>(Arrays.asList(response1));

        responseResultPairs = new ArrayList<>();

        Result result1 = new Result();
        result1.addAttribute("place", new Entity("Cologne"));
        result1.addAttribute("place", new Entity("Hamburg"));
        result1.addAttribute("dateTime", new Entity("31.08.1972"));
        result1.addAttribute("dateTime", new Entity("December"));
        result1.addAttribute("product", new Entity("first class"));

        responseResultPairs.add(new ResponseResultPair(response1, result1));
    }

    @Configuration
    public static class SpecificResultMappingServiceImplTestConfig {

        @Bean
        public ResultMappingService resultMappingService() {
            return new GenericResultMappingServiceImpl();
        }
    }
}