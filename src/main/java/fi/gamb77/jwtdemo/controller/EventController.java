package fi.gamb77.jwtdemo.controller;

import fi.gamb77.jwtdemo.service.EventService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "events")
@RequestMapping(value = "/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping(value = "/events")
    List getAll() {
        return eventService.getAllEvents();
    }


}
