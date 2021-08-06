package com.sunil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateScamYearByName {

	public static void main(String[] args) {

		String username = "root";
		String password = "Sunilgksp@42";
		String url = "jdbc:mysql://localhost:3306/april_transformers";

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String updateYearByName = "update scam set s_year=2011 where s_name='2G Specturm Scam'";
			Statement st = conn.createStatement();
			st.execute(updateYearByName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
