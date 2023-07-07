import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public static List<Customer> main(String[] args, String query) {
        Connection conn = null;
        Statement stmt = null;
        List<Customer> customerList = new ArrayList<Customer>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pilot_customers", "Testuser",
                    "Test123456*");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Customer customer = new Customer(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8),
                        rs.getInt(9), rs.getString(10),
                        rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
                        rs.getInt(15));

                customerList.add(customer);

            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return customerList;

    }

    public static boolean deleteCustomer(Integer customerNumber) {
        String deleteQuery = String.format("DELETE FROM customers WHERE customer_number = %d;",
                customerNumber);
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pilot_customers", "Testuser",
                    "Test123456*");
            stmt = conn.createStatement();
            int rs = stmt.executeUpdate(deleteQuery);

            if (rs == 0) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }

        return true;
    }

    public static boolean insertCustomer(Customer customer) {
        String query = String.format(
                "INSERT into pilot_customers.customers (customer_number, salutation, title, name, last_name, birth_date, street, street_number, postcode, town, phone_number, mobile_number, fax, e_mail, newsletter) values(%d, '%s', '%s', '%s', '%s', '%s', '%s', %d, %d, '%s', '%s', '%s', '%s', '%s', %d);",
                customer.getCustomernumber(), customer.getSalulation(), customer.getTitel(),
                customer.getName(), customer.getLastName(), customer.getBirthdate(), customer.getStreet(),
                customer.getStreetnumber(),
                customer.getPostcode(), customer.getTown(),
                customer.getPhonenumber(), customer.getMobilephonenumeber(),
                customer.getFax(), customer.getEmail(),
                customer.getNewsletter());

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pilot_customers", "Testuser",
                    "Test123456*");
            stmt = conn.createStatement();
            int rs = stmt.executeUpdate(query);

            if (rs == 0) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
            }
        }

        return true;
    }

}