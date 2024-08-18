package airline;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class ReservationSystem {
    private Flight[] flights;
    private Scanner scanner;

    public ReservationSystem() {
        flights = new Flight[] {
                new Flight("AI101", "New York", "Los Angeles", 100),
                new Flight("AI102", "Chicago", "Miami", 80)
        };
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            String menu = "1. View Flights\n2. Book a Flight\n3. Cancel a Booking\n4. Exit";
            String choice = JOptionPane.showInputDialog(menu);
            switch (choice) {
                case "1":
                    viewFlights();
                    break;
                case "2":
                    bookFlight();
                    break;
                case "3":
                    cancelBooking();
                    break;
                case "4":
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice, please try again.");
            }
        }
    }

    private void viewFlights() {
        StringBuilder flightList = new StringBuilder();
        for (Flight flight : flights) {
            flightList.append(flight.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, flightList.toString());
    }

    private void bookFlight() {
        String flightNumber = JOptionPane.showInputDialog("Enter flight number:");
        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            String name = JOptionPane.showInputDialog("Enter passenger name:");
            String email = JOptionPane.showInputDialog("Enter passenger email:");
            Passenger passenger = new Passenger(name, email);
            Booking booking = flight.book(passenger);
            JOptionPane.showMessageDialog(null, "Booking successful! Booking ID: " + booking.getId());
        } else {
            JOptionPane.showMessageDialog(null, "Flight not found.");
        }
    }

    private void cancelBooking() {
        String flightNumber = JOptionPane.showInputDialog("Enter flight number:");
        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            String bookingId = JOptionPane.showInputDialog("Enter booking ID:");
            if (flight.cancelBooking(bookingId)) {
                JOptionPane.showMessageDialog(null, "Booking canceled successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Booking ID not found.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Flight not found.");
        }
    }

    private Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }
}
