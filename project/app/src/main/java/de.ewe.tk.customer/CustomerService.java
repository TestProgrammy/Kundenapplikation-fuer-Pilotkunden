import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    static String user = Access.user;
    static String password = Access.password;
    static Connection connection = getConnection();

    private static Connection getConnection() {
        try {
            if (user == null || password == null) {
                System.out.println("Anmeldedaten wurden nicht gefunden!");
                return null;
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pilot_customers", user,
                    password);
            return connection;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static Statement getStatement(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static ResultSet getResultSet(String query, Statement statement) {
        try {
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static int getResultInt(String query, Statement statement) {
        try {
            int result = statement.executeUpdate(query);
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Customer> getCustomer(int customerNumber) {
        String query;
        if (customerNumber == 0) {
            query = "SELECT * FROM pilot_customers.customers;";
        } else {
            query = String.format("SELECT * FROM pilot_customers.customers WHERE customer_number = %d;",
                    customerNumber);
        }
        List<Customer> customerList = new ArrayList<Customer>();
        ResultSet rs = getResultSet(query, getStatement(connection));
        try {
            while (rs.next()) {
                Customer customer = new Customer(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8),
                        rs.getInt(9), rs.getString(10),
                        rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
                        rs.getInt(15));
                customerList.add(customer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return customerList;
    }

    public static boolean deleteCustomer(Integer customerNumber) {
        String query = String.format("DELETE FROM customers WHERE customer_number = %d;",
                customerNumber);
        int rs = getResultInt(query, getStatement(connection));

        if (rs == 0) {
            System.out.printf("Kundennummer %d gibt es nicht.", customerNumber);
            return false;
        }
        return true;
    }

    public static boolean insertCustomer(Customer customer) {
        String query = String.format(
                "INSERT into pilot_customers.customers (salutation, title, name, last_name, birth_date, street, street_number, postcode, town, phone_number, mobile_number, fax, e_mail, newsletter) values('%s', '%s', '%s', '%s', '%s', '%s', %d, %d, '%s', '%s', '%s', '%s', '%s', %d);",
                customer.getSalutation(), customer.getTitle(),
                customer.getName(), customer.getLastName(), customer.getBirthdate(), customer.getStreet(),
                customer.getStreetNumber(),
                customer.getPostcode(), customer.getTown(),
                customer.getPhoneNumber(), customer.getMobileNumber(),
                customer.getFax(), customer.getEmail(),
                customer.getNewsletter());

        int rs = getResultInt(query, getStatement(connection));

        if (rs == 0) {
            System.out.println("Das Anlegen des Kunden hat nicht funktioniert.");
            return false;
        }
        return true;
    }

    public static boolean updateCustomer(Customer customer) {
        String query = String.format(
                "Update pilot_customers.customers SET salutation = '%s', title = '%s', name = '%s', last_name = '%s', birth_date = '%s', street = '%s', street_number = %d, postcode = %d, town = '%s', phone_number = '%s', mobile_number = '%s', fax = '%s', e_mail = '%s', newsletter = %d WHERE customer_number = %d;",
                customer.getSalutation(), customer.getTitle(),
                customer.getName(), customer.getLastName(), customer.getBirthdate(), customer.getStreet(),
                customer.getStreetNumber(),
                customer.getPostcode(), customer.getTown(),
                customer.getPhoneNumber(), customer.getMobileNumber(),
                customer.getFax(), customer.getEmail(),
                customer.getNewsletter(), customer.getCustomerNumber());

        int rs = getResultInt(query, getStatement(connection));

        if (rs == 0) {
            System.out.println("Das Verändern des Kunden hat nicht funktioniert.");
            return false;
        }
        return true;
    }
}