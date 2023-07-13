public class Customer {
      private final Integer customerNumber;
      private final String salutation;
      private final String title;
      private final String name;
      private final String lastName;
      private final String birthDate;
      private final String street;
      private final Integer streetNumber;
      private final String postcode;
      private final String town;
      private final String phoneNumber;
      private final String mobileNumber;
      private final String fax;
      private final String eMail;
      private final Integer newsletter;

      public Customer(Integer customerNumber, String salutation, String title, String name, String lastName,
                  String birthDate, String street, Integer streetNumber, String postcode, String town,
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

      public Integer getCustomerNumber() {
            return this.customerNumber;
      }

      public String getSalutation() {
            return this.salutation;
      }

      public String getTitle() {
            return this.title;
      }

      public String getName() {
            return this.name;
      }

      public String getLastName() {
            return this.lastName;
      }

      public String getBirthdate() {
            return this.birthDate;
      }

      public String getStreet() {
            return this.street;
      }

      public Integer getStreetNumber() {
            return this.streetNumber;
      }

      public String getPostcode() {
            return this.postcode;
      }

      public String getTown() {
            return this.town;
      }

      public String getPhoneNumber() {
            return this.phoneNumber;
      }

      public String getMobileNumber() {
            return this.mobileNumber;
      }

      public String getFax() {
            return this.fax;
      }

      public String getEmail() {
            return this.eMail;
      }

      public Integer getNewsletter() {
            return this.newsletter;
      }
}