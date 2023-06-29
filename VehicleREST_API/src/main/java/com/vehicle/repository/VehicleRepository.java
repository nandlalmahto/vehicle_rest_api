package com.vehicle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
	public Optional<Vehicle> findById(int id);

}
