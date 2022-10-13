package org.springboot.monitoring.api.repositories;

import org.springboot.monitoring.api.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
