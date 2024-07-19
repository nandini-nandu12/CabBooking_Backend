package com.sprint1.CabBooking.bean;

import java.util.ArrayList;
import java.util.List;

import com.sprint1.CabBooking.entity.Cab;
import com.sprint1.CabBooking.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverBean {
	private Integer userID;
	private String userName;
	private String password;
	private String mobilenumber;
	private String emailId;
	private float rating;
	private String licenseNo;
	private String location;
	private Cab cab;
	private List<TripBookingBean> trips;
	
	public DriverBean(Driver driver, Boolean buildTrip) {
		userID = driver.getUserId();
		userName = driver.getUserName();
		password = driver.getPassword();
		mobilenumber = driver.getMobilenumber();
		emailId = driver.getEmailId();
		rating = driver.getRating();
		licenseNo = driver.getLicenseNo();
		location = driver.getLocation();
		if (buildTrip) {
			trips = new ArrayList<>();
			driver.getTripbooking().stream().forEach(d -> {
				trips.add(new TripBookingBean(d, false));
			});
		}
	}

}