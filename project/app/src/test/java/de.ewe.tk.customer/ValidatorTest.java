
import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTest {

    @Test
    public void testCustomerNumberValidation() {
        // Positive Fälle
        int[] pIntValues = { 1, 1000 };
        for (int value : pIntValues) {
            assertTrue(Validator.validateCustomerNumber(value));
        }

        // Negative Fälle
        int[] nIntValues = { 0, -21 };
        for (int value : nIntValues) {
            assertFalse(Validator.validateCustomerNumber(value));
        }
    }

    @Test
    public void testStreetNumberValidation() {
        // Positive Fälle
        int[] pIntValues = { 1, 238219 };
        for (int value : pIntValues) {
            assertTrue(Validator.validateStreetNumber(value));
        }

        // Negative Fälle
        int[] nIntValues = { 0, -21 };
        for (int value : nIntValues) {
            assertFalse(Validator.validateStreetNumber(value));
        }
    }

    @Test
    public void testPostcodeValidation() {
        // Positive Fälle
        String[] pIntValues = { " 01912", "12092" };
        for (String value : pIntValues) {
            assertTrue(Validator.validatePostcode(value));
        }

        // Negative Fälle
        String[] nIntValues = { "", "?", "-", "1", "ja", "asdr", "[", "aS", "-1", "0",
                "1", "100", "20", "-1000", "0192" };
        for (String value : nIntValues) {
            assertFalse(Validator.validatePostcode(value));
        }
    }

    @Test
    public void testSalutationValidation() {
        // Positive Fälle
        String[] pStringValues = { "Frau", "Herr", "Divers" };
        for (String value : pStringValues) {
            assertTrue(Validator.validateSalutation(value));
        }
        // Negative Fälle
        String[] nStringValues = { "", "?", "1" };
        for (String value : nStringValues) {
            assertFalse(Validator.validateSalutation(value));
        }
    }

    @Test
    public void testTitleValidation() {
        // Positive Fälle
        String[] pStringValues = { "Dr.", "Prof." };
        for (String value : pStringValues) {
            assertTrue(Validator.validateTitle(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1" };
        for (String value : nStringValues) {
            assertFalse(Validator.validateTitle(value));
        }
    }

    @Test
    public void testNameValidation() {
        // Positive Fälle
        String[] pStringValues = { "Max", " Özir ", "Peter-Peter", "Anna Maria" };
        for (String value : pStringValues) {
            assertTrue(Validator.validateName(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "j", "1" };
        for (String value : nStringValues) {
            assertFalse(Validator.validateName(value));
        }
    }

    @Test
    public void testLastNameValidation() {
        // Positive Fälle
        String[] pStringValues = { "Maxmann", " Özir ", "Peter-Peter", "Anna Maria" };
        for (String value : pStringValues) {
            assertTrue(Validator.validateLastName(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "j", "1" };
        for (String value : nStringValues) {
            assertFalse(Validator.validateLastName(value));
        }
    }

    @Test
    public void testBirthdateValidation() {
        // Positive Fälle
        String[] pStringValues = { "01.12.1999", "10.02.2009" };
        for (String value : pStringValues) {
            assertTrue(Validator.validateBirthdate(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "j", "1", "Nmae", "01.13.1999", "01.12.0999", "01.01.3000", "1.1.2000",
                "01.1.2000", "01.01.20", "00.00.2009", "2009-10-00" };
        for (String value : nStringValues) {
            assertFalse(Validator.validateBirthdate(value));
        }
    }

    @Test
    public void testStreetValidation() {
        // Positive Fälle
        String[] pStringValues = { "An der Wall", " Cloppenburger Str.", "Wiesenstr.", "Blablastraße " };
        for (String value : pStringValues) {
            assertTrue(Validator.validateStreet(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1", "[" };
        for (String value : nStringValues) {
            assertFalse(Validator.validateStreet(value));
        }
    }

    @Test
    public void testTownValidation() {
        // Positive Fälle
        String[] pStringValues = { "Mührendorf", "Stadensen", "Eßlingen", "St. Maria" };
        for (String value : pStringValues) {
            assertTrue(Validator.validateTown(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1", "[" };
        for (String value : nStringValues) {
            assertFalse(Validator.validateTown(value));
        }
    }

    @Test
    public void testPhoneNumberValidation() {
        // Positive Fälle
        String[] pStringValues = { "02743/88385128", "+49-711-9876543", "0049(711)1234567", "+44 161 999 8888",
                "0044 (161) 999 8888", "040-999 8888", "+49 (40) 999 8888", "0711-5222 8888" };
        for (String value : pStringValues) {
            assertTrue(Validator.validatePhoneNumber(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1" };
        for (String value : nStringValues) {
            assertFalse(Validator.validatePhoneNumber(value));
        }
    }

    @Test
    public void testMobileNumberValidation() {
        // Positive Fälle
        String[] pStringValues = { "0158/2180605", "0167/9869637" };
        for (String value : pStringValues) {
            assertTrue(Validator.validateMobileNumber(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1" };
        for (String value : nStringValues) {
            assertFalse(Validator.validateMobileNumber(value));
        }
    }

    @Test
    public void testFaxValidation() {
        // Positive Fälle
        String[] pStringValues = { "02743/88385128", "+49-711-9876543", "0049(711)1234567", "+44 161 999 8888",
                "0044 (161) 999 8888", "040-999 8888", "+49 (40) 999 8888", "0711-5222 8888" };
        for (String value : pStringValues) {
            assertTrue(Validator.validateFax(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "-", "j", "1" };
        for (String value : nStringValues) {
            assertFalse(Validator.validateFax(value));
        }
    }

    @Test
    public void testEmailValidation() {
        // Positive Fälle
        String[] pStringValues = { "welsch@mail.xyz", "r.radtke@mail.xyz", "b.brauner@mail.xyz", "n.hacker@mail.xyz",
                " frederic.schleicher@mail.de", "y.behrend@mail.com ", "Lilian.kahl@yahoo.xyz",
                "frederic-schleicher@mail.de" };
        for (String value : pStringValues) {
            assertTrue(Validator.validateEmail(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "1", "Nmae", "wels ch@mail.xyz", "y.behrendmail.com", "Lilian.kahl@yahoo.",
                "asdjsao@" };
        for (String value : nStringValues) {
            assertFalse(Validator.validateEmail(value));
        }
    }

    @Test
    public void testNewsletterValidation() {
        // Positive Fälle
        String[] pStringValues = { "Ja", "Nein" };
        for (String value : pStringValues) {
            assertTrue(Validator.validateNewsletter(value));
        }

        // Negative Fälle
        String[] nStringValues = { "", "?", "1", "ja" };
        for (String value : nStringValues) {
            assertFalse(Validator.validateNewsletter(value));
        }
    }
}