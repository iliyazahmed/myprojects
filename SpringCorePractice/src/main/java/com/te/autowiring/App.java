package com.te.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/te/autowiring/CustomerConfig.xml");
		Paradise par = applicationContext.getBean("paradise",Paradise.class);
		Customer cust = applicationContext.getBean("customer",Customer.class);
		System.out.println("Hi "+cust.getName()+", this are the below items for you " );
		System.out.println(par.getFood()+" and price is "+par.getPrice());

	}

}
