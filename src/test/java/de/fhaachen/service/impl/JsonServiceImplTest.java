package de.fhaachen.service.impl;

import de.fhaachen.model.Data;
import de.fhaachen.model.Entity;
import de.fhaachen.model.InputText;
import de.fhaachen.model.Result;
import de.fhaachen.service.JsonService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
@ContextConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class JsonServiceImplTest {

    private static final String JSON_OBJECT_1 = "{\n" +
            "    \"inputText\": \"Yesterday, 31.08.1972, I was travelling from Cologne to Hamburg first class. Next time I will travel in December\",\n" +
            "    \"result\": {\n" +
            "      \"place\": [\n" +
            "        \"Cologne\",\n" +
            "        \"Hamburg\"\n" +
            "      ],\n" +
            "      \"dateTime\": [\n" +
            "        \"31.08.1972\",\n" +
            "        \"December\"\n" +
            "      ],\n" +
            "      \"product\": \"first class\"\n" +
            "    }\n" +
            "  }";

    private static final String JSON_OBJECT_2 = "  {\n" +
            "    \"inputText\": \"I will go to New York with good-night ticket\",\n" +
            "    \"result\": {\n" +
            "      \"place\": [\n" +
            "        \"New York\"\n" +
            "      ],\n" +
            "      \"dateTime\": [],\n" +
            "      \"product\": \"good-night ticket\"\n" +
            "    }\n" +
            "  }";

    @Autowired
    private JsonService jsonService;

    private static Data dataObject1, dataObject2;

    @BeforeAll
    public static void init() {
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
        result2.addAttribute("place", new Entity("New York"));
        result2.addAttribute("product", new Entity("good-night ticket"));
        dataObject2 = new Data(
                new InputText("I will go to New York with good-night ticket"),
                result2
        );
    }

    @Test
    void should_readJsonFromFile_OneObject(@TempDir Path directory) throws IOException {
        Path path = directory.resolve("testdata.json");

        //List<String> lines = Arrays.asList(JSON_OBJECT_1);
        List<String> lines = Arrays.asList("[", JSON_OBJECT_1, "]");
        Files.write(path, lines);

        List<Data> data = jsonService.readJsonFromFile(new File(path.toUri()));

        assertThat(data.size(), equalTo(1));
        assertThat(data.get(0), equalTo(dataObject1));
    }

    @Test
    void should_readJsonFromFile_MultipleObjects(@TempDir Path directory) throws IOException {
        Path path = directory.resolve("testdata.json");

        List<String> lines = Arrays.asList("[", JSON_OBJECT_1, ",", JSON_OBJECT_2, "]");
        Files.write(path, lines);

        List<Data> data = jsonService.readJsonFromFile(new File(path.toUri()));

        assertThat(data.size(), equalTo(2));
        assertThat(data.get(0), equalTo(dataObject1));
        assertThat(data.get(1), equalTo(dataObject2));
    }



    @Test
    void should_not_readJsonFromFile_MultipleObjects_not_valid(@TempDir Path directory) throws IOException {
        Path path = directory.resolve("testdata.json");

        List<String> lines = Arrays.asList("[", JSON_OBJECT_1, JSON_OBJECT_2, "]");
        Files.write(path, lines);

        List<Data> data = jsonService.readJsonFromFile(new File(path.toUri()));

        assertThat(data, equalTo(new ArrayList<>()));
    }

    @Test
    void should_not_readJsonFromFile_Json_not_valid(@TempDir Path directory) throws IOException {
        Path path = directory.resolve("invalid_testdata.json");

        List<String> lines = Arrays.asList("[{inputText:{Yesterday,},},]");
        Files.write(path, lines);

        Collection<Data> data = jsonService.readJsonFromFile(new File(path.toUri()));

        assertThat(data, equalTo(new ArrayList<>()));
    }

    @Test
    void should_not_readJsonFromFile_FileNotFound() {
        assertThrows(FileNotFoundException.class,
                () -> jsonService.readJsonFromFile(new File("")));
    }

    @Test
    void should_not_readJsonFromFile_CouldNotReadFile(@TempDir Path directory) throws IOException {
        Path path = directory.resolve("invalid_testdata.json");

        List<String> lines = Arrays.asList("", "", "", "");
        Files.write(path, lines);

        assertThrows(IOException.class,
                () -> jsonService.readJsonFromFile(new File(path.toUri())));
    }

    @Configuration
    public static class JsonServiceImplTestConfig {

        @Bean
        public JsonService jsonService() {
            return new JsonServiceImpl();
        }
    }

}