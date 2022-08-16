package de.fhaachen.model.login;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class LoginRequest {

    private String username;

    private String password;
}
