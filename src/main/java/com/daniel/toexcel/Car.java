package com.daniel.toexcel;

public class Car {
	private int id;
	private String brand;
	private String model;
	private String colour;

	public Car(int id, String brand, String model, String colour) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.colour = colour;
	}

	public Car() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

}
