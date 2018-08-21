package org.jug.oops.ps;

import java.util.Date;

class Student{
	private int id;
	private String name;
	private Date dob;
	private String marks;
	private int rank;
	
	
	
	public Student(int id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getDob() {
		return dob;
	}

	public String getMarks() {
		return marks;
	}
	
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public int getRank() {
		return rank;
	}
	
	
	
}
public class Demo2 {
	
	public static void main(String[] args) {
		
	}

}
