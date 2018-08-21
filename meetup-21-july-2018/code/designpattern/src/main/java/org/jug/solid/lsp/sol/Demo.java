package org.jug.solid.lsp.sol;
/*
 * res, subst, extend
 */

class Rectangle{
	private int l, b;

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

	public Rectangle(int l, int b) {
		this.l = l;
		this.b = b;
	}
	
	public int calculateArea(){
		return l*b;
	}
	
}

class Square{
	private Rectangle rectangle=null;
	public Square(int l) {
		rectangle=new Rectangle(l, l);
	}
	public void changeDimension(int changedDimemsion){
		rectangle.setB(changedDimemsion);
		rectangle.setL(changedDimemsion);
	}
	public int calculateArea(){
		return rectangle.calculateArea();
	}
	
	
}

public class Demo {
	
	public static void main(String[] args) {
	
		Square square=new Square(4);
		System.out.println(square.calculateArea());
		square.changeDimension(2);
		System.out.println(square.calculateArea());
		
	}

}
