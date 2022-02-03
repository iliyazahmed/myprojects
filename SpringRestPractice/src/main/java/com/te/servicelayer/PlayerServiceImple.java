package com.te.servicelayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.daolayer.PlayerDAO;
import com.te.dtolayer.PlayerInfo;

@Service
public class PlayerServiceImple implements PlayerService{
    
	@Autowired
	private PlayerDAO playerDao;
	
	@Override
	public boolean addServicePlayer(PlayerInfo player) {
		return playerDao.addPlayer(player);
	}

	@Override
	public boolean updateServicePlayer(PlayerInfo updatedPlayer) {
		return playerDao.updatePlayer(updatedPlayer);
	}

	@Override
	public PlayerInfo getServicePlayer(int jerseryNumber) {
		return playerDao.getPlayer(jerseryNumber);
	}

	@Override
	public boolean deleteServicePlayer(int jerseryNumber) {
		return playerDao.deletePlayer(jerseryNumber);
	}

}
