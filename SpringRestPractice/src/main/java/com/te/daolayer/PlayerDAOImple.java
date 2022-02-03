package com.te.daolayer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.te.dtolayer.PlayerInfo;

@Repository
public class PlayerDAOImple implements PlayerDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addPlayer(PlayerInfo player) {
		boolean isInserted = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(player);
			transaction.commit();
			isInserted = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		}
		return isInserted;
	}

	@Override
	public boolean updatePlayer(PlayerInfo updatedPlayer) {
		boolean isUpdated=false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			PlayerInfo newPlayer = manager.find(PlayerInfo.class, updatedPlayer.getJerseryNo());
			if(updatedPlayer.getPlayerName() !=null && updatedPlayer.getPlayerName() !=""){
				newPlayer.setPlayerName(updatedPlayer.getPlayerName());
			}
			if(updatedPlayer.getGame() !=null&&updatedPlayer.getGame() !="") {
				newPlayer.setGame(updatedPlayer.getGame());
			}
			if(updatedPlayer.getFranchise() !=null && updatedPlayer.getFranchise()!="") {
				newPlayer.setFranchise(updatedPlayer.getFranchise());
			}
			if(updatedPlayer.getCountry() !=null &&updatedPlayer.getCountry()!=""){
				newPlayer.setCountry(updatedPlayer.getCountry());
			}
			
			transaction.commit();
			isUpdated=true;
		}
		
		catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public PlayerInfo getPlayer(int jerseryNumber) {
		EntityManager manager = factory.createEntityManager();
		PlayerInfo info = manager.find(PlayerInfo.class, jerseryNumber);
		
		return info;
	}

	@Override
	public boolean deletePlayer(int jerseryNumber) {
		boolean isDeleted=false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
        transaction.begin();
		PlayerInfo info = manager.find(PlayerInfo.class, jerseryNumber);
		manager.remove(info);
		transaction.commit();
	    manager.close();
	    isDeleted=true;
		}
		catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}		
		return isDeleted;
	}

}
