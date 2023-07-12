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

        Customer customer = CustomerCreator.createUser();

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
        int customerNumber;
        Customer customer;
        System.out.println("Kunden updaten:\n");
        do {
            customerNumber = EA.readInt("Kundennummer des zuupdatenden Kunden: ");
        } while (!Validator.validateCustomerNumber(customerNumber));
        String query = String.format("SELECT * FROM pilot_customers.customers WHERE customer_number = %d;",
                customerNumber);

        List<Customer> customers = CustomerService.getCustomer(query);

        switch (customers.size()) {
            case 0 -> {
                System.out.println("Die Kundennummer ist nicht vorhanden.");
                System.out.print("Abbruch\n");
            }
            default -> {
                System.out.println("Kundennummer ist mehrfach vorhanden.");
                System.out.print("Abbruch\n");
            }
            case 1 -> {
                customer = customers.get(0);
                Customer updatedCustomer = CustomerCreator.changeUser(customer);

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
        OutputCustomerService.showUsers(query);
    }

    static void waitForEnter() {
        EA.readString("\nDrücke Enter ...");
    }
}
