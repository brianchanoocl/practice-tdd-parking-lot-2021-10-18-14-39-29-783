package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartParkingBoyTest {
    @Test
    void should_return_ticket_in_first_parking_lot_when_park_car_given_super_smart_parking_boy_with_2_parking_lots_and_same_empty_position_rate_and_car() {
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        Ticket ticket = superSmartParkingBoy.parkCar(new Car());

        assertNotNull(ticket);
        assertEquals(9, parkingLot1.getAvailablePosition());
        assertEquals(10, parkingLot2.getAvailablePosition());
    }

    @Test
    void should_return_ticket_in_second_parking_lot_when_park_car_given_super_smart_parking_boy_with_2_parking_lots_and_secopnd_parking_lot_has_larger_empty_position_rate_and_car() {
        ParkingLot parkingLot1 = new ParkingLot();
        parkingLot1.parkCar(new Car());
        ParkingLot parkingLot2 = new ParkingLot(9);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        Ticket ticket = superSmartParkingBoy.parkCar(new Car());

        assertNotNull(ticket);
        assertEquals(9, parkingLot1.getAvailablePosition());
        assertEquals(8, parkingLot2.getAvailablePosition());
    }

    @Test
    void should_return_correct_car_form_2_parking_lots_when_fetch_car_given_super_smart_parking_boy_with_2_parking_lot_and_both_parking_lot_parked_car_and_2_tickets() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = superSmartParkingBoy.parkCar(car1);
        Ticket ticket2 = superSmartParkingBoy.parkCar(car2);

        Car carFetched1 = superSmartParkingBoy.fetchCar(ticket1);
        Car carFetched2 = superSmartParkingBoy.fetchCar(ticket2);

        assertEquals(carFetched1, car1);
        assertEquals(carFetched2, car2);
    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_fetch_car_given_super_smart_parking_boy_with_2_parking_lot_ticket_is_null() {
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        superSmartParkingBoy.parkCar(new Car());

        UnRecognizedParkingTicketException unRecognizedParkingTicketException = assertThrows(UnRecognizedParkingTicketException.class, () -> {
            superSmartParkingBoy.fetchCar(null);
        });
        assertEquals("Unrecognized parking ticket.", unRecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_fetch_car_given_super_smart_parking_boy_with_2_parking_lot_ticket_is_used() {
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);
        superSmartParkingBoy.parkCar(new Car());

        UnRecognizedParkingTicketException unRecognizedParkingTicketException = assertThrows(UnRecognizedParkingTicketException.class, () -> {
            superSmartParkingBoy.fetchCar(null);
        });
        assertEquals("Unrecognized parking ticket.", unRecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_throw_no_available_position_exception_when_park_car_given_super_smart_parking_boy_with_2_parking_lot_and_all_parking_lots_fulled_and_car() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        superSmartParkingBoy.parkCar(new Car());
        superSmartParkingBoy.parkCar(new Car());

        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, () -> {
            superSmartParkingBoy.parkCar(new Car());
        });
        assertEquals("No available position.", noAvailablePositionException.getMessage());
    }
}
