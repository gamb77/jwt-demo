package fi.gamb77.jwtdemo.service;

import fi.gamb77.jwtdemo.dto.EventDTO;

import java.util.List;

public interface EventService {
    List<EventDTO> getAllEvents();
}
