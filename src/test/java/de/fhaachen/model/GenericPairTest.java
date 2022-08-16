package de.fhaachen.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GenericPairTest {

    private GenericPair genericPairWithStrings;

    @BeforeEach
    void init() {
        genericPairWithStrings = new GenericPair("Left", "Right");
    }

    @Test
    public void shouldBeEqual_SameL() {
        assertThat(genericPairWithStrings.getLeft(), equalTo("Left"));
    }

    @Test
    public void shouldNotBeEqual_OtherL() {
        assertThat(genericPairWithStrings.getLeft(), not(equalTo("Right")));
    }

    @Test
    public void shouldBeEqual_SameR() {
        assertThat(genericPairWithStrings.getRight(), equalTo("Right"));
    }

    @Test
    public void shouldNotBeEqual_OtherR() {
        assertThat(genericPairWithStrings.getRight(), not(equalTo("Left")));
    }

    @Test
    public void shouldNotBeEqual_NotAComparableObject() {
        assertThat(genericPairWithStrings, not(equalTo(new Object())));
    }

    @Test
    public void shouldNotBeEqual_NullShouldNeverEqualAnything() {
        assertThat(genericPairWithStrings, not(equalTo(null)));
    }

    @Test
    public void shouldBeEqual_SameInstance() {
        assertThat(genericPairWithStrings, equalTo(genericPairWithStrings));
    }

    @Test
    public void shouldBeEqual_SymbolEqual() {
        GenericPair<String, String> genericPairWithStrings1 = new GenericPair("Left", "Right");

        assertThat(genericPairWithStrings, equalTo(genericPairWithStrings1));
    }

    @Test
    public void shouldComplyHashCodeContract() {
        GenericPair<String, String> genericPairWithStrings1 = new GenericPair("Left", "Right");
        GenericPair<String, String> genericPairWithStrings2 = new GenericPair("Left1", "Right");
        GenericPair<String, String> genericPairWithStrings3 = new GenericPair("Left", "Right1");


        Map<GenericPair, String> map = new HashMap<>();

        map.put(genericPairWithStrings, "a");
        map.put(genericPairWithStrings1, "b");
        map.put(genericPairWithStrings2, "c");
        map.put(genericPairWithStrings3, "d");

        assertThat(map, not(hasEntry(genericPairWithStrings, "a")));
        assertThat(map, hasEntry(genericPairWithStrings1, "b"));
        assertThat(map, hasEntry(genericPairWithStrings2, "c"));
        assertThat(map, hasEntry(genericPairWithStrings3, "d"));
    }

}