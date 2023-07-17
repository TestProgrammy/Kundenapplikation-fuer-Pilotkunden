import util.EA;

public class CustomerCreator {
    public static Customer createUser() {
        int streetNumber;
        String salutation, title, name, lastName, birthdate, street, postcode, town, phoneNumber, mobilephoneNumber,
                fax, email, newsletter;

        do {
            salutation = EA.readString("Anrede: ");
        } while (!Validator.validateSalutation(salutation));

        do {
            title = EA.readString("Titel: ");
            if (title.equals("")) {
                break;
            }
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
            postcode = EA.readString("PLZ: ");
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
            if (email.equals("")) {
                break;
            }
        } while (!Validator.validateEmail(email));

        do {
            newsletter = EA.readString("Newsletter Ja/Nein: ");
        } while (!Validator.validateNewsletter(newsletter));

        int newsletterValue = newsletter.equals("Ja") ? 1 : 0;

        Customer customer = new Customer(null, salutation, title, name, lastName, birthdate, street,
                streetNumber, postcode, town, phoneNumber, mobilephoneNumber, fax, email, newsletterValue);
        return customer;
    }

    public static Customer changeUser(Customer customer) {
        int streetNumber;
        String salutation, title, name, lastName, birthdate, street, postcode, town, phoneNumber, mobilephoneNumber,
                fax, email, newsletter;

        System.out.println("\n---Für keine Veränderung Enter drücken---\n");

        do {
            salutation = EA.readString(String.format("Anrede\t\taktueller Stand(%s): ", customer.getSalutation()));
            if (salutation.equals("")) {
                salutation = customer.getSalutation();
                break;
            }
        } while (!Validator.validateSalutation(salutation));

        do {
            title = EA.readString(String.format("Titel\t\taktueller Stand(%s): ", customer.getTitle()));
            if (title.equals("")) {
                if (!title.equals(customer.getTitle())) {
                    boolean isChangeTitle = EA.readString("Soll der Title verändert werden? j/n ").equals("j") ? true
                            : false;
                    if (!isChangeTitle) {
                        title = customer.getTitle();
                    }
                }
                break;
            }
        } while (!Validator.validateTitle(title));

        do {
            name = EA.readString(String.format("Vorname\t\taktueller Stand(%s): ", customer.getName()));
            if (name.equals("")) {
                name = customer.getName();
                break;
            }
        } while (!Validator.validateName(name));

        do {
            lastName = EA.readString(String.format("Nachname\taktueller Stand(%s): ", customer.getLastName()));
            if (lastName.equals("")) {
                lastName = customer.getLastName();
                break;
            }
        } while (!Validator.validateLastName(lastName));

        do {
            birthdate = EA.readString(String.format("Geburtsdatum\taktueller Stand(%s): ", customer.getBirthdate()));
            if (birthdate.equals("")) {
                birthdate = customer.getBirthdate();
                break;
            }
        } while (!Validator.validateBirthdate(birthdate));

        do {
            street = EA.readString(String.format("Straße\t\taktueller Stand(%s): ", customer.getStreet()));
            if (street.equals("")) {
                street = customer.getStreet();
                break;
            }
        } while (!Validator.validateStreet(street));

        do {
            streetNumber = EA
                    .readIntAllowEmpty(String.format("Hausnr.\t\taktueller Stand(%d): ", customer.getStreetNumber()));
            if (streetNumber == Integer.MIN_VALUE) {
                streetNumber = customer.getStreetNumber();
                break;
            }
        } while (!Validator.validateStreetNumber(streetNumber));

        do {
            postcode = EA.readString(String.format("PLZ\t\taktueller Stand(%s): ", customer.getPostcode()));
            if (postcode.equals("")) {
                postcode = customer.getPostcode();
                break;
            }
        } while (!Validator.validatePostcode(postcode));

        do {
            town = EA.readString(String.format("Stadt\t\taktueller Stand(%s): ", customer.getTown()));
            if (town.equals("")) {
                town = customer.getTown();
                break;
            }
        } while (!Validator.validateTown(town));

        do {
            phoneNumber = EA.readString(String.format("Telefon\t\taktueller Stand(%s): ", customer.getPhoneNumber()));
            if (phoneNumber.equals("")) {
                phoneNumber = customer.getPhoneNumber();
                break;
            }
        } while (!Validator.validatePhoneNumber(phoneNumber));

        do {
            mobilephoneNumber = EA
                    .readString(String.format("Mobile\t\taktueller Stand(%s): ", customer.getMobileNumber()));
            if (mobilephoneNumber.equals("")) {
                mobilephoneNumber = customer.getMobileNumber();
                break;
            }
        } while (!Validator.validateMobileNumber(mobilephoneNumber));

        do {
            fax = EA.readString(String.format("Fax\t\taktueller Stand(%s): ", customer.getFax()));
            if (fax.equals("")) {
                fax = customer.getFax();
                break;
            }
        } while (!Validator.validateFax(fax));

        do {
            email = EA.readString(String.format("Email\t\taktueller Stand(%s): ", customer.getEmail()));
            if (email.equals("")) {
                if (!title.equals(customer.getEmail())) {
                    boolean isChangeEmail = EA.readString("Soll die Email verändert werden? j/n ").equals("j") ? true
                            : false;
                    if (!isChangeEmail) {
                        title = customer.getEmail();
                    }
                }
                break;
            }
        } while (!Validator.validateEmail(email));

        do {
            newsletter = EA.readString(
                    String.format("Newsletter\taktueller Stand(%s): ",
                            customer.getNewsletter() == 1 ? "Ja" : "Nein"));
            if (newsletter.equals("")) {
                newsletter = customer.getNewsletter() == 1 ? "Ja" : "Nein";
                break;
            }
        } while (!Validator.validateNewsletter(newsletter));

        int newsletterValue = newsletter.equals("Ja") ? 1 : 0;

        Customer updatedCustomer = new Customer(customer.getCustomerNumber(), salutation, title, name, lastName,
                birthdate,
                street, streetNumber, postcode, town, phoneNumber, mobilephoneNumber, fax, email, newsletterValue);

        return updatedCustomer;
    }
}