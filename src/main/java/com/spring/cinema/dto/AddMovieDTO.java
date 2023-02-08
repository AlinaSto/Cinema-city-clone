package com.spring.cinema.dto;

import java.util.ArrayList;
import java.util.List;

public class AddMovieDTO {
    private String movieName;
    private Long cinemaRoomId;
    private Integer price;
    private List<AddProjectionsDTO> dates;

    public AddMovieDTO(String movieName, Long cinemaRoomId, Integer price, List<AddProjectionsDTO> dates) {
        this.movieName = movieName;
        this.cinemaRoomId = cinemaRoomId;
        this.price = price;
        this.dates = dates;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Long getCinemaRoomId() {
        return cinemaRoomId;
    }

    public void setCinemaRoomId(Long cinemaRoomId) {
        this.cinemaRoomId = cinemaRoomId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<AddProjectionsDTO> getDates() {
        if (this.getDates() == null) {
            dates = new ArrayList<>();
        }
        return dates;
    }

    public void setDates(List<AddProjectionsDTO> dates) {
        this.dates = dates;
    }
}
