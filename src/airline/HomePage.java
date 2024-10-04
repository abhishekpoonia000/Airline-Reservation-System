package airline;

import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize the Scanner
        try {
            System.out.println("===== Airline Reservation System =====");
            System.out.println("1. Book Flight");
            System.out.println("2. View Flights");
            System.out.println("3. Cancel Flight");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Code to book flight
                    break;
                case 2:
                    // Code to view flights
                    break;
                case 3:
                    CancelFlight.cancelFlight();
                    break;
                case 4:
                    System.out.println("Thank you for using the Airline Reservation System.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } finally {
            scanner.close(); // Ensure the Scanner is closed to prevent resource leak
        }
    }
}
