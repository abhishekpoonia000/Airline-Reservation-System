package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateFlights {

    public static void updateFlight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Update Flight Details =====");
        System.out.print("Enter Flight Number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter New Destination: ");
        String newDestination = scanner.nextLine();
        System.out.print("Enter New Departure Time: ");
        String newDepartureTime = scanner.nextLine();
        System.out.print("Enter New Arrival Time (optional, press Enter to skip): ");
        String newArrivalTime = scanner.nextLine();

        // Check if the user really wants to update
        System.out.println("Confirm update? (yes/no)");
        String confirmation = scanner.nextLine();

        if (!confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Update cancelled.");
            return;
        }

        String sql = "UPDATE flights SET destination = ?, departureTime = ?" +
                (newArrivalTime.isEmpty() ? "" : ", arrivalTime = ?") +
                " WHERE flightNumber = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root",
                "password");
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newDestination);
            statement.setString(2, newDepartureTime);

            if (!newArrivalTime.isEmpty()) {
                statement.setString(3, newArrivalTime);
                statement.setString(4, flightNumber);
            } else {
                statement.setString(3, flightNumber);
            }

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Flight updated successfully!");
            } else {
                System.out.println("No flight found with the given flight number.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating flight: " + e.getMessage());
        }
    }
}
