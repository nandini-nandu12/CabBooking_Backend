package com.sprint1.CabBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sprint1.CabBooking.entity.Cab;

@Repository
public interface ICabRepository extends JpaRepository<Cab, Integer> {

}