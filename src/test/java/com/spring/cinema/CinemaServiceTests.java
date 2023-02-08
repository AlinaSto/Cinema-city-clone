package com.spring.cinema;

import com.spring.cinema.dto.AddCinemaRoomDTO;
import com.spring.cinema.dto.ExtraPriceDTO;
import com.spring.cinema.model.CinemaRoom;
import com.spring.cinema.repository.CinemaRoomRepository;
import com.spring.cinema.repository.MovieRepository;
import com.spring.cinema.service.CinemaRoomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})//pt unitTest
class CinemaServiceTests {

	@InjectMocks//folosit in loc de autowired pt ca nu mai suntem in spring ci in jUnit
	private CinemaRoomService cinemaRoomService;

	@Mock
	private CinemaRoomRepository cinemaRoomRepository;

	@Mock
	private MovieRepository movieRepository;

	@Test
	void contextLoads() {
	}



	@Test
	void testAddCinemaRoom() {
		//given

		ExtraPriceDTO extraPriceDTO = new ExtraPriceDTO(4,6,3);
		AddCinemaRoomDTO addCinemaRoomDTO = new AddCinemaRoomDTO(8,9, Arrays.asList(extraPriceDTO));

		//when
		CinemaRoom cinemaRoomRepositoryObject = new CinemaRoom(1L, 8,9,null,null);
		when(cinemaRoomRepository.save(any())).thenReturn(cinemaRoomRepositoryObject);

		CinemaRoom result = cinemaRoomService.createCinemaRoom(addCinemaRoomDTO);
		//then
		assertEquals(8, result.getNoOfRows());
	}

}
