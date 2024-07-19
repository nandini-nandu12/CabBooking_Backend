package com.sprint1.CabBooking.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint1.CabBooking.Helper.CustomerHelper;
import com.sprint1.CabBooking.bean.CustomerBean;
import com.sprint1.CabBooking.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl {

	@Autowired
	private ICustomerRepository customerrepo;

	// to get All Customers
	public List<CustomerBean> findAllCustomers() {
		List<CustomerBean> list = new ArrayList<>();
		customerrepo.findAll().stream().forEach(c -> {
			list.add(new CustomerBean(c, true));
		});
		return list;
	}

	// to get by customerId
	public CustomerBean findCustomerById(Integer CustomerId) {
		return CustomerHelper.generateCustomerBean(customerrepo.findById(CustomerId).get());
	}

}
