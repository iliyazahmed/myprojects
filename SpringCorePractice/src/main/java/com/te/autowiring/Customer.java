package com.te.autowiring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Customer {
     
	@Value("Iliyaz")
	private String name;
	@Value("Male")
	private String gender;
	@Value("23")
	private int age;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
	
	
	
	
	
	
}
