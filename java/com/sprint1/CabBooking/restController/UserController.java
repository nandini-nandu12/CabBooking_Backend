package com.sprint1.CabBooking.restController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sprint1.CabBooking.entity.Abstractuser;
import com.sprint1.CabBooking.entity.Customer;
import com.sprint1.CabBooking.entity.Driver;
import com.sprint1.CabBooking.exception.UserNotFoundException;
import com.sprint1.CabBooking.service.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	// to add customer
	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		userServiceImpl.addCustomer(customer);
		return ResponseEntity.ok("Customer Saved");
	}

	// to add driver
	@PostMapping("/addDriver")
	public ResponseEntity<String> addDriver(@RequestBody Driver driver) {
		userServiceImpl.addDriver(driver);
		return ResponseEntity.ok("Driver Saved");
	}

	// to get all users
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<Abstractuser>> findAllUsers() {
		List<Abstractuser> users = userServiceImpl.findAllUsers();
		return ResponseEntity.ok(users);
	}

	//update user by userId
	@PutMapping("/update/{userId}")
	 public ResponseEntity<String> updateUser(@PathVariable int userId, @RequestBody Abstractuser userName) throws UserNotFoundException
	{
	    userServiceImpl.updateUser(userId, userName);
	    return ResponseEntity.ok("User Updated");
	}
	//delete user by userId
			@DeleteMapping("/delete/{userId}")
			public ResponseEntity<String> deleteUserById(@PathVariable Integer userId,@RequestBody Driver d) {
				userServiceImpl.deleteUserById(userId);
				return ResponseEntity.ok("User Deleted");
			}
}
