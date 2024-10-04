package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CancelFlight {

    public static void cancelFlight() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("===== Cancel Flight =====");
            System.out.print("Enter Booking ID: ");
            String bookingID = scanner.nextLine();

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root",
                        "password");
                String sql = "DELETE FROM bookings WHERE bookingID = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, bookingID);
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Flight canceled successfully!");
                } else {
                    System.out.println("No booking found with the given ID.");
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            scanner.close();
        }
    }
}
