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
        if(carList.size()+1 > capacity){
            return null;
        }
        carList.add(car);
        return new Ticket(car);
    }

    public Car fetchCar(Ticket ticket) {
        if(ticket != null) {
            if(carList.contains(ticket.getCar())){
                int carParkedPosition = carList.indexOf(ticket.getCar());
                Car fetchedCar = carList.get(carParkedPosition);
                carList.remove(carParkedPosition);
                return fetchedCar;
            }
        }
        return null;
    }
}
