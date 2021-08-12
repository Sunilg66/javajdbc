package com.sunil.preparedStmt;

import java.util.ArrayList;
import java.util.Collection;

import com.sunil.preparedStmt.constants.Genre;
import com.sunil.preparedStmt.constants.StreamedIn;
import com.sunil.preparedStmt.dao.WebSeriesDAO;
import com.sunil.preparedStmt.dao.WebSeriesDAOImpl;
import com.sunil.preparedStmt.dto.WebSeriesDTO;

public class WebSeriesTester {
	

	public static void main(String[] args) {
		
		WebSeriesDTO dto=new WebSeriesDTO("Seetha Vallaba",722,2,StreamedIn.ZEEKANNADA,Genre.FAMILY,18);
		
		WebSeriesDAO dao = new WebSeriesDAOImpl();
		dao.save(dto);
		
		Collection<WebSeriesDTO> dt = dao.findAll();
		dt.forEach(s->System.out.println(s));
		
		int count = dao.total();
		System.out.println(count);
		
		int max=dao.findMaxSeason();
		System.out.println(max);
		
		int min=dao.findMinSeason();
		System.out.println(min);
		
		Collection<WebSeriesDTO> set = dao.findAllSortByNameDesc();
		set.forEach(m->System.out.println(m));

	}

}
