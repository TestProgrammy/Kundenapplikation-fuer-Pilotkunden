import java.util.List;

import util.IO;

public class CustomerController {
    public static void main(String[] args) throws Exception {

        String[] choices = { "Neukunden einpflegen", "Kundendaten verändern", "Kunden löschen", "Kunden suchen",
                "Alle Kunden anzeigen", "Beenden" };

        while (true) {
            System.out.println("\nWas wollen Sie tun?\n");

            // Get User choice
            printList(choices);
            int choice = getinputUser(choices);
            String isNotBreak = "y";

            switch (choice) {
                case 1:
                    while (true) {
                        addUser();
                        isNotBreak = IO.readString("Weiter? j/n");
                        if (isNotBreak != "j") {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        updateUser();
                        isNotBreak = IO.readString("Weiter? j/n");
                        if (isNotBreak != "j") {
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        deleteUser();
                        isNotBreak = IO.readString("Weiter? j/n");
                        if (isNotBreak != "j") {
                            break;
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        searchUser();
                        isNotBreak = IO.readString("Weiter? j/n");
                        if (isNotBreak != "j") {
                            break;
                        }
                    }
                    break;
                case 5:
                    showAllUsers();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
            }
            waitForEnter();
        }
    }

    /* functions */
    static void printList(String[] list) {
        for (int i = 1; i <= list.length; i++) {
            System.out.println(i + ". " + list[i - 1]);
        }
        System.out.println("");
        return;
    }

    static int getinputUser(String[] list) {
        int choice = IO.readInt("Nummer: ");
        System.out.println("\nGewählt: " + list[choice - 1] + "\n");
        return choice;
    }

    static void addUser() {
        // int customerNumber = IO.readString("Titel: ");
        String salulation = IO.readString("Anrede: ");
        String titel = IO.readString("Titel: ");
        String name = IO.readString("Vorname: ");
        String lastName = IO.readString("Nachname: ");
        String birthdate = IO.readString("Geburtsdatum: ");
        String street = IO.readString("Straße: ");
        int streetNumber = IO.readInt("Hausnr.: ");
        int postcode = IO.readInt("PLZ: ");
        String town = IO.readString("Stadt: ");
        String phoneNumber = IO.readString("Telefonnr.: ");
        String mobilephonenNumeber = IO.readString("Handynr.: ");
        String fax = IO.readString("Fax: ");
        String tempnewsletter = IO.readString("Newsletter: Ja/Nein");
        int newsletter = tempnewsletter == "Ja" ? 1 : 0;

        String query = "INSERT INTO pilot_customers.customers ?;";// , salulation, titel, name, lastName, birthdate,
                                                                  // street, streetNumber, postcode, town, phoneNumber,
                                                                  // mobilephonenNumeber, fax, newsletter, ";";
        System.out.println("Query: \n" + query + "\n");
        System.out.printf(
                "%-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10s | %-10s | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                "Anrede", "Titel", "Vorname", "Nachname", "Geburtsdatum", "Straße",
                "Hausnr.", "PLZ", "Ort",
                "Telefon", "Mobil", "Fax", "E-Mail", "Newsletter");
        System.out.printf(
                "%-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10d | %-10d | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                salulation, titel, name, lastName, birthdate, street, streetNumber, postcode, town, phoneNumber,
                mobilephonenNumeber, fax, newsletter);
        String isOkay = IO.readString("Richtig? j/n");
        if (isOkay == "j") {
            showUsers(query);
            // meldung?
        }
        return;
    }

    static void updateUser() {
        // fragen was upgedated werden soll?
        String query = "UPDATE ....;";
        System.out.println("Query: \n" + query + "\n");
        String isOkay = IO.readString("Richtig? j/n");
        if (isOkay == "j") {
            showUsers(query);
            // meldung?
        }
        return;
    }

    static void deleteUser() {
        int nr = IO.readInt("Kundennummer des zulöschenden Kunden: ");
        String query = "DELETE * FROM pilot_customers.customers WHERE customer_number = " + nr + ";";
        System.out.println("Query: \n" + query + "\n");
        String showQuery = "SELECT * FROM pilot_cutomers.customers WHERE customer_number = " + nr + ";";
        showUsers(showQuery);
        String isOkay = IO.readString("Richtig? j/n");
        if (isOkay == "j") {
            showUsers(query);
            // meldung?
        }
        return;
    }

    static void searchUser() {
        String what = IO.readString("Suchbegriff: ");
        String query = "SELECT * FROM pilot_customers.customers WHERE name LIKE '%" + what + "%' OR last_name LIKE '%"
                + what + "%';";
        System.out.println("Suchergebnisse: \n");
        System.out.println(query);
        showUsers(query);
        return;
    }

    static void showAllUsers() {
        String query = "SELECT * FROM pilot_customers.customers;";
        System.out.println("Alle Kunden:\n");
        showUsers(query);
        return;
    }

    static void showUsers(String query) {
        // Holt die Daten
        List<Customer> CustomerList = CustomerService.main(null, query);

        // Kopfzeile
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
        return;
    }

    static void waitForEnter() {
        IO.readString("Drücke Enter ...");
        return;
    }
}
