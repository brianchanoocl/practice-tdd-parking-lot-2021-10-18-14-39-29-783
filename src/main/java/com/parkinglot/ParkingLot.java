package com.parkinglot;

import java.util.ArrayList;

public class ParkingLot {
    private final int capacity;
    private ArrayList<Car> carList;

    public ParkingLot() {
        this.capacity = 10;
        carList = new ArrayList<Car>();
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        carList = new ArrayList<Car>();
    }

    public Ticket parkCar(Car car) {
        if(isFull()){
            throw new NoAvailablePositionException("No available position.");
        }
        carList.add(car);
        return new Ticket(car);
    }

    public Car fetchCar(Ticket ticket) {
        if(validateTicket(ticket)) {
            return releaseCarByTicket(ticket);
        }
        throw new UnRecognizedParkingTicketException("Unrecognized parking ticket.");
    }

    private boolean isFull(){
        return carList.size() == capacity;
    }

    public boolean validateTicket(Ticket ticket){
        return ticket != null && !ticket.isUsed() && carList.contains(ticket.getCar());
    }



    private Car releaseCarByTicket(Ticket ticket) {
        if(carList.contains(ticket.getCar())){
            ticket.checkOutWithThisTicket();
            int carParkedPosition = carList.indexOf(ticket.getCar());
            Car fetchedCar = carList.get(carParkedPosition);
            carList.remove(carParkedPosition);
            return fetchedCar;
        }
        throw new UnRecognizedParkingTicketException("Unrecognized parking ticket.");
    }

    public int getAvailablePosition() {
        return capacity - carList.size();
    }


    public Double getAvailablePositionRate() {
        return (double) ((getAvailablePosition())  / capacity);
    }
}
