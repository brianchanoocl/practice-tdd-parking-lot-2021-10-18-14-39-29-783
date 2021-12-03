package com.parkinglot;

public class UnRecognizedParkingTicketException extends RuntimeException{
    public UnRecognizedParkingTicketException(String message) {
        super(message);
    }
}
