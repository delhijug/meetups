package org.jug.solid.lsp.ps;
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

class Square extends Rectangle{
	public Square(int l){
		super(l, l);
	}
}

public class Demo {
	
	public static void main(String[] args) {
	
		Square square=new Square(2);
		square.setB(3);
		System.out.println(square.calculateArea());
		
	}

}
