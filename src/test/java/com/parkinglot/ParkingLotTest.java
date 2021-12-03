package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// [ParkingLot] [Brian] - feat:

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_car_given_parking_lot_and_car() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        Ticket ticket = parkingLot.parkCar(car);

        assertNotNull(ticket);
    }

    @Test
    void should_return_null_when_park_car_given_parking_lot_is_full_and_car() {
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();

        Ticket ticket = parkingLot.parkCar(car);

        assertNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_car_given_parking_lot_and_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.parkCar(car);

        Car fetchedCar = parkingLot.fetchCar(ticket);

        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_2_correct_car_when_fetch_2_cars_given_parking_lot_and_2_tickets() {
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot.parkCar(car1);
        Ticket ticket2 = parkingLot.parkCar(car2);

        Car fetchedCar1 = parkingLot.fetchCar(ticket1);
        Car fetchedCar2 = parkingLot.fetchCar(ticket2);

        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
    }

    @Test
    void should_return_null_when_fetch_car_given_parking_lot_and_ticket_is_for_wrong_car() {
        ParkingLot parkingLot = new ParkingLot();
        Car rightCar = new Car();
        Car wrongCar = new Car();
        parkingLot.parkCar(rightCar);
        Ticket wrongTicket = new Ticket(wrongCar);

        Car fetchedCar = parkingLot.fetchCar(wrongTicket);

        assertNull(fetchedCar);
    }

    @Test
    void should_return_null_when_fetch_car_given_parking_lot_and_without_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.parkCar(car);
        Ticket nullTicket = null;

        Car fetchedCar = parkingLot.fetchCar(nullTicket);

        assertNull(fetchedCar);
    }
}
