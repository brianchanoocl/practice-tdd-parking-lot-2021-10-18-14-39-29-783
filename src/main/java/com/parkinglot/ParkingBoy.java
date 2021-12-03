package com.parkinglot;

import java.util.ArrayList;

public class ParkingBoy {
    private ArrayList<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = new ArrayList<ParkingLot>();
        this.parkingLots.add(parkingLot);
    }

    public ParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                .findFirst()
                .get()
                .parkCar(car);
    }
}
