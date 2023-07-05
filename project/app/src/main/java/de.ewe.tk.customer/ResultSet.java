package com.journaldev.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;


public class ResultSetDemo {

	public static List<Customer> main(String[] args) {
		String query = "select customer_number, salution, title, name, last_name, birth_date, street, street_number, postcode, town, phone_number, mobile_number, fax, e_mail, newsletter";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pilot_customers", "Testuser", "Test123456*");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			List<Customer> CustomerList = new List<Customer>;
			while (rs.next()) {
				int customer_number = rs.getInt(1);
				String salutation = rs.getString(2);
				String title = rs.getString(3);
				String name = rs.getString(4);
				String last_name = rs.getString(5);
				String birth_date = rs.getString(6);
				String street = rs.getString(7);
				int street_number = rs.getInt(8);
				int postcode = rs.getInt(9);
				String town = rs.getString(10);
				String phone_number = rs.getString(11);
				String mobile_number = rs.getString(12);
				String fax = rs.getString(13);
				String e_mail = rs.getString(14);
				int newsletter = rs.getInt(15);

				CustomerList.add( customer_number ,  salutation ,  title ,  name ,  last_name ,  birth_date ,  street , street_number ,  postcode ,  town ,  phone_number ,  mobile_number ,  fax ,  e_mail , newsletter );
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		return CustomerList;
	}
}