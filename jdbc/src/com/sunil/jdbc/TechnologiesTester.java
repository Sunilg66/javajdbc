package com.sunil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TechnologiesTester {

	public static void main(String[] args) {
		
		String username = "root";
		String password = "Sunilgksp@42";
		String url = "jdbc:mysql://localhost:3306/april_transformers";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";
		
		Connection connect=null;
		
		try {
			Class.forName(fqnOfDriverImpl);
			 connect= DriverManager.getConnection(url, username, password);
			System.out.println(connect);
			
			String query = "insert into technologies values(4,'PhP','CGI',8.1,1994)";
			Statement st = connect.createStatement();
			st.execute(query);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connect.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
