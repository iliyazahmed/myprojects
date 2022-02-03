package com.te.JPAwithCRUD;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CricketPlayers {

	@Id
	private int jerseyNumber;
	private String playerName;
	private String countryName;
	private double salary;
	
	public CricketPlayers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CricketPlayers(int jerseyNumber, String playerName, String countryName, double salary) {
		super();
		this.jerseyNumber = jerseyNumber;
		this.playerName = playerName;
		this.countryName = countryName;
		this.salary = salary;
	}
	public int getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "CricketPlayers [jerseyNumber=" + jerseyNumber + ", playerName=" + playerName + ", countryName="
				+ countryName + ", salary=" + salary + "]";
	}
	
	
	
}
