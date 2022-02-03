package com.te.autowiring;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Paradise {
    
    @Value("#{food}")
	private List<String> food;
    @Value("#{price}")
	private List<Double> price;
	
	@Autowired
	private Customer customer;
	
	

	public Paradise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paradise(List<String> food, List<Double> price, Customer customer) {
		super();
		this.food = food;
		this.price = price;
		this.customer = customer;
	}

	public List<String> getFood() {
		return food;
	}

	public void setFood(List<String> food) {
		this.food = food;
	}

	public List<Double> getPrice() {
		return price;
	}

	public void setPrice(List<Double> price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Paradise [food=" + food + ", price=" + price + ", customer=" + customer + "]";
	}
	
	
	
	
	
}
