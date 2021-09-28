package it.euris.academy.six.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.six.data.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
