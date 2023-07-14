import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static boolean matches(String value, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        boolean isMatch = matcher.find();
        return isMatch;
    }

    public static boolean validateCustomerNumber(int customerNumber) {
        String regex = "^[1-9][0-9]+$|^[1-9]$";
        boolean isValid = matches(String.format("%d", customerNumber), regex);
        return isValid;
    }

    public static boolean validateSalutation(String salutation) {
        salutation = salutation.trim();
        String regex = "^(Frau|Herr)$";
        boolean isValid = matches(salutation, regex);
        return isValid;
    }

    public static boolean validateTitle(String title) {
        title = title.trim();
        String regex = "^(Dr[.]|Prof[.])$";
        boolean isValid = matches(title, regex);
        return isValid;
    }

    public static boolean validateName(String name) {
        name = name.trim();
        String regex = "^[A-ZÀ-ÞŸŽŠŒČ][a-zA-ZÀ-ÿŸžŽšŠŒœČč .'!-]*$|^[A-ZÀ-ÞŸŽŠŒ]$";
        boolean isValid = matches(name, regex);
        return isValid;
    }

    public static boolean validateLastName(String lastName) {
        lastName = lastName.trim();
        String regex = "^[A-ZÀ-ÞŸŽŠŒČ][a-zA-ZÀ-ÿŸžŽšŠŒœČč .'!-]*$|^[A-ZÀ-ÞŸŽŠŒ]$";
        boolean isValid = matches(lastName, regex);
        return isValid;
    }

    public static boolean validateBirthdate(String birthdate) {
        birthdate = birthdate.trim();
        String regex = "^(0[1-9]|[1-2][0-9]|3[0-1])[.](0[1-9]|1[0-2])[.][1-2][0-9]{3}$";
        boolean isValid = matches(birthdate, regex);
        return isValid;
    }

    public static boolean validateStreet(String street) {
        street = street.trim();
        String regex = "^[A-ZÀ-ÞŸŽŠŒČ][a-zA-ZÀ-ÿŸžŽšŠŒœČč .'!-]*$|^[A-ZÀ-ÞŸŽŠŒ]$";
        boolean isValid = matches(street, regex);
        return isValid;
    }

    public static boolean validateStreetNumber(int streetNumber) {
        String regex = "^[1-9][0-9]+$|^[1-9]$";
        boolean isValid = matches(String.format("%d", streetNumber), regex);
        return isValid;
    }

    public static boolean validatePostcode(String postcode) {
        postcode = postcode.trim();
        String regex = "^[0-9]{5}$";
        boolean isValid = matches(postcode, regex);
        return isValid;
    }

    public static boolean validateTown(String town) {
        town = town.trim();
        String regex = "^[A-ZÀ-ÞŸŽŠŒČ][a-zA-ZÀ-ÿŸžŽšŠŒœČč .'!-]*$|^[A-ZÀ-ÞŸŽŠŒ]$";
        boolean isValid = matches(town, regex);
        return isValid;
    }

    // noch anpassen
    public static boolean validatePhoneNumber(String num) {
        num = num.trim();
        String regex = "^([+]?[0-9]{1,}([ \t]?|[\\-]?)[0-9]*([ \t]?|[\\-]?)\\(?[0-9]{2,}\\)?([ \t]?|[\\-]?)[0-9]{3,}[ \t]?[0-9]{3,})$|^0[0-9]{2,4}/[0-9]{7,8}$";
        boolean isValid = matches(num, regex);
        return isValid;
    }

    // noch anpassen
    public static boolean validateMobileNumber(String num) {
        num = num.trim();
        String regex = "^([+]?[0-9]{1,}([ \t]?|[\\-]?)[0-9]*([ \t]?|[\\-]?)\\(?[0-9]{2,}\\)?([ \t]?|[\\-]?)[0-9]{3,}[ \t]?[0-9]{3,})$|^[0-9]{4}/[0-9]{7}$";
        boolean isValid = matches(num, regex);
        return isValid;
    }

    // noch anpassen
    public static boolean validateFax(String num) {
        num = num.trim();
        String regex = "^([+]?[0-9]{1,}([ \t]?|[\\-]?)[0-9]*([ \t]?|[\\-]?)\\(?[0-9]{2,}\\)?([ \t]?|[\\-]?)[0-9]{3,}[ \t]?[0-9]{3,})$|^[0-9]{3,5}/[0-9]{6,8}$";
        boolean isValid = matches(num, regex);
        return isValid;
    }

    public static boolean validateEmail(String eMail) {
        eMail = eMail.trim();
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";

        boolean isValid = matches(eMail, regex);
        return isValid;
    }

    public static boolean validateNewsletter(String newsletter) {
        newsletter = newsletter.trim();
        String regex = "^Ja$|^Nein$";
        boolean isValid = matches(newsletter, regex);
        return isValid;
    }
}