package com.sprint1.CabBooking.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.sprint1.CabBooking.bean.LoginreqBean;
import com.sprint1.CabBooking.entity.Abstractuser;
import com.sprint1.CabBooking.service.AuthenticationServerImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	@Autowired
	private AuthenticationServerImpl authenticationserver;
	
	@PostMapping("/login")
	public ResponseEntity<Abstractuser> doLogin(@RequestBody LoginreqBean loginreq){
		Abstractuser user=authenticationserver.login(loginreq.getUserName(),loginreq.getPassword());
		ResponseEntity<Abstractuser> responseEntity=new ResponseEntity<>(user,HttpStatus.OK);
		return  responseEntity;
	}
	

}
