package com.sunil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDescriptionByName {

	public static void main(String[] args) {

		String username = "root";
		String password = "Sunilgksp@42";
		String url = "jdbc:mysql://localhost:3306/april_transformers";

		try (Connection cn = DriverManager.getConnection(url, username, password)) {
			String updateDescriptionByName = "update scam set s_description='The agency carried out raids on premises of Agrasain Gehlot in Jodhpur. It is alleged that Agrasain Gehlot between 2007 to 2009.' where s_name='IPL Scam'";
			Statement st = cn.createStatement();
			st.execute(updateDescriptionByName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
