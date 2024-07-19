package com.sprint1.CabBooking.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.sprint1.CabBooking.entity.TripBooking;
import com.sprint1.CabBooking.repository.ITripBookingRepository;

@Service
public class AdminServiceImpl {
	
	@Autowired
	private ITripBookingRepository tripbooking;
	
	//get all trips
	/*public List<TripBooking> getAllTrips(){
		return tripbooking.findAll();
	}*/
	//get trips cab wise
	public List<TripBooking> getTripsCabwise(Integer cabId) {
		return tripbooking.getTripsCabwise(cabId);
	}
	//get trips customer wise
	public List<TripBooking> getTripsCustomerwise(Integer customerId) {
		return tripbooking.getTripsCustomerwise(customerId);
	}
	//get trips date wise
	public List<TripBooking> getTripsDatewise(LocalDateTime fromDateTime,LocalDateTime toDateTime) {
		return tripbooking.getTripsDatewise(fromDateTime,toDateTime);
	}


}
