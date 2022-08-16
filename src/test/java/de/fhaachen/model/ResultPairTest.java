package de.fhaachen.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ResultPairTest {

    private ResultPair resultPair;

    @Mock
    private Result expected, expected1, actual, actual1;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        resultPair = new ResultPair(expected, actual);
    }

    @Test
    public void shouldBeEqual_SameResponse() {
        assertThat(resultPair.getLeft(), equalTo(expected));
    }

    @Test
    public void shouldNotBeEqual_OtherResponse() {
        assertThat(resultPair.getLeft(), not(equalTo(expected1)));
    }

    @Test
    public void shouldBeEqual_SameResult() {
        assertThat(resultPair.getRight(), equalTo(actual));
    }

    @Test
    public void shouldNotBeEqual_OtherResult() {
        assertThat(resultPair.getRight(), not(equalTo(actual1)));
    }

    @Test
    public void shouldNotBeEqual_NotAComparableObject() {
        assertThat(resultPair, not(equalTo(new Object())));
    }

    @Test
    public void shouldNotBeEqual_NullShouldNeverEqualAnything() {
        assertThat(resultPair, not(equalTo(null)));
    }

    @Test
    public void shouldBeEqual_SameInstance() {
        assertThat(resultPair, equalTo(resultPair));
    }

    @Test
    public void shouldBeEqual_SymbolEqual() {
        ResultPair resultPair1 = new ResultPair(expected, actual);

        assertThat(resultPair, equalTo(resultPair1));
    }

    @Test
    public void shouldComplyHashCodeContract() {
        ResultPair resultPair1 = new ResultPair(expected, actual);
        ResultPair resultPair2 = new ResultPair(expected1, actual);
        ResultPair resultPair3 = new ResultPair(expected, actual1);


        Map<ResultPair, String> map = new HashMap<>();

        map.put(resultPair, "a");
        map.put(resultPair1, "b");
        map.put(resultPair2, "c");
        map.put(resultPair3, "d");

        assertThat(map, not(hasEntry(resultPair, "a")));
        assertThat(map, hasEntry(resultPair1, "b"));
        assertThat(map, hasEntry(resultPair2, "c"));
        assertThat(map, hasEntry(resultPair3, "d"));
    }
}