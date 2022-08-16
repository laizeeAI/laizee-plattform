package de.fhaachen.service.impl;

import de.fhaachen.model.*;
import de.fhaachen.model.generated.AnalyzeResponse;
import de.fhaachen.model.generated.Category;
import de.fhaachen.model.generated.TokenBasedEntity;
import de.fhaachen.service.EvaluationService;
import org.apache.commons.lang3.tuple.Triple;
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
class EvaluationServiceImplTest {

    @Autowired
    private EvaluationService evaluationService;

    private List<Data> dataListOne;
    private List<Data> dataListTwo;
    private List<ResponseResultPair> resultsToCompareOne;
    private List<ResponseResultPair> resultsToCompareTwo;

    @BeforeEach
    void init() {
        prepareData();
    }

    @Test
    void should_evaluateMappedResults_OneObject_true() {
        List<Triple<Data, ResponseResultPair, Boolean>> resultList
                = evaluationService.evaluateMappedResults(dataListOne, resultsToCompareOne);

        assertThat(resultList.get(0).getLeft(), equalTo(dataListOne.get(0)));
        assertThat(resultList.get(0).getMiddle(), equalTo(resultsToCompareOne.get(0)));
        assertThat(resultList.get(0).getRight(), equalTo(true));
    }

    @Test
    void should_evaluateMappedResults_MultipleObjects_trueAndFalse() {
        List<Triple<Data, ResponseResultPair, Boolean>> resultList
                = evaluationService.evaluateMappedResults(dataListTwo, resultsToCompareTwo);

        assertThat(resultList.get(0).getLeft(), equalTo(dataListTwo.get(0)));
        assertThat(resultList.get(0).getMiddle(), equalTo(resultsToCompareTwo.get(0)));
        assertThat(resultList.get(0).getRight(), equalTo(true));

        assertThat(resultList.get(1).getLeft(), equalTo(dataListTwo.get(1)));
        assertThat(resultList.get(1).getMiddle(), equalTo(resultsToCompareTwo.get(1)));
        assertThat(resultList.get(1).getRight(), equalTo(false));
    }

    @Test
    void should_printFinalResults() {
    }

    private void prepareData() {
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

        resultsToCompareOne = new ArrayList<>();

        Result result1 = new Result();
        result1.addAttribute("place", new Entity("Cologne"));
        result1.addAttribute("place", new Entity("Hamburg"));
        result1.addAttribute("dateTime", new Entity("31.08.1972"));
        result1.addAttribute("dateTime", new Entity("December"));
        result1.addAttribute("product", new Entity("first class"));

        resultsToCompareOne.add(new ResponseResultPair(response1, result1));

        Data dataObject1 = new Data(
                new InputText("Yesterday, 31.08.1972, I was travelling from Cologne to Hamburg first class. Next time I will travel in December"),
                result1
        );

        dataListOne = new ArrayList<>();
        dataListOne.add(dataObject1);

        Result result2Expected = new Result();
        result2Expected.addAttribute("place", new Entity("New York"));
        result2Expected.addAttribute("product", new Entity("good-night ticket"));
        Data dataObject2 = new Data(
                new InputText("I will go to New York with good-night ticket"),
                result2Expected
        );

        dataListTwo = new ArrayList<>();
        dataListTwo.add(dataObject1);
        dataListTwo.add(dataObject2);

        Result result2Actual = new Result();
        result2Expected.addAttribute("place", new Entity("Hamburg"));
        result2Expected.addAttribute("product", new Entity("premium"));

        TokenBasedEntity response2Token1 = new TokenBasedEntity();
        response2Token1.setText("Hamburg");
        response2Token1.setLabel("place");
        TokenBasedEntity response2Token2 = new TokenBasedEntity();
        response2Token2.setText("premium");
        response2Token2.setLabel("product");

        Category response2Category = new Category();
        response2Category.setScore(new BigDecimal(1.0));
        response2Category.setLabel("dissatisfied");

        AnalyzeResponse response2 = new AnalyzeResponse();
        response1.setText("I will go to New York with good-night ticket");
        response1.setEntities(Arrays.asList(
                response2Token1,
                response2Token2
        ));
        response2.setCategories(List.of(response1Category));

        resultsToCompareTwo = new ArrayList<>();

        resultsToCompareTwo.add(new ResponseResultPair(response1, result1));
        resultsToCompareTwo.add(new ResponseResultPair(response2, result2Actual));

    }

    @Configuration
    public static class EvaluationServiceImplTestConfig {

        @Bean
        public EvaluationService evaluationService() {
            return new EvaluationServiceImpl();
        }
    }
}