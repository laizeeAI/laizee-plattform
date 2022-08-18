package de.laizee.model;

import lombok.*;

/**
 * This object class represents an input json file.
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Data {
    private InputText inputText;
    private Result result;
}
