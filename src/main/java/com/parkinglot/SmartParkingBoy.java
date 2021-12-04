package com.parkinglot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

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
        try{
            return parkingLots.stream()
                    .filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                    .max(Comparator.comparing(ParkingLot::getAvailablePosition))
                    .get()
                    .parkCar(car);
        } catch (NoSuchElementException e) {
            throw new NoAvailablePositionException("No available position.");
        }
    }

    public Car fetchCar(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.fetchCar(ticket);
            } catch (UnRecognizedParkingTicketException ignored) {
            }
        }
        throw new UnRecognizedParkingTicketException("Unrecognized parking ticket.");
    }
}
