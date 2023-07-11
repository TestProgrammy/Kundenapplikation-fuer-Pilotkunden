import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.IO;

public class Validator {

    private static boolean isInteger(int value) {
        String regex = "^[0-9]+$";
        return isInteger(value, regex);
    }

    private static boolean isInteger(int value, String regex) {
        try {
            if (isMatch(String.format("%d", value), regex)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
        }
        return false;
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
            value.trim();
            return value;
        } else {
            return original;
        }
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

    public static Integer validateCustomerNumber(int customerNumber) {
        if (isInteger(customerNumber)) {
        }
        try {
            Integer.valueOf(customerNumber);
            return customerNumber;
        } catch (NumberFormatException e) {
            customerNumber = IO.readInt("Falsche Eingabe der Kundennummer. Kundennummer: ");
            return validateCustomerNumber(customerNumber);
        }
    }

    public static String validateSalutation(String salutation, String original) {
        String returnValue = validateNormalString(salutation, original);
        return returnValue.equals(null) ? (validateSalutation(IO.readString("Falsche Eingabe. Anrede: "), original))
                : original;
    }

    public static String validateTitel(String title, String original) {
        String returnValue;
        if (isString(title)) {
            if (title.equals("") && !original.equals("")) {
                String isNoChangeWanted = IO.readString("Gibt es keinen Title? j/n ");
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
        return returnValue.equals(null) ? (validateTitel(IO.readString("Falsche Eingabe. Title: "), original))
                : original;
    }

    public static String validateName(String name, String original) {
        String returnValue = validateNormalString(name, original);
        return returnValue.equals(null) ? (validateName(IO.readString("Falsche Eingabe. Vorname: "), original))
                : original;
    }

    public static String validateLastName(String lastName, String original) {
        String returnValue = validateNormalString(lastName, original);
        return returnValue.equals(null) ? (validateLastName(IO.readString("Falsche Eingabe. Nachname: "), original))
                : original;
    }

    public static String validateBirthdate(String birthdate, String original) {
        String regex = "^[1-2][0-9]{3}-(0\\d|1[0-2])-([0-2]\\d|3[0-1])$";
        String returnValue = validateRegexString(birthdate, original, regex);
        return returnValue.equals(null) ? (validateBirthdate(IO.readString("Falsche Eingabe. Geburtstag: "), original))
                : original;
    }

    public static String validateStreet(String street, String original) {
        String returnValue = validateNormalString(street, original);
        return returnValue.equals(null) ? (validateStreet(IO.readString("Falsche Eingabe. Straße: "), original))
                : original;
    }

    public static Integer validateStreetNumber(int streetNumber, int original) {
        int returnValue = isInteger(streetNumber) ? streetNumber : original;
        return returnValue == Integer.MIN_VALUE
                ? (validateStreetNumber(IO.readInt("Falsche Eingabe. Hausnr.: "), original))
                : original;
    }

    public static Integer validatePostcode(int postcode, int original) {
        String regex = "^[0-9]{4,5}$";
        if (isInteger(postcode, regex)) {
            return postcode;
        }
        return original == Integer.MIN_VALUE ? (validatePostcode(IO.readInt("Falsche Eingabe. PLZ: "), original))
                : original;
    }

    public static String validateTown(String town, String original) {
        String returnValue = validateNormalString(town, original);
        return returnValue.equals(null) ? (validateTown(IO.readString("Falsche Eingabe. Stadt: "), original))
                : original;
    }

    public static String validatePhoneNumber(String num, String original) {
        String regex = "^0\\d{3,4}/\\d{7,8}$";
        String returnValue = validateRegexString(num, original, regex);
        return returnValue.equals(null) ? (validatePhoneNumber(IO.readString("Falsche Eingabe. Telefon: "), original))
                : original;
    }

    public static String validateMobilenumber(String num, String original) {
        String regex = "^01\\d{2}/\\d{7}$";
        String returnValue = validateRegexString(num, original, regex);
        return returnValue.equals(null) ? (validateMobilenumber(IO.readString("Falsche Eingabe. Mobile: "), original))
                : original;
    }

    public static String validateFax(String num, String original) {
        String regex = "^0\\d{2,4}/\\d{6,8}$";
        String returnValue = validateRegexString(num, original, regex);
        return returnValue.equals(null) ? (validateFax(IO.readString("Falsche Eingabe. Fax: "), original)) : original;
    }

    public static String validateEmail(String eMail, String original) {
        String regex = "^[a-zA-Z.]+[@][a-zA-Z]+[.](xyz|com|de)$";
        String returnValue = validateRegexString(eMail, original, regex);
        return returnValue.equals(null) ? (validateEmail(IO.readString("Falsche Eingabe. E-Mail: "), original))
                : original;
    }

    public static Integer validateNewsletter(String newsletter, int original) {
        int returnValue;
        try {
            String.valueOf(newsletter);
            Double.parseDouble(newsletter);
            returnValue = original;
        } catch (NullPointerException e) {
            returnValue = original;
        } catch (NumberFormatException e) {
            int value = newsletter.equals("Ja") ? 1 : newsletter.equals("Nein") ? 0 : 2;
            if (value == 2) {
                returnValue = original;
            } else {
                returnValue = value;
            }
        }
        return returnValue == Integer.MIN_VALUE
                ? (validateNewsletter(IO.readString("Falsche Eingabe. Newsletter: Ja/Nein"), original))
                : original;
    }
}