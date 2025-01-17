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
    void should_throw_no_available_position_exception_when_park_car_given_parking_lot_is_full_and_car() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parkCar(new Car());
        Car car = new Car();

        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, () -> {
            parkingLot.parkCar(car);
        });
        assertEquals("No available position.", noAvailablePositionException.getMessage());
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
    void should_throw_unrecognized_parking_ticket_exception_when_fetch_car_given_parking_lot_and_ticket_is_for_wrong_car() {
        ParkingLot parkingLot = new ParkingLot();
        Car rightCar = new Car();
        Car wrongCar = new Car();
        parkingLot.parkCar(rightCar);
        Ticket wrongTicket = new Ticket(wrongCar);

        UnRecognizedParkingTicketException unRecognizedParkingTicketException = assertThrows(UnRecognizedParkingTicketException.class, () -> {
            parkingLot.fetchCar(wrongTicket);
        });
        assertEquals("Unrecognized parking ticket.", unRecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_fetch_car_given_parking_lot_and_without_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        parkingLot.parkCar(car);

        UnRecognizedParkingTicketException unRecognizedParkingTicketException = assertThrows(UnRecognizedParkingTicketException.class, () -> {
            parkingLot.fetchCar(null);
        });
        assertEquals("Unrecognized parking ticket.", unRecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_fetch_car_given_parking_lot_and_ticket_is_used() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.parkCar(car);
        parkingLot.parkCar(car);
        parkingLot.fetchCar(ticket);

        UnRecognizedParkingTicketException unRecognizedParkingTicketException = assertThrows(UnRecognizedParkingTicketException.class, () -> {
            parkingLot.fetchCar(ticket);
        });
        assertEquals("Unrecognized parking ticket.", unRecognizedParkingTicketException.getMessage());
    }
}
