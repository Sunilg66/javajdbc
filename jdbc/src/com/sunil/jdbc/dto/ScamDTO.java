package com.sunil.jdbc.dto;

import java.io.Serializable;

public class ScamDTO implements Serializable{
	
	private int id;
	private String name;
	private String type;
	private String by;
	private int amount;
	private String location;
	private int year;
	private String description;
	
	public ScamDTO() {
		// TODO Auto-generated constructor stub
	}

	public ScamDTO(int id, String name, String type, String by, int amount, String location, int year,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.by = by;
		this.amount = amount;
		this.location = location;
		this.year = year;
		this.description = description;
	}

	@Override
	public String toString() {
		return "ScamDTO [id=" + id + ", name=" + name + ", type=" + type + ", by=" + by + ", amount=" + amount
				+ ", location=" + location + ", year=" + year + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		ScamDTO other = (ScamDTO) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
