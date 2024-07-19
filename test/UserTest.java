package com.sprint1.CabBooking.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.sprint1.CabBooking.entity.Abstractuser;
import com.sprint1.CabBooking.entity.Customer;
import com.sprint1.CabBooking.entity.Driver;
import com.sprint1.CabBooking.repository.IUserRepository;
import com.sprint1.CabBooking.service.UserServiceImpl;

@SpringBootTest
public class UserTest {
	@Autowired
	private UserServiceImpl user;
	@MockBean
	private IUserRepository abstractuser;

	@Test
	public void saveCustomerTest() {
		Customer customer = new Customer();
		when(abstractuser.save(customer)).thenReturn(customer);
		assertEquals(customer, user.addCustomer(customer));
	}

	@Test
	public void saveDriverTest() {
		Driver driver = new Driver();
		when(abstractuser.save(driver)).thenReturn(driver);
		assertEquals(driver, user.addDriver(driver));
	}

	@Test
	public void getUsersTest() {
		when(abstractuser.findAll()).thenReturn(Stream
				.of(new Abstractuser()).collect(Collectors.toList()));
		assertEquals(1, user.findAllUsers().size());
	}
}