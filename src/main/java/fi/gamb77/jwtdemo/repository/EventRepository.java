package fi.gamb77.jwtdemo.repository;

import fi.gamb77.jwtdemo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
