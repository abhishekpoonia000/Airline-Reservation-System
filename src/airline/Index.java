package airline;

import java.util.Scanner;

public class Index {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("===== Airline Reservation System =====");
                System.out.println("1. Admin Login");
                System.out.println("2. User Login");
                System.out.println("3. Exit");
                System.out.print("Select an option: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        if (AdminLoginPage.adminLogin()) {
                            AdminHomePage.displayAdminMenu();
                        }
                        break;
                    case 2:
                        if (Login.userLogin()) {
                            HomePage.displayUserMenu();
                        }
                        break;
                    case 3:
                        System.out.println("Thank you for using the Airline Reservation System. Goodbye!");
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
