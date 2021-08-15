package com.sunil.preparedStmt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import static com.sunil.preparedStmt.constants.JdbcConnection.*;

import com.sunil.preparedStmt.constants.Genre;
import com.sunil.preparedStmt.constants.StreamedIn;
import com.sunil.preparedStmt.dto.WebSeriesDTO;

public class WebSeriesDAOImpl implements WebSeriesDAO {

	@Override
	public int save(WebSeriesDTO dto) {
		int aiId = 0;
		System.out.println("Saved DTO into DAO: " + dto);
		Connection tempConnection = null;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			tempConnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into webseries(w_name,w_noOfEpisodes,w_totalSeason,w_streamedIn, w_genre,w_yestAgeIndaNodbahudu)VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, dto.getName());
			statement.setInt(2, dto.getNoOfEpisodes());
			statement.setInt(3, dto.getTotalSeason());
			statement.setString(4, dto.getType().toString());
			statement.setString(5, dto.getGenre().toString());
			statement.setInt(6, dto.getYestAgeIndaNodbahudu());
			statement.execute();
			ResultSet resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				aiId = resultSet.getInt(1);
			}
			dto.setId(aiId);
			statement.execute();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		return aiId;
	}

	@Override
	public Collection<WebSeriesDTO> findAll() {
		Collection cl = new ArrayList();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from webseries";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				WebSeriesDTO ws = createValuesFromResultSet(resultSet);
				cl.add(ws);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cl;
	}

	@Override
	public int total() {
		int count = 0;
		try (Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select count(w_id) from WebSeries";
			ResultSet set = createdFromPreparedStatement(connect, query);
			if (set.next()) {
				count = set.getInt(1);
			}
			System.out.println("Total : " + count);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	private ResultSet createdFromPreparedStatement(Connection connect, String query) throws SQLException {
		PreparedStatement ps = connect.prepareStatement(query);
		ps.execute();
		ResultSet set = ps.getResultSet();
		return set;
	}

	@Override
	public int findMaxSeason() {
		int maxSeason = 0;
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select max(w_totalSeason) from webseries";
			ResultSet rs = createdFromPreparedStatement(con, query);
			while (rs.next()) {
				maxSeason = rs.getInt(1);

			}
			System.out.println("max season : " + maxSeason);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxSeason;
	}

	@Override
	public int findMinSeason() {
		int minSeason = 0;
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select min(w_totalSeason) from webseries";
			ResultSet rs = createdFromPreparedStatement(con, query);
			while (rs.next()) {
				minSeason = rs.getInt(1);

			}
			System.out.println("min season : " + minSeason);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return minSeason;
	}

	@Override
	public Collection<WebSeriesDTO> findAllSortByNameDesc() {
		Collection<WebSeriesDTO> cl = new ArrayList<WebSeriesDTO>();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from webseries order by w_name desc";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				WebSeriesDTO ws = createValuesFromResultSet(resultSet);
				cl.add(ws);
				System.out.println("desceinding order : " + ws);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cl;
	}

	private WebSeriesDTO createValuesFromResultSet(ResultSet resultSet) throws SQLException {
		int wid = resultSet.getInt("w_id");
		String wname = resultSet.getString("w_name");
		int wepisodes = resultSet.getInt("w_noOfEpisodes");
		int wseason = resultSet.getInt("w_totalSeason");
		String wstreamed = resultSet.getString("w_streamedIn");
		String wgenre = resultSet.getString("w_genre");
		int wage = resultSet.getInt("w_yestAgeIndaNodbahudu");

		WebSeriesDTO ws = new WebSeriesDTO(wname, wepisodes, wseason, StreamedIn.valueOf(wstreamed),
				Genre.valueOf(wgenre), wage);
		ws.setId(wid);
		return ws;
	}

	@Override
	public Optional<WebSeriesDTO> findOne(Predicate<WebSeriesDTO> predicate) {
		Optional<WebSeriesDTO> optional = Optional.empty();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from webseries";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				WebSeriesDTO dto = createValuesFromResultSet(result);
				if (predicate.test(dto)) {
					optional = Optional.of(dto);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return optional;

	}

	@Override
	public Collection<WebSeriesDTO> findAll(Predicate<WebSeriesDTO> predicate) {
		Collection<WebSeriesDTO> list = new ArrayList<WebSeriesDTO>();

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from webseries";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				WebSeriesDTO dto = createValuesFromResultSet(result);
				if (predicate.test(dto)) {
					list.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return list;
	}

	@Override
	public void saveAll(Collection<WebSeriesDTO> collection) {

		Connection tempconnection = null;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			tempconnection = connection;
			connection.setAutoCommit(false);
			String query = "insert into webseries(w_name,w_noOfEpisodes,w_totalSeason,w_streamedIn, w_genre,w_yestAgeIndaNodbahudu)VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			collection.forEach(dto -> {
				try {
					ps.setString(1, dto.getName());
					ps.setInt(2, dto.getNoOfEpisodes());
					ps.setInt(3, dto.getTotalSeason());
					ps.setString(4, dto.getType().toString());
					ps.setString(5, dto.getGenre().toString());
					ps.setInt(6, dto.getYestAgeIndaNodbahudu());
					ps.execute();
					System.out.println(dto);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			});
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				tempconnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

}
