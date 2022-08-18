package de.laizee.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertNull;

class ResultTest {

    private Result result;

    @BeforeEach
    void init() {
        result = new Result();
        result.addAttribute("test", new Entity("Test Entity"));
    }

    @Test
    void should_getAttribute() {
        assertThat(result.getAttribute("test"), equalTo(new ArrayList<>(List.of(new Entity("Test Entity")))));
    }

    @Test
    void should_not_getAttribute() {
        assertNull(result.getAttribute("key"));
    }

    @Test
    void addAttribute() {
        assertThat(result.getAttributeMap().size(), equalTo(1));

        result.addAttribute("key", new Entity("Key Entity"));

        assertThat(result.getAttributeMap().size(), equalTo(2));
    }

    @Test
    void addAttribute_existingKey() {
        assertThat(result.getAttributeMap().size(), equalTo(1));
        assertThat(result.getAttribute("test").size(), equalTo(1));

        result.addAttribute("test", new Entity("Key Entity"));

        assertThat(result.getAttributeMap().size(), equalTo(1));
        assertThat(result.getAttribute("test").size(), equalTo(2));
    }

    @Test
    public void shouldNotBeEqual_NotAComparableObject() {
        assertThat(result, not(equalTo(new Object())));
    }

    @Test
    public void shouldNotBeEqual_NullShouldNeverEqualAnything() {
        assertThat(result, not(equalTo(null)));
    }

    @Test
    public void shouldBeEqual_SameInstance() {
        assertThat(result, equalTo(result));
    }
}