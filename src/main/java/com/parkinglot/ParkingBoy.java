package com.parkinglot;

import java.util.ArrayList;
import java.util.NoSuchElementException;

// [ParkingLot] [Brian] - feat:

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
        Ticket returnTicket;
        try{
            return parkingLots.stream()
                    .filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                    .findFirst()
                    .get()
                    .parkCar(car);
        } catch (NoSuchElementException e) {
            throw new NoAvailablePositionException("No available position.");
        }
    }

    public Car fetchCar(Ticket ticket) {
        return null;
    }
}
