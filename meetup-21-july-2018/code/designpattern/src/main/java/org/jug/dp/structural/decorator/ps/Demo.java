package org.jug.dp.structural.decorator.ps;
//Car-> BasicCar-> SportCar->SuperSportCar
interface Car{
	public String assemble();
}
class BasicCar implements Car{

	@Override
	public String assemble() {
		return "car with basics config";
	}
	
}



public class Demo {
	public static void main(String[] args) {
		
	}

}
