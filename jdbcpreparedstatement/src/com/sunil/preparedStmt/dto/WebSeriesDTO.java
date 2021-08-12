package com.sunil.preparedStmt.dto;

import java.io.Serializable;

import com.sunil.preparedStmt.constants.Genre;
import com.sunil.preparedStmt.constants.StreamedIn;

public class WebSeriesDTO implements Serializable{
	
	private String name;
	private int noOfEpisodes;
	private int totalSeason;
	private StreamedIn type;
	private Genre genre;
	private int yestAgeIndaNodbahudu;
	private int id;
	
	public WebSeriesDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public WebSeriesDTO(String name, int noOfEpisodes, int totalSeason, StreamedIn type, Genre genre,
			int yestAgeIndaNodbahudu,int id) {
		this.id=id;
	}

	public WebSeriesDTO(String name, int noOfEpisodes, int totalSeason, StreamedIn type, Genre genre,
			int yestAgeIndaNodbahudu) {
		super();
		this.name = name;
		this.noOfEpisodes = noOfEpisodes;
		this.totalSeason = totalSeason;
		this.type = type;
		this.genre = genre;
		this.yestAgeIndaNodbahudu = yestAgeIndaNodbahudu;
	}

	@Override
	public String toString() {
		return "WebseriesDTO [name=" + name + ", noOfEpisodes=" + noOfEpisodes + ", totalSeason=" + totalSeason
				+ ", type=" + type + ", genre=" + genre + ", yestAgeIndaNodbahudu=" + yestAgeIndaNodbahudu + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebSeriesDTO other = (WebSeriesDTO) obj;
		if (genre != other.genre)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfEpisodes() {
		return noOfEpisodes;
	}

	public void setNoOfEpisodes(int noOfEpisodes) {
		this.noOfEpisodes = noOfEpisodes;
	}

	public int getTotalSeason() {
		return totalSeason;
	}

	public void setTotalSeason(int totalSeason) {
		this.totalSeason = totalSeason;
	}

	public StreamedIn getType() {
		return type;
	}

	public void setType(StreamedIn type) {
		this.type = type;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getYestAgeIndaNodbahudu() {
		return yestAgeIndaNodbahudu;
	}

	public void setYestAgeIndaNodbahudu(int yestAgeIndaNodbahudu) {
		this.yestAgeIndaNodbahudu = yestAgeIndaNodbahudu;
	}

	public int setId(int id) {
		return id;
	}

}
