package com.sprint1.CabBooking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint1.CabBooking.entity.Abstractuser;
import com.sprint1.CabBooking.entity.Customer;
import com.sprint1.CabBooking.entity.Driver;
import com.sprint1.CabBooking.exception.EmptyInputException;
import com.sprint1.CabBooking.exception.UserNotFoundException;
import com.sprint1.CabBooking.repository.IUserRepository;

@Service
public class UserServiceImpl {
	@Autowired
	private IUserRepository abstractuser;

	// to add customer
	public Abstractuser addCustomer(Customer customer) {
		if(customer.getUserName().isEmpty()||customer.getUserName().length()==0
			||customer.getPassword().isEmpty()||customer.getPassword().length()==0
			||customer.getEmailId().isEmpty()||customer.getEmailId().length()==0
			||customer.getMobilenumber().isEmpty()||customer.getMobilenumber().length()==0)
			
		{
			throw new EmptyInputException();
		}
		return abstractuser.save(customer);
	}
		
	// to add driver
	public Abstractuser addDriver(Driver driver) {
		if(driver.getUserName().isEmpty()||driver.getUserName().length()==0
				||driver.getPassword().isEmpty()||driver.getPassword().length()==0
				||driver.getEmailId().isEmpty()||driver.getEmailId().length()==0
				||driver.getMobilenumber().isEmpty()||driver.getMobilenumber().length()==0
				||driver.getLicenseNo().isEmpty()||driver.getLicenseNo().length()==0
				||driver.getLocation().isEmpty()||driver.getLocation().length()==0
				||driver.getRating()==0)
		{
			throw new EmptyInputException();
		}
		return abstractuser.save(driver);
	}

	// to get All Users
	public List<Abstractuser> findAllUsers() { 
		return abstractuser.findAll();

	}
	//update user
	public Abstractuser updateUser(int userId, Abstractuser user)throws UserNotFoundException
	{
		if(!abstractuser.existsById(userId)) 
		{
			throw new UserNotFoundException();
		}
		Abstractuser existingUser = abstractuser.findById(userId).get();
		existingUser.setUserName(user.getUserName());
		existingUser.setEmailId(user.getEmailId());
		existingUser.setPassword(user.getPassword());
		existingUser.setMobilenumber(user.getMobilenumber());
	
		return abstractuser.save(existingUser);
	}
	//Delete user
	public void deleteUserById(Integer userId) {
		abstractuser.deleteById(userId);
		
	}
}
