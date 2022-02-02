package com.example.parkingLot;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompactParkingSpot extends  ParkingSlot{
    CompactParkingSpot(ParkingSlotType parkingSlotType){
        super(parkingSlotType);
    }
}
