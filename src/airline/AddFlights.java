package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddFlights {

    public static void addFlight() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("===== Add Flight =====");
            System.out.print("Enter Flight Number: ");
            String flightNumber = scanner.nextLine();
            System.out.print("Enter Destination: ");
            String destination = scanner.nextLine();
            System.out.print("Enter Departure Time: ");
            String departureTime = scanner.nextLine();
            System.out.print("Enter Arrival Time: ");
            String arrivalTime = scanner.nextLine();

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root",
                        "password");
                String sql = "INSERT INTO flights (flightNumber, destination, departureTime, arrivalTime) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, flightNumber);
                statement.setString(2, destination);
                statement.setString(3, departureTime);
                statement.setString(4, arrivalTime);
                statement.executeUpdate();
                System.out.println("Flight added successfully!");
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            scanner.close();
        }
    }
}
