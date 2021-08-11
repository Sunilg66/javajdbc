package com.sunil.jdbc;

import java.util.Collection;

import com.sunil.jdbc.constants.RestaurantType;
import com.sunil.jdbc.dao.RestaurantDAO;
import com.sunil.jdbc.dao.RestaurantDAOImpl;
import com.sunil.jdbc.dto.RestaurantDTO;

public class RestaurantImplTester {

	public static void main(String[] args) {
		
		RestaurantDAO dao = new RestaurantDAOImpl();
		RestaurantDTO dt = dao.findByName("SiriVennala");
		System.out.println(dt);
		
		Collection<RestaurantDTO> dto = dao.findByType(RestaurantType.BAR);
		dto.forEach(t-> System.out.println(t));
		
		boolean update = dao.updateTypeByName(RestaurantType.DHARSHINI, "SiriVennela");
		System.out.println(update);
		
		boolean delete = dao.deleteByTypeAndName(RestaurantType.BAR,"Jetlag");
		System.out.println(delete);

	}

}
