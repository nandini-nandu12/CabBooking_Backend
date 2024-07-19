package com.sprint1.CabBooking.Helper;

import com.sprint1.CabBooking.bean.CustomerBean;
import com.sprint1.CabBooking.entity.Customer;

public class CustomerHelper {
	public static CustomerBean generateCustomerBean(Customer c) {
		CustomerBean bean = null;
		if (c != null)
			bean = new CustomerBean(c, true);

		return bean;
	}
}