package de.laizee.model.login;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class LoginResult {
    private String auth;
    private String sessionId;
    private String csrfToken;
}
