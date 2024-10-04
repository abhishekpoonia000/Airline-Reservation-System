package airline;

import java.util.Scanner;

public class AdminHomePage {
    public static void displayAdminMenu() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("===== Admin Home Page =====");
            System.out.println("1. Add Flight");
            System.out.println("2. View Flights");
            System.out.println("3. Update Flight");
            System.out.println("4. Delete Flight");
            System.out.println("5. Logout");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
