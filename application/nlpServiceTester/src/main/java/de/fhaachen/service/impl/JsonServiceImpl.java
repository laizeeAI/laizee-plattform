package de.fhaachen.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.fhaachen.model.Data;
import de.fhaachen.model.Entity;
import de.fhaachen.model.InputText;
import de.fhaachen.model.Result;
import de.fhaachen.service.JsonService;
import de.fhaachen.util.JsonValidator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This Service class defines methods for json operations.
 */
@Service
public class JsonServiceImpl implements JsonService {

    private static final Logger LOGGER = Logger.getLogger(JsonServiceImpl.class);

    @Override
    public List<Data> readJsonFromFile(File file) throws IOException {
        List<Data> dataList = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(file)) {
            String json = inputToString(inputStream);
            ObjectMapper mapper = new ObjectMapper();
            if (!JsonValidator.isValidJson(mapper, json)) {
                LOGGER.info("# Json not valid!");
                return new ArrayList<>();
            }
            List<Map<String, Object>> deserializedJson = mapper.readValue(json, List.class);
            deserializedJson.forEach(value -> dataList.add(readDataFromDeserializedJson(value)));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        } catch (IOException e) {
            throw new IOException("Could not read file");
        }
        return dataList;
    }

    private String inputToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        for (int length; (length = inputStream.read(buffer)) != -1; ) {
            result.write(buffer, 0, length);
        }
        return result.toString(StandardCharsets.UTF_8);
    }

    private Data readDataFromDeserializedJson(Map<String, Object> jsonMap) {
        Data data = new Data();
        String message = (String) jsonMap.get("inputText");
        data.setInputText(new InputText(message));

        LinkedHashMap resultMap;
        Result result = new Result();
        if (jsonMap.get("result") instanceof LinkedHashMap) {
            resultMap = (LinkedHashMap) jsonMap.get("result");
            resultMap.forEach((key, value) -> {
                if (value instanceof ArrayList<?>) {
                    ArrayList values = (ArrayList) value;
                    values.forEach(v -> {
                        result.addAttribute((String) key, new Entity((String) v));
                    });
                } else {
                    String stringValue = (String) value;
                    result.addAttribute((String) key, new Entity(stringValue));
                }
            });
        }

        data.setResult(result);
        return data;
    }
}