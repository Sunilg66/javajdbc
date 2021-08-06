package com.sunil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteScamById {

	public static void main(String[] args) {

		String username = "root";
		String password = "Sunilgksp@42";
		String url = "jdbc:mysql://localhost:3306/april_transformers";

		try (Connection connect = DriverManager.getConnection(url, username, password)) {

			String deleteScamById = "delete from scam where s_id=13";
			Statement st = connect.createStatement();
			st.execute(deleteScamById);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
