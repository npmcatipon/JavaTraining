package com.bpi.module2;

public class Car {
	private String model;
	private String color;
	private String brand;
	
	public Car() {
		super();
	}
	public Car(String model, String color, String brand) {
		super();
		this.model = model;
		this.color = color;
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String branch) {
		this.brand = branch;
	}
	
	@Override
	public String toString() {
		return "Car [model=" + model + ", color=" + color + ", brand=" + brand + "]";
	}
	
	
}
