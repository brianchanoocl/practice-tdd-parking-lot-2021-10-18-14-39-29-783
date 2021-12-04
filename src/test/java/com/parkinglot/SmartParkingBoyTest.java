package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class SmartParkingBoyTest {
    @Test
    void should_return_ticket_in_first_parking_lot_when_park_car_given_smart_parking_boy_with_2_parking_lots_and_same_empty_position_and_car() {
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        Ticket ticket = smartParkingBoy.parkCar(new Car());

        assertNotNull(ticket);
        assertEquals(9, parkingLot1.getAvailablePosition());
        assertEquals(10, parkingLot2.getAvailablePosition());
    }

    @Test
    void should_return_ticket_in_second_parking_lot_when_park_car_given_smart_parking_boy_with_2_parking_lots_and_secopnd_parking_lot_has_more_empty_position_and_car() {
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot();
        ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        Ticket ticket = smartParkingBoy.parkCar(new Car());

        assertNotNull(ticket);
        assertEquals(5, parkingLot1.getAvailablePosition());
        assertEquals(9, parkingLot2.getAvailablePosition());
    }
}
