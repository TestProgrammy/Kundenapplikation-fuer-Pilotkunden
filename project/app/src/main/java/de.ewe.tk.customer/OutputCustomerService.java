import java.util.ArrayList;
import java.util.List;

public class OutputCustomerService {

    static void showAllUsers() {
        System.out.println("Alle Kunden:\n");
        List<Customer> customers = CustomerService.getCustomer(0);

        if (customers == null) {
            return;
        }

        printCustomers(customers);
    }

    static void showUser(Customer customer) {
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        printCustomers(customers);
    }

    static boolean showSearchUser(int customerNumber) {
        List<Customer> customers = CustomerService.getCustomer(customerNumber);

        if (customers == null) {
            return false;
        }

        if (customers.size() == 0) {
            System.out.printf(
                    "Die Kundennummer %d ist nicht vorhanden.\n",
                    customerNumber);
            return false;
        }
        printCustomers(customers);
        return true;
    }

    static void printCustomers(List<Customer> customers) {
        System.out.printf(
                "%-3s | %-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10s | %-10s | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                "Nr.", "Anrede", "Titel", "Vorname", "Nachname", "Geburtsdatum", "Straße",
                "Hausnr.", "PLZ", "Stadt",
                "Telefon", "Mobil", "Fax", "E-Mail", "Newsletter");

        System.out.println(
                "===================================================================================================================================================================================================================================================================================================");

        for (Customer customer : customers) {
            System.out.printf(
                    "%-3s | %-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10d | %-10s | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                    customer.getCustomerNumber() == null ? "" : String.valueOf(customer.getCustomerNumber()),
                    customer.getSalutation(), customer.getTitle(),
                    customer.getName(),
                    customer.getLastName(),
                    customer.getBirthdate(), customer.getStreet(), customer.getStreetNumber(),
                    customer.getPostcode(),
                    customer.getTown(),
                    customer.getPhoneNumber(), customer.getMobileNumber(),
                    customer.getFax(), customer.getEmail(),
                    customer.getNewsletter() == 1 ? "Ja" : "Nein");
        }
    }
}