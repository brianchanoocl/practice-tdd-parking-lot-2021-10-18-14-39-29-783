package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// [ParkingLot] [Brian] - feat:

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_car_given_parking_lot_and_car() {
        ParkingLot parkinLot = new ParkingLot();
        Car car = new Car();

        Ticket ticket = parkinLot.parkCar(car);

        assertNotNull(ticket);
    }

}
