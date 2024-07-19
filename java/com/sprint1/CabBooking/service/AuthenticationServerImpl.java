package com.sprint1.CabBooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.CabBooking.entity.Abstractuser;
import com.sprint1.CabBooking.exception.AuthenticationFailureException;
import com.sprint1.CabBooking.exception.userNameNotExistingexception;
import com.sprint1.CabBooking.repository.IUserRepository;

@Service
public class AuthenticationServerImpl {
	@Autowired
	private IUserRepository abstractuser;
	
	public Abstractuser  login(String userName,String password) throws userNameNotExistingexception,AuthenticationFailureException
	{
		Optional<Abstractuser> user=abstractuser.findByUserName(userName);
		if(user.isEmpty()) {
			throw new userNameNotExistingexception();
			
		}
		Abstractuser user1=user.get();
		if(!password.equals(user1.getPassword())) {
			throw new AuthenticationFailureException();
			
		}
		return user1;
		

	}
	

}
