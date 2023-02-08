package com.spring.cinema.controller;

import com.spring.cinema.dto.AddCinemaRoomDTO;
import com.spring.cinema.model.CinemaRoom;
import com.spring.cinema.service.CinemaRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemaRoom")
public class CinemaRoomController {

    private CinemaRoomService cinemaRoomService;

    @Autowired
    public CinemaRoomController(CinemaRoomService cinemaRoomService) {
        this.cinemaRoomService = cinemaRoomService;
    }

    @PostMapping("/add")
    public CinemaRoom addCinemaRoom(@RequestBody AddCinemaRoomDTO addCinemaRoomDTO) {
        return cinemaRoomService.createCinemaRoom(addCinemaRoomDTO);
    }

    @GetMapping("/")
    public List<CinemaRoom> getCinemaRooms() {
        return cinemaRoomService.getCinemaRooms();
    }

    @PutMapping("/update/{cinemaRoomId}")
    public CinemaRoom updateCinemaRoom(@RequestBody AddCinemaRoomDTO addCinemaRoomDTO, @PathVariable Long cinemaRoomId) {
        return cinemaRoomService.updateCinemaRoom(addCinemaRoomDTO, cinemaRoomId);
    }

    @DeleteMapping
    public void del("/delete/{cinemaRoomId}")eteCinemaRoom(@PathVariable Long cinemaRoomId) {
        cinemaRoomService.deleteCinemaRoom(cinemaRoomId);
    }

}
