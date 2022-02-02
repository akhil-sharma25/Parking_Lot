package com.example.parkingLot;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Vehicle {
    private VehicleType vehicleType;
    private Integer vehicleNumber;
    private ParkingSlot parkingSlot;
    Vehicle(VehicleType vehicleType){
        this.vehicleType=vehicleType;
    }
}
