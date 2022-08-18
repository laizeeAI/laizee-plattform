package de.laizee.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

/**
 * Utility class for validating json.
 */
public class JsonValidator {

    private static final Logger LOGGER = Logger.getLogger(JsonValidator.class);

    /**
     * Validates weather the json string is valid or not
     *
     * @param mapper given mapper
     * @param json given json String
     * @return true for valid; false for invalid
     */
    public static boolean isValidJson(ObjectMapper mapper, String json) {
        try {
            mapper.readTree(json);
        } catch (JacksonException e) {
            LOGGER.info("Could not parse json");
            return false;
        }
        return true;
    }
}
