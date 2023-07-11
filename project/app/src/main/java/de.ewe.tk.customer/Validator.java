import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.EA;

public class Validator {

    private static String validateNormalString(String value, String original) {
        if (value.equals("")) {
            return original;
        }
        value.trim();
        return value;
    }

    private static String validateRegexString(String value, String original, String regex) {
        value = validateNormalString(value, original);
        if (!value.equals(original) && isMatch(value, regex)) {
            return original;
        }
        return value;
    }

    private static boolean isMatch(String value, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        }
        return false;
    }

    public static Integer validateCustomerNumber(String message) {
        int customerNumber = EA.readInt("Kundennummer: ");
        try {
            // kundennummer abfragen, ob da
            return customerNumber;
        } catch (Exception e) {
            System.out.print("Falsche Eingabe. ");
            return validateCustomerNumber(message);
        }
    }

    public static String validateSalutation(String message, String original) {
        String salutation = EA.readString(message);
        // auf Frau und Herr einschränken?
        String returnValue = validateNormalString(salutation, original);
        if (!returnValue.equals(null)) {
            return returnValue;
        } else {
            System.out.print("Falsche Eingabe. ");
            return validateSalutation(message, original);
        }
    }

    public static String validateTitel(String message, String original) {
        String title = EA.readString(message);
        String returnValue;
        if (isString(title)) {
            if (title.equals("") && !original.equals("")) {
                String isNoChangeWanted = EA.readString("Gibt es keinen Title? j/n ");
                if (!isNoChangeWanted.equals("j")) {
                    returnValue = original;
                } else {
                    returnValue = title;
                }
            } else {
                title.trim();
                returnValue = title;
            }
        } else {
            returnValue = original;
        }
        if (!returnValue.equals(null)) {
            return returnValue;
        } else {
            System.out.print("Falsche Eingabe. ");
            return validateTitel(String.format("Falsche Eingabe. %s", message), original);
        }
    }

    public static String validateName(String message, String original) {
        String name = EA.readString(message);
        String returnValue = validateNormalString(name, original);
        if (!returnValue.equals(null)) {
            return returnValue;
        } else {
            System.out.print("Falsche Eingabe. ");
            return validateName(String.format("Falsche Eingabe. %s", message), original);
        }
    }

    public static String validateLastName(String message, String original) {
        String lastName = EA.readString(message);
        String returnValue = validateNormalString(lastName, original);
        if (!returnValue.equals(null)) {
            return returnValue;
        } else {
            System.out.print("Falsche Eingabe. ");
            return validateLastName(String.format("Falsche Eingabe. %s", message), original);
        }
    }

    public static String validateBirthdate(String message, String original) {
        String birthdate = EA.readString(message);
        String regex = "^[1-2][0-9]{3}-(0\\d|1[0-2])-([0-2]\\d|3[0-1])$";
        String returnValue = validateRegexString(birthdate, original, regex);
        if (!returnValue.equals(null)) {
            return returnValue;
        } else {
            System.out.print("Falsche Eingabe. ");
            return validateBirthdate(String.format("Falsche Eingabe. %s", message), original);
        }
    }

    public static String validateStreet(String message, String original) {
        String street = EA.readString(message);
        String returnValue = validateNormalString(street, original);
        if (!returnValue.equals(null)) {
            return returnValue;
        } else {
            System.out.print("Falsche Eingabe. ");
            return validateStreet(String.format("Falsche Eingabe. %s", message), original);
        }
    }

    public static Integer validateStreetNumber(String message, int original) {
        int streetNumber = EA.readInt(message);
        int returnValue = isInteger(streetNumber) ? streetNumber : original;
        if (returnValue != Integer.MIN_VALUE) {
            return returnValue;
        } else {
            System.out.print("Falsche Eingabe. ");
            return validateStreetNumber(String.format("Falsche Eingabe. %s", message), original);
        }
    }

    public static Integer validatePostcode(String message, int original) {
        int postcode = EA.readInt(message);
        String regex = "^[0-9]{4,5}$";
        if (isInteger(postcode, regex)) {
            return postcode;
        }
        return original == Integer.MIN_VALUE
                ? (validatePostcode(String.format("Falsche Eingabe. %s", message), original))
                : original;
    }

    public static String validateTown(String message, String original) {
        String town = EA.readString(message);
        String returnValue = validateNormalString(town, original);
        return returnValue.equals(null) ? (validateTown(String.format("Falsche Eingabe. %s", message), original))
                : original;
    }

    public static String validatePhoneNumber(String message, String original) {
        String regex = "^0\\d{3,4}/\\d{7,8}$";
        String num = EA.readString(message);
        String returnValue = validateRegexString(num, original, regex);
        return returnValue.equals(null) ? (validatePhoneNumber(String.format("Falsche Eingabe. %s", message), original))
                : original;
    }

    public static String validateMobileNumber(String message, String original) {
        String regex = "^01\\d{2}/\\d{7}$";
        String num = EA.readString(message);
        String returnValue = validateRegexString(num, original, regex);
        return returnValue.equals(null)
                ? (validateMobileNumber(String.format("Falsche Eingabe. %s", message), original))
                : original;
    }

    public static String validateFax(String message, String original) {
        String regex = "^0\\d{2,4}/\\d{6,8}$";
        String numj = EA.readString(message);
        String returnValue = validateRegexString(num, original, regex);
        return returnValue.equals(null) ? (validateFax(String.format("Falsche Eingabe. %s", message), original))
                : original;
    }

    public static String validateEmail(String message, String original) {
        String regex = "^[a-zA-Z.]+[@][a-zA-Z]+[.](xyz|com|de)$";
        String eMail = EA.readString(message);
        String returnValue = validateRegexString(eMail, original, regex);
        return returnValue.equals(null) ? (validateEmail(String.format("Falsche Eingabe. %s", message), original))
                : original;
    }

    public static Integer validateNewsletter(String message, int original) {
        String newsletter = EA.readString("Newsletter: Ja/Nein");
        int returnValue = newsletter.equals("Ja") ? 1 : newsletter.equals("Nein") ? 0 : 2;
        if (returnValue == 2) {
            returnValue = original;
        }
        return returnValue == Integer.MIN_VALUE
                ? (validateNewsletter(String.format("Falsche Eingabe. %s", message), original))
                : original;
    }
}