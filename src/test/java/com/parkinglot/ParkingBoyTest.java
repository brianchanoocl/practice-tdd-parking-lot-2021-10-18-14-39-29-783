package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_car_given_parking_boy_with_1_parking_lot_and_car() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        Ticket ticket = parkingBoy.parkCar(new Car());

        assertNotNull(ticket);
    }

    @Test
    void should_return_ticket_for_parking_lot_1_when_park_car_given_parking_boy_with_2_parking_lot_and_car() {
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        Ticket ticket = parkingBoy.parkCar(new Car());

        assertNotNull(ticket);
        assertEquals(9, parkingLot1.getAvailablePosition());
        assertEquals(10, parkingLot2.getAvailablePosition());
    }

    @Test
    void should_return_ticket_for_parking_lot_2_when_park_car_given_parking_boy_with_2_parking_lot_and_parking_lot_1_fulled_and_car() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        parkingBoy.parkCar(new Car());
        Ticket ticket = parkingBoy.parkCar(new Car());

        assertNotNull(ticket);
        assertEquals(0, parkingLot1.getAvailablePosition());
        assertEquals(9, parkingLot2.getAvailablePosition());
    }

    @Test
    void should_throw_no_available_position_exception_when_park_car_given_parking_boy_with_2_parking_lot_and_all_parking_lots_fulled_and_car() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        parkingBoy.parkCar(new Car());
        parkingBoy.parkCar(new Car());

        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, () -> {
            parkingBoy.parkCar(new Car());
        });
        assertEquals("No available position.", noAvailablePositionException.getMessage());
    }

    @Test
    void should_return_correct_car_form_2_parking_lots_when_fetch_car_given_parking_boy_with_2_parking_lot_and_both_parking_lot_parked_car_and_2_tickets() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Ticket ticket2 = parkingBoy.parkCar(car2);

        Car carFetched1 = parkingBoy.fetchCar(ticket1);
        Car carFetched2 = parkingBoy.fetchCar(ticket2);

        assertEquals(carFetched1, car1);
        assertEquals(carFetched2, car2);
    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_fetch_car_given_parking_boy_with_2_parking_lot_ticket_is_null() {
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.parkCar(new Car());

        UnRecognizedParkingTicketException unRecognizedParkingTicketException = assertThrows(UnRecognizedParkingTicketException.class, () -> {
            parkingBoy.fetchCar(null);
        });
        assertEquals("Unrecognized parking ticket.", unRecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_fetch_car_given_parking_boy_with_2_parking_lot_ticket_is_used() {
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.parkCar(new Car());

        UnRecognizedParkingTicketException unRecognizedParkingTicketException = assertThrows(UnRecognizedParkingTicketException.class, () -> {
            parkingBoy.fetchCar(null);
        });
        assertEquals("Unrecognized parking ticket.", unRecognizedParkingTicketException.getMessage());
    }

}
