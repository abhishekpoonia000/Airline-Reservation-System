package airline;

import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {
    private List<Flight> flights;
    private List<Employee> employees;

    public ReservationSystem() {
        flights = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight " + flight.getFlightNumber() + " added successfully.");
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee " + employee.getName() + " added successfully.");
    }

    public void displayFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            System.out.println("Available Flights:");
            for (Flight flight : flights) {
                System.out.println(flight);
            }
        }
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
        } else {
            System.out.println("Employees:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
}
