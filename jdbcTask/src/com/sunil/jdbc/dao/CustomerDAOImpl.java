package com.sunil.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import static com.sunil.jdbc.connection.JdbcConnection.*;

import com.sunil.jdbc.constants.Education;
import com.sunil.jdbc.dto.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public int save(CustomerDTO dto) {
		System.out.println(dto);
		Connection temp = null;
		int tempResult = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			temp = connection;
			connection.setAutoCommit(false);
			String query = "insert into customer(c_name,c_from,c_to,c_address,c_married,c_passportNo,c_education)values(?,?,?,?,?,?,?)";
			PreparedStatement prepare = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			createFromPrepareStatement(dto, prepare);
			ResultSet result = prepare.getGeneratedKeys();

			if (result.next()) {
				tempResult = result.getInt(1);
				System.out.println(tempResult);
			}
			dto.setId(tempResult);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				temp.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return tempResult;
	}

	private void createFromPrepareStatement(CustomerDTO dto, PreparedStatement prepare) throws SQLException {
		prepare.setString(1, dto.getName());
		prepare.setString(2, dto.getFrom());
		prepare.setString(3, dto.getTo());
		prepare.setString(4, dto.getAddress());
		prepare.setString(5, dto.getMarried());
		prepare.setString(6, dto.getPassportNo());
		prepare.setString(7, dto.getEdu().toString());
		prepare.execute();
	}

	@Override
	public void saveAll(Collection<CustomerDTO> collection) {
        collection.stream().forEach(dto-> save(dto));
	}

	@Override
	public Collection<CustomerDTO> findAll() {
		Collection<CustomerDTO> coll = new ArrayList<CustomerDTO>();

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from customer";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet rs = prepare.executeQuery();

			while (rs.next()) {
				CustomerDTO dto = createValuesFromResultSet(rs);
				coll.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return coll;

	}

	private CustomerDTO createValuesFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("c_id");
		String name = rs.getString("c_name");
		String from = rs.getString("c_from");
		String to = rs.getString("c_to");
		String address = rs.getString("c_address");
		String married = rs.getString("c_married");
		String passportNo = rs.getString("c_passportNo");
		String education = rs.getString("c_education");

		CustomerDTO dto = new CustomerDTO(name, from, to, address, married, passportNo, Education.valueOf(education));
		dto.setId(id);
		return dto;
	}

	@Override
	public int total() {
		int total = 0;
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "SELECT count(c_id) FROM customer";
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.execute();
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				total = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return total;
	}

	@Override
	public Collection<CustomerDTO> findAllSortByNameDesc() {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			String query = "select * from customer order by c_name desc";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet rs = prepare.executeQuery();
			while (rs.next()) {
				CustomerDTO dto = createValuesFromResultSet(rs);
				collection.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return collection;
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {
		Collection<CustomerDTO> collection = new ArrayList<CustomerDTO>();

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from customer";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet set = prepare.executeQuery();

			while (set.next()) {
				CustomerDTO dto = createValuesFromResultSet(set);
				if(predicate.test(dto)) {
					collection.add(dto);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return collection;
	}

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		Optional<CustomerDTO> op = Optional.empty();
		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String query = "select * from customer";
			PreparedStatement prepare = connection.prepareStatement(query);
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				CustomerDTO dto = createValuesFromResultSet(result);
				if (predicate.test(dto)) {
					op = Optional.of(dto);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return op;
	}

}
