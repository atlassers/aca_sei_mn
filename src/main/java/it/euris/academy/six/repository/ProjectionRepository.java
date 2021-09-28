package it.euris.academy.six.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.six.data.model.Projection;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {

}
