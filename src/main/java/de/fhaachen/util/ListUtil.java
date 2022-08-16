package de.fhaachen.util;

import de.fhaachen.model.Entity;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for converting list in readable console outputs.
 */
public class ListUtil {

    /**
     * Converts a list of Entities in a single console output String.
     *
     * @param list given list of entities
     * @return String output
     */
    public static String entityListToString(List<Entity> list) {
        if (list == null) {
            return "[]";
        }
        List<String> strings = new ArrayList<>();
        list.forEach(entity ->
                strings.add((entity).getText())
        );

        return StringUtils.join(strings, ", ");
    }
}
