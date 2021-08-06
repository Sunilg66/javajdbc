package com.sunil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateScamByMultipleFields {

	public static void main(String[] args) {

		String username = "root";
		String password = "Sunilgksp@42";
		String url = "jdbc:mysql://localhost:3306/april_transformers";

		try (Connection cn = DriverManager.getConnection(url, username, password)) {
			String updateScamByMultipleFields = "update scam set s_year=2020,s_amount=1900,s_location='Chennai',s_type='GST' where s_name='INX Media' and s_id=17";
			Statement st = cn.createStatement();
			st.execute(updateScamByMultipleFields);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
