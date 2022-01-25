package com.sparta.apiteam1.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActorPOJO{

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("lastUpdate")
	private String lastUpdate;

	@JsonProperty("id")
	private int id;

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setLastUpdate(String lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdate(){
		return lastUpdate;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}