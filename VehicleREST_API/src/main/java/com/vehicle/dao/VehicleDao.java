package com.vehicle.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.vehicle.entity.Vehicle;
import com.vehicle.exceptionhandler.VehicleIdNotFoundException;
import com.vehicle.repository.VehicleRepository;

@Repository
public class VehicleDao
{
	@Autowired
	private VehicleRepository vehicleRepository;

	
	
	//add the data into database
	public Vehicle addVehicle(Vehicle vehicle)
	{
		return vehicleRepository.save(vehicle);
	}
	
	//get all the data from database
	public List<Vehicle> getAllVehicles()
	{
		List<Vehicle> list = this.vehicleRepository.findAll();
		return list;
	}
	
	//get a single data from database by id
	public Vehicle getVehicleById(int id)
	{
		Optional<Vehicle> option = vehicleRepository.findById(id);
		if(option.isPresent()) {
			return option.get();
		}
		throw new VehicleIdNotFoundException("this id is not present");
	}

	//update the data into database by id
	public Vehicle updateVehicle(Vehicle vehicle, int id)
	{
		Optional<Vehicle> option = vehicleRepository.findById(id);
		if (option.isPresent()) {
			vehicle.setId(id);
			return vehicleRepository.save(vehicle);
		}
		throw new VehicleIdNotFoundException("This id is not present in the database");
	}
	
	//delete the data into database by id
	public Vehicle deleteVehicle(int id) {
		
		Optional<Vehicle> option = vehicleRepository.findById(id);
		if(option.isPresent())
		{
			vehicleRepository.deleteById(id);
			return option.get();			
		}
		throw new VehicleIdNotFoundException("This id is not present in the database");
	}

}
