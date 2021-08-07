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
			String updateDescriptionByName = "update scam set s_description='The army recruitment scam was basically about clearing temporarily rejected candidates of the army by fraudulently passing them in the medical review. Havildar Rajesh Kumar, who was one of the accused army personnel used to compile a full list .' where s_name='Recruitment Scam'";
			Statement st = cn.createStatement();
			st.execute(updateDescriptionByName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
