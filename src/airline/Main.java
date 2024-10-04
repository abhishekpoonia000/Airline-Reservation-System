package airline;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        Flight addFlights = new Flight(reservationSystem);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAirline Reservation System");
            System.out.println("1. Add Airline Employee");
            System.out.println("2. Add Flight");
            System.out.println("3. Display Flights");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Employee ID:");
                    String employeeID = scanner.nextLine();
                    System.out.println("Enter Employee Name:");
                    String employeeName = scanner.nextLine();
                    System.out.println("Enter Employee Role:");
                    String role = scanner.nextLine();

                    AddAirlineEmployee employee = new AddAirlineEmployee(employeeID, employeeName, role);
                    reservationSystem.addEmployee(employee);
                    System.out.println("Employee added successfully.");
                    break;

                case 2:
                    addFlights.addNewFlight();
                    break;

                case 3:
                    reservationSystem.displayFlights();
                    break;

                case 4:
                    reservationSystem.displayEmployees();
                    break;

                case 5:
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
