package com.sprint1.CabBooking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sprint1.CabBooking.entity.Driver;

@Repository
public interface IDriverRepository extends JpaRepository<Driver,Integer>{

}
