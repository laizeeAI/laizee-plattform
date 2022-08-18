package de.laizee.service.impl;

import de.laizee.api.DefaultApi;
import de.laizee.model.login.LoginRequest;
import de.laizee.model.login.LoginResult;
import de.laizee.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This Service class defines methods for authentication.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final DefaultApi defaultApi;

    @Autowired
    public LoginServiceImpl(DefaultApi defaultApi) {
        this.defaultApi = defaultApi;
    }

    @Override
    public LoginResult authUserLogin(LoginRequest loginRequest) {
        LoginResult loginResult = defaultApi.authLoginUser(new LoginRequest(loginRequest.getUsername(), loginRequest.getPassword()));
        return loginResult;
    }
}
