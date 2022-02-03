package com.te.servicelayer;

import com.te.dtolayer.PlayerInfo;

public interface PlayerService {
      
	public boolean addServicePlayer(PlayerInfo player);
	
	public boolean updateServicePlayer(PlayerInfo updatedPlayer);
	
	public PlayerInfo getServicePlayer(int jerseryNumber);
	
	public boolean deleteServicePlayer(int jerseryNumber);
	
}
