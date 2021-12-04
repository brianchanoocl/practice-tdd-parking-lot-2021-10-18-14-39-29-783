package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket parkCar(Car car) {
        return null;
    }
}
