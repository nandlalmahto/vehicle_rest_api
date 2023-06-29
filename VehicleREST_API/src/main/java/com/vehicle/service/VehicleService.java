package com.vehicle.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.vehicle.dao.VehicleDao;
import com.vehicle.entity.Vehicle;
import com.vehicle.exceptionhandler.Response;

@Service
public class VehicleService {

	
	@Autowired
	private VehicleDao vehicleDao;	
	
	//add the data into database
	public ResponseEntity<Response<Vehicle>> addVehicle(@RequestBody Vehicle vehicle)
	{
			Response<Vehicle> response = new Response<>();
			response.setMessage("Data Saved Successfully");
			response.setData(vehicleDao.addVehicle(vehicle));
			
			return new ResponseEntity<Response<Vehicle>>(response, HttpStatus.CREATED);	
	}
	
	
	//get all the data from database
	public ResponseEntity<Response<List<Vehicle>>> getAllVehicles()
	{
		Response<List<Vehicle>> response = new Response<>();
		response.setMessage("All the Data Fetched Successfully");
		response.setData(vehicleDao.getAllVehicles());
		
		return new ResponseEntity<Response<List<Vehicle>>>(response, HttpStatus.FOUND);
	}
	
	
	//get a single data from database by id
	public ResponseEntity<Response<Vehicle>> getVehicleById1(int id)
	{
		Response<Vehicle> response = new Response<>();
		response.setMessage("Data Fetched Successfully with " + id);
		response.setData(vehicleDao.getVehicleById(id));
		
		return new ResponseEntity<Response<Vehicle>>(response, HttpStatus.FOUND);
	}
	
	
	//update the data into database by id
	public ResponseEntity<Response<Vehicle>> updateVehicle(Vehicle vehicle, int id)
	{
		Response<Vehicle> response = new Response<>();
		response.setMessage("Data Updated Successfully");
		response.setData(vehicleDao.updateVehicle(vehicle, id));
		
		return new ResponseEntity<Response<Vehicle>>(response, HttpStatus.OK);
	}
	
	
	//delete the data into database by id
	public ResponseEntity<Response<Vehicle>> deleteVehicle(int id)
	{
		Response<Vehicle> response = new Response<>();
		response.setMessage("Data deleted Successfully");
		response.setData(vehicleDao.deleteVehicle(id));
		
		return new ResponseEntity<Response<Vehicle>>(response, HttpStatus.OK);
	}
	
}
