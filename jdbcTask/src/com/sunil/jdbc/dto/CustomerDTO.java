package com.sunil.jdbc.dto;

import java.io.Serializable;

import com.sunil.jdbc.constants.Education;

public class CustomerDTO implements Serializable {

	private String name;
	private String from;
	private String to;
	private String address;
	private String married;
	private String passportNo;
	private Education edu;
	private int id;

	public CustomerDTO() {
		// TODO Auto-generated constructor stub
	}

	public CustomerDTO(String name, String from, String to, String address, String married, String passportNo,
			Education edu) {
		super();
		this.name = name;
		this.from = from;
		this.to = to;
		this.address = address;
		this.married = married;
		this.passportNo = passportNo;
		this.edu = edu;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ",name=" + name + ", from=" + from + ", to=" + to + ", address=" + address
				+ ", married=" + married + ", passportNo=" + passportNo + ", edu=" + edu + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
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
		CustomerDTO other = (CustomerDTO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public Education getEdu() {
		return edu;
	}

	public void setEdu(Education edu) {
		this.edu = edu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
