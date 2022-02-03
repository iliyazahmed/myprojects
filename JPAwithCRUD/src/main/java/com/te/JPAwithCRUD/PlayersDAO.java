package com.te.JPAwithCRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PlayersDAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ravinder");
	
	//insert Data
	public void insertPlayer(CricketPlayers cricketPlayers) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(cricketPlayers);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	//Read Operation
	public CricketPlayers getPlayerDetails(int jerseryNumber) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CricketPlayers players = entityManager.find(CricketPlayers.class, jerseryNumber);
		return players;
	}
	
	public void updateDetails(int jerseyNumber,String playerName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		CricketPlayers cricketPlayers = entityManager.find(CricketPlayers.class, jerseyNumber);
		cricketPlayers.setPlayerName(playerName);
		
		entityManager.merge(cricketPlayers);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		System.out.println("Updated Successfully..........");
	}
	
	public void deletePlayer(int jerseyNumber) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		CricketPlayers cricketPlayers = entityManager.find(CricketPlayers.class, jerseyNumber);
		entityManager.remove(cricketPlayers);
		
		entityManager.getTransaction().commit();
		entityManager.close();

		
	}
}
