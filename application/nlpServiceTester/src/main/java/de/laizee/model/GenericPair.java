package de.laizee.model;

import lombok.*;

/**
 * This object class represents a generic pair of data.
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Builder
public class GenericPair<L,R>{

    private L left;
    private R right;
}
