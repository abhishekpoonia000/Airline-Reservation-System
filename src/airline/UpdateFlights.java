package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateFlights {

    public static void updateFlight() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("===== Update Flight Details =====");
            System.out.print("Enter Flight Number: ");
            String flightNumber = scanner.nextLine();
            System.out.print("Enter New Destination: ");
            String newDestination = scanner.nextLine();
            System.out.print("Enter New Departure Time: ");
            String newDepartureTime = scanner.nextLine();

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root",
                    "password")) {
                String sql = "UPDATE flights SET destination = ?, departureTime = ? WHERE flightNumber = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, newDestination);
                statement.setString(2, newDepartureTime);
                statement.setString(3, flightNumber);
                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Flight updated successfully!");
                } else {
                    System.out.println("Flight not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
