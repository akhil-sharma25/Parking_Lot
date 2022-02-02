package com.example.parkingLot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingLotApplication {

	public static void main(String[] args) {

		SpringApplication.run(ParkingLotApplication.class, args);
		System.out.println("Abc");

		ParkingLot parkingLot = new ParkingLot(2,2,2);
		Vehicle vehicle = new Vehicle(VehicleType.Car);
		vehicle.setVehicleNumber(123);
		parkingLot.parkVehicle(vehicle);
		parkingLot.unparkMyVehicle(vehicle);
	}

}
