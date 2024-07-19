package com.sprint1.CabBooking.bean;

import java.time.LocalDateTime;

import com.sprint1.CabBooking.entity.TripBooking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripBookingBean {

	private Integer tripBookingId;
	private String fromLocation;
	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private String status;
	private Float distanceinKm;
	private Float bill;
	private String Payment;
	private CustomerBean customer;
	private DriverBean driver;

	public TripBookingBean(TripBooking trip, boolean buildCustDriver) {
		tripBookingId = trip.getTripBookingId();
		fromLocation = (String) trip.getFromLocation();
		toLocation = (String) trip.getToLocation();
		fromDateTime=(LocalDateTime) trip.getFromDateTime();
		toDateTime=(LocalDateTime) trip.getToDateTime();
		status = trip.getStatus();
		distanceinKm = trip.getDistanceinKm();
		bill = trip.getBill();
		Payment = trip.getPayment();
		if (buildCustDriver) {
			customer = new CustomerBean(trip.getCustomer(), false);
			driver = new DriverBean(trip.getDriver(), false);
		}
	}

}