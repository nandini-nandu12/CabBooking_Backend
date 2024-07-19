package com.sprint1.CabBooking.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.sprint1.CabBooking.entity.Driver;
import com.sprint1.CabBooking.repository.IDriverRepository;
import com.sprint1.CabBooking.service.DriverServiceImpl;

@SpringBootTest
public class DriverTest {

	@Autowired
	private DriverServiceImpl driverServiceImpl;
	@MockBean
	private IDriverRepository driver;
	
	@Test
	public void getDriverTest() {
		when(driver.findAll()).thenReturn(Stream
				.of(new Driver()).collect(Collectors.toList()));
		assertEquals(1, driverServiceImpl.findAllDrivers().size());
	}
}