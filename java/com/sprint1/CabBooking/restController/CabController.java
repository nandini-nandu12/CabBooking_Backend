package com.sprint1.CabBooking.restController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sprint1.CabBooking.entity.Cab;
import com.sprint1.CabBooking.service.CabService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/cabs")
public class CabController {
	@Autowired
	private CabService cabservice;

	//add Cab
	@PostMapping("/addCab")
	public ResponseEntity<String> addCab(@RequestBody Cab cab) {
		cabservice.addCab(cab);
		return ResponseEntity.ok("Cab Saved");
	}

	//view cabs
	@GetMapping("/viewAllCabs")
	public ResponseEntity<List<Cab>> viewCabs() {
		List<Cab> cab = cabservice.viewCabs();
		return ResponseEntity.ok(cab);
	}

	//count of cabs
	@GetMapping("/cabsCount")
	public long countCabs() {
		long cab = cabservice.countCabs();
		return cab;
	}

	//view cab by cabId
	@GetMapping("/view/{cabId}")
	public ResponseEntity<Cab> viewCabsByCabId(@PathVariable("cabId") Integer cabId) {
		Cab cabs = cabservice.viewCabsByCabId(cabId);
		return ResponseEntity.ok(cabs);
	}
	
	//to update cab
	@PostMapping("/update")
	public ResponseEntity<String> updateCab(@RequestBody Cab cab) {
		cabservice.updateCab(cab);
		return ResponseEntity.ok("Cab Updated");
	}
	
	//to cancel cab
	@DeleteMapping("/cancel/{cabId}")
	public ResponseEntity<String> cancelCab(@RequestBody Integer cabId) {
		cabservice.cancelCab(cabId);
		return ResponseEntity.ok("Cab Updated");
	}
	

}
