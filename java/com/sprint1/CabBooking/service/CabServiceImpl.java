package com.sprint1.CabBooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint1.CabBooking.entity.Cab;
import com.sprint1.CabBooking.repository.ICabRepository;
import com.sprint1.CabBooking.repository.IDriverRepository;

import jakarta.ws.rs.NotFoundException;

@Service
public class CabServiceImpl{

	@Autowired
	private ICabRepository cabrepo;
	
	/*public Cab insertCab(Cab cab) {
		return cabrepo.save(cab);
	}
	public Cab updateCab(Cab cab) {
		return cabrepo.save(cab);
	}*/
	
	//to view on basis of type(mini/maxi)
	public List<Cab> viewCabsOfType(String carType){
		return cabrepo.findAll();
	}
	//count of cabs
	public long countCabsOfType(String carType) {
		return cabrepo.count();
	}


	}



