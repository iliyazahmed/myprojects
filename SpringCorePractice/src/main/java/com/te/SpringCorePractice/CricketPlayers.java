package com.te.SpringCorePractice;

public class CricketPlayers {
	
	private String playerName;
	private int jerseryNumber;
	private double remuneration;
	
	public CricketPlayers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CricketPlayers(String playerName, int jerseryNumber, double remuneration) {
		super();
		this.playerName = playerName;
		this.jerseryNumber = jerseryNumber;
		this.remuneration = remuneration;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getJerseryNumber() {
		return jerseryNumber;
	}
	public void setJerseryNumber(int jerseryNumber) {
		this.jerseryNumber = jerseryNumber;
	}
	public double getRemuneration() {
		return remuneration;
	}
	public void setRemuneration(double remuneration) {
		this.remuneration = remuneration;
	}
	@Override
	public String toString() {
		return "CricketPlayers [playerName=" + playerName + ", jerseryNumber=" + jerseryNumber + ", remuneration="
				+ remuneration + "]";
	}
	
	

}
