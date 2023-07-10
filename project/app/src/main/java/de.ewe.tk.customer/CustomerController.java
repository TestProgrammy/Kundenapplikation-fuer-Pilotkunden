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

        String query = "SELECT * FROM pilot_customers.customers WHERE customer_number = " + nr + ";";

        // Kunden holen
        List<Customer> customers = CustomerService.main(null, query);
        // Eingabe der Veränderungen + Anzeige des letzen Standes
        for (Customer customer : customers) {

            System.out.println("\n---Für keine Veränderung: 0---\n");

            String salutation = IO.readString(String.format("Anrede Stand(%s): ", customer.getSalulation()));
            String title = IO.readString(String.format("Titel Stand(%s): ", customer.getTitel()));
            String name = IO.readString(String.format("Vorname Stand(%s): ", customer.getName()));
            String lastName = IO.readString(String.format("Nachname Stand(%s): ", customer.getLastName()));
            String birthdate = IO.readString(String.format("Geburtsdatum Stand(%s): ", customer.getBirthdate()));
            String street = IO.readString(String.format("Straße Stand(%s): ", customer.getStreet()));
            int streetnr = IO.readInt(String.format("Hausnr. Stand(%d): ", customer.getStreetnumber()));
            int postcode = IO.readInt(String.format("PLZ Stand(%d): ", customer.getPostcode()));
            String city = IO.readString(String.format("Stadt Stand(%s): ", customer.getTown()));
            String phone = IO.readString(String.format("Telefonnr. Stand(%s): ", customer.getPhonenumber()));
            String mobile = IO.readString(String.format("Handynr. Stand(%s): ", customer.getMobilephonenumeber()));
            String fax = IO.readString(String.format("Fax Stand(%s): ", customer.getFax()));
            String email = IO.readString(String.format("Email Stand(%s): ", customer.getEmail()));
            String tempNewsletter = (IO
                    .readString(
                            String.format("Newsletter Stand(%s): ", customer.getNewsletter() == 1 ? "Ja" : "Nein")));

            salutation = salutation.equals("0") == true ? customer.getSalulation() : salutation;
            title = title.equals("0") == true ? customer.getTitel() : title;
            name = name.equals("0") == true ? customer.getName() : name;
            lastName = lastName.equals("0") == true ? customer.getLastName() : lastName;
            birthdate = birthdate.equals("0") == true ? customer.getBirthdate() : birthdate;
            street = street.equals("0") == true ? customer.getStreet() : street;
            streetnr = streetnr == 0 ? customer.getStreetnumber() : streetnr;
            postcode = postcode == 0 ? customer.getPostcode() : postcode;
            city = city.equals("0") == true ? customer.getTown() : city;
            phone = phone.equals("0") == true ? customer.getPhonenumber() : phone;
            mobile = mobile.equals("0") == true ? customer.getMobilephonenumeber() : mobile;
            fax = fax.equals("0") == true ? customer.getFax() : fax;
            email = email.equals("0") == true ? customer.getEmail() : email;
            int newsletter = tempNewsletter.equals("0") == true ? customer.getNewsletter()
                    : tempNewsletter.equals("Ja") ? 1 : 0;

            Customer ucustomer = new Customer(nr, salutation, title, name, lastName, birthdate, street, streetnr,
                    postcode, city, phone, mobile, fax, email, newsletter);
            // Anzeigen des neuen Stand
            System.out.printf(
                    "%-3s | %-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10s | %-10s | %-25s| %-17s | %-17s | %-17s | %-32s | %-12s%n",
                    "Nr", "Anrede", "Titel", "Vorname", "Nachname", "Geburtsdatum", "Straße", "Hausnr.", "PLZ", "Ort",
                    "Telefon", "Mobil", "Fax", "E-Mail", "Newsletter");
            System.out.printf(
                    "%-3d | %-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10d | %-10d | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                    ucustomer.getCustomernumber(), ucustomer.getSalulation(), ucustomer.getTitel(), ucustomer.getName(),
                    ucustomer.getLastName(), ucustomer.getBirthdate(), ucustomer.getStreet(),
                    ucustomer.getStreetnumber(),
                    ucustomer.getPostcode(), ucustomer.getTown(), ucustomer.getPhonenumber(),
                    ucustomer.getMobilephonenumeber(),
                    ucustomer.getFax(), ucustomer.getEmail(), (ucustomer.getNewsletter() == 1 ? "Ja" : "Nein"));

            String isOkay = IO.readString("Richtig? j/n ");
            System.out.println("");
            // löschen & updaten

            if (isOkay.equals("j")) {
                boolean isDeleted = CustomerService.deleteCustomer(nr);
                boolean isSuccess = CustomerService.insertCustomer(ucustomer);
                if (isSuccess && isDeleted) {
                    System.out.println("Erfolgreich!\n");
                } else {
                    System.out.println("Fehlgeschlagen!\n");
                }
            } else {
                System.out.print("Abbruch\n");
            }
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
