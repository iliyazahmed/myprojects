package com.te.dtolayer;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Player-Info")
@Entity
public class PlayerInfo implements Serializable {
	@Id
	private int jerseryNo;
	private String playerName;
	private String game;
	private String franchise;
	private String country;

	public PlayerInfo(int jerseryNo, String playerName, String game, String franchise, String country) {
		super();
		this.jerseryNo = jerseryNo;
		this.playerName = playerName;
		this.game = game;
		this.franchise = franchise;
		this.country = country;
	}

	public PlayerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getJerseryNo() {
		return jerseryNo;
	}

	public void setJerseryNo(int jerseryNo) {
		this.jerseryNo = jerseryNo;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getFranchise() {
		return franchise;
	}

	public void setFranchise(String franchise) {
		this.franchise = franchise;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	/*
	 * @Override public String toString() { return "PlayerInfo [jerseryNo=" +
	 * jerseryNo + ", playerName=" + playerName + ", game=" + game + ", franchise="
	 * + franchise + ", country=" + country + "]"; }
	 */

}
