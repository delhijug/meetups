package org.jug.dp.createional.builder.sol;

public class FoodBuilder {
	private String name;
	private int unit;
	private int vitC=200;
	private int vitA=200;
	private int vitB12=200;
	private int vitB5=200;
	private int vitD=200;
	public FoodBuilder(String name, int unit) {
		super();
		this.name = name;
		this.unit = unit;
	}
	public FoodBuilder setVitC(int vitC) {
		this.vitC = vitC;
		return this;
	}
	public FoodBuilder setVitA(int vitA) {
		this.vitA = vitA;
		return this;
	}
	public FoodBuilder setVitB12(int vitB12) {
		this.vitB12 = vitB12;
		return this;
	}
	public FoodBuilder setVitB5(int vitB5) {
		this.vitB5 = vitB5;
		return this;
	}
	public FoodBuilder setVitD(int vitD) {
		this.vitD = vitD;
		return this;
	}
	
	
	public Food build(){
		return new Food(name, unit, vitC, vitA, vitB12, vitB5, vitD);
	}
	
}
