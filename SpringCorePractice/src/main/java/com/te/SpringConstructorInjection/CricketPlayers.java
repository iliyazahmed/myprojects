package com.te.SpringConstructorInjection;


public class CricketPlayers {
    

	private int jerseyNumber;
	private String playerName;
	private double remuneration;
	
	private Country country;

	public CricketPlayers(int jerseyNumber, String playerName, double remuneration, Country country) {
		super();
		this.jerseyNumber = jerseyNumber;
		this.playerName = playerName;
		this.remuneration = remuneration;
		this.country = country;
	}

	@Override
	public String toString() {
		return "CricketPlayers [jerseyNumber=" + jerseyNumber + ", playerName=" + playerName + ", remuneration="
				+ remuneration + ", country=" + country + "]";
	}
	
	
	
	
	
	
}
