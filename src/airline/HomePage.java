package airline;

import java.util.Scanner;

public class HomePage {

    public static void displayUserMenu() {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("===== User Menu =====");
                System.out.println("1. View Flights");
                System.out.println("2. Book Flight");
                System.out.println("3. Cancel Flight");
                System.out.println("4. View Booked Flights");
                System.out.println("5. Exit");
                System.out.print("Select an option: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        ViewFlights.displayFlight();  
                        break;
                    case 2:
                        BookFlight.bookFlight();  
                        break;
                    case 3:
                        CancelFlight.cancelFlight(); 
                        break;
                    case 4:
                        ViewBookedFlight.viewBookedFlights();  
                        break;
                    case 5:
                        System.out.println("Exiting User Menu. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } finally {
            scanner.close();
        }
    }
}
