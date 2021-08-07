package com.sunil.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ScamTester {

	public static void main(String[] args) {

		String username = "root";
		String password = "Sunilgksp@42";
		String url = "jdbc:mysql://localhost:3306/april_transformers";

		try (Connection connect = DriverManager.getConnection(url, username, password)) {

			String insertquery = "insert into scam values(20,'Oil and Food Scam','Food','Adithya Khanna',2005,6000,'Delhi','The wheels of bureaucracy grind slowly. It has been three weeks since the Union Government announced the setting up of the Justice R.S. Pathak Inquiry Authority to probe the allegations.A full bench of the commision decided against their decision')";

			Statement st = connect.createStatement();
			st.execute(insertquery);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
