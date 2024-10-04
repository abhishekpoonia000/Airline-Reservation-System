package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddPassengerDetails {

    public static void addPassenger() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("===== Add Passenger Details =====");
            System.out.print("Enter Passenger Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root",
                    "password")) {
                String sql = "INSERT INTO passengers (name, email) VALUES (?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, name);
                    statement.setString(2, email);
                    statement.executeUpdate();
                    System.out.println("Passenger added successfully!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
