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
			String updateDescriptionByName = "update scam set s_description='In the early years, IPL enforced strict guidelines to the media for covering matches. It had to be consistent with a model mimicking North America in terms of media coverage. For example, there was a restriction to use images taken during the event unless purchased and the prohibition of live coverage from the cricket grounds..' where s_name='IPL Scam'";
			Statement st = cn.createStatement();
			st.execute(updateDescriptionByName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
