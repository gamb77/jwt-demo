package fi.gamb77.jwtdemo.service.actions.login;

import fi.gamb77.jwtdemo.model.User;
import fi.gamb77.jwtdemo.security.UserPrincipal;
import fi.gamb77.jwtdemo.service.actions.BaseAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class LoginDataUpdateAction extends BaseAction implements LoginAction {
    private static final Logger log = LogManager.getLogger(LoginDataUpdateAction.class);

    @Override
    public void action(Authentication authentication) {
        log.debug("LoginDataUpdateAction started.");

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Optional<User> user = userRepository.findById(userPrincipal.getId());
        user.ifPresentOrElse(u -> updateInfo(u), () -> log.error("Failed to find user."));

    }

    private void updateInfo(User user) {
        user.setLastLogin(LocalDateTime.now());
        user.setLoginCount(user.getLoginCount()+1);
        userRepository.save(user);
    }

}
