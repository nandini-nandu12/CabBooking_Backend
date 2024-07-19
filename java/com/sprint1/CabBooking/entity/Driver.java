package com.sprint1.CabBooking.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Driver extends Abstractuser {
	private String licenseNo;
	private String location;
	private Float rating;
	//private String status;
	
	//Bidirectional with tripBooking
	@OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<TripBooking> tripbooking;
	
	//Unidirectional with Cab
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cabId")
	private Cab cab;
}