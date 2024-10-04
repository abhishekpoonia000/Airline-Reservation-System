package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewCanceledTicket {

    public static void viewCanceledTickets() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("===== View Canceled Tickets =====");
            System.out.print("Enter Passenger ID: ");
            String passengerID = scanner.nextLine();

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root",
                    "password")) {
                String sql = "SELECT * FROM canceled_tickets WHERE passengerID = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, passengerID);
                ResultSet resultSet = statement.executeQuery();

                if (!resultSet.isBeforeFirst()) {
                    System.out.println("No canceled tickets found for the given Passenger ID.");
                } else {
                    while (resultSet.next()) {
                        System.out.println("Canceled Ticket ID: " + resultSet.getString("ticketID"));
                        System.out.println("Flight Number: " + resultSet.getString("flightNumber"));
                        System.out.println("Cancellation Date: " + resultSet.getString("cancelDate"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
