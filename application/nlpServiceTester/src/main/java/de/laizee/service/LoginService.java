package de.laizee.service;

import de.laizee.model.login.LoginRequest;
import de.laizee.model.login.LoginResult;

/**
 * This interface defines methods for authentication.
 */
public interface LoginService {

    /**
     * Authenticates a given user.
     *
     * @param loginRequest given login credentials
     * @return LoginResult with necessary data
     */
    LoginResult authUserLogin(LoginRequest loginRequest);
}
