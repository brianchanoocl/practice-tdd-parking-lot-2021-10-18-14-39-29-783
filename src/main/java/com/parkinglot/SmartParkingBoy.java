package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SmartParkingBoy extends ParkingBoy {
    private ArrayList<ParkingLot> parkingLots;

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parkCar(Car car) {
        try{
            return super.getParkingLots().stream()
                    .filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                    .max(Comparator.comparing(ParkingLot::getAvailablePosition))
                    .get()
                    .parkCar(car);
        } catch (NoSuchElementException e) {
            throw new NoAvailablePositionException("No available position.");
        }
    }
}
