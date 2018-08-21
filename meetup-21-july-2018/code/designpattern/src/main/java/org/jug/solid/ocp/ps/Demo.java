package org.jug.solid.ocp.ps;

class Circle{
	private int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
class Rectangle{
	private int l,b;

	public Rectangle(int l, int b) {
		this.l = l;
		this.b = b;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
}

class AreaCalculator{
	private static final Circle Circle = null;

	public double getArea(Object shape){
		double calculatedArea=0;
		if(shape instanceof Circle){
			Circle shape2=Circle;
			calculatedArea=shape2.getRadius()*shape2.getRadius()*Math.PI;
		}else{
			
		}
		
		
		return calculatedArea;
	}
}
public class Demo {
	
	public static void main(String[] args) {
		
	}

}
