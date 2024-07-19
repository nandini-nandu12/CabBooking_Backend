package com.sprint1.CabBooking.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tripBookingId;
	private String fromLocation;
	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private String status;
	private Float distanceinKm;
	private Float bill;
	private String payment;
	
	//Bidirectional with trip customer
	
	@ManyToOne
	@JoinColumn(name = "customerId", nullable = false)
	private Customer customer;
	
	//Bidirectional with Driver
	@ManyToOne
	@JoinColumn(name = "driverId", nullable = false)
	private Driver driver;
	@OneToOne
	@JoinColumn(name="cabId")
	private Cab cab;

}