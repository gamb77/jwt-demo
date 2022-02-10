package fi.gamb77.jwtdemo.util;

import fi.gamb77.jwtdemo.dto.EventDTO;
import fi.gamb77.jwtdemo.model.Event;

public class EventMapper {
    public static EventDTO entityToDTO(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setType(event.getEventType().name());
        eventDTO.setDate(event.getCreatedDate());
        eventDTO.setDescription(event.getDescription());
        return eventDTO;
    }
}
