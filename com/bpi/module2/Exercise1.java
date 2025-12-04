package com.bpi.module2;

public class Exercise1 {

	public static void main(String[] args) {
		Car honda = new Car();
		honda.setBrand("Honda");
		honda.setColor("Blue");
		honda.setModel("City");
		
		Car toyota = new Car("Toyota","White","Vios");
		
		honda.displayCarInfo();
		toyota.displayCarInfo();
		
		
	}

}
