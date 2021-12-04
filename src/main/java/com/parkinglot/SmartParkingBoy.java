package com.parkinglot;

import java.util.ArrayList;

public class SmartParkingBoy {
    private ArrayList<ParkingLot> parkingLots;

    public SmartParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = new ArrayList<ParkingLot>();
        this.parkingLots.add(parkingLot);
    }

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {
        return null;
    }
}
