package com.sprint1.CabBooking.restController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.CabBooking.bean.TripBillRequest;
import com.sprint1.CabBooking.bean.TripBookingBean;
import com.sprint1.CabBooking.entity.TripBooking;
import com.sprint1.CabBooking.service.TripBookingServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/trips")
public class TripBookingController {

	@Autowired
	private TripBookingServiceImpl tripServiceImpl;

	// to get all trips
	@GetMapping("/getAllTrips")
	public ResponseEntity<List<TripBookingBean>> getAllTrips() {
		List<TripBookingBean> trip = tripServiceImpl.getAllTrips();
		return ResponseEntity.ok(trip);
	}

	// to add trip
	@PostMapping("/addTrip")
	public ResponseEntity<String> addTripBooking(@RequestBody TripBooking tripBooking) {
		tripServiceImpl.addTripBooking(tripBooking);
		return ResponseEntity.ok("Added booking");
	}

	// to get trip by tripbookingId
	@GetMapping("/gettrip/{tripBookingId}")
	public TripBookingBean findTripBookingById(@PathVariable Integer tripBookingId) {
		return tripServiceImpl.findTripBookingById(tripBookingId);
	}

	// to cancel trip
	@DeleteMapping("/cancel/{tripBookingId}")
	public void cancelTripBookingById(@PathVariable Integer tripBookingId) {
		tripServiceImpl.cancelTripBookingById(tripBookingId);
	}
	
	//update trip status
	@PutMapping("/update/{tripBookingId}")
	public ResponseEntity<String> changeTripStatus(@PathVariable int tripBookingId,@RequestBody TripBooking status) 
	{
		tripServiceImpl.changeTripStatus(tripBookingId,status);
		return ResponseEntity.ok("Trip Status Saved");

	}
	
	//to generate bill
	@PutMapping("/bill")
	public ResponseEntity<TripBooking> generateBill(@RequestBody TripBillRequest tripBillRequest) 
	{
		TripBooking tripBooking=tripServiceImpl.generateBill(tripBillRequest.getTripBookingId(), tripBillRequest.getDistanceinKm());
		return new ResponseEntity<>(tripBooking,HttpStatus.OK);

	}
	
}
