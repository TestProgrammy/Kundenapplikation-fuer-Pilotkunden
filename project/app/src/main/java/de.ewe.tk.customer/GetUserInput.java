//package com.journaldev.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GetUserInput {

	public static ArrayList<Customer> main(String[] args, String query) {
		// String query = "select customer_number, salution, title, name, last_name,
		// birth_date, street, street_number, postcode, town, phone_number,
		// mobile_number, fax, e_mail, newsletter";
		Connection conn = null;
		Statement stmt = null;
		ArrayList<Customer> CustomerList = new ArrayList<Customer>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pilot_customers", "Testuser",
					"Test123456*");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getInt(15));

				CustomerList.add(customer);

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return CustomerList;
	}
}