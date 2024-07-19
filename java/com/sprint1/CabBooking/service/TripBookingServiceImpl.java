package com.sprint1.CabBooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint1.CabBooking.Helper.TripBookingHelper;
import com.sprint1.CabBooking.bean.TripBookingBean;
import com.sprint1.CabBooking.entity.Cab;
import com.sprint1.CabBooking.entity.Customer;
import com.sprint1.CabBooking.entity.Driver;
import com.sprint1.CabBooking.entity.TripBooking;
import com.sprint1.CabBooking.exception.EmptyInputException;
import com.sprint1.CabBooking.exception.TripBookingNotFoundException;
import com.sprint1.CabBooking.exception.UserNotFoundException;
import com.sprint1.CabBooking.repository.ICabRepository;
import com.sprint1.CabBooking.repository.ICustomerRepository;
import com.sprint1.CabBooking.repository.IDriverRepository;
import com.sprint1.CabBooking.repository.ITripBookingRepository;

@Service
public class TripBookingServiceImpl {

	@Autowired
	private ITripBookingRepository tripbookingrepo;
	
	@Autowired
	private ICustomerRepository customerrepo;
	
	@Autowired
	private IDriverRepository driverrepo;
	
	@Autowired
	private ICabRepository cabrepo;


	// to get All trips
	public List<TripBookingBean> getAllTrips() {
		List<TripBookingBean> list = new ArrayList<>();
		tripbookingrepo.findAll().stream().forEach(trip -> {
			list.add(new TripBookingBean(trip, true));
		});
		return list;
	}

	// to add trip
	public TripBooking addTripBooking(TripBooking tripBooking) {
		int customerId=tripBooking.getCustomer().getUserId();
		//int driverId=tripBooking.getDriver().getUserId();
		int cabId=tripBooking.getCab().getCabId();
		Optional<Customer> optionalCustomer=customerrepo.findById(customerId);
		if(optionalCustomer.isEmpty())
		{
			throw new UserNotFoundException();
		}
		/*Optional<Driver> optionalDriver=driverrepo.findById(driverId);
		if(optionalDriver.isEmpty())
		{
			throw new UserNotFoundException();
		}*/
		Optional<Cab> optionalCab=cabrepo.findById(cabId);
		if(optionalCab.isEmpty())
		{
			throw new UserNotFoundException();
		}
		Customer customer=optionalCustomer.get();
		//Driver driver=optionalDriver.get();
		Cab cab=optionalCab.get();
		List<TripBooking> customertripbookings=customer.getTripbooking();
		//List<TripBooking> drivertripbookings=driver.getTripbooking();
		customertripbookings.add(tripBooking);
		//drivertripbookings.add(tripBooking);
		tripBooking.setCustomer(customer);
		//tripBooking.setDriver(driver);
		tripBooking.setCab(cab);
			
			if(tripBooking.getFromLocation().isEmpty()||tripBooking.getFromLocation().length()==0
					||tripBooking.getFromLocation().isEmpty()||tripBooking.getFromLocation().length()==0
					||tripBooking.getToLocation().isEmpty()||tripBooking.getToLocation().length()==0)
			{
			throw new EmptyInputException();
		}
			tripBooking.setStatus("Requested");
		return tripbookingrepo.save(tripBooking);
	}

	// to get trip by Id
	public TripBookingBean findTripBookingById(int tripBookingId) {
		return TripBookingHelper.generateTripBookingBean(tripbookingrepo.findById(tripBookingId).get());
	}

	// to cancel trip
	public void cancelTripBookingById(Integer tripBookingId) {
		tripbookingrepo.deleteById(tripBookingId);
	}
	
	//to update trip
		public TripBooking changeTripStatus(int tripBookingId, TripBooking status) throws TripBookingNotFoundException
		{
			if(!tripbookingrepo.existsById(tripBookingId)) 
			{
				throw new TripBookingNotFoundException();
			}
			TripBooking newStatus = tripbookingrepo.findById(tripBookingId).get();
			newStatus.setStatus(status.getStatus());

			return tripbookingrepo.save(newStatus);
		}
		
		public TripBooking generateBill(int tripBookingId,float distanceinKm) {
			Optional<TripBooking> optionalTripBooking=tripbookingrepo.findById(tripBookingId);
			if(optionalTripBooking.isEmpty())
			{
				throw new TripBookingNotFoundException();
			}
			TripBooking tripBooking=optionalTripBooking.get();
			if(tripBooking.getStatus().equalsIgnoreCase("Completed")) {
				throw new EmptyInputException();
			}
			Cab cab=tripBooking.getCab();
			Float perKmRate=cab.getPerKmRate();
			Float bill=distanceinKm*perKmRate;
			tripBooking.setDistanceinKm(distanceinKm);
			tripBooking.setBill(bill);
			tripBooking.setStatus("Completed");
			tripBooking.setPayment("Paid");
			tripbookingrepo.save(tripBooking);
			return tripBooking;
			
			
		}
    }


