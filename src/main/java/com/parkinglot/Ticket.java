package com.parkinglot;

public class Ticket {
    private final Car car;
    private boolean isUsed;

    public Ticket(Car car) {
        this.car = car;
        isUsed = false;
    }

    public Car getCar() {
        return car;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void checkOutWithThisTicket() {
        isUsed = true;
    }
}
