package com.sunil.jdbc;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import com.sunil.jdbc.constants.Education;
import com.sunil.jdbc.dto.CustomerDTO;
import com.sunil.jdbc.service.CustomerService;
import com.sunil.jdbc.service.CustomerServiceImpl;

public class CustomerTester {

	public static void main(String[] args) {

		CustomerDTO dto = new CustomerDTO("Sunil", "Dakshina Kannada", "Agumbe", "#42 JP nagar", "false", "sm4849ps32",
				Education.MSC);

		CustomerDTO dto1 = new CustomerDTO("Sai", "Chikmagalur", "Udupi", "#665 Mulki", "false", "mg5298jsb15",
				Education.MTECH);

		CustomerDTO dto2 = new CustomerDTO("Akhil", "Mysore", "Mangalore", "#35 Kunjibettu", "false", "gr6425ks35",
				Education.BSC);

		CustomerService cs = new CustomerServiceImpl();
		cs.validateAndSave(dto);
		cs.validateAndSave(dto1);
		cs.validateAndSave(dto2);

		Collection<CustomerDTO> cl = Arrays.asList(dto, dto1, dto2);
		cs.validateAndSaveAll(cl);

		Optional<CustomerDTO> findOne = cs.findOne(o -> o.getName().equalsIgnoreCase("sunil"));
		if (findOne.isPresent()) {
			CustomerDTO name = findOne.get();
			System.out.println(name);
		}

		Collection<CustomerDTO> findAll = cs.findAll();
		findAll.forEach(a -> System.out.println(a));

		Collection<CustomerDTO> findall = cs.findAll(s -> s.getFrom().endsWith("e"));
		findall.forEach(s -> System.out.println(s));

		Collection<CustomerDTO> nameDesc = cs.findAllSortByNameDesc();
		nameDesc.forEach(n -> System.out.println(n));

		int total = cs.total();
		System.out.println(total);

	}

}
