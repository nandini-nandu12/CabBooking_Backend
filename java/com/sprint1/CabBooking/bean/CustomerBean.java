package com.sprint1.CabBooking.bean;

import java.util.ArrayList;
import java.util.List;
import com.sprint1.CabBooking.entity.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerBean {
	private Integer userId;
	private String userName;
	private String mobilenumber;
	private String emailId;
	private List<TripBookingBean> trips;

	public CustomerBean(Customer cust, Boolean buildTrip) {
		userId = cust.getUserId();
		userName = cust.getUserName();
		mobilenumber = cust.getMobilenumber();
		emailId = cust.getEmailId();
		
		if (buildTrip) {
			trips = new ArrayList<>();
			cust.getTripbooking().stream().forEach(c -> {
				trips.add(new TripBookingBean(c, false));
			});

		}

	}

}