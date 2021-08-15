package com.sunil.jdbc.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.sunil.jdbc.dto.CustomerDTO;

public interface CustomerDAO {

	int save(CustomerDTO dto);

	void saveAll(Collection<CustomerDTO> collection);

	Collection<CustomerDTO> findAll();

	int total();

	Collection<CustomerDTO> findAllSortByNameDesc();

	Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate);

	Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate);

}
