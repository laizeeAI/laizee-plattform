package de.fhaachen.service;

import de.fhaachen.model.login.LoginRequest;
import de.fhaachen.model.login.LoginResult;

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
