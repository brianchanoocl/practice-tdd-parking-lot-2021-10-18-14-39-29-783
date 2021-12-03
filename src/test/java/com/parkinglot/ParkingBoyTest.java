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
}
