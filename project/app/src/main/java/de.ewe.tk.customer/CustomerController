import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import util.IO;

public class CustomerService2 {
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
        List<Customer> CustomerList = ResultSet.main(null, query);

        CreateTable(CustomerList);
        /**
         * System.out.println(
         * "customer_number\t| salutation\t| title\t| name\t| last_name\t| birth_date\t|
         * street\t| street_number\t| postcode\t| town\t| phone_number\t|
         * mobile_number\t fax text\t| e_mail\t| newsletter");
         * 
         * try {
         * 
         * int customer_number = rs.getInt(1);
         * String salutation = rs.getString(2);
         * String title = rs.getString(3);
         * String name = rs.getString(4);
         * String last_name = rs.getString(4);
         * String birth_date = rs.getString(5);
         * String street = rs.getString(6);
         * int street_number = rs.getInt(7);
         * int postcode = rs.getInt(8);
         * String town = rs.getString(9);
         * String phone_number = rs.getString(10);
         * String mobile_number = rs.getString(11);
         * String fax = rs.getString(12);
         * String e_mail = rs.getString(13);
         * int newsletter = rs.getInt(14);
         * 
         * IO.print("");
         * }
         * rs.close();
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         **/
    }
}