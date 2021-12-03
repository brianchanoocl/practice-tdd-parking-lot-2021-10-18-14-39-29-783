package com.parkinglot;

public class ParkingLot {
    private final int capacity;

    public ParkingLot() {
        this.capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket parkCar(Car car) {
        return new Ticket(car);
    }
}
