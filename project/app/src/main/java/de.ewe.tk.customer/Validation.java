public class Validation {
    private final Integer customerNumber;
    private final String salutation;
    private final String title;
    private final String name;
    private final String lastName;
    private final String birthDate;
    private final String street;
    private final Integer streetNumber;
    private final Integer postcode;
    private final String town;
    private final String phoneNumber;
    private final String mobileNumber;
    private final String fax;
    private final String eMail;
    private final Integer newsletter;

    public Validation(Integer customerNumber, String salutation, String title, String name, String lastName,
            String birthDate, String street, Integer streetNumber, Integer postcode, String town,
            String phoneNumber, String mobileNumber, String fax, String eMail, Integer newsletter) {

        this.customerNumber = customerNumber;
        this.salutation = salutation;
        this.title = title;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.street = street;
        this.streetNumber = streetNumber;
        this.postcode = postcode;
        this.town = town;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.fax = fax;
        this.eMail = eMail;
        this.newsletter = newsletter;
    }

    public Integer validateCustomerNumber() {
        return this.customerNumber;
    }

    public String validateSalutation() {
        return this.salutation;
    }

    public String validateTitel() {
        return this.title;
    }

    public String validateName() {
        return this.name;
    }

    public String validateLastName() {
        return this.lastName;
    }

    public String validateBirthdate() {
        return this.birthDate;
    }

    public String validateStreet() {
        return this.street;
    }

    public Integer validateStreetNumber() {
        return this.streetNumber;
    }

    public Integer validatePostcode() {
        return this.postcode;
    }

    public String validateTown() {
        return this.town;
    }

    public String validatePhoneNumber() {
        return this.phoneNumber;
    }

    public String validateMobileNumeber() {
        return this.mobileNumber;
    }

    public String validateFax() {
        return this.fax;
    }

    public String validateEmail() {
        return this.eMail;
    }

    public Integer validateNewsletter() {
        return this.newsletter;
    }
}