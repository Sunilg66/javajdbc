package com.sunil.jdbc.dao;

import static com.sunil.jdbc.constants.JdbcConnection.PASSWORD;
import static com.sunil.jdbc.constants.JdbcConnection.URL;
import static com.sunil.jdbc.constants.JdbcConnection.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import com.sunil.jdbc.constants.RestaurantType;
import com.sunil.jdbc.dto.RestaurantDTO;

public interface RestaurantDAO {

	int save(RestaurantDTO dto);

	RestaurantDTO findByName(String name);

	Collection<RestaurantDTO> findByType(RestaurantType type);

	default boolean updateTypeByName(RestaurantType newtype, String name) {
		
		Connection connect = null;
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			connect=conn;
			conn.setAutoCommit(false);
			String updatequery = "update restaurant set r_type='"+newtype+"'"+ "where r_name='" + name + "'";
			Statement st = conn.createStatement();
			st.execute(updatequery);
			conn.commit();
			return true;
		}
		 catch (SQLException e) {
			e.printStackTrace();
			try {
				connect.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
					
		}
	
		return false;
	}
	
	default boolean deleteByTypeAndName(RestaurantType type,String name) {
		try(Connection connect = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
			connect.setAutoCommit(false);
			String query = "delete from restaurant where r_type='"+type+"' and r_name='"+name+"'";
			Statement ste = connect.createStatement();
			ste.execute(query);
			connect.commit();
			return true;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
