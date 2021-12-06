package com.parkinglot;

import java.util.ArrayList;
import java.util.Arrays;

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
                    .orElseThrow(() -> new NoAvailablePositionException("No available position."))
                    .parkCar(car);
    }

    public Car fetchCar(Ticket ticket) {
        ParkingLot parkingLotContainingRequestedCar =  parkingLots.stream()
                .filter(parkingLot -> parkingLot.validateTicket(ticket))
                .findFirst()
                .orElseThrow(() -> new UnRecognizedParkingTicketException("Unrecognized parking ticket."));

        return parkingLotContainingRequestedCar.fetchCar(ticket);
    }

    protected ArrayList<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
