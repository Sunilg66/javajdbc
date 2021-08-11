package com.sunil.jdbc.dto;

import java.io.Serializable;

import com.sunil.jdbc.constants.RestaurantType;

public class RestaurantDTO implements Serializable {

	
	private String name;
	private String location;
	private String specialFood;
	private boolean best;
	private RestaurantType type;
	private int id;

	public RestaurantDTO() {
		// TODO Auto-generated constructor stub
	}
    
	public RestaurantDTO( String name, String location, String specialFood, boolean best,
			RestaurantType type,int id) {
		this.id=id;
		
	}


	public RestaurantDTO( String name, String location, String specialFood, boolean best,
			RestaurantType type) {
		super();
		
		this.name = name;
		this.location = location;
		this.specialFood = specialFood;
		this.best = best;
		this.type = type;
	}

	@Override
	public String toString() {
		return "RestaurantDTO [ name=" + name + ", location=" + location + ", specialFood=" + specialFood
				+ ", best=" + best + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
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
		RestaurantDTO other = (RestaurantDTO) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public int setId(int id) {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSpecialFood() {
		return specialFood;
	}

	public void setSpecialFood(String specialFood) {
		this.specialFood = specialFood;
	}

	public boolean isBest() {
		return best;
	}

	public void setBest(boolean best) {
		this.best = best;
	}

	public RestaurantType getType() {
		return type;
	}

	public void setType(RestaurantType type) {
		this.type = type;
	}

}
