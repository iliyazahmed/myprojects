package com.te.daolayer;

import com.te.dtolayer.PlayerInfo;

public interface PlayerDAO {
      public boolean addPlayer(PlayerInfo player);
      
      public boolean updatePlayer(PlayerInfo updatedPlayer);
      
      public PlayerInfo getPlayer(int jerseryNumber);
      
      public boolean deletePlayer(int jerseryNumber);
      
}
