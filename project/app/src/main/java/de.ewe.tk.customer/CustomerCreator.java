import util.EA;

public class CustomerCreator {
    public static Customer createUser() {
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
        return customer;
    }

    public static Customer changeUser(Customer customer) {
        int streetNumber, postcode;
        String salutation, title, name, lastName, birthdate, street, town, phoneNumber, mobilephoneNumber, fax,
                email, newsletter;

        System.out.println("\n---Für keine Veränderung Enter drücken---\n");

        do {
            salutation = EA.readString(String.format("Anrede: Stand(%s)", customer.getSalutation()));
            if (salutation.equals("")) {
                salutation = customer.getSalutation();
                break;
            }
        } while (!Validator.validateSalutation(salutation));
        do {
            title = EA.readString(String.format("Titel: Stand(%s)", customer.getTitle()));
            if (title.equals("")) {
                title = customer.getTitle();
                break;
            }
        } while (!Validator.validateTitle(title));
        do {
            name = EA.readString(String.format("Vorname: Stand(%s)", customer.getName()));
            if (name.equals("")) {
                name = customer.getName();
                break;
            }
        } while (!Validator.validateName(name));
        do {
            lastName = EA.readString(String.format("Nachname: Stand(%s)", customer.getLastName()));
            if (lastName.equals("")) {
                lastName = customer.getLastName();
                break;
            }
        } while (!Validator.validateLastName(lastName));
        do {
            birthdate = EA.readString(String.format("Geburtsdatum: Stand(%s)", customer.getBirthdate()));
            if (birthdate.equals("")) {
                birthdate = customer.getBirthdate();
                break;
            }
        } while (!Validator.validateBirthdate(birthdate));
        do {
            street = EA.readString(String.format("Straße: Stand(%s)", customer.getStreet()));
            if (street.equals("")) {
                street = customer.getStreet();
                break;
            }
        } while (!Validator.validateStreet(street));
        do {
            streetNumber = EA.readIntAllowEmpty(String.format("Hausnr.: Stand(%s)", customer.getStreetNumber()));
            if (streetNumber == Integer.MIN_VALUE) {
                streetNumber = customer.getStreetNumber();
                break;
            }
        } while (!Validator.validateStreetNumber(streetNumber));
        do {
            postcode = EA.readIntAllowEmpty(String.format("PLZ: Stand(%s)", customer.getPostcode()));
            if (postcode == Integer.MIN_VALUE) {
                postcode = customer.getPostcode();
                break;
            }
        } while (!Validator.validatePostcode(postcode));
        do {
            town = EA.readString(String.format("Stadt: Stand(%s)", customer.getTown()));
            if (town.equals("")) {
                town = customer.getTown();
                break;
            }
        } while (!Validator.validateTown(town));
        do {
            phoneNumber = EA.readString(String.format("Telefon: Stand(%s)", customer.getPhoneNumber()));
            if (phoneNumber.equals("")) {
                phoneNumber = customer.getPhoneNumber();
                break;
            }
        } while (!Validator.validatePhoneNumber(phoneNumber));
        do {
            mobilephoneNumber = EA.readString(String.format("Mobile: Stand(%s)", customer.getMobileNumber()));
            if (mobilephoneNumber.equals("")) {
                mobilephoneNumber = customer.getMobileNumber();
                break;
            }
        } while (!Validator.validateMobileNumber(mobilephoneNumber));
        do {
            fax = EA.readString(String.format("Fax: Stand(%s)", customer.getFax()));
            if (fax.equals("")) {
                fax = customer.getFax();
                break;
            }
        } while (!Validator.validateFax(fax));
        do {
            email = EA.readString(String.format("Email: Stand(%s)", customer.getEmail()));
            if (email.equals("")) {
                email = customer.getEmail();
                break;
            }
        } while (!Validator.validateEmail(email));
        do {
            newsletter = EA.readString(
                    String.format("Newsletter: Ja/Nein Stand(%s)", customer.getNewsletter() == 1 ? "Ja" : "Nein"));
            if (newsletter.equals("")) {
                name = customer.getNewsletter() == 1 ? "Ja" : "Nein";
                break;
            }
        } while (!Validator.validateNewsletter(newsletter));

        Customer updatedCustomer = new Customer(customer.getCustomerNumber(), salutation, title, name, lastName,
                birthdate,
                street, streetNumber, postcode, town, phoneNumber, mobilephoneNumber, fax, email,
                newsletter.equals("Ja") ? 1 : 0);

        return updatedCustomer;
    }
}