package com.sunil.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.sunil.jdbc.constants.JdbcConnection.*;
import com.sunil.jdbc.dto.RestaurantDTO;

public class RestaurantDAOImpl implements RestaurantDAO{

	@Override
	public int save(RestaurantDTO dto) {

		System.out.println("saving dto into DB " + dto);
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into restaurant values(1,'" + dto.getName() + "','" + dto.getLocation() + "'," + "'"
					+ dto.getSpecialFood() + "'," + dto.isBest() + ",'" + dto.getType() + "')";
			Statement statement = connection.createStatement();
			statement.execute(query);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return 0;
	}

}
