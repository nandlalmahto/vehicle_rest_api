package com.vehicle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.entity.Vehicle;
import com.vehicle.exceptionhandler.Response;
import com.vehicle.service.VehicleService;

@RestController
public class Controller {

	@Autowired
	private VehicleService vehicleService;


	//adding the data into the database
	//command line:- POST: http://localhost:8080/vihicles
	@PostMapping("/vehicles")
	public ResponseEntity<Response<Vehicle>> saveVehicle(@RequestBody Vehicle vehicle)
	{
		return vehicleService.addVehicle(vehicle);
	}


	//Getting the data from the database
	//command:- GET: http://localhost:8080/vehicles 
	@GetMapping("/vehicles")
	public ResponseEntity<Response<List<Vehicle>>> getAllVehicles()
	{
		return vehicleService.getAllVehicles();
	}


	//Getting the data from the database
	//command:- GET: http://localhost:8080/vehicles/id
	@GetMapping("/vehicles/{id}")
	public ResponseEntity<Response<Vehicle>> getVehicleById(@PathVariable int id)
	{
		return vehicleService.getVehicleById1(id);
	}


	//Updating the data into the database
	//command:- PUT: http://localhost:8080/vehicles/id
	@PutMapping("/vehicles/{id}")
	public ResponseEntity<Response<Vehicle>> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable int id)
	{
		return vehicleService.updateVehicle(vehicle, id);
	}


	//Updating the data into the database
	//command:- PUT: http://localhost:8080/vehicles/id
	@DeleteMapping("/vehicles/{id}")
	public ResponseEntity<Response<Vehicle>> deleteVehicle(@PathVariable int id)
	{
		return vehicleService.deleteVehicle(id);
	}

}
