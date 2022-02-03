package com.te.SpringConstructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/te/SpringConstructorInjection/CricketPlayersConfig.xml");
		CricketPlayers cricketPlayers = context.getBean("countryPlayers", CricketPlayers.class);
		System.out.println(cricketPlayers);

	}

}
