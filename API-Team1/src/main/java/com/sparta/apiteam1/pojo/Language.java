package com.sparta.apiteam1.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Language{

	@JsonProperty("id")
	private int id;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}