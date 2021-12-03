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

    @Test
    void should_return_null_when_park_car_given_parking_lot_is_full_and_car() {
        ParkingLot parkinLot = new ParkingLot(0);
        Car car = new Car();

        Ticket ticket = parkinLot.parkCar(car);

        assertNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_car_given_parking_lot_and_ticket() {
        ParkingLot parkinLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkinLot.parkCar(car);

        Car fetchedCar = parkinLot.fetchCar(ticket);

        assertEquals(car, fetchedCar);
    }
}
