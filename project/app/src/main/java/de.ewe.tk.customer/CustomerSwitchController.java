import util.EA;

public class CustomerSwitchController {
    static void executeChoice(int choice) {
        String repeatAction;

        switch (choice) {
            case 1 -> {
                do {
                    CustomerController.addUser();
                    repeatAction = EA.readString("Wollen Sie einen weiteren Kunden anlegen? j/n ");
                    System.out.println("");
                } while (repeatAction.equals("j"));
            }
            case 2 -> {
                do {
                    CustomerController.updateUser();
                    repeatAction = EA.readString("Wollen Sie einen weiteren Kunden verändern? j/n ");
                    System.out.println("");
                } while (repeatAction.equals("j"));
            }
            case 3 -> {
                do {
                    CustomerController.deleteUser();
                    repeatAction = EA.readString("Wollen Sie einen weiteren Kunden löschen? j/n ");
                    System.out.println("");
                } while (repeatAction.equals("j"));
            }
            case 4 -> {
                do {
                    CustomerController.searchUser();
                    repeatAction = EA.readString("Wollen Sie nach einen weiteren Kunden suchen? j/n ");
                    System.out.println("");
                } while (repeatAction.equals("j"));
            }
            case 5 -> {
                OutputCustomerService.showAllUsers();
            }
            case 6 -> {
                CustomerService.closeConnection();
                System.exit(0);
            }
        }
    }
}
