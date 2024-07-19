package com.sprint1.CabBooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sprint1.CabBooking.entity.Abstractuser;


@Repository
public interface IUserRepository extends JpaRepository<Abstractuser, Integer> {

	Optional<Abstractuser> findByUserName(String userName);

}
