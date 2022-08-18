package de.laizee.model;

import de.laizee.model.generated.AnalyzeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ResponseResultPairTest {

    private ResponseResultPair responseResultPair;

    @Mock
    private AnalyzeResponse response, response1;

    @Mock
    private Result result, result1;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        responseResultPair = new ResponseResultPair(response, result);
    }

    @Test
    public void shouldBeEqual_SameResponse() {
        assertThat(responseResultPair.getLeft(), equalTo(response));
    }

    @Test
    public void shouldNotBeEqual_OtherResponse() {
        assertThat(responseResultPair.getLeft(), not(equalTo(response1)));
    }

    @Test
    public void shouldBeEqual_SameResult() {
        assertThat(responseResultPair.getRight(), equalTo(result));
    }

    @Test
    public void shouldNotBeEqual_OtherResult() {
        assertThat(responseResultPair.getRight(), not(equalTo(result1)));
    }

    @Test
    public void shouldNotBeEqual_NotAComparableObject() {
        assertThat(responseResultPair, not(equalTo(new Object())));
    }

    @Test
    public void shouldNotBeEqual_NullShouldNeverEqualAnything() {
        assertThat(responseResultPair, not(equalTo(null)));
    }

    @Test
    public void shouldBeEqual_SameInstance() {
        assertThat(responseResultPair, equalTo(responseResultPair));
    }

    @Test
    public void shouldBeEqual_SymbolEqual() {
        ResponseResultPair responseResultPair1 = new ResponseResultPair(response, result);

        assertThat(responseResultPair, equalTo(responseResultPair1));
    }

    @Test
    public void shouldComplyHashCodeContract() {
        ResponseResultPair responseResultPair1 = new ResponseResultPair(response, result);
        ResponseResultPair responseResultPair2 = new ResponseResultPair(response1, result);
        ResponseResultPair responseResultPair3 = new ResponseResultPair(response, result1);

        Map<ResponseResultPair, String> map = new HashMap<>();

        map.put(responseResultPair, "a");
        map.put(responseResultPair1, "b");
        map.put(responseResultPair2, "c");
        map.put(responseResultPair3, "d");

        assertThat(map, not(hasEntry(responseResultPair, "a")));
        assertThat(map, hasEntry(responseResultPair1, "b"));
        assertThat(map, hasEntry(responseResultPair2, "c"));
        assertThat(map, hasEntry(responseResultPair3, "d"));
    }
}