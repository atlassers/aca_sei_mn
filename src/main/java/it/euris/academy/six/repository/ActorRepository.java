package it.euris.academy.six.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.six.data.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {

}
