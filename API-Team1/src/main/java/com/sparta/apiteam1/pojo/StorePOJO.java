package com.sparta.apiteam1.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StorePOJO{

	@JsonProperty("address")
	private Address address;

	@JsonProperty("managerStaff")
	private ManagerStaff managerStaff;

	@JsonProperty("lastUpdate")
	private String lastUpdate;

	@JsonProperty("id")
	private Integer id;

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	public void setManagerStaff(ManagerStaff managerStaff){
		this.managerStaff = managerStaff;
	}

	public ManagerStaff getManagerStaff(){
		return managerStaff;
	}

	public void setLastUpdate(String lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdate(){
		return lastUpdate;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

}