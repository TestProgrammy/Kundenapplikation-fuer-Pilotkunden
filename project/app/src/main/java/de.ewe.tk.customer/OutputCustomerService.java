import java.util.List;

public class OutputCustomerService {

    static void showAllUsers() {
        String query = "SELECT * FROM pilot_customers.customers;";
        System.out.println("Alle Kunden:\n");
        showUsers(query);
        return;
    }

    static void showUsers(String query) {
        showUsers(query, null);
    }

    static void showUsers(String query, List<Customer> CustomerList) {
        if (CustomerList == null) {
            CustomerList = CustomerService.getCustomer(query);
        }

        System.out.printf(
                "%-3s | %-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10s | %-10s | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                "Nr.", "Anrede", "Titel", "Vorname", "Nachname", "Geburtsdatum", "Straße",
                "Hausnr.", "PLZ", "Ort",
                "Telefon", "Mobil", "Fax", "E-Mail", "Newsletter");

        System.out.println(
                "===================================================================================================================================================================================================================================================================================================");

        for (Customer customer : CustomerList) {
            System.out.printf(
                    "%-3d | %-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10d | %-10d | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                    customer.getCustomerNumber(), customer.getSalutation(), customer.getTitel(),
                    customer.getName(),
                    customer.getLastName(),
                    customer.getBirthdate(), customer.getStreet(), customer.getStreetNumber(),
                    customer.getPostcode(),
                    customer.getTown(),
                    customer.getPhoneNumber(), customer.getMobileNumber(),
                    customer.getFax(), customer.getEmail(),
                    customer.getNewsletter() == 1 ? "Ja" : "Nein");
        }
        return;
    }
}
