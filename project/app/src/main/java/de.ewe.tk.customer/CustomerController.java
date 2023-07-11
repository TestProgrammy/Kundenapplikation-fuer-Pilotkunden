import java.util.ArrayList;
import java.util.List;

import util.IO;

public class CustomerController {
    public static void main(String[] args) throws Exception {

        System.out.printf("user: %s password: %s", Access.user, Access.password);
        String[] choices = { "1. Neukunden einpflegen", "2. Kundendaten verändern", "3. Kunden löschen",
                "4. Kunden suchen",
                "5. Alle Kunden anzeigen", "6. Beenden" };

        while (true) {
            System.out.println("\nWas wollen Sie tun?\n");

            printList(choices);
            int choice = getInputUser();
            String isNotBreak;

            switch (choice) {
                case 1:
                    do {
                        addUser();
                        isNotBreak = IO.readString("Wollen Sie einen weiteren Kunden anlegen? j/n ");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    } while (true);
                    break;
                case 2:
                    do {
                        updateUser();
                        isNotBreak = IO.readString("Wollen Sie einen weiteren Kunden verändern? j/n ");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    } while (true);
                    break;
                case 3:
                    do {
                        deleteUser();
                        isNotBreak = IO.readString("Wollen Sie einen weiteren Kunden löschen? j/n ");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    } while (true);
                    break;
                case 4:
                    do {
                        searchUser();
                        isNotBreak = IO.readString("Wollen Sie nach einen weiteren Kunden suchen? j/n ");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    } while (true);
                    break;
                case 5:
                    OutputCustomerService.showAllUsers();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
            }
            waitForEnter();
        }
    }

    static void printList(String[] list) {
        for (String choice : list) {
            System.out.println(choice);
        }
        System.out.println("");
    }

    static int getInputUser() {
        int choice = IO.readInt("Nummer: ");
        return choice;
    }

    static void addUser() {
        System.out.println("Neuen Kunden eingeben:\n");
        int placeholderAndCheck = Integer.MIN_VALUE;

        Customer customer = new Customer(
                Validator.validateCustomerNumber(IO.readInt("Kundennummer: ")),
                Validator.validateSalutation(IO.readString("Anrede: "), null),
                Validator.validateTitel(IO.readString("Titel: "), null),
                Validator.validateName(IO.readString("Vorname: "), null),
                Validator.validateLastName(IO.readString("Nachname: "), null),
                Validator.validateBirthdate(IO.readString("Geburtsdatum: "), null),
                Validator.validateStreet(IO.readString("Straße: "), null),
                Validator.validateStreetNumber(IO.readInt("Hausnr.: "), placeholderAndCheck),
                Validator.validatePostcode(IO.readInt("PLZ: "), placeholderAndCheck),
                Validator.validateTown(IO.readString("Stadt: "), null),
                Validator.validatePhoneNumber(IO.readString("Telefonnr.: "), null),
                Validator.validateMobilenumber(IO.readString("Handynr.: "), null),
                Validator.validateFax(IO.readString("Fax: "), null),
                Validator.validateEmail(IO.readString("Email: "), null),
                Validator.validateNewsletter(IO.readString("Newsletter: Ja/Nein "), placeholderAndCheck));

        System.out.printf(
                "%-3s | %-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10s | %-10s | %-25s| %-17s | %-17s | %-17s | %-32s | %-12s%n",
                "Nr", "Anrede", "Titel", "Vorname", "Nachname", "Geburtsdatum", "Straße", "Hausnr.", "PLZ", "Ort",
                "Telefon", "Mobil", "Fax", "E-Mail", "Newsletter");
        System.out.printf(
                "%-3d | %-12s | %-12s | %-17s | %-17s | %-17s | %-32s | %-10d | %-10d | %-25s | %-17s | %-17s | %-17s | %-32s | %-12s%n",
                customer.getCustomerNumber(), customer.getSalutation(), customer.getTitel(), customer.getName(),
                customer.getLastName(), customer.getBirthdate(), customer.getStreet(), customer.getStreetNumber(),
                customer.getPostcode(), customer.getTown(), customer.getPhoneNumber(), customer.getMobileNumber(),
                customer.getFax(), customer.getEmail(), (customer.getNewsletter() == 1 ? "Ja" : "Nein"));

        String isInputOkay = IO.readString("Ist ihre Eingabe so richtig? j/n ");
        if (isInputOkay.equals("j")) {
            boolean isSuccess = CustomerService.insertCustomer(customer);
            if (isSuccess) {
                System.out.println("Das Anlegen des neuen Kunden war erfolgreich!\n");
            } else {
                System.out.println("Das Anlegen des neuen Kunden ist fehlgeschlagen!\n");
            }
        } else {
            System.out.print("Abbruch\n");
        }
        return;
    }

    static void updateUser() {
        System.out.println("Kunden updaten:\n");
        int customerNumber = IO.readInt("Kundennummer des zuupdatenden Kunden: ");
        System.out.println("");

        String query = String.format("SELECT * FROM pilot_customers.customers WHERE customer_number = %d;",
                customerNumber);

        List<Customer> customers = CustomerService.getCustomer(query);

        for (Customer customer : customers) {
            String test = "2";
            do {
                int customerNumber2 = Validator
                        .validateCustomerNumber(IO.readInt("Kundennummer des zuupdatenden Kunden: "));
                System.out.println("nochmal");
            } while (test.equals("2"));

            System.out.println("\n---Für keine Veränderung: 0---\n");

            String salutation = IO.readString(String.format("Anrede Stand(%s): ", customer.getSalutation()));
            String title = IO.readString(String.format("Titel Stand(%s): ", customer.getTitel()));
            String name = IO.readString(String.format("Vorname Stand(%s): ", customer.getName()));
            String lastName = IO.readString(String.format("Nachname Stand(%s): ", customer.getLastName()));
            String birthdate = IO.readString(String.format("Geburtsdatum Stand(%s): ", customer.getBirthdate()));
            String street = IO.readString(String.format("Straße Stand(%s): ", customer.getStreet()));
            int streetnr = IO.readInt(String.format("Hausnr. Stand(%d): ", customer.getStreetNumber()));
            int postcode = IO.readInt(String.format("PLZ Stand(%d): ", customer.getPostcode()));
            String city = IO.readString(String.format("Stadt Stand(%s): ", customer.getTown()));
            String phone = IO.readString(String.format("Telefonnr. Stand(%s): ", customer.getPhoneNumber()));
            String mobile = IO.readString(String.format("Handynr. Stand(%s): ", customer.getMobileNumber()));
            String fax = IO.readString(String.format("Fax Stand(%s): ", customer.getFax()));
            String email = IO.readString(String.format("Email Stand(%s): ", customer.getEmail()));
            String tempNewsletter = (IO
                    .readString(
                            String.format("Newsletter Stand(%s): ", customer.getNewsletter() == 1 ? "Ja" : "Nein")));

            salutation = salutation.equals("0") == true ? customer.getSalutation() : salutation;
            title = title.equals("0") == true ? customer.getTitel() : title;
            name = name.equals("0") == true ? customer.getName() : name;
            lastName = lastName.equals("0") == true ? customer.getLastName() : lastName;
            birthdate = birthdate.equals("0") == true ? customer.getBirthdate() : birthdate;
            street = street.equals("0") == true ? customer.getStreet() : street;
            streetnr = streetnr == 0 ? customer.getStreetNumber() : streetnr;
            postcode = postcode == 0 ? customer.getPostcode() : postcode;
            city = city.equals("0") == true ? customer.getTown() : city;
            phone = phone.equals("0") == true ? customer.getPhoneNumber() : phone;
            mobile = mobile.equals("0") == true ? customer.getMobileNumber() : mobile;
            fax = fax.equals("0") == true ? customer.getFax() : fax;
            email = email.equals("0") == true ? customer.getEmail() : email;
            int newsletter = tempNewsletter.equals("0") == true ? customer.getNewsletter()
                    : tempNewsletter.equals("Ja") ? 1 : 0;

            Customer updatedCustomer = new Customer(customerNumber, salutation, title, name, lastName, birthdate,
                    street,
                    streetnr,
                    postcode, city, phone, mobile, fax, email, newsletter);

            List<Customer> customerList = new ArrayList<Customer>();
            customerList.add(updatedCustomer);
            OutputCustomerService.showUsers(null, customerList);

            String isInputOkay = IO.readString("Ist ihre Eingabe so richtig? j/n ");
            System.out.println("");

            if (isInputOkay.equals("j")) {
                boolean isDeleted = CustomerService.deleteCustomer(customerNumber);
                boolean isSuccess = CustomerService.insertCustomer(updatedCustomer);
                if (isSuccess && isDeleted) {
                    System.out.println("Der Kunde wurde erfolgreich verändert!\n");
                } else {
                    if (!isDeleted) {
                        System.out.println("Der Kunde wurde während der Veränderung gelöscht.");
                    }
                    System.out.println("Der Kunde konnte nicht verändert werden!\n");
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

        int customerNumber = IO.readInt("Kundennummer des zulöschenden Kunden: ");
        String showQuery = String.format("SELECT * FROM pilot_customers.customers WHERE customer_number = %d;",
                customerNumber);
        OutputCustomerService.showUsers(showQuery);

        String isInputOkay = IO.readString("Ist ihre Eingabe so richtig? j/n ");
        System.out.println("");

        if (isInputOkay.equals("j")) {
            boolean isSuccess = CustomerService.deleteCustomer(customerNumber);
            if (isSuccess) {
                System.out.println("Der Kunde wurde erfolgreich gelöscht!\n");
            } else {
                System.out.println("Der Kunde nicht gelöscht werden!\n");
            }
        } else {
            System.out.print("Abbruch\n");
        }
        return;
    }

    static void searchUser() {
        String customerNumber = IO.readString("Suchbegriff: ");
        String query = "SELECT * FROM pilot_customers.customers WHERE customer_number = " + customerNumber + ";";
        System.out.println("Suchergebnisse: \n");
        System.out.println(query);
        OutputCustomerService.showUsers(query);
        return;
    }

    static void waitForEnter() {
        IO.readString("\nDrücke Enter ...");
        return;
    }
}
