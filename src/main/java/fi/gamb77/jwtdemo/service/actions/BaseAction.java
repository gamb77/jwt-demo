package fi.gamb77.jwtdemo.service.actions;

import fi.gamb77.jwtdemo.repository.EventRepository;
import fi.gamb77.jwtdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseAction {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected EventRepository eventRepository;
}
