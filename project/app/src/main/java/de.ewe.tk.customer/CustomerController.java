import java.util.List;

import util.EA;

public class CustomerController {
    public static void main(String[] args) throws Exception {
        if (!Access.readFile()) {
            System.out.println("Es konnten die DB-Anmeldedaten nicht gelesen werden.");
            System.exit(1);
        }

        String[] choices = { "1. Neukunden einpflegen", "2. Kundendaten verändern", "3. Kunden löschen",
                "4. Kunden suchen",
                "5. Alle Kunden anzeigen", "6. Beenden" };

        while (true) {
            System.out.println("\nWas wollen Sie tun?\n");

            printChoices(choices);
            int choice = getUserChoice();

            CustomerSwitchController.executeChoice(choice);
        }
    }

    static void printChoices(String[] list) {
        for (String choice : list) {
            System.out.println(choice);
        }
        System.out.println("");
    }

    static int getUserChoice() {
        int choice = EA.readInt("Nummer: ");
        return choice;
    }

    static void addUser() {
        System.out.println("Neuen Kunden eingeben:\n");

        Customer customer = CustomerCreator.createUser();
        OutputCustomerService.showUser(customer);

        String isConfirmed = EA.readString("Ist ihre Eingabe so richtig? j/n ");

        if (isConfirmed.equals("j")) {
            boolean successful = CustomerService.insertCustomer(customer);
            if (successful) {
                System.out.println("Das Anlegen des neuen Kunden war erfolgreich!\n");
            } else {
                System.out.println("Das Anlegen des neuen Kunden ist fehlgeschlagen!\n");
            }
        } else {
            System.out.print("Abbruch\n");
        }
    }

    static void updateUser() {
        int customerNumber;
        Customer customer;

        System.out.println("Kunden bearbeiten:\n");

        do {
            customerNumber = EA.readInt("Kundennummer des zu bearbeitenden Kunden: ");
        } while (!Validator.validateCustomerNumber(customerNumber));

        List<Customer> customers = CustomerService.getCustomer(customerNumber);

        if (customers.size() != 1) {
            System.out.println("Fehlgeschlagen! Die Kundennummer ist nicht vorhanden.");
            System.out.print("Abbruch\n");
            return;
        }

        customer = customers.get(0);
        Customer updatedCustomer = CustomerCreator.changeUser(customer);
        OutputCustomerService.showUser(updatedCustomer);

        String isConfirmed = EA.readString("Ist ihre Eingabe so richtig? j/n ");
        System.out.println("");

        if (isConfirmed.equals("j")) {
            boolean successful = CustomerService.updateCustomer(updatedCustomer);
            if (successful) {
                System.out.println("Der Kunde wurde erfolgreich verändert!\n");
            } else {
                System.out.println("Der Kunde konnte nicht verändert werden!\n");
            }
        } else {
            System.out.print("Abbruch\n");
        }
    }

    static void deleteUser() {
        System.out.println("Kunden löschen:\n");

        int customerNumber;
        do {
            customerNumber = EA.readInt("Kundennummer des zu löschenden Kunden: ");
        } while (!Validator.validateCustomerNumber(customerNumber));

        if (!OutputCustomerService.showSearchUser(customerNumber)) {
            return;
        }

        String isConfirmed = EA.readString("Ist ihre Eingabe so richtig? j/n ");
        System.out.println("");

        if (isConfirmed.equals("j")) {
            boolean successful = CustomerService.deleteCustomer(customerNumber);
            if (successful) {
                System.out.println("Der Kunde wurde erfolgreich gelöscht!\n");
            } else {
                System.out.println("Der Kunde konnte nicht gelöscht werden!\n");
            }
        } else {
            System.out.print("Abbruch\n");
        }
    }

    static void searchUser() {
        int customerNumber;

        do {
            customerNumber = EA.readInt("Gesuchte Kundennummer: ");
        } while (!Validator.validateCustomerNumber(customerNumber));

        System.out.println("Suchergebnisse: \n");
        OutputCustomerService.showSearchUser(customerNumber);
    }

    static void waitForEnter() {
        EA.readString("\nDrücke Enter ...");
    }
}