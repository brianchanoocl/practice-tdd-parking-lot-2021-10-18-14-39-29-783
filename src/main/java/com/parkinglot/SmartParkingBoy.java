package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parkCar(Car car) {
        return super.getParkingLots().stream()
                .filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                .max(Comparator.comparing(ParkingLot::getAvailablePosition))
                .orElseThrow(() -> new NoAvailablePositionException("No available position."))
                .parkCar(car);
    }
}
