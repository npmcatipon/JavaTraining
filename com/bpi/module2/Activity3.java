package com.bpi.module2;

public class Activity3 {
	public static void main(String[] args) {
		Car honda = new Car();
		honda.setBrand("Honda");
		honda.setColor("Blue");
		honda.setModel("City");
		
		Car toyota = new Car("Toyota", "White", "Vios");
				
		System.out.println(honda.toString());
		System.out.println(toyota.toString());
	}
}
