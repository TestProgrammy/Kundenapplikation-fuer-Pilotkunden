import java.util.ArrayList;
import java.util.List;

import util.IO;

public class CustomerController {
    public static void main(String[] args) throws Exception {

        System.out.printf("user: %s password: %s", Access.user, Access.password);
        String[] choices = { "1. Neukunden einpflegen", "2. Kundendaten verändern", "3. Kunden löschen",
                "4. Kunden suchen",
                "5. Alle Kunden anzeigen", "6. Beenden", "7. Test" };

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
                case 7:
                    Test.Test();
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
                Validator.validateCustomerNumber("Kundennummer: "),
                Validator.validateSalutation("Anrede: ", null),
                Validator.validateTitel("Titel: ", null),
                Validator.validateName("Vorname: ", null),
                Validator.validateLastName("Nachname: ", null),
                Validator.validateBirthdate("Geburtstag: ", null),
                Validator.validateStreet("Straße: ", null),
                Validator.validateStreetNumber("Hausnr.:", placeholderAndCheck),
                Validator.validatePostcode("PLZ: ", placeholderAndCheck),
                Validator.validateTown("Stadt: ", null),
                Validator.validatePhoneNumber("Telefon: ", null),
                Validator.validateMobileNumber("Mobile: ", null),
                Validator.validateFax("Fax: ", null),
                Validator.validateEmail("E-Mail: ", null),
                Validator.validateNewsletter("Newsletter: Ja/Nein", placeholderAndCheck));

        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer);
        OutputCustomerService.showUsers(null, customerList);

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
            System.out.println("\n---Für keine Veränderung Enter drücken---\n");

            Customer updatedCustomer = new Customer(
                    Validator.validateCustomerNumber("Kundennummer: "),
                    Validator.validateSalutation(String.format("Anrede: Stand(%s)", customer.getSalutation()),
                            customer.getSalutation()),
                    Validator.validateTitel(String.format("Titel: Stand(%s)", customer.getTitel()),
                            customer.getTitel()),
                    Validator.validateName(String.format("Vorname: Stand(%s)", customer.getName()), customer.getName()),
                    Validator.validateLastName(String.format("Nachname: Stand(%s)", customer.getLastName()),
                            customer.getLastName()),
                    Validator.validateBirthdate(String.format("Geburtstag: Stand(%s)", customer.getBirthdate()),
                            customer.getBirthdate()),
                    Validator.validateStreet(String.format("Straße: Stand(%s)", customer.getStreet()),
                            customer.getStreet()),
                    Validator.validateStreetNumber(String.format("Hausnr.: Stand(%s)", customer.getStreetNumber()),
                            customer.getStreetNumber()),
                    Validator.validatePostcode(String.format("PLZ: Stand(%s)", customer.getPostcode()),
                            customer.getPostcode()),
                    Validator.validateTown(String.format("Stadt: Stand(%s)", customer.getTown()), customer.getTown()),
                    Validator.validatePhoneNumber(String.format("Telefon: Stand(%s)", customer.getPhoneNumber()),
                            customer.getPhoneNumber()),
                    Validator.validateMobileNumber(String.format("Mobile: Stand(%s)", customer.getMobileNumber()),
                            customer.getMobileNumber()),
                    Validator.validateFax(String.format("Fax: Stand(%s)", customer.getFax()), customer.getFax()),
                    Validator.validateEmail(String.format("E-Mail: Stand(%s)", customer.getEmail()),
                            customer.getEmail()),
                    Validator.validateNewsletter(String.format("Newsletter: Ja/Nein Stand(%s)",
                            customer.getNewsletter() == 1 ? "Ja" : "Nein"), customer.getNewsletter()));

            List<Customer> customerList = new ArrayList<Customer>();
            customerList.add(updatedCustomer);
            OutputCustomerService.showUsers(null, customerList);

            String isInputOkay = IO.readString("Ist ihre Eingabe so richtig? j/n ");
            System.out.println("");

            if (isInputOkay.equals("j")) {
                boolean isSuccess = CustomerService.updateCustomer(updatedCustomer);
                if (isSuccess) {
                    System.out.println("Der Kunde wurde erfolgreich verändert!\n");
                } else {
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
