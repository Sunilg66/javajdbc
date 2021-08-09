package com.sunil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sunil.jdbc.constants.JdbcConstants;

public class TotalScamTester {

	public static void main(String[] args) {
		

		try (Connection connect = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,JdbcConstants.PASSWORD)){
			String query = "select count(s_name) from scam";
			Statement st = connect.createStatement();
			st.execute(query);
			ResultSet set = st.getResultSet();

			while (set.next()) {
				int count = set.getInt(1);
				
				System.out.println("Number of Scams : " + count);
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		
		}

	}

}
