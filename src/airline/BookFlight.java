package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookFlight {

    public static void bookFlight() {
        // Using try-with-resources for the Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("===== Book Flight =====");
            System.out.print("Enter Passenger Name: ");
            String passengerName = scanner.nextLine();
            System.out.print("Enter Flight Number: ");
            String flightNumber = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root",
                        "password");
                String sql = "INSERT INTO bookings (passengerName, flightNumber, email) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, passengerName);
                statement.setString(2, flightNumber);
                statement.setString(3, email);
                statement.executeUpdate();

                System.out.println("Flight booked successfully!");
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } // Scanner is closed automatically here
    }
}
