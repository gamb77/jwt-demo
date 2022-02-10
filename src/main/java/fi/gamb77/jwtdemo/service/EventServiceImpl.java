package fi.gamb77.jwtdemo.service;

import fi.gamb77.jwtdemo.dto.EventDTO;
import fi.gamb77.jwtdemo.repository.EventRepository;
import fi.gamb77.jwtdemo.util.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream().map(EventMapper::entityToDTO).collect(Collectors.toList());
    }
}
