package com.sprint1.CabBooking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sprint1.CabBooking.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

}
