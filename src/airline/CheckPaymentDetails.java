package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckPaymentDetails {

    public static void checkPayment(Scanner scanner) {
        System.out.println("===== Check Payment Details =====");
        System.out.print("Enter Booking ID: ");
        String bookingID = scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/airline";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM payments WHERE bookingID = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, bookingID);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Payment ID: " + resultSet.getString("paymentID"));
                    System.out.println("Amount: " + resultSet.getDouble("amount"));
                    System.out.println("Payment Status: " + resultSet.getString("status"));
                } else {
                    System.out.println("No payment details found for this booking.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while retrieving payment details. Please try again later.");
            e.printStackTrace();
        }
    }
}
