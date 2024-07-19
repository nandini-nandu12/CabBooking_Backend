package com.sprint1.CabBooking.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.sprint1.CabBooking.entity.Customer;
import com.sprint1.CabBooking.repository.ICustomerRepository;
import com.sprint1.CabBooking.service.CustomerServiceImpl;

@SpringBootTest
public class CustomerTest {
	@Autowired
	private CustomerServiceImpl  cust1;

	@MockBean
	private ICustomerRepository customerrepo; // creating mock instance for class

	@Test
	public void getCustomerTest() {
		when(customerrepo.findAll()).thenReturn(Stream
				.of(new Customer()).collect(Collectors.toList()));
		assertEquals(0, cust1.findAllCustomers().size());
	}
}