package com.sunil.preparedStmt;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import com.sunil.preparedStmt.constants.Genre;
import com.sunil.preparedStmt.constants.StreamedIn;
import com.sunil.preparedStmt.dao.WebSeriesDAO;
import com.sunil.preparedStmt.dao.WebSeriesDAOImpl;
import com.sunil.preparedStmt.dto.WebSeriesDTO;

public class WebSeriesTester {

	public static void main(String[] args) {

		WebSeriesDTO dto = new WebSeriesDTO("Seetha Vallaba", 722, 2, StreamedIn.ZEEKANNADA, Genre.FAMILY, 18);
		WebSeriesDAO dao = new WebSeriesDAOImpl();
		dao.save(dto);
		
		Collection<WebSeriesDTO> dt = dao.findAll();
		dt.forEach(s -> System.out.println(s));
		
		int count = dao.total();
		System.out.println(count);
		
		int max = dao.findMaxSeason();
		System.out.println(max);
		
		int min = dao.findMinSeason();
		System.out.println(min);

		Collection<WebSeriesDTO> set = dao.findAllSortByNameDesc();
		set.forEach(m -> System.out.println(m));

		Optional<WebSeriesDTO> one = dao.findOne(g -> g.getName().equals("Seetha Vallaba"));
		if (one.isPresent()) {
			WebSeriesDTO optional = one.get();
			System.out.println(optional);
		}
		Collection<WebSeriesDTO> pre = dao.findAll(m -> m.getNoOfEpisodes() > 250);
		pre.forEach(m -> System.out.println(m));

		
		Collection<WebSeriesDTO> cl = Arrays.asList(dto);
		dao.saveAll(cl);
	}

}
