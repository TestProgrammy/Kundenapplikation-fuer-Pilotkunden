import java.util.ArrayList;
import java.util.List;

import util.EA;

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
                case 1 -> {
                    do {
                        addUser();
                        isNotBreak = EA.readString("Wollen Sie einen weiteren Kunden anlegen? j/n ");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    } while (true);
                }
                case 2 -> {
                    do {
                        updateUser();
                        isNotBreak = EA.readString("Wollen Sie einen weiteren Kunden verändern? j/n ");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    } while (true);
                }
                case 3 -> {
                    do {
                        deleteUser();
                        isNotBreak = EA.readString("Wollen Sie einen weiteren Kunden löschen? j/n ");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    } while (true);
                }
                case 4 -> {
                    do {
                        searchUser();
                        isNotBreak = EA.readString("Wollen Sie nach einen weiteren Kunden suchen? j/n ");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    } while (true);
                }
                case 5 -> {
                    OutputCustomerService.showAllUsers();
                }
                case 6 -> {
                    System.exit(0);
                }
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
        int choice = EA.readInt("Nummer: ");
        return choice;
    }

    static void addUser() {
        System.out.println("Neuen Kunden eingeben:\n");

        int customerNumber, streetNumber, postcode;
        String salutation, title, name, lastName, birthdate, street, town, phoneNumber, mobilephoneNumber, fax, email,
                newsletter;
        do {
            customerNumber = EA.readInt("Kundennummer: ");
        } while (!(Validator.validateCustomerNumber(customerNumber)));
        do {
            salutation = EA.readString("Anrede: ");
        } while (!Validator.validateSalutation(salutation));
        do {
            title = EA.readString("Titel: ");
        } while (!Validator.validateTitle(title));
        do {
            name = EA.readString("Vorname: ");
        } while (!Validator.validateName(name));
        do {
            lastName = EA.readString("Nachname: ");
        } while (!Validator.validateLastName(lastName));
        do {
            birthdate = EA.readString("Geburtsdatum: ");
        } while (!Validator.validateBirthdate(birthdate));
        do {
            street = EA.readString("Straße: ");
        } while (!Validator.validateStreet(street));
        do {
            streetNumber = EA.readInt("Hausnr.: ");
        } while (!Validator.validateStreetNumber(streetNumber));
        do {
            postcode = EA.readInt("PLZ: ");
        } while (!Validator.validatePostcode(postcode));
        do {
            town = EA.readString("Stadt: ");
        } while (!Validator.validateTown(town));
        do {
            phoneNumber = EA.readString("Telefonnr.: ");
        } while (!Validator.validatePhoneNumber(phoneNumber));
        do {
            mobilephoneNumber = EA.readString("Handynr.: ");
        } while (!Validator.validateMobileNumber(mobilephoneNumber));
        do {
            fax = EA.readString("Fax: ");
        } while (!Validator.validateFax(fax));
        do {
            email = EA.readString("Email: ");
        } while (!Validator.validateEmail(email));
        do {
            newsletter = EA.readString("Newsletter: j/n ");
        } while (!Validator.validateNewsletter(newsletter));

        Customer customer = new Customer(customerNumber, salutation, title, name, lastName, birthdate, street,
                streetNumber, postcode, town, phoneNumber, mobilephoneNumber, fax, email,
                newsletter.equals("Ja") ? 1 : 0);

        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer);
        OutputCustomerService.showUsers(null, customerList);

        String isInputOkay = EA.readString("Ist ihre Eingabe so richtig? j/n ");
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
    }

    static void updateUser() {
        int customerNumber, streetNumber, postcode;
        String salutation, title, name, lastName, birthdate, street, town, phoneNumber, mobilephoneNumber, fax,
                email, newsletter;
        System.out.println("Kunden updaten:\n");
        do {
            customerNumber = EA.readInt("Kundennummer des zuupdatenden Kunden: ");
        } while (!Validator.validateCustomerNumber(customerNumber));
        String query = String.format("SELECT * FROM pilot_customers.customers WHERE customer_number = %d;",
                customerNumber);

        List<Customer> customers = CustomerService.getCustomer(query);

        for (Customer customer : customers) {
            System.out.println("\n---Für keine Veränderung Enter drücken---\n");

            do {
                salutation = EA.readString(String.format("Anrede: Stand(%s)", customer.getSalutation()));
            } while (!Validator.validateSalutation(salutation));
            do {
                title = EA.readString(String.format("Titel: Stand(%s)", customer.getTitle()));
            } while (!Validator.validateTitle(title));
            do {
                name = EA.readString(String.format("Vorname: Stand(%s)", customer.getName()));
            } while (!Validator.validateName(name));
            do {
                lastName = EA.readString(String.format("Nachname: Stand(%s)", customer.getLastName()));
            } while (!Validator.validateLastName(lastName));
            do {
                birthdate = EA.readString(String.format("Geburtsdatum: Stand(%s)", customer.getBirthdate()));
            } while (!Validator.validateBirthdate(birthdate));
            do {
                street = EA.readString(String.format("Straße: Stand(%s)", customer.getStreet()));
            } while (!Validator.validateStreet(street));
            do {
                streetNumber = EA.readInt(String.format("Hausnr.: Stand(%s)", customer.getStreetNumber()));
            } while (!Validator.validateStreetNumber(streetNumber));
            do {
                postcode = EA.readInt(String.format("PLZ: Stand(%s)", customer.getPostcode()));
            } while (!Validator.validatePostcode(postcode));
            do {
                town = EA.readString(String.format("Stadt: Stand(%s)", customer.getTown()));
            } while (!Validator.validateTown(town));
            do {
                phoneNumber = EA.readString(String.format("Telefon: Stand(%s)", customer.getPhoneNumber()));
            } while (!Validator.validatePhoneNumber(phoneNumber));
            do {
                mobilephoneNumber = EA.readString(String.format("Mobile: Stand(%s)", customer.getMobileNumber()));
            } while (!Validator.validateMobileNumber(mobilephoneNumber));
            do {
                fax = EA.readString(String.format("Fax: Stand(%s)", customer.getFax()));
            } while (!Validator.validateFax(fax));
            do {
                email = EA.readString(String.format("Email: Stand(%s)", customer.getEmail()));
            } while (!Validator.validateEmail(email));
            do {
                newsletter = EA.readString(
                        String.format("Newsletter: Ja/Nein Stand(%s)", customer.getNewsletter() == 1 ? "Ja" : "Nein"));
            } while (!Validator.validateNewsletter(newsletter));

            Customer updatedCustomer = new Customer(customerNumber, salutation, title, name, lastName, birthdate,
                    street, streetNumber, postcode, town, phoneNumber, mobilephoneNumber, fax, email,
                    newsletter.equals("Ja") ? 1 : 0);

            List<Customer> customerList = new ArrayList<Customer>();
            customerList.add(updatedCustomer);
            OutputCustomerService.showUsers(null, customerList);

            String isInputOkay = EA.readString("Ist ihre Eingabe so richtig? j/n ");
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
    }

    static void deleteUser() {
        System.out.println("Kunden löschen:\n");
        System.out.println("");

        int customerNumber = EA.readInt("Kundennummer des zulöschenden Kunden: ");
        String showQuery = String.format("SELECT * FROM pilot_customers.customers WHERE customer_number = %d;",
                customerNumber);
        OutputCustomerService.showUsers(showQuery);

        String isInputOkay = EA.readString("Ist ihre Eingabe so richtig? j/n ");
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
    }

    static void searchUser() {
        String customerNumber = EA.readString("Suchbegriff: ");
        String query = "SELECT * FROM pilot_customers.customers WHERE customer_number = " + customerNumber + ";";
        System.out.println("Suchergebnisse: \n");
        System.out.println(query);
        OutputCustomerService.showUsers(query);
    }

    static void waitForEnter() {
        EA.readString("\nDrücke Enter ...");
    }
}
