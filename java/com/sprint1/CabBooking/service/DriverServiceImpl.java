package com.sprint1.CabBooking.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.CabBooking.Helper.DriverHelper;
import com.sprint1.CabBooking.bean.DriverBean;
import com.sprint1.CabBooking.entity.Abstractuser;
import com.sprint1.CabBooking.entity.Driver;
import com.sprint1.CabBooking.exception.UserNotFoundException;
import com.sprint1.CabBooking.repository.IDriverRepository;

@Service
public class DriverServiceImpl {

	@Autowired
	private IDriverRepository driver;

	// to get All drivers
	public List<DriverBean> findAllDrivers() {
		List<DriverBean> list = new ArrayList<>();
		driver.findAll().stream().forEach(c -> {
			list.add(new DriverBean(c, true));
		});
		return list;
	}
	//to get by driverId
	public DriverBean findDriverById(Integer driverId) {
		return DriverHelper.generateDriverBean(driver.findById(driverId).get());
		
	}
	//update user
		public Driver updateDriver(int userId, Driver d)throws UserNotFoundException
		{
			if(!driver.existsById(userId)) 
			{
				throw new UserNotFoundException();
			}
			Driver existingUser = driver.findById(userId).get();
			existingUser.setUserName(d.getUserName());
			existingUser.setEmailId(d.getEmailId());
			existingUser.setPassword(d.getPassword());
			existingUser.setMobilenumber(d.getMobilenumber());
			existingUser.setRating(d.getRating());
			existingUser.setLicenseNo(d.getLicenseNo());
			existingUser.setLocation(d.getLocation());
			
		
			return driver.save(existingUser);
		}

}
