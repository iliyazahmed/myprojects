package com.te.SpringCorePractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/te/SpringCorePractice/CricketPlayersConfig.xml");
        CricketPlayers cricketPlayers = context.getBean("player1",CricketPlayers.class);
        System.out.println(cricketPlayers);
        CricketPlayers cricketPlayers2 = context.getBean("player2",CricketPlayers.class);
        System.out.println(cricketPlayers2);
        
    }
}
