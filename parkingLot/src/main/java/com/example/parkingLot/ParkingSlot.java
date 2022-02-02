package com.example.parkingLot;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ParkingSlot {
    private ParkingSlotType parkingSlotType;
    private Vehicle vehicle;
    private Boolean free;

    ParkingSlot(ParkingSlotType parkingSlotType){
        this.parkingSlotType=parkingSlotType;
    }
}
