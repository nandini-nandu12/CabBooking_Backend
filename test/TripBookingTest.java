package com.sprint1.CabBooking.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.sprint1.CabBooking.entity.TripBooking;
import com.sprint1.CabBooking.repository.ITripBookingRepository;
import com.sprint1.CabBooking.service.TripBookingServiceImpl;

@SpringBootTest
public class TripBookingTest {
	@Autowired
	private TripBookingServiceImpl tripServiceImpl;

	@MockBean
	private ITripBookingRepository tripbookingrepo;

	@Test
	public void getUsersTest() {
		when(tripbookingrepo.findAll()).thenReturn(Stream
				.of(new TripBooking()).collect(Collectors.toList()));
		assertEquals(1, tripServiceImpl.getAllTrips().size());
	}
}
