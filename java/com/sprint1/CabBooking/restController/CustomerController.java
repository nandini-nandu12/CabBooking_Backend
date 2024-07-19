package com.sprint1.CabBooking.restController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sprint1.CabBooking.bean.CustomerBean;

import com.sprint1.CabBooking.service.CustomerServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	// to get all customers
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<CustomerBean>> findAllCustomers() {
		List<CustomerBean> customer = customerServiceImpl.findAllCustomers();
		return ResponseEntity.ok(customer);
	}

	 //to get customer by Id
	@GetMapping("/{CustomerId}")
	public CustomerBean findCustomerById(@PathVariable Integer CustomerId) {
		return customerServiceImpl.findCustomerById(CustomerId);
	}
}
