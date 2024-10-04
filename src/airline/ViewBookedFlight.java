package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewBookedFlight {

    public static void viewBookedFlights() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("===== View Booked Flights =====");
            System.out.print("Enter Passenger ID: ");
            String passengerID = scanner.nextLine();

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root",
                    "password")) {
                String sql = "SELECT * FROM bookings WHERE passengerID = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, passengerID);
                ResultSet resultSet = statement.executeQuery();

                if (!resultSet.isBeforeFirst()) {
                    System.out.println("No booked flights found for the given Passenger ID.");
                } else {
                    while (resultSet.next()) {
                        System.out.println("Booking ID: " + resultSet.getString("bookingID"));
                        System.out.println("Flight Number: " + resultSet.getString("flightNumber"));
                        System.out.println("Booking Date: " + resultSet.getString("bookingDate"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
