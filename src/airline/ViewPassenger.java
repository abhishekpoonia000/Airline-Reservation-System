package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewPassenger {

    public static void viewPassengerDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== View Passenger Details =====");
        System.out.print("Enter Passenger ID: ");
        String passengerID = scanner.nextLine();

        String sql = "SELECT * FROM passengers WHERE passengerID = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root",
                "password");
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, passengerID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("===== Passenger Details =====");
                System.out.println("Passenger Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Phone: " + resultSet.getString("phone"));
                System.out.println("Nationality: " + resultSet.getString("nationality"));
            } else {
                System.out.println("No passenger found with the given ID: " + passengerID);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving passenger details: " + e.getMessage());
        }
    }
}
