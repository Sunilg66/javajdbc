package com.sunil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTester {

	public static void main(String[] args) {

		String username = "root";
		String password = "Sunilgksp@42";
		String url = "jdbc:mysql://localhost:3306/april_transformers";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(fqnOfDriverImpl);
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println(connection);

			String query = "insert into insurance_info values(5,'Aishwarya','jewwllary',1,'Max Health',48460)";
			Statement st = connection.createStatement();
			st.execute(query);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
