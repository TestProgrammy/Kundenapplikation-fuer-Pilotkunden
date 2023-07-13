import java.util.ArrayList;
import java.util.List;

public class OutputCustomerService {

    static void showAllUsers() {
        List<Customer> customerList = CustomerService.getCustomer(0);
        System.out.println("Alle Kunden:\n");
        printList(customerList);
    }

    static void showUser(Customer customer) {
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer);
        printList(customerList);
    }

    static boolean showSearchUser(int customerNumber) {
        List<Customer> customerList = CustomerService.getCustomer(customerNumber);

        if (customerList.size() == 0) {
            System.out.printf(
                    "Die Kundennummer %d ist nicht vorhanden.\n",
                    customerNumber);
            return false;
        }
        printList(customerList);
        return true;
    }

    static void printList(List<Customer> customerList) {
        System.out.printf(
                "%-3s | %-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10s | %-10s | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                "Nr.", "Anrede", "Titel", "Vorname", "Nachname", "Geburtsdatum", "Straße",
                "Hausnr.", "PLZ", "Ort",
                "Telefon", "Mobil", "Fax", "E-Mail", "Newsletter");

        System.out.println(
                "===================================================================================================================================================================================================================================================================================================");

        for (Customer customer : customerList) {
            System.out.printf(
                    "%-3d | %-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10d | %-10s | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                    customer.getCustomerNumber(), customer.getSalutation(), customer.getTitle(),
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