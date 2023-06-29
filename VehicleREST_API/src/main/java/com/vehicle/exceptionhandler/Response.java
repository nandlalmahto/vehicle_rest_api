package com.vehicle.exceptionhandler;

import lombok.Data;

@Data
public class Response<Vehicle> {
	
	private String message;
	private Object data;

}
