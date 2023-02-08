package com.spring.cinema.repository;

import com.spring.cinema.model.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Long> {
}
