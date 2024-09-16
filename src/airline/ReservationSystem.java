package airline;

import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {
    private List<Flight> flights;
    private List<AddAirlineEmployee> employees;

    public ReservationSystem() {
        flights = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void addEmployee(AddAirlineEmployee employee) {
        employees.add(employee);
    }

    public void displayFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            for (Flight flight : flights) {
                System.out.println(flight);
            }
        }
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
        } else {
            for (AddAirlineEmployee employee : employees) {
                System.out.println(employee);
            }
        }
    }
}
