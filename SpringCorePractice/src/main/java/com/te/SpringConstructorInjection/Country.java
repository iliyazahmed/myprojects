package com.te.SpringConstructorInjection;

public class Country {
 
	private String countryName;
	private String coachName;
	
	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", coachName=" + coachName + "]";
	}

	public Country(String countryName, String coachName) {
		super();
		this.countryName = countryName;
		this.coachName = coachName;
	}
	
	
}
