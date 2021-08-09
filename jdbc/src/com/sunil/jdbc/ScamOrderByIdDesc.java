package com.sunil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.sunil.jdbc.constants.JdbcConstants;
import com.sunil.jdbc.dto.ScamDTO;

public class ScamOrderByIdDesc {

	public static void main(String[] args) {
		
		try (Connection connect = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME,
				JdbcConstants.PASSWORD)) {

			String query = "select * from scam order by s_id desc";

			Statement st = connect.createStatement();
			st.execute(query);
			ResultSet set = st.getResultSet();
			ScamDTO dto = null;
			Set<ScamDTO> dt = new HashSet<ScamDTO>();
			while (set.next()) {
				ScamDTO ob = new ScamDTO();
				ob.setYear(set.getInt("s_year"));
				int id = set.getInt("s_id");
				String name = set.getString("s_name");
				String type = set.getString("s_type");
				int amount = set.getInt("s_amountincrores");
				String by = set.getString("s_by");
				String location = set.getString("s_location");
				String descr = set.getString("s_description");
				int year = set.getInt("s_year");

				System.out.println(name);

				dto = new ScamDTO(id, name, type, by, amount, location, year, descr);
				System.out.println(dto);
				System.out.println(dto.hashCode());
				dt.add(ob);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
