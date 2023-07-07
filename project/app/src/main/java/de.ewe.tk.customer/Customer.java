public class Customer {
      private final Integer customerNumber;
      private final String salution;
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

      // Konstruktor, legt ein Kundenobjekt an und befüllt sie
      public Customer(Integer customerNumber, String salution, String title, String name, String lastName,
                  String birthDate, String street, Integer streetNumber, Integer postcode, String town,
                  String phoneNumber, String mobileNumber, String fax, String eMail, Integer newsletter) {

            this.customerNumber = customerNumber;
            this.salution = salution;
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

      // Kundennummer abfragen
      public Integer getCustomernumber() {
            return this.customerNumber;
      }

      // Geschlächt abfragen
      public String getSalulation() {
            return this.salution;
      }

      // Titel abfragen
      public String getTitel() {
            return this.title;
      }

      // Vorname des Kunden abfragen
      public String getName() {
            return this.name;
      }

      // Nachname des Kunden abfragen
      public String getLastName() {
            return this.lastName;
      }

      // Geburtsdatum abfragen
      public String getBirthdate() {
            return this.birthDate;
      }

      // Straße abfragen
      public String getStreet() {
            return this.street;
      }

      // Straßennummer abfragen
      public Integer getStreetnumber() {
            return this.streetNumber;
      }

      // Postleitzahl abfragen
      public Integer getPostcode() {
            return this.postcode;
      }

      // Stadt abfragen
      public String getTown() {
            return this.town;
      }

      // Telefonnummer abfragen
      public String getPhonenumber() {
            return this.phoneNumber;
      }

      // Mobil Telefonnummer abfragen
      public String getMobilephonenumeber() {
            return this.mobileNumber;
      }

      // Fax abfragen
      public String getFax() {
            return this.fax;
      }

      // E-Mail abfragen
      public String getEmail() {
            return this.eMail;
      }

      // Newsletter abfragen
      public Integer getNewsletter() {
            return this.newsletter;
      }
}