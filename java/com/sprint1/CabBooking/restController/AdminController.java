package com.sprint1.CabBooking.restController;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.CabBooking.entity.TripBooking;
import com.sprint1.CabBooking.service.AdminServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	/*@GetMapping("/getAllTrips")
	public List<TripBooking> getAllTrips(){
		return adminServiceImpl.getAllTrips();
	}*/
	
	@GetMapping("/cabtrips")
	public ResponseEntity<List<TripBooking>> getTripsCabwise(Integer cabId){
	List<TripBooking> list = adminServiceImpl.getTripsCabwise(cabId);
	return ResponseEntity.ok(list);
	}
	
	@GetMapping("/customertrips")
	public ResponseEntity<List<TripBooking>> getTripsCustomerwise(Integer customerId){
		List<TripBooking> list = adminServiceImpl.getTripsCustomerwise(customerId);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/datewisetrips")
	public ResponseEntity<List<TripBooking>> getTripsDatewise(LocalDateTime fromDateTime,LocalDateTime toDateTime){
		List<TripBooking> list = adminServiceImpl.getTripsDatewise(fromDateTime,toDateTime);
		return ResponseEntity.ok(list);
	}
	
	}


