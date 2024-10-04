package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewPassenger {

    public static void viewPassengerDetails() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("===== View Passenger Details =====");
            System.out.print("Enter Passenger ID: ");
            String passengerID = scanner.nextLine();

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root",
                    "password")) {
                String sql = "SELECT * FROM passengers WHERE passengerID = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, passengerID);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Passenger Name: " + resultSet.getString("name"));
                    System.out.println("Email: " + resultSet.getString("email"));
                    System.out.println("Phone: " + resultSet.getString("phone"));
                    System.out.println("Nationality: " + resultSet.getString("nationality"));
                } else {
                    System.out.println("No passenger found with the given ID.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
