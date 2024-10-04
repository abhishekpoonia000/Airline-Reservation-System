package airline;

import java.util.List;

public class ViewFlights {

    public void displayFlights(List<Flight> flights) {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            System.out.println("Available Flights:");
            for (Flight flight : flights) {
                System.out.println("Flight Number: " + flight.getFlightNumber());
                System.out.println("Destination: " + flight.getDestination());
                System.out.println("Departure Time: " + flight.getDepartureTime());
                System.out.println("Arrival Time: " + flight.getArrivalTime());
                System.out.println("---------------------------");
            }
        }
    }
}
