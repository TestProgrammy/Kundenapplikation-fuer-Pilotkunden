package com.journaldev.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;


public class ResultSetDemo {

	public static void main(String[] args) {
		String query = "select customer_number, salution, title, name, last_name, birth_date, street, street_number, postcode, town, phone_number, mobile_number, fax, e_mail, newsletter";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pilot_customers", "Testuser", "Test123456*");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Integer empId = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				Date dob = rs.getDate(4);
				System.out.println("customer_number:" + customer_number);
				System.out.println("name:" + name);
				System.out.println("last_name:" + last_name);
				System.out.println("birth_day:" + birth_day);
				System.out.println("");
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
	}
}