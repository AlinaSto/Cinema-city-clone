package com.spring.cinema;

import com.spring.cinema.dto.AddCinemaRoomDTO;
import com.spring.cinema.dto.AddMovieDTO;
import com.spring.cinema.dto.ExtraPriceDTO;
import com.spring.cinema.model.CinemaRoom;
import com.spring.cinema.model.Movie;
import com.spring.cinema.repository.CinemaRoomRepository;
import com.spring.cinema.repository.MovieRepository;
import com.spring.cinema.service.CinemaRoomService;
import com.spring.cinema.service.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {
    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieRepository movieRepository;
    @Mock
    private CinemaRoomRepository cinemaRoomRepository;


    @Test
    void testAddMovie_ShouldTrowExceptoin(){
        //given

        AddMovieDTO addMovieDTO = new AddMovieDTO("Ajunul Craciunului",null,0,null);

        //when
        when(cinemaRoomRepository.findById(any())).thenReturn(Optional.of(new CinemaRoom()));
        when(movieRepository.findByMovieName(addMovieDTO.getMovieName())).thenReturn(Optional.of(new Movie(addMovieDTO.getMovieName(),0,null,null,null,null,null,null)));
        assertThrows(ResponseStatusException.class, () -> movieService.addMovie(addMovieDTO));
    }
}