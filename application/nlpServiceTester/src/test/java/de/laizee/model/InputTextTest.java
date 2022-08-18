package de.laizee.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class InputTextTest {

    private static InputText inputText;

    @BeforeAll
    public static void init() {
        inputText = new InputText("This is a test!");
    }

    @Test
    public void shouldBeEqual_SameL() {
        assertThat(inputText.getMessage(), equalTo("This is a test!"));
    }

    @Test
    public void shouldNotBeEqual_OtherL() {
        assertThat(inputText.getMessage(), not(equalTo("Wrong message")));
    }

    @Test
    public void shouldNotBeEqual_NotAComparableObject() {
        assertThat(inputText, not(equalTo(new Object())));
    }

    @Test
    public void shouldNotBeEqual_NullShouldNeverEqualAnything() {
        assertThat(inputText, not(equalTo(null)));
    }

    @Test
    public void shouldBeEqual_SameInstance() {
        assertThat(inputText, equalTo(inputText));
    }

    @Test
    public void shouldBeEqual_SymbolEqual() {
        InputText inputText1 = new InputText("This is a test!");

        assertThat(inputText, equalTo(inputText1));
    }

    @Test
    public void shouldComplyHashCodeContract() {
        InputText inputText1 = new InputText("This is a test!");
        InputText inputText2 = new InputText("Wrong Message!");


        Map<InputText, String> map = new HashMap<>();

        map.put(inputText, "a");
        map.put(inputText1, "b");
        map.put(inputText2, "c");

        assertThat(map, not(hasEntry(inputText, "a")));
        assertThat(map, hasEntry(inputText1, "b"));
        assertThat(map, hasEntry(inputText2, "c"));
    }
}