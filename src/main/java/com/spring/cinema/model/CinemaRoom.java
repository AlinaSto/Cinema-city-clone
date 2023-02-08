package com.spring.cinema.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CinemaRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @SequenceGenerator(name = "category_seq",
            sequenceName = "category_seq",
            initialValue = 1,
            allocationSize = 1)
    private Long id;

    @Column
    private int noOfRows;

    @Column
    private int noOfCols;

    @OneToMany(mappedBy = "cinemaRoom", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "cinema-movie")
    private List<Movie> movieList;

    @OneToMany(mappedBy = "cinemaRoom", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "cinema-seat")
    private List<Seat> seatList;

    public CinemaRoom() {
    }

    public CinemaRoom(Long id, int noOfRows, int noOfCols, List<Movie> movieList, List<Seat> seatList) {
        this.id = id;
        this.noOfRows = noOfRows;
        this.noOfCols = noOfCols;
        this.movieList = movieList;
        this.seatList = seatList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(int noOfRows) {
        this.noOfRows = noOfRows;
    }

    public int getNoOfCols() {
        return noOfCols;
    }

    public void setNoOfCols(int noOfCols) {
        this.noOfCols = noOfCols;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
