package com.sprint1.CabBooking.restController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sprint1.CabBooking.bean.DriverBean;
import com.sprint1.CabBooking.entity.Abstractuser;
import com.sprint1.CabBooking.entity.Driver;
import com.sprint1.CabBooking.exception.UserNotFoundException;
import com.sprint1.CabBooking.service.DriverServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/driver")
public class DriverController {

	@Autowired
	private DriverServiceImpl driverServiceImpl;

	// to get all drivers
	@GetMapping("/getAllDrivers")
	public ResponseEntity<List<DriverBean>> findAllDrivers() {
		List<DriverBean> driver = driverServiceImpl.findAllDrivers();
		return ResponseEntity.ok(driver);
	}
	//to get driver by Id
	@GetMapping("/{DriverId}")
	public DriverBean findDriverById(@PathVariable Integer DriverId) {
		return driverServiceImpl.findDriverById(DriverId);
	}
	// to update driver details
	@PutMapping("/update/{userId}")
	 public ResponseEntity<String> updateDriver(@PathVariable int userId, @RequestBody  Driver d) throws UserNotFoundException
	{
		driverServiceImpl.updateDriver(userId, d);
	    return ResponseEntity.ok("Driver Updated");
	}

}
