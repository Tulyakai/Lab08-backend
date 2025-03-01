package se331.lab.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
   List<Event> findAll();
}
