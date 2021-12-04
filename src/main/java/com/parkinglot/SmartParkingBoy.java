package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;

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
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.getAvailablePosition() > 0).max(Comparator.comparing(ParkingLot::getAvailablePosition))
                .get()
                .parkCar(car);
    }

    public Car fetchCar(Ticket ticket) {
        return null;
    }
}
