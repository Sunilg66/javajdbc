package com.sunil.jdbc.service;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.sunil.jdbc.dto.CustomerDTO;

public interface CustomerService {

	int validateAndSave(CustomerDTO dto);

	void validateAndSaveAll(Collection<CustomerDTO> collection);

	Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate);

	Collection<CustomerDTO> findAll();

	Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate);

	Collection<CustomerDTO> findAllSortByNameDesc();

	int total();

}
