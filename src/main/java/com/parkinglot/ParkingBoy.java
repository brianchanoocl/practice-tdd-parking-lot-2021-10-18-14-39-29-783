package com.parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
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
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.fetchCar(ticket);
            } catch (UnRecognizedParkingTicketException ignored) {
            }
        }
        throw new UnRecognizedParkingTicketException("Unrecognized parking ticket.");
    }

    protected ArrayList<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
