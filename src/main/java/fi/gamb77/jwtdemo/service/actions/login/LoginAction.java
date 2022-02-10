package fi.gamb77.jwtdemo.service.actions.login;

import org.springframework.security.core.Authentication;

public interface LoginAction {
    void action(Authentication authentication);
}
