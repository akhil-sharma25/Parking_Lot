package com.example.parkingLot;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ParkingLot {
    Map<Integer,CompactParkingSpot> compactParkingSpotMap = new HashMap();
    Map<Integer,BikeParkingSpot> bikeParkingSpotMap = new  HashMap();
    Map<Integer,LargeParkingSpot> largeParkingSpotMap = new  HashMap();
    int freeLargeParkingSlot=0,freeCompactParkingSlot=0,freeBikeParkingSlot=0;

    ParkingLot(int freeLargeParkingSlot,int freeCompactParkingSlot,int freeBikeParkingSlot){
        this.freeCompactParkingSlot=freeCompactParkingSlot;
        this.freeBikeParkingSlot=freeBikeParkingSlot;
        this.freeLargeParkingSlot=freeLargeParkingSlot;
    }
    //park
    public void parkVehicle(Vehicle vehicle){
        System.out.println("We are about to park your vehicleType: "+vehicle.getVehicleType());
        if(vehicle.getVehicleType().equals(VehicleType.Truck)){
            if(freeLargeParkingSlot>0){
                    parkLargeVehicle(vehicle);
            }
            else{
                System.out.println("Sorry no more space for: "+vehicle.getVehicleType());
            }
        }
        if(vehicle.getVehicleType().equals(VehicleType.Car)){
            if(freeCompactParkingSlot>0){
                parkCompactVehicle(vehicle);
            }
            else{
                if(freeLargeParkingSlot>0){
                    parkLargeVehicle(vehicle);
                }
                else {
                    System.out.println("Sorry no more space for: " + vehicle.getVehicleType());
                }
            }
        }
        if(vehicle.getVehicleType().equals(VehicleType.Bike)){
            if(freeBikeParkingSlot>0){
                parBike(vehicle);
            }
            else{
                if(freeCompactParkingSlot>0){
                    parkCompactVehicle(vehicle);
                }
                else if(freeLargeParkingSlot>0)
                    parkLargeVehicle(vehicle);
                else {
                    System.out.println("Sorry no more space for: " + vehicle.getVehicleType());
                }
            }
        }
    }

    //unpark
    public void parkLargeVehicle(Vehicle vehicle){
        LargeParkingSpot largeParkingSpot = new LargeParkingSpot(ParkingSlotType.Large);
        largeParkingSpot.setVehicle(vehicle);
        largeParkingSpot.setFree(false);
        largeParkingSpotMap.put(vehicle.getVehicleNumber(),largeParkingSpot);
        System.out.println("Your vehicle is parked of type: "+vehicle.getVehicleType());
        freeLargeParkingSlot--;
    }

    public void parkCompactVehicle(Vehicle vehicle){
        CompactParkingSpot compactParkingSpot = new CompactParkingSpot(ParkingSlotType.Compact);
        compactParkingSpot.setVehicle(vehicle);
        compactParkingSpot.setFree(false);
        compactParkingSpotMap.put(vehicle.getVehicleNumber(),compactParkingSpot);
        System.out.println("Your vehicle is parked of type: "+vehicle.getVehicleType());
        freeCompactParkingSlot--;
    }

    public void parBike(Vehicle vehicle){
        BikeParkingSpot bikeParkingSpot = new BikeParkingSpot(ParkingSlotType.Bike);
        bikeParkingSpot.setVehicle(vehicle);
        bikeParkingSpot.setFree(false);
        bikeParkingSpotMap.put(vehicle.getVehicleNumber(),bikeParkingSpot);
        System.out.println("Your vehicle is parked of type: "+vehicle.getVehicleType());
        freeBikeParkingSlot--;
    }

    //Unpark
    public void unparkMyVehicle(Vehicle vehicle){
        System.out.println("Vehicle is getting removed: "+vehicle.getVehicleNumber());
        if(largeParkingSpotMap.containsKey(vehicle.getVehicleNumber())){
            System.out.println("Your Vehicle is successfully Unparked: "+vehicle.getVehicleNumber());
            largeParkingSpotMap.remove(vehicle.getVehicleNumber());
            freeLargeParkingSlot++;
        }
        else if(bikeParkingSpotMap.containsKey(vehicle.getVehicleNumber())){
            System.out.println("Your Vehicle is successfully Unparked: "+vehicle.getVehicleNumber());
            bikeParkingSpotMap.remove(vehicle.getVehicleNumber());
            freeBikeParkingSlot++;
        }
        else if(compactParkingSpotMap.containsKey(vehicle.getVehicleNumber())){
            System.out.println("Your Vehicle is successfully Unparked: "+vehicle.getVehicleNumber());
            compactParkingSpotMap.remove(vehicle.getVehicleNumber());
            freeCompactParkingSlot++;
        }
        else{
            System.out.println("We do not have your vehicle parked at us: "+ vehicle.getVehicleNumber());
        }
    }

}
