package org.jug.dp.createional.prototype.ps;

import java.util.Date;
import java.util.GregorianCalendar;

class Employee implements Cloneable {
	private Integer id;
	private String name;
	private Date hireDay;// mutable

	public Employee(Integer id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.hireDay = date;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", hireDay=" + hireDay
				+ "]";
	}



	public void changeHireDay(int year, int month, int day) {
		hireDay.setDate(day);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}

}

public class Demo {

	public static void main(String[] args) throws CloneNotSupportedException {
		Date date=new GregorianCalendar(2001, 11, 22).getTime();
		
		Employee employee1 = new Employee(33, "raja", date);
	
		//Employee employee2 = employee1.clone();
	
		System.out.println(employee1);
		//System.out.println(employee2);
		
		System.out.println("After changing............");
		employee1.changeHireDay(2011, 11, 11);
		employee1.setName("amit");
		System.out.println(employee1);
		//System.out.println(employee2);
	}
}
