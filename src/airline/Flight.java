package com.airline;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int capacity;
    private List<Booking> bookings;

    public Flight(String flightNumber, String origin, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
        this.bookings = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Booking book(Passenger passenger) {
        if (bookings.size() < capacity) {
            Booking booking = new Booking(passenger, this);
            bookings.add(booking);
            return booking;
        } else {
            throw new RuntimeException("Flight is fully booked.");
        }
    }

    public boolean cancelBooking(String bookingId) {
        return bookings.removeIf(booking -> booking.getId().equals(bookingId));
    }

    @Override
    public String toString() {
        return flightNumber + " (" + origin + " -> " + destination + ") Capacity: " + capacity;
    }
}
