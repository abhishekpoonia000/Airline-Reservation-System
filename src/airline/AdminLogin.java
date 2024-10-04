package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogin {

    public static boolean adminLogin() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("===== Admin Login =====");
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root",
                        "password");
                String sql = "SELECT * FROM admins WHERE username = ? AND password = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Login Successful! Welcome, " + resultSet.getString("username"));
                    return true;
                } else {
                    System.out.println("Invalid Credentials. Try Again.");
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
