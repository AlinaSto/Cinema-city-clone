package com.spring.cinema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.cinema.config.StringListConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @SequenceGenerator(name = "category_seq",
            sequenceName = "category_seq",
            initialValue = 1,
            allocationSize = 1)
    private Long id;
    @Column
    private String movieName;
//    @Column
//    private LocalDateTime startAt;
//    @Column
//    private LocalDateTime endAt;
    @Column
    private Integer price;
    @Column
    private String overview;

    @Column
    private String language;

    @Column
    private LocalDate releaseDate;

    @Column
    private Double voteAverage;

    @ManyToOne
    @JoinColumn(name = "cinemaRoom_id")
    @JsonBackReference(value ="cinemaRoom-movie")
    private CinemaRoom cinemaRoom;

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference(value = "movie-projection")
    private List<Projection> projectionList;

    @Convert(converter = StringListConverter.class)
    private List<String> genres;

    public Movie(String movieName, Integer price, CinemaRoom cinemaRoom, List<Projection> projectionList, String language, String overview,Double voteAverage, LocalDate releaseDate) {
        this.movieName = movieName;
        this.price = price;
        this.cinemaRoom = cinemaRoom;
        this.projectionList = projectionList;
        this.overview = overview;
        this.language = language;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public List<Projection> getProjectionList() {
        if (this.projectionList == null) {
            projectionList = new ArrayList<>();
        }
        return projectionList;
    }

    public void setProjectionList(List<Projection> projectionList) {
        this.projectionList = projectionList;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
