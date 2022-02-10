package fi.gamb77.jwtdemo.model;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event extends BaseEntity {

    @Enumerated(EnumType.ORDINAL)
    private EventType eventType;

    @Column
    private String description;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
