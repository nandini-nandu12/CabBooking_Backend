package com.sprint1.CabBooking.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.sprint1.CabBooking.entity.Cab;
import com.sprint1.CabBooking.repository.ICabRepository;
import com.sprint1.CabBooking.service.CabService;

@SpringBootTest
public class CabTest {

	@Autowired
	private CabService cabservice;
	@MockBean
	private ICabRepository cabrepo;
	
	@Test
	public void saveCabTest() {
		Cab cab = new Cab();
		when(cabrepo.save(cab)).thenReturn(cab);
		assertEquals(cab, cabservice.addCab(cab));
	}
	@Test
	public void getCabTest() {
		when(cabrepo.findAll()).thenReturn(Stream
				.of(new Cab()).collect(Collectors.toList()));
		assertEquals(1, cabservice.viewCabs().size());
	}
	
}