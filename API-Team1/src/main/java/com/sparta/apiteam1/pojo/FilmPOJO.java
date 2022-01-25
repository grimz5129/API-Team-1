package com.sparta.apiteam1.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmPOJO{

	@JsonProperty("rentalRate")
	private double rentalRate;

	@JsonProperty("rentalDuration")
	private int rentalDuration;

	@JsonProperty("length")
	private int length;

	@JsonProperty("rating")
	private String rating;

	@JsonProperty("description")
	private String description;

	@JsonProperty("replacementCost")
	private double replacementCost;

	@JsonProperty("language")
	private Language language;

	@JsonProperty("title")
	private String title;

	@JsonProperty("originalLanguage")
	private Object originalLanguage;

	@JsonProperty("specialFeatures")
	private String specialFeatures;

	@JsonProperty("lastUpdate")
	private String lastUpdate;

	@JsonProperty("id")
	private int id;

	@JsonProperty("releaseYear")
	private int releaseYear;

	public void setRentalRate(double rentalRate){
		this.rentalRate = rentalRate;
	}

	public double getRentalRate(){
		return rentalRate;
	}

	public void setRentalDuration(int rentalDuration){
		this.rentalDuration = rentalDuration;
	}

	public int getRentalDuration(){
		return rentalDuration;
	}

	public void setLength(int length){
		this.length = length;
	}

	public int getLength(){
		return length;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setReplacementCost(double replacementCost){
		this.replacementCost = replacementCost;
	}

	public double getReplacementCost(){
		return replacementCost;
	}

	public void setLanguage(Language language){
		this.language = language;
	}

	public Language getLanguage(){
		return language;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setOriginalLanguage(Object originalLanguage){
		this.originalLanguage = originalLanguage;
	}

	public Object getOriginalLanguage(){
		return originalLanguage;
	}

	public void setSpecialFeatures(String specialFeatures){
		this.specialFeatures = specialFeatures;
	}

	public String getSpecialFeatures(){
		return specialFeatures;
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

	public void setReleaseYear(int releaseYear){
		this.releaseYear = releaseYear;
	}

	public int getReleaseYear(){
		return releaseYear;
	}
}