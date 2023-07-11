import util.IO;

public class Validation {

    private static boolean isInteger(int value) {
        return true;
    }

    private static boolean isString(String value) {
        try {
            String.valueOf(value);
            Double.parseDouble(value);
            return true;
        } catch (NullPointerException e) {
            return false;
        } catch (NumberFormatException e) {
        }
        return true;
    }

    private static String validateNormalString(String value, String original) {
        if (isString(value)) {
            if (value.equals("")) {
                return original;
            }
            // trim?
            return value;
        } else {
            return original;
        }
    }

    public static Integer validateCustomerNumber(int customerNumber) {
        if (isInteger(customerNumber)) {
        }
        try {
            Integer.valueOf(customerNumber);
            return customerNumber;
        } catch (NumberFormatException e) {
            customerNumber = IO.readInt("Kundennummer des zuupdatenden Kunden: ");
            return validateCustomerNumber(customerNumber);
        }
    }

    public static String validateSalutation(String salutation, String original) {
        return validateNormalString(salutation, original);
    }

    public static String validateTitel(String str, String original) {
        // was mit empthy -> nachfragen
        try {
            Integer.valueOf(str);
            return str;
        } catch (NumberFormatException e) {
            return original;
        }
    }

    public static String validateName(String name, String original) {
        try {
            String.valueOf(name);
            Double.parseDouble(name);
            return original;
        } catch (NullPointerException e) {
            return original;
        } catch (NumberFormatException e) {
        }
        return name;
    }

    public static String validateLastName(String lastName, String original) {
        try {
            String.valueOf(lastName);
            Double.parseDouble(lastName);
            return original;
        } catch (NullPointerException e) {
            return original;
        } catch (NumberFormatException e) {
        }
        return lastName;
    }

    public static String validateBirthdate(String str, String original) {
        // regex
        try {
            Integer.valueOf(str);
            return str;
        } catch (NumberFormatException e) {
            return original;
        }
    }

    public static String validateStreet(String street, String original) {
        try {
            String.valueOf(street);
            Double.parseDouble(street);
            return original;
        } catch (NullPointerException e) {
            return original;
        } catch (NumberFormatException e) {
        }
        return street;
    }

    public static Integer validateStreetNumber(int num, int original) {
        try {
            Integer.valueOf(num);
            return num;
        } catch (NumberFormatException e) {
            return original;
        }
    }

    public static Integer validatePostcode(int num, int original) {
        // regex for length
        try {
            Integer.valueOf(num);
            return num;
        } catch (NumberFormatException e) {
            return original;
        }
    }

    public static String validateTown(String town, String original) {
        try {
            String.valueOf(town);
            Double.parseDouble(town);
            return original;
        } catch (NullPointerException e) {
            return original;
        } catch (NumberFormatException e) {
        }
        return town;
    }

    public static String validatePhoneNumber(String str, String original) {
        // regex
        try {
            Integer.valueOf(str);
            return str;
        } catch (NumberFormatException e) {
            return original;
        }
    }

    public static String validateMobilenumber(String str, String original) {
        // regex
        try {
            Integer.valueOf(str);
            return str;
        } catch (NumberFormatException e) {
            return original;
        }
    }

    public static String validateFax(String str, String original) {
        // regex
        try {
            Integer.valueOf(str);
            return str;
        } catch (NumberFormatException e) {
            return original;
        }
    }

    public static String validateEmail(String eMail, String original) {
        // regex
        try {
            String.valueOf(eMail);
            return eMail;
        } catch (NumberFormatException e) {
            return original;
        }
    }

    public static Integer validateNewsletter(String newsletter, int original) {
        try {
            String.valueOf(newsletter);
            Double.parseDouble(newsletter);
            return original;
        } catch (NullPointerException e) {
            return original;
        } catch (NumberFormatException e) {
        }
        int value = newsletter.equals("Ja") ? 1 : newsletter.equals("Nein") ? 0 : 2;
        if (value == 2) {
            return original;
        }
        return value;
    }
}