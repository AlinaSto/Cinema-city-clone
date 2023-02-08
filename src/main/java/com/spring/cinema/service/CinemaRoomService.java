package com.spring.cinema.service;

import com.spring.cinema.dto.AddCinemaRoomDTO;
import com.spring.cinema.dto.ExtraPriceDTO;
import com.spring.cinema.model.CinemaRoom;
import com.spring.cinema.model.Seat;
import com.spring.cinema.repository.CinemaRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaRoomService {

    private CinemaRoomRepository cinemaRoomRepository;


    @Autowired
    public CinemaRoomService(CinemaRoomRepository cinemaRoomRepository) {
        this.cinemaRoomRepository = cinemaRoomRepository;

    }

    public CinemaRoom createCinemaRoom(AddCinemaRoomDTO addCinemaRoomDTO) {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setNoOfRows(addCinemaRoomDTO.getNoOfRows());
        cinemaRoom.setNoOfCols(addCinemaRoomDTO.getNoOfCols());
        generateExtraPricesForCinemaRoom(addCinemaRoomDTO, cinemaRoom);
        generateSeatsForCinemaRoom(addCinemaRoomDTO, cinemaRoom);
        return cinemaRoomRepository.save(cinemaRoom);

    }

    private void generateExtraPricesForCinemaRoom(AddCinemaRoomDTO addCinemaRoomDTO, CinemaRoom cinemaRoom) {
        //1.parcurgem lista de extraprice-uri
        //2.parcurgem randurile de la startingRow la endingRow,
        // 3.la fiecare loc de pe fiecare rand setam extraprice curent
        for (ExtraPriceDTO extraPriceDTO : addCinemaRoomDTO.getExtraPrices()) {
            for (int i = extraPriceDTO.getStartingRow(); i <= extraPriceDTO.getEndingRow(); i++) {
                for (int j = 0; j < addCinemaRoomDTO.getNoOfCols(); j++) {
                    Seat seat = getSeatByRowAndCol(cinemaRoom, i, j + 1).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "the seat was not found"));
                    seat.setExtraPrice(extraPriceDTO.getExtraPrice());
                }
            }
        }
    }

    private void generateSeatsForCinemaRoom(AddCinemaRoomDTO addCinemaRoomDTO, CinemaRoom cinemaRoom) {
        for (int i = 0; i < addCinemaRoomDTO.getNoOfRows(); i++) {
            for (int j = 0; j < addCinemaRoomDTO.getNoOfCols(); j++) {
                Seat seat = new Seat();
                seat.setSeatRow(i + 1);
                seat.setSeatCol(j + 1);
                seat.setExtraPrice(0);
                cinemaRoom.getSeatList().add(seat);
                seat.setCinemaRoom(cinemaRoom);
            }
        }
    }


    public Optional<Seat> getSeatByRowAndCol(CinemaRoom cinemaRoom, Integer row, Integer col) {
//        for (Seat seat : cinemaRoom.getSeatList()) {
//            if (row == seat.getSeatRow() && col == seat.getSeatCol()) {
//                return seat;
//            }
//        }
        //      return null;
        return cinemaRoom.getSeatList().stream()
                .filter((seat -> seat.getSeatRow() == row && seat.getSeatCol() == col))
                .findFirst();
    }

    public CinemaRoom updateCinemaRoom(AddCinemaRoomDTO addCinemaRoomDTO, Long cinemaRoomId) {
        CinemaRoom foundCinemaRoom = cinemaRoomRepository.findById(cinemaRoomId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "the cinema was not found"));
        foundCinemaRoom.setNoOfRows(addCinemaRoomDTO.getNoOfRows());
        foundCinemaRoom.setNoOfCols(addCinemaRoomDTO.getNoOfCols());
        return cinemaRoomRepository.save(foundCinemaRoom);
    }

    public List<CinemaRoom> getCinemaRooms() {
        return cinemaRoomRepository.findAll();
    }

    public void deleteCinemaRoom(Long cinemaRoomId) {
        CinemaRoom foundCinemaRoom = cinemaRoomRepository.findById(cinemaRoomId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "the cinema was not found"));
        cinemaRoomRepository.delete(foundCinemaRoom);
    }

}
