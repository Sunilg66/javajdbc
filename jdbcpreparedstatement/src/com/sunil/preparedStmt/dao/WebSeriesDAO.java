package com.sunil.preparedStmt.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.sunil.preparedStmt.dto.WebSeriesDTO;

public interface WebSeriesDAO {

	int save(WebSeriesDTO dto);

	Collection<WebSeriesDTO> findAll();

	int total();

	int findMaxSeason();

	int findMinSeason();

	Collection<WebSeriesDTO> findAllSortByNameDesc();

	Optional<WebSeriesDTO> findOne(Predicate<WebSeriesDTO> predicate);
	
	Collection<WebSeriesDTO> findAll(Predicate<WebSeriesDTO> predicate);
	
	Collection<WebSeriesDTO> saveAll(Collection<WebSeriesDTO> collection);

}
