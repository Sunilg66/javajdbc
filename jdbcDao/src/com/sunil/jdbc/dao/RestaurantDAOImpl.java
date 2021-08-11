package com.sunil.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import static com.sunil.jdbc.constants.JdbcConnection.*;

import com.sunil.jdbc.constants.RestaurantType;
import com.sunil.jdbc.dto.RestaurantDTO;

public class RestaurantDAOImpl implements RestaurantDAO {

	@Override
	public int save(RestaurantDTO dto) {

		System.out.println("saving dto into DB " + dto);
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into restaurant (r_name,r_location,r_specialFood,r_best,r_type) values('"
					+ dto.getName() + "','" + dto.getLocation() + "'," + "'" + dto.getSpecialFood() + "',"
					+ dto.isBest() + ",'" + dto.getType() + "')";
			Statement statement = connection.createStatement();
			statement.execute(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys();
			int id = 0;
			if (rs.next()) {
				id = rs.getInt(1);
				System.out.println(id);
			}
			connection.commit();
			return id;
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

	@Override
	public RestaurantDTO findByName(String name) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			String query = "select * from restaurant where r_name='" + name + "'";
			Statement st = conn.createStatement();
			st.execute(query);
			ResultSet set = st.getResultSet();
			if (set.next()) {
				int id = set.getInt("r_id");
				String rname = set.getString("r_name");
				String rlocation = set.getString("r_location");
				String rspcl = set.getString("r_specialFood");
				boolean rbest = set.getBoolean("r_best");
				String rtype = set.getString("r_type");

				RestaurantDTO res = new RestaurantDTO(rname, rlocation, rspcl, rbest, RestaurantType.valueOf(rtype));
				res.setId(id);
				return res;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<RestaurantDTO> findByType(RestaurantType type) {
		Collection collect = new ArrayList();
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String str = "select * from restaurant where r_type='" + type + "'";
			Statement sta = con.createStatement();
			sta.execute(str);
			ResultSet st = sta.getResultSet();
			if (st.next()) {
				int resid = st.getInt("r_id");
				String resname = st.getString("r_name");
				String reslocation = st.getString("r_location");
				String resspcl = st.getString("r_specialFood");
				boolean resbest = st.getBoolean("r_best");
				String restype = st.getString("r_type");

				RestaurantDTO dto = new RestaurantDTO(resname, reslocation, resspcl, resbest,
						RestaurantType.valueOf(restype));
				dto.setId(resid);
				collect.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collect;
	}

}
