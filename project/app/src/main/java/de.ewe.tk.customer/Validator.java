import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static boolean isMatch(String value, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        boolean isMatch = matcher.find();
        return isMatch;
    }

    public static boolean validateCustomerNumber(int customerNumber) {
        String regex = "^[0-9]+$";
        boolean isValid = isMatch(String.format("%d", customerNumber), regex);
        return isValid;
    }

    public static boolean validateSalutation(String salutation) {
        salutation = salutation.trim();
        String regex = "^Frau|Herr$";
        boolean isValid = isMatch(salutation, regex);
        return isValid;
    }

    public static boolean validateTitle(String title) {
        title = title.trim();
        String regex = "^Dr.|Prof.|$";
        boolean isValid = isMatch(title, regex);
        return isValid;
    }

    public static boolean validateName(String name) {
        name = name.trim();
        String regex = "^[A-ZÄÜÖ][a-zöüä]*$";
        boolean isValid = isMatch(name, regex);
        return isValid;
    }

    public static boolean validateLastName(String lastName) {
        lastName = lastName.trim();
        String regex = "^[A-ZÄÜÖ][a-zöüä]*$";
        boolean isValid = isMatch(lastName, regex);
        return isValid;
    }

    public static boolean validateBirthdate(String birthdate) {
        birthdate = birthdate.trim();
        String regex = "^[1-2][0-9]{3}-(0\\d|1[0-2])-([0-2]\\d|3[0-1])$";
        boolean isValid = isMatch(birthdate, regex);
        return isValid;
    }

    public static boolean validateStreet(String street) {
        street = street.trim();
        String regex = "^[A-ZÄÜÖ][a-zöüäA-ZÜÖÄ\\s-.]+$";
        boolean isValid = isMatch(street, regex);
        return isValid;
    }

    public static boolean validateStreetNumber(int streetNumber) {
        String regex = "^\\d+$";
        boolean isValid = isMatch(String.format("/d", streetNumber), regex);
        return isValid;
    }

    public static boolean validatePostcode(int postcode) {
        String regex = "^[0-9]{4,5}$";
        boolean isValid = isMatch(String.format("%d", postcode), regex);
        return isValid;
    }

    public static boolean validateTown(String town) {
        town = town.trim();
        String regex = "^[A-ZÄÜÖ][a-zöüäA-ZÜÖÄ\\sß]+$";
        boolean isValid = isMatch(town, regex);
        return isValid;
    }

    public static boolean validatePhoneNumber(String num) {
        num = num.trim();
        String regex = "^0\\d{3,4}/\\d{7,8}$";
        boolean isValid = isMatch(num, regex);
        return isValid;
    }

    public static boolean validateMobileNumber(String num) {
        num = num.trim();
        String regex = "^01\\d{2}/\\d{7}$";
        boolean isValid = isMatch(num, regex);
        return isValid;
    }

    public static boolean validateFax(String num) {
        num = num.trim();
        String regex = "^0\\d{2,4}/\\d{6,8}$";
        boolean isValid = isMatch(num, regex);
        return isValid;
    }

    public static boolean validateEmail(String eMail) {
        eMail = eMail.trim();
        String regex = "^[a-zA-Z.]+[@][a-zA-Z]+[.](xyz|com|de)$";
        boolean isValid = isMatch(eMail, regex);
        return isValid;
    }

    public static boolean validateNewsletter(String newsletter) {
        newsletter = newsletter.trim();
        String regex = "^Ja|Nein$";
        boolean isValid = isMatch(newsletter, regex);
        return isValid;
    }
}