package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    public static Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/airline";
        String user = "root";
        String password = "password";

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Failed to establish a connection to the database.");
            e.printStackTrace();
        }

        return connection;
    }
}
