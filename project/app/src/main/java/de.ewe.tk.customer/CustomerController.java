import java.util.List;

import util.IO;

public class CustomerController {
    public static void main(String[] args) throws Exception {

        String[] choices = { "Neukunden einpflegen", "Kundendaten verändern", "Kunden löschen", "Kunden suchen",
                "Alle Kunden anzeigen" };

        /**
         * System.out.println("Datenbank einbinden");
         * System.out.println("\tDatenbank wurde noch nicht eingebunden");
         * System.out.println("---------------");
         * System.out.println("Eingabe des Kunden");
         * System.out.println("---------------");
         **/
        System.out.println("Was wollen Sie tun?\n");

        printList(choices);
        int choice = getinputUser(choices);

        if (choice == 5) {
            showAllUsers();
        }

        /*
         * System.out.println("---------------");
         * System.out.println("Daten annehmen / verarbeiten");
         * System.out.println("");
         * System.out.println("Daten in DB speichern");
         * System.out.println("");
         * System.out.println("Erfolgsmeldung an den User");
         * System.out.println("");
         **/
    }

    /* functions */
    static void printList(String[] list) {
        for (int i = 1; i <= list.length; i++) {
            System.out.println(i + ". " + list[i - 1]);
        }
        IO.print("");
    }

    static int getinputUser(String[] list) {
        int choice = IO.readInt("Nummer: ");
        System.out.println("\nGewählt: " + list[choice - 1] + "\n");
        return choice;
    }

    static void addUser() {
    }

    static void updateUser() {
    }

    static void deleteUser() {
    }

    static void searchUser() {
    }

    static void showAllUsers() {
        String query = "SELECT * FROM pilot_customers.customers;";
        /**
         * ResultSet rs = CustomerService.main(query);
         **/
        System.out.println("Alle Kunden:\n");

        /** ResultSetDemo.main(null, query); **/
        List<Customer> CustomerList = GetUserInput.main(null, query);

        // CreateTable.execute(CustomerList);

        System.out.println(
                "customer_number\t| salutation\t| title\t| name\t| last_name\t| birth_date\t| street\t| street_number\t| postcode\t| town\t\t\t| phone_number\t\t| mobile_number\t\t| fax\t\t| e_mail\t\t| newsletter");
        for (int i = 0; i < CustomerList.size(); i++) {
            System.out.println(CustomerList.get(i).getCustomernumber() + "\t\t| " + CustomerList.get(i).getSalulation()
                    + "\t\t| " + CustomerList.get(i).getTitel() + "\t| " + CustomerList.get(i).getName() + "\t| "
                    + CustomerList.get(i).getLastName() + "\t| " + CustomerList.get(i).getBirthdate() + "\t| "
                    + CustomerList.get(i).getStreet() + "\t| " + CustomerList.get(i).getStreetnumber() + "\t\t| "
                    + CustomerList.get(i).getPostcode() + "\t\t| " + CustomerList.get(i).getTown() + "\t| "
                    + CustomerList.get(i).getPhonenumber() + "\t| " + CustomerList.get(i).getMobilephonenumeber()
                    + "\t| " + CustomerList.get(i).getFax() + "\t| " + CustomerList.get(i).getEmail() + "\t| "
                    + CustomerList.get(i).getNewsletter());

        }

    }
}