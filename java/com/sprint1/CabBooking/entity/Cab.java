package com.sprint1.CabBooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Cab {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cabId;
	private String cabNo;
	private String cartype;
	private String cabName;
	private Float perKmRate;
	
	@OneToOne(mappedBy="cab")
	@JsonIgnore
	private TripBooking tripbooking;

}