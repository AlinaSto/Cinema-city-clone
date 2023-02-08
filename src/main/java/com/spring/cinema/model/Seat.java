package com.spring.cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @SequenceGenerator(name = "category_seq",
            sequenceName = "category_seq",
            initialValue = 1,
            allocationSize = 1)
    private Long id;

    @Column
    private Integer seatRow;
    @Column
    private Integer seatCol;
    @Column
    private Integer extraPrice;

    @ManyToOne
    @JoinColumn(name = "cinemaRoom_id")
    @JsonBackReference(value ="cinemaRoom-seat")
    private CinemaRoom cinemaRoom;

    @OneToMany(mappedBy = "seat", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference(value = "seat-ticket")
    private List<Ticket> ticketList;

    public Seat(Integer seatRow, Integer col, Integer extraPrice, CinemaRoom cinemaRoom, List<Ticket> ticketList) {
        this.seatRow = seatRow;
        this.seatCol = col;
        this.extraPrice = extraPrice;
        this.cinemaRoom = cinemaRoom;
        this.ticketList = ticketList;
    }
    public Seat(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(Integer row) {
        this.seatRow = row;
    }

    public Integer getSeatCol() {
        return seatCol;
    }

    public void setSeatCol(Integer col) {
        this.seatCol = col;
    }

    public Integer getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(Integer extraPrice) {
        this.extraPrice = extraPrice;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public List<Ticket> getTicketList() {
        if (this.ticketList == null) {
            ticketList = new ArrayList<>();
        }
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}

