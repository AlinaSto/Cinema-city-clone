package com.spring.cinema.repository;

import com.spring.cinema.model.Projection;
import com.spring.cinema.model.Seat;
import com.spring.cinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket findByProjectionAndSeat(Projection projection, Seat seat);
}
