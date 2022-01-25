package com.sparta.apiteam1.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagerStaff{

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("password")
	private String password;

	@JsonProperty("lastUpdate")
	private String lastUpdate;

	@JsonProperty("active")
	private Boolean active;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;

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

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setLastUpdate(String lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdate(){
		return lastUpdate;
	}

	public void setActive(Boolean active){
		this.active = active;
	}

	public Boolean isActive(){
		return active;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

}