import java.util.List;

import util.IO;

public class CustomerController {
    public static void main(String[] args) throws Exception {

        String[] choices = { "Neukunden einpflegen", "Kundendaten verändern", "Kunden löschen", "Kunden suchen",
                "Alle Kunden anzeigen" };

        /**
         * System.out.println("Datenbank einbinden");
         * System.out.println("\tDatenbank wurde noch nicht eingebunden");
         * System.out.println("---------------");
         * System.out.println("Eingabe des Kunden");
         * System.out.println("---------------");
         **/
        System.out.println("Was wollen Sie tun?\n");

        printList(choices);
        int choice = getinputUser(choices);

        if (choice == 5) {
            showAllUsers();
        }

        /*
         * System.out.println("---------------");
         * System.out.println("Daten annehmen / verarbeiten");
         * System.out.println("");
         * System.out.println("Daten in DB speichern");
         * System.out.println("");
         * System.out.println("Erfolgsmeldung an den User");
         * System.out.println("");
         **/
    }

    /* functions */
    static void printList(String[] list) {
        for (int i = 1; i <= list.length; i++) {
            System.out.println(i + ". " + list[i - 1]);
        }
        IO.print("");
    }

    static int getinputUser(String[] list) {
        int choice = IO.readInt("Nummer: ");
        System.out.println("\nGewählt: " + list[choice - 1] + "\n");
        return choice;
    }

    static void addUser() {
    }

    static void updateUser() {
    }

    static void deleteUser() {
    }

    static void searchUser() {
    }

    static void showAllUsers() {
        String query = "SELECT * FROM pilot_customers.customers;";
        /**
         * ResultSet rs = CustomerService.main(query);
         **/
        System.out.println("Alle Kunden:\n");

        /** ResultSetDemo.main(null, query); **/
        List<Customer> CustomerList = GetUserInput.main(null, query);

        // CreateTable.execute(CustomerList);

        System.out.printf(
                "%-3s | %-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10s | %-10s | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                "Nr.", "Anrede", "Titel", "Vorname", "Nachname", "Geburtsdatum", "Straße",
                "Hausnr.", "PLZ", "Ort",
                "Telefon", "Mobil", "Fax", "E-Mail", "Newsletter");

        // Trennlinie ausgeben
        System.out.println(
                "===================================================================================================================================================================================================================================================================================================");

        // Jeden Kunden in der Liste ausgeben
        for (Customer customer : CustomerList) {
            System.out.printf(
                    "%-3d | %-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10d | %-10d | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                    customer.getCustomernumber(), customer.getSalulation(), customer.getTitel(),
                    customer.getName(),
                    customer.getLastName(),
                    customer.getBirthdate(), customer.getStreet(), customer.getStreetnumber(),
                    customer.getPostcode(),
                    customer.getTown(),
                    customer.getPhonenumber(), customer.getMobilephonenumeber(),
                    customer.getFax(), customer.getEmail(),
                    customer.getNewsletter() == 1 ? "Ja" : "Nein");
        }
    }
}