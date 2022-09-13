package model;

import java.io.Serializable;

//JavaBeans　（Health情報）
public class Health implements Serializable {

	private String name, bodyType;
	private int age;
	private double height, weight, bmi;

	public Health() {

	}

	public Health(String name, int age, double height, double weight, double bmi) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

}
