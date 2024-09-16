package airline;

import java.util.Scanner;

public class Flight {
    private ReservationSystem reservationSystem;

    public Flight(ReservationSystem reservationSystem) {
        this.reservationSystem = reservationSystem;
    }

    public void addNewFlight() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Flight Number:");
        String flightNumber = scanner.nextLine();

        System.out.println("Enter Origin:");
        String origin = scanner.nextLine();

        System.out.println("Enter Destination:");
        String destination = scanner.nextLine();

        System.out.println("Enter Number of Available Seats:");
        int seatsAvailable = scanner.nextInt();

        // Create new flight object
        Flight newFlight = new Flight(flightNumber, origin, destination, seatsAvailable);

        // Add flight to reservation system
        reservationSystem.addFlight(newFlight);

        System.out.println("Flight added successfully.");
    }
}
