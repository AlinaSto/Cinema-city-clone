package com.spring.cinema.service;

import com.spring.cinema.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

//Care este valoarea tuturor biletelor vandute intr-o anumita zi (la un film sau la toate filmele)
//Cate bilete s-au vandut la un anumit film sau la toate filmele

}