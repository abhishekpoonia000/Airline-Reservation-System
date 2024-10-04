package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePassengers {

    public static void updatePassenger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Update Passenger Details =====");
        System.out.print("Enter Passenger ID: ");
        String passengerID = scanner.nextLine();
        System.out.print("Enter New Email: ");
        String newEmail = scanner.nextLine();
        System.out.print("Enter New Phone Number: ");
        String newPhone = scanner.nextLine();

        // Confirmation before updating
        System.out.println("Confirm update? (yes/no)");
        String confirmation = scanner.nextLine();

        if (!confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Update cancelled.");
            return;
        }

        String sql = "UPDATE passengers SET email = ?, phone = ? WHERE passengerID = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root",
                "password");
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newEmail);
            statement.setString(2, newPhone);
            statement.setString(3, passengerID);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Passenger details updated successfully!");
            } else {
                System.out.println("No passenger found with the given ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating passenger details: " + e.getMessage());
        }
    }
}
