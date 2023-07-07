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
            String isNotBreak = "j";

            switch (choice) {
                case 1:
                    while (true) {
                        addUser();
                        isNotBreak = IO.readString("Weiter? j/n ");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        updateUser();
                        isNotBreak = IO.readString("Weiter? j/n ");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        deleteUser();
                        isNotBreak = IO.readString("Weiter? j/n ");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        searchUser();
                        isNotBreak = IO.readString("Weiter? j/n ");
                        if (!isNotBreak.equals("j")) {
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
        // System.out.println("\nGewählt: " + list[choice - 1] + "\n");
        return choice;
    }

    static void addUser() {
        System.out.println("Neuen Kunden eingeben:\n");

        Customer customer = new Customer(IO.readInt("Kundennummer: "), IO.readString("Anrede: "),
                IO.readString("Titel: "), IO.readString("Vorname: "), IO.readString("Nachname: "),
                IO.readString("Geburtsdatum: "), IO.readString("Straße: "), IO.readInt("Hausnr.: "),
                IO.readInt("PLZ: "), IO.readString("Stadt: "), IO.readString("Telefonnr.: "),
                IO.readString("Handynr.: "), IO.readString("Fax: "), IO.readString("Email: "),
                (IO.readString("Newsletter: j/n ").equals("j") == true ? 1 : 0));

        System.out.printf(
                "%-3s | %-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10s | %-10s | %-25s| %-17s | %-17s | %-17s | %-32s | %-12s%n",
                "Nr", "Anrede", "Titel", "Vorname", "Nachname", "Geburtsdatum", "Straße", "Hausnr.", "PLZ", "Ort",
                "Telefon", "Mobil", "Fax", "E-Mail", "Newsletter");
        System.out.printf(
                "%-3d | %-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10d | %-10d | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                customer.getCustomernumber(), customer.getSalulation(), customer.getTitel(), customer.getName(),
                customer.getLastName(), customer.getBirthdate(), customer.getStreet(), customer.getStreetnumber(),
                customer.getPostcode(), customer.getTown(), customer.getPhonenumber(), customer.getMobilephonenumeber(),
                customer.getFax(), customer.getEmail(), (customer.getNewsletter() == 1 ? "Ja" : "Nein"));

        String isOkay = IO.readString("Richtig? j/n ");
        if (isOkay.equals("j")) {
            boolean isSuccess = CustomerService.insertCustomer(customer);
            if (isSuccess) {
                System.out.println("Erfolgreich!\n");
            } else {
                System.out.println("Fehlgeschlagen!\n");
            }
        } else {
            System.out.print("Abbruch\n");
        }
        return;
    }

    static void updateUser() {
        System.out.println("Kunden updaten:\n");
        int nr = IO.readInt("Kundennummer des zuupdatenden Kunden: ");
        System.out.println("");

        String[][] valuesOfColumns = {
                { "salulation", "String", "Anrede: " },
                { "titel", "String", "Titel: " },
                { "name", "String", "Vorname: " },
                { "lastName", "String", "Nachname: " },
                { "birthdate", "String", "Geburtsdatum: " },
                { "street", "String", "Straße: " },
                { "streetNumber", "Int", "Hausnr.: " },
                { "postcode", "Int", "PLZ: " },
                { "town", "String", "Stadt: " },
                { "phoneNumber", "String", "Telefonnr.: " },
                { "mobilephoneNumeber", "String", "Handynr.: " },
                { "fax", "String", "Fax: " },
                { "email", "String", "Email: " },
                { "newsletter", "String", "Newsletter: Ja/Nein " }
        };

        String stringForUpdate = "UPDATE pilot_customers.customers SET";
        for (int i = 0; i < valuesOfColumns.length; i++) {
            String column = valuesOfColumns[i][0];
            String cast = valuesOfColumns[i][1];
            String request = valuesOfColumns[i][2];

            if (cast.equals("Int")) {
                int value = IO.readInt(request);
                if (value != 0) {
                    stringForUpdate = String.format("%s %s = %d,", stringForUpdate, column, value);
                }
            } else {
                String value = IO.readString(request);
                if (!value.equals("0")) {
                    if (column.equals("newsletter")) {
                        stringForUpdate = String.format("%s %s = %d,", stringForUpdate, column,
                                (value.equals("Ja") ? 1 : 0));
                    } else {
                        stringForUpdate = String.format("%s %s = '%s',", stringForUpdate, column, value);
                    }
                }
            }
        }
        stringForUpdate = String.format("%s WHERE customer_number = %d;",
                stringForUpdate.substring(0, stringForUpdate.length() - 1), nr);

        System.out.println("Query: \n" + stringForUpdate + "\n");
        String isOkay = IO.readString("Richtig? j/n ");
        System.out.println("");

        if (isOkay.equals("j")) {
            boolean isSuccess = true;// CustomerService.updateCustomer(customer);
            if (isSuccess) {
                System.out.println("Erfolgreich!\n");
            } else {
                System.out.println("Fehlgeschlagen!\n");
            }
        } else {
            System.out.print("Abbruch\n");
        }
        return;
    }

    static void deleteUser() {
        System.out.println("Kunden löschen:\n");
        System.out.println("");

        int nr = IO.readInt("Kundennummer des zulöschenden Kunden: ");
        String showQuery = "SELECT * FROM pilot_customers.customers WHERE customer_number = " + nr + ";";
        showUsers(showQuery);

        String isOkay = IO.readString("Richtig? j/n ");
        System.out.println("");

        if (isOkay.equals("j")) {
            boolean isSuccess = CustomerService.deleteCustomer(nr);
            if (isSuccess) {
                System.out.println("Erfolgreich!\n");
            } else {
                System.out.println("Fehlgeschlagen!\n");
            }
        } else {
            System.out.print("Abbruch\n");
        }
        return;
    }

    static void searchUser() {
        String nr = IO.readString("Suchbegriff: ");
        String query = "SELECT * FROM pilot_customers.customers WHERE customer_number = " + nr + ";";
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
        IO.readString("\nDrücke Enter ...");
        return;
    }
}
