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

    // Sonderzeichen??
    public static boolean validateName(String name) {
        name = name.trim();
        String regex = "^[A-ZÀ-ÞŸŽŠŒ][a-zA-ZÀ-ÿŸžŽšŠŒœ .'!-]*$|^[A-ZÀ-ÞŸŽŠŒ]$";
        boolean isValid = matches(name, regex);
        return isValid;
    }

    // Sonderzeichen ??
    public static boolean validateLastName(String lastName) {
        lastName = lastName.trim();
        String regex = "^[A-ZÀ-ÞŸŽŠŒ][a-zA-ZÀ-ÿŸžŽšŠŒœ .'!-]*$|^[A-ZÀ-ÞŸŽŠŒ]$";
        boolean isValid = matches(lastName, regex);
        return isValid;
    }

    // Sonderzeichen ??
    public static boolean validateBirthdate(String birthdate) {
        birthdate = birthdate.trim();
        String regex = "^[1-2][0-9]{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
        boolean isValid = matches(birthdate, regex);
        return isValid;
    }

    // Sonderzeichen ??
    public static boolean validateStreet(String street) {
        street = street.trim();
        String regex = "^[A-ZÀ-ÞŸŽŠŒ][a-zA-ZÀ-ÿŸžŽšŠŒœ .'!-]*$|^[A-ZÀ-ÞŸŽŠŒ]$";
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

    // ^[a-zA-Z][0-9a-zA-Z][0-9a-zA-Z '-.=#/]*$
    // [ .'!-]
    // ^[A-ZÀ-ÞŸŽŠŒ][a-zA-ZÀ-ÿŸžŽšŠŒœ .'!-]*$

    // Č/č

    public static boolean validateTown(String town) {
        town = town.trim();
        String regex = "^[A-ZÀ-ÞŸŽŠŒ][a-zA-ZÀ-ÿŸžŽšŠŒœ .'!-]*$|^[A-ZÀ-ÞŸŽŠŒ]$";
        boolean isValid = matches(town, regex);
        return isValid;
    }

    /*
     * 0231 274870
     * 0231 27487-03
     * +49 30 27012244
     * 
     * [+][1-9][0-9]{0,3}....Ländervorwahl
     */
    // Sonderzeichen ??
    public static boolean validatePhoneNumber(String num) {
        num = num.trim();
        String regex = "^0[0-9]{2,4}/[0-9]{7,8}$";
        boolean isValid = matches(num, regex);
        return isValid;
    }

    /*
     * 0170 7654321
     * +49 170 7654321
     * 
     * [+][1-9][0-9]{0,3}....
     */
    // Sonderzeichen ??
    public static boolean validateMobileNumber(String num) {
        num = num.trim();
        String regex = "^01[0-9]{2}/[0-9]{7}$";
        boolean isValid = matches(num, regex);
        return isValid;
    }

    /*
     * +(Landesvorwahl)(Ortsvorwahl)(Faxnummer)
     * 
     * z.B.: +49-711-9876543
     * oder 0049(711)1234567
     * Beispiele für den Aufbau einer Faxnummer
     * Faxnummer Beispiel 1:
     * 
     * In den InterFAX Account-Einstellungen ist hinterlegt: a) Länderkennung:
     * Deutschland, b) Ortsvorwahl: 711 (für Stuttgart)
     * Es soll ein Fax in ein anderes Land gesendet werden (z.B. Großbritannien, mit
     * der Länderkennzahl '44'):
     * Option 1: +44 161 999 8888
     * Option 2: 0044 (161) 999 8888
     * 
     * Es soll ein Fax in eine andere Stadt innerhalb Deutschlands gesendet werden:
     * Option 1: 040-999 8888
     * Option 2: +49 (40) 999 8888
     * 
     * Es soll ein Fax an eine Faxnummer in Stuttgart gesendet werden
     * Option 1: 5222 8888
     * Option 2: 0711-5222 8888
     * Option 3: +49 (711) 5222 8888
     * 
     * 0211 2147-36
     * 
     * [ ()-]
     */
    // Sonderzeichen ??
    public static boolean validateFax(String num) {
        num = num.trim();
        String regex = "^0[0-9]{2,4}/[0-9]{6,8}$";
        boolean isValid = matches(num, regex);
        return isValid;
    }

    // Sonderzeichen local:
    // Buchstaben A-Z und a-z (ohne Akzente und keine Umlaute, kein ß)
    // Ziffern 0-9
    // Die folgenden Sonderzeichen: ! # $ % & ‘ * + – / = ? ^ _ ` { | } ~
    // . nicht vorne oder hinten und nicht mehrfach hintereinader
    // Space and special characters "(),:;<>@[\] are allowed with restrictions (they
    // are only allowed inside a quoted string, as described in the paragraph below,
    // and in that quoted string, any backslash or double-quote must be preceded
    // once by a backslash); "hello world"@example.com

    // domain: “a-z”, “0-9” und “-“ (Bindestrich). Die Mindestlänge des Domainnamens
    // beträgt 3 Zeichen, die Höchstlänge 63 Zeichen. Der Name darf nicht mit einem
    // Bindestrich beginnen oder enden. Ein gültiger Domain-Name besteht aus maximal
    // 63 Zeichen. Wer darauf besteht, kann auch ä,ö, oder ü im Domain part
    // benutzen, aber davon rate ich ab.

    // endung [a-z]{2,6}
    // \w -> A-Za-Z0-9_
    // local: [\w]

    // ^(?=[A-Z0-9][A-Z0-9@._%+-]{5,253}+$)[A-Z0-9._%+-]{1,64}+@(?:(?=[A-Z0-9-]{1,63}+\.)[A-Z0-9]++(?:-[A-Z0-9]++)*+\.){1,8}+[A-Z]{2,63}+$

    public static boolean validateEmail(String eMail) {
        eMail = eMail.trim();
        String regex = "^[a-zA-Z.\"-]+[@][a-zA-Z]+[.](xyz|com|de)$";
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