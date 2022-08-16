package de.fhaachen.model;

import lombok.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This object class represents mapped data, in form of label and corresponding text.
 */
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Builder
public class Result {

    private Map<String, List<Entity>> attributeMap;

    public Result() {
        attributeMap = new LinkedHashMap<>();
    }

    public List<Entity> getAttribute(String key) {
        return attributeMap.get(key);
    }

    public void addAttribute(String key, Entity entity) {
        if (attributeMap.containsKey(key)) {
            List<Entity> entities = attributeMap.get(key);
            entities.add(entity);
            attributeMap.put(key, entities);
        } else {
            attributeMap.put(key, new ArrayList<>(List.of(entity)));
        }
    }
}
