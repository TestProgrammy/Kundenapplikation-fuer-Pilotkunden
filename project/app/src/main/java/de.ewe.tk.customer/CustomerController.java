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
                        isNotBreak = IO.readString("Weiter? j/n ");
                        if (isNotBreak != "j") {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        updateUser();
                        isNotBreak = IO.readString("Weiter? j/n ");
                        if (isNotBreak != "j") {
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        deleteUser();
                        isNotBreak = IO.readString("Weiter? j/n ");
                        if (isNotBreak != "j") {
                            break;
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        searchUser();
                        isNotBreak = IO.readString("Weiter? j/n ");
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
        String email = IO.readString("Email: ");
        String tempnewsletter = IO.readString("Newsletter: Ja/Nein ");
        int newsletter = tempnewsletter == "Ja" ? 1 : 0;

        System.out.println("");
        System.out.printf(
                "%-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10s | %-10s | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                "Anrede", "Titel", "Vorname", "Nachname", "Geburtsdatum", "Straße",
                "Hausnr.", "PLZ", "Ort",
                "Telefon", "Mobil", "Fax", "E-Mail", "Newsletter");
        System.out.printf(
                "%-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10d | %-10d | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                salulation, titel, name, lastName, birthdate, street, streetNumber, postcode, town, phoneNumber,
                mobilephonenNumeber, fax, email, tempnewsletter);
        String isOkay = IO.readString("Richtig? j/n ");
        System.out.println("Test1" + isOkay);
        if (isOkay == "j") {
            System.out.println("in if");
            String query = "INSERT into pilot_customers.customers (customer_number, salution, title, name, last_name, birth_date, street, street_number, postcode, town, phone_number, mobile_number, fax, e_mail, newsletter) values ('"
                    + salulation + "','" + titel + "','" + name + "','" + lastName + "','" + birthdate + "','" + street
                    + "','" + streetNumber + "','" + postcode + "','" + town + "','" + phoneNumber + "','"
                    + mobilephonenNumeber + "','" + fax + "','" + newsletter + "';";
            System.out.println("Query: \n" + query + "\n");
            // showUsers(query);
            System.out.println("Insert ausführen, nicht aktiviert");

            // meldung?
        }
        return;
    }

    static void updateUser() {
        int nr = IO.readInt("Kundennummer des zuupdatenden Kunden: ");
        // fragen was upgedated werden soll?

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
                { "mobilephonenNumeber", "String", "Handynr.: " },
                { "fax", "String", "Fax: " },
                { "email", "String", "Email: " },
                { "newsletter", "String", "Newsletter: Ja/Nein " }
        };

        String stringForUpdate = "UPDATE pilot_customers.customers SET";
        for (int i = 0; i < valuesOfColumns.length; i++) {// (Object[] valuesOfColumn : valuesOfColumns) {
            String column = valuesOfColumns[i][0];
            String cast = valuesOfColumns[i][1];
            String request = valuesOfColumns[i][2];
            if (cast == "Int") {
                int value = IO.readInt(request);
                if (value == 0) {
                    stringForUpdate += " " + column + " = " + value + ",";
                }
            } else {
                String value = IO.readString(request);
                if (value == "0") {
                    if (column == "newsletter") {
                        stringForUpdate += " " + column + " = " + (value == "Ja" ? 1 : 0) + ",";
                    } else {
                        stringForUpdate += " " + column + " = '" + value + "',";
                    }
                }
            }
        }
        stringForUpdate = stringForUpdate/** [0:(stringForUpdate.length()-1)] */
                + "WHERE customer_number = " + nr + ";";

        String query = stringForUpdate;
        System.out.println("Query: \n" + query + "\n");
        String isOkay = IO.readString("Richtig? j/n ");
        if (isOkay == "j") {
            System.out.println("Update ausführen, nicht aktiviert");
            // showUsers(query);
            // meldung?
        }
        return;
    }

    static void deleteUser() {
        int nr = IO.readInt("Kundennummer des zulöschenden Kunden: ");
        String query = "DELETE FROM pilot_customers.customers WHERE customer_number = " + nr + ";";
        System.out.println("Query: \n" + query + "\n");
        String showQuery = "SELECT * FROM pilot_customers.customers WHERE customer_number = " + nr + ";";
        showUsers(showQuery);
        String isOkay = IO.readString("Richtig? j/n ");
        if (isOkay == "j") {
            System.out.println("Delete ausführen, nicht aktiviert");
            // showUsers(query);
            // meldung?
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
        IO.readString("Drücke Enter ...");
        return;
    }
}
