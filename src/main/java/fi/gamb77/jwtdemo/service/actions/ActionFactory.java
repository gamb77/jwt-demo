package fi.gamb77.jwtdemo.service.actions;

import fi.gamb77.jwtdemo.service.actions.login.LoginAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionFactory {

    @Autowired
    private List<LoginAction> loginActions;

    public void startLoginActions(Authentication authentication) {
        loginActions.stream().forEach(loginAction -> loginAction.action(authentication));
    }

}
