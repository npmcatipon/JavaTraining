package com.bpi.module2;

public class Car {
	
	private String brand;
	private String color;
	private String model;
	
	public Car() {
	}
	public Car(String brand, String color, String model) {
		this.brand = brand;
		this.color = color;
		this.model = model;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public void displayCarInfo() {
		System.out.println("Branch is: " + this.brand);
		System.out.println("Color is: " + this.color);
		System.out.println("Model is: " + this.model);
	}

}
