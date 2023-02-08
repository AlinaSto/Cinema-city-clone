package com.spring.cinema.repository;

import com.spring.cinema.model.Projection;
import com.spring.cinema.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    Seat findBySeatRowAndSeatCol(Integer row,Integer col);
}
