public class Customer {
  private final String name;
  private final String last_name;
  private final String birth_date;
  private final String street;
  private final String street_number;
  private final String postcode;
  private final String town;
  private final String phone_number;
  private final String mobile_number;
  private final String fax;
  private final String e_mail;
  private final String newsletter;

  
  // Konstruktor, legt ein Kundenobjekt an und befüllt sie
  public Customer(String name, String last_name) {
        this.name = name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.street = street;
        this.street_number = street_number;
        this.postcode = postcode;
        this.town = town;
        this.phone_number = phone_number;
        this.mobile_number = mobile_number;
        this.fax = fax;
        this.e_mail = e_mail;
        this.newsletter = newsletter;

  }
  
  // Vorname des Kunden abfragen
  public String getName() {
        return this.name;
  }

  // Nachname des Kunden abfragen
  public String getLastName() {
        return this.last_name;
  }

  // Geburtsdatum abfragen
  public String getBirthdate() {
        return this.birth_date;
  }
  // Straße abfragen
  public String getStreet(){
        return this.street;
  }
  //Straßennummer abfragen
  public String getStreetnumber() {
        return this.street_number;
  }
  //Postleitzahl abfragen
  public String getPostcode() {
        return this.postcode;
  }
  //Stadt abfragen
  public String getTown() {
        return this.town;
  }
  //Telefonnummer abfragen
  public String getPhonenumber() {
        return this.phone_number;
  }
  //Mobil Telefonnummer abfragen
  public String getMobilephonenumeber() {
        return this.mobile_number;
  }
  //Fax abfragen
  public String getFax() {
        return this.fax;
  }
  //E-Mail abfragen
  public String getEmail() {
        return this.e_mail;
  }
  //Newsletter abfragen
  public String getNewsletter() {
        return this.newsletter;
  }
}