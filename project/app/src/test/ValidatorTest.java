package java.de.ewe.tk.customer;

import static de.ewe.customer.Validator.*;
import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void testCustomerNumberValidation() {
        // Positive Fälle
        int[] pIntValues = { 1, 2, 34, 1000 };
        for (String value : pIntValues) {
            assertTrue(validator.validateCustomerNumber(value));
        }

        // Negative Fälle
        int[] nIntValues = { -1, 0, -21 };
        for (String value : pIntValues) {
            assertFalse(validator.validateCustomerNumber(value));
        }
    }

    @Test
    public void testStreetNumberValidation() {
        // Positive Fälle
        int[] pIntValues = { 0, 1, 2, 34, 1000 };
        for (String value : pIntValues) {
            assertTrue(validator.validateStreetNumber(value));
        }

        // Negative Fälle
        int[] nIntValues = { -1, -21 };
        for (String value : pIntValues) {
            assertFalse(validator.validateStreetNumber(value));
        }
    }

    @Test
    public void testPostcodeValidation() {
        // Positive Fälle
        int[] pIntValues = { 0221, 04342 };
        for (String value : pIntValues) {
            assertTrue(validator.validatePostcode(value));
        }

        // Negative Fälle
        int[] nIntValues = { -1, 0, 1, 100, 20, -1000 };
        for (String value : pIntValues) {
            assertFalse(validator.validatePostcode(value));
        }
    }

    @Test
    public void testSalutationValidation() {
        // Positive Fälle
        String[] pStringValues = { "Frau", "Herr", " Frau ", " Frau", "Frau " };
        for (String value : pStringValues) {
            assertTrue(validator.validateSalutation(value));
        }
        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1", "ja", "nein", "Nmae", " ", " Na", "asdr", "[", "aS" };
        for (String value : pStringValues) {
            assertFalse(validator.validateSalutation(value));
        }
    }

    @Test
    public void testTitleValidation() {
        // Positive Fälle
        String[] pStringValues = { "Dr.", "Prof.", " Dr.", "Prof. " };
        for (String value : pStringValues) {
            assertTrue(validator.validateTitle(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1", "ja", "nein", "Nmae", " ", " Na", "asdr", "[", "aS", "dr",
                "." };
        for (String value : pStringValues) {
            assertFalse(validator.validateTitle(value));
        }
    }

    @Test
    public void testNameValidation() {
        // Positive Fälle
        String[] pStringValues = { "Max", " Max", "Äber", " Özir ", "Peter", "Anna-Jenna" };
        for (String value : pStringValues) {
            assertTrue(validator.validateName(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1", " 1", "ja", "nein", "nmae", " ", " nA", "asdr", "[", "aS" };
        for (String value : pStringValues) {
            assertFalse(validator.validateName(value));
        }
    }

    @Test
    public void testLastNameValidation() {
        // Positive Fälle
        String[] pStringValues = { "Maxmann", " Max", "Äber", " Özir ", "Peter-Peter" };
        for (String value : pStringValues) {
            assertTrue(validator.validateLastName(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1", " 1", "ja", "nein", "nmae", " ", " nA", "asdr", "[", "aS" };
        for (String value : pStringValues) {
            assertFalse(validator.validateLastName(value));
        }
    }

    @Test
    public void testBirthdateValidation() {
        // Positive Fälle
        String[] pStringValues = { "1999-12-01", "2009-03-02" };
        for (String value : pStringValues) {
            assertTrue(validator.validateBirthdate(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1", "ja", "nein", "Nmae", " ", " Na", "asdr", "[", "aS",
                "1999-13-01", "0999-12-01", "3000-01-01", "2009-00-10", "2009-10-00" };
        for (String value : pStringValues) {
            assertFalse(validator.validateBirthdate(value));
        }
    }

    @Test
    public void testStreetValidation() {
        // Positive Fälle
        String[] pStringValues = { "An der Wall", " Cloppenburger Str.", "Wiesenstr.", "Blablastraße " };
        for (String value : pStringValues) {
            assertTrue(validator.validateStreet(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1", "ja", "nein", "mae", " ", " nA", "asdr", "[", "aS" };
        for (String value : pStringValues) {
            assertFalse(validator.validateStreet(value));
        }
    }

    @Test
    public void testTownValidation() {
        // Positive Fälle
        String[] pStringValues = { "Mührendorf", "Hätschenhausen", "Stadensen", "Odderade ", " Krefeld",
                "Mänkhagen", "Eßlingen" };
        for (String value : pStringValues) {
            assertTrue(validator.validateTown(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1", "ja", "nein", "mae", " ", " aN", "asdr", "[", "aS" };
        for (String value : pStringValues) {
            assertFalse(validator.validateTown(value));
        }
    }

    @Test
    public void testPhoneNumberValidation() {
        // Positive Fälle
        String[] pStringValues = { "04131/66343532", "02064/72057711 ", "  06502/70122539", "04254/17837452",
                "07503/21985435", "02692/16113330", " 09422/76673801", "069/74155588" };
        for (String value : pStringValues) {
            assertTrue(validator.validatePhoneNumber(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1", "ja", "nein", "Nmae", " ", " Na", "asdr", "[", "aS",
                "016/130671", "06/3074744", "9163/131067", "0156/307474444" };
        for (String value : pStringValues) {
            assertFalse(validator.validatePhoneNumber(value));
        }
    }

    @Test
    public void testMobileNumberValidation() {
        // Positive Fälle
        String[] pStringValues = { " 0158/2180605 ", " 0167/9041015", "0174/3643929 ", "0160/7890723", "0156/9117659",
                "0163/1310671", "0156/3074744", "0162/2361361", "0167/9869637" };
        for (String value : pStringValues) {
            assertTrue(validator.validateMobileNumber(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1", "ja", "nein", "Nmae", " ", " Na", "asdr", "[", "aS",
                "016/1310671", "9156/3074744", "0163/131067", "0156/30747444" };
        for (String value : pStringValues) {
            assertFalse(validator.validateMobileNumber(value));
        }
    }

    @Test
    public void testFaxValidation() {
        // Positive Fälle
        String[] pStringValues = { "02743/88385128", "03622/93560602", "03523/10508643", "0551/74743421",
                "055/74743421", "06563/75076483", " 09823/957224", "06237/2106740 ", "09566/45288491" };
        for (String value : pStringValues) {
            assertTrue(validator.validateFax(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1", "ja", "nein", "Nmae", " ", " Na", "asdr", "[", "aS",
                "155/74743421", "06563/750276483", " 09/957224", "06237/21060 " };
        for (String value : pStringValues) {
            assertFalse(validator.validateFax(value));
        }
    }

    @Test
    public void testEmailValidation() {
        // Positive Fälle
        String[] pStringValues = { "welsch@mail.xyz", "r.radtke@mail.xyz", "b.brauner@mail.xyz", "n.hacker@mail.xyz",
                " frederic.schleicher@mail.de", "y.behrend@mail.com ", "Lilian.kahl@yahoo.xyz" };
        for (String value : pStringValues) {
            assertTrue(validator.validateEmail(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1", "ja", "nein", "Nmae", " ", " Na", "asdr", "[", "aS",
                "wels ch@mail.xyz", "frederic-schleicher@mail.de", "y.behrendmail.com", "Lilian.kahl@yahoo.",
                "asdjsao@" };
        for (String value : pStringValues) {
            assertFalse(validator.validateEmail(value));
        }
    }

    @Test
    public void testNewsletterValidation() {
        // Positive Fälle
        String[] pStringValues = { "Ja", "Nein" };
        for (String value : pStringValues) {
            assertTrue(validator.validateNewsletter(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1", "ja", "nein", "Nmae", " ", " Na", "asdr", "[", "aS" };
        for (String value : pStringValues) {
            assertFalse(validator.validateNewsletter(value));
        }
    }
}