package com.sprint1.CabBooking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint1.CabBooking.entity.Cab;
import com.sprint1.CabBooking.exception.EmptyInputException;
import com.sprint1.CabBooking.repository.ICabRepository;

@Service
public class CabService {
	@Autowired
	private ICabRepository cabrepo;

	// to add cab
	public Cab addCab(Cab cab) {
		if(cab.getCabName().isEmpty()||cab.getCabName().length()==0
				||cab.getCabNo().isEmpty()||cab.getCabNo().length()==0
				||cab.getCartype().isEmpty()||cab.getCartype().length()==0
				||cab.getPerKmRate()==0)
						
		{
			throw new EmptyInputException();
		}
		return cabrepo.save(cab);
	}

	// to view cabs
	public List<Cab> viewCabs() {
		return cabrepo.findAll();
	}

	// to count cabs
	public long countCabs() {
		return cabrepo.count();
	}

	// to view cabs by cabId
	public Cab viewCabsByCabId(Integer id) {
		return cabrepo.findById(id).get();
	}
	
	// to update cab by cabId
	public Cab updateCab(Cab cab) {
		return cabrepo.save(cab);
	}
	
	//to cancel cab
	public void cancelCab(Integer cabId) {
		cabrepo.deleteById(cabId);
	}
	

}