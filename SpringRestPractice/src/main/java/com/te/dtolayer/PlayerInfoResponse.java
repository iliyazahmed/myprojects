package com.te.dtolayer;

import org.springframework.beans.factory.annotation.Autowired;

public class PlayerInfoResponse {

	private int statusCode;
	private String message;
	private String description;

	@Autowired
	private PlayerInfo playerInfo;

	public PlayerInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerInfoResponse(int statusCode, String message, String description, PlayerInfo playerInfo) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.description = description;
		this.playerInfo = playerInfo;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PlayerInfo getPlayerInfo() {
		return playerInfo;
	}

	public void setPlayerInfo(PlayerInfo playerInfo) {
		this.playerInfo = playerInfo;
	}

	/*
	 * @Override public String toString() { return "PlayerInfoResponse [statusCode="
	 * + statusCode + ", message=" + message + ", description=" + description +
	 * ", playerInfo=" + playerInfo + "]"; }
	 */

}
