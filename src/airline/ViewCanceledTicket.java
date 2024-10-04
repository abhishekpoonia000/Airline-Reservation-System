package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewCanceledTicket {

    public static void viewCanceledTickets() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== View Canceled Tickets =====");
        System.out.print("Enter Passenger ID: ");
        String passengerID = scanner.nextLine();

        String sql = "SELECT * FROM canceled_tickets WHERE passengerID = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root",
                "password");
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, passengerID);
            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.isBeforeFirst()) { // Check if no records found
                System.out.println("No canceled tickets found for Passenger ID: " + passengerID);
            } else {
                while (resultSet.next()) {
                    System.out.println("Canceled Ticket ID: " + resultSet.getString("ticketID"));
                    System.out.println("Flight Number: " + resultSet.getString("flightNumber"));
                    System.out.println("Cancellation Date: " + resultSet.getString("cancelDate"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving canceled tickets: " + e.getMessage());
        }
    }
}
