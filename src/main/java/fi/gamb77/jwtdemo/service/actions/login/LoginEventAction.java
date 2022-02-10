package fi.gamb77.jwtdemo.service.actions.login;

import fi.gamb77.jwtdemo.model.Event;
import fi.gamb77.jwtdemo.model.EventType;
import fi.gamb77.jwtdemo.model.User;
import fi.gamb77.jwtdemo.security.UserPrincipal;
import fi.gamb77.jwtdemo.service.actions.BaseAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginEventAction extends BaseAction implements LoginAction {
    private static final Logger log = LogManager.getLogger(LoginEventAction.class);

    @Override
    public void action(Authentication authentication) {
        log.debug("LoginEventAction started.");

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Optional<User> user = userRepository.findById(userPrincipal.getId());
        user.ifPresentOrElse(u -> addLoginEvent(u), () -> log.error("Failed to find user."));

    }

    private void addLoginEvent(User user) {
        Event event = new Event();
        event.setEventType(EventType.LOGIN_EVENT);
        event.setDescription("User " + user.getUserName() + " logged to the system.");
        eventRepository.save(event);
    }

}
