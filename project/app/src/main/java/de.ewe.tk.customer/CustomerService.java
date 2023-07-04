import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pilot_customers";
    private static final String USERNAME = "Testuser";
    private static final String PASSWORD = "Test123456*";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Register the JDBC driver (optional for newer versions of JDBC)
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Check if the connection is successful
            if (connection != null) {
                System.out.println("Database connection established!");
                // Perform database operations here
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}