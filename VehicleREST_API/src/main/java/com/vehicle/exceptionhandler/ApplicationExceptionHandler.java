package com.vehicle.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vehicle.entity.Vehicle;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(VehicleIdNotFoundException.class)
	public ResponseEntity<Response<Vehicle>> vehicleIdNotFoundException(VehicleIdNotFoundException vh)
	{
		Response<Vehicle> response = new Response<>();
		response.setData(vh.getMessage());
		response.setMessage("Please provede proper id");
		
		return new ResponseEntity<Response<Vehicle>>(response, HttpStatus.NOT_FOUND);
	}
}
