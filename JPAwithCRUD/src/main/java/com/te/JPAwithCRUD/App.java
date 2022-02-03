package com.te.JPAwithCRUD;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		
		/*
		 * // insert data
		 *  CricketPlayers cricketPlayers = new CricketPlayers();
		 * cricketPlayers.setJerseyNumber(45);
		 * cricketPlayers.setPlayerName("Rohit Sharma");
		 * cricketPlayers.setCountryName("India"); 
		 * cricketPlayers.setSalary(12000);
		 * 
		 * PlayersDAO playersDAO = new PlayersDAO();
		 * playersDAO.insertPlayer(cricketPlayers);
		 */
    	
        
    	PlayersDAO playersDAO = new PlayersDAO();
    	
    	//read operation....
    	//System.out.println(playersDAO.getPlayerDetails(18));
		  
    	// update operation
    	//playersDAO.updateDetails(40, "David Warner");
    	
    	//delete operation
    	playersDAO.deletePlayer(45);
    	
    }
}
