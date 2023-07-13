import java.util.ArrayList;
import java.util.List;

import util.EA;

public class CustomerController {
    public static void main(String[] args) throws Exception {
        if (!Access.readFile()) {
            System.out.println("Es konnten die DB-Anmeldedaten nicht gelesen werden.");
            System.exit(1);
        }

        String tets;
        do {
            tets = EA.readString("test straße: ");
            System.out.println("str.: " + tets);
        } while (!Validator.validateStreet(tets));

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
                        System.out.println("");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    } while (true);
                }
                case 2 -> {
                    do {
                        updateUser();
                        isNotBreak = EA.readString("Wollen Sie einen weiteren Kunden verändern? j/n ");
                        System.out.println("");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    } while (true);
                }
                case 3 -> {
                    do {
                        deleteUser();
                        isNotBreak = EA.readString("Wollen Sie einen weiteren Kunden löschen? j/n ");
                        System.out.println("");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    } while (true);
                }
                case 4 -> {
                    do {
                        searchUser();
                        isNotBreak = EA.readString("Wollen Sie nach einen weiteren Kunden suchen? j/n ");
                        System.out.println("");
                        if (!isNotBreak.equals("j")) {
                            break;
                        }
                    } while (true);
                }
                case 5 -> {
                    OutputCustomerService.showAllUsers();
                }
                case 6 -> {
                    CustomerService.closeConnection();
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

        Customer customer = CustomerCreator.createUser();

        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(customer);
        OutputCustomerService.showUsers(0, customerList);

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
        int customerNumber;
        Customer customer;
        System.out.println("Kunden updaten:\n");
        do {
            customerNumber = EA.readInt("Kundennummer des zuupdatenden Kunden: ");
        } while (!Validator.validateCustomerNumber(customerNumber));

        List<Customer> customers = CustomerService.getCustomer(customerNumber);

        if (customers.size() != 1) {
            System.out.println("Fehlgeschlagen! Die Kundennummer ist nicht vorhanden.");
            System.out.print("Abbruch\n");
            return;
        }
        customer = customers.get(0);
        Customer updatedCustomer = CustomerCreator.changeUser(customer);

        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(updatedCustomer);
        OutputCustomerService.showUsers(0, customerList);

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

    static void deleteUser() {
        System.out.println("Kunden löschen:\n");

        int customerNumber;
        do {
            customerNumber = EA.readInt("Kundennummer des zulöschenden Kunden: ");
        } while (!Validator.validateCustomerNumber(customerNumber));

        if (!OutputCustomerService.showUsers(customerNumber)) {
            return;
        }

        String isInputOkay = EA.readString("Ist ihre Eingabe so richtig? j/n ");
        System.out.println("");

        if (isInputOkay.equals("j")) {
            boolean isSuccess = CustomerService.deleteCustomer(customerNumber);
            if (isSuccess) {
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
        OutputCustomerService.showUsers(customerNumber);
    }

    static void waitForEnter() {
        EA.readString("\nDrücke Enter ...");
    }
}
