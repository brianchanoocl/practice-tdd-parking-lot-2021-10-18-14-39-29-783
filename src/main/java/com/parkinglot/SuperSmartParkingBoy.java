package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket parkCar(Car car) {
            return super.getParkingLots().stream()
                    .filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                    .max(Comparator.comparing(ParkingLot::getAvailablePositionRate))
                    .orElseThrow(() -> new NoAvailablePositionException("No available position."))
                    .parkCar(car);
    }
}
