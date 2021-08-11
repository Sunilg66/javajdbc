package com.sunil.jdbc;

import com.sunil.jdbc.constants.RestaurantType;
import com.sunil.jdbc.dao.RestaurantDAO;
import com.sunil.jdbc.dao.RestaurantDAOImpl;
import com.sunil.jdbc.dto.RestaurantDTO;

public class RestaurantTester {

	public static void main(String[] args) {
		
		RestaurantDTO dto = new RestaurantDTO("SiriVennala","DakshinKannada","vegBiriyani",true,RestaurantType.FAMILY);
		
		RestaurantDAO dao = new RestaurantDAOImpl();
		dao.save(dto);
		

	}

}
