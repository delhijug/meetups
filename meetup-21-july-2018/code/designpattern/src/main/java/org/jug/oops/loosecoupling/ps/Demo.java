package org.jug.oops.loosecoupling.ps;
//"A passanger is using metro to travel from Laxmi Nagar to Noida"'
/*
 * 
 */

abstract class Vehical{
	public abstract void  move(String source, String desination);
}


class Metro extends Vehical{
	public void move(String source, String desination){
		System.out.println("moving from " + source+ " to " + desination+ " using metro");
	}
}

class Bus extends Vehical{
	public void move(String source, String desination){
		System.out.println("moving from " + source+ " to " + desination+ " using Bus");
	}
}

class Passanger{
	
	private String passangerName;
	public Passanger(String passangerName) {
		this.passangerName = passangerName;
	}
	public void travel(String source, String desination, Vehical vehical){
		vehical.move(source, desination);
	}
}

public class Demo {

	public static void main(String[] args) {

		//Metro metro=new Metro();
		Vehical bus=new Metro();
		Passanger passanger=new Passanger("amit");
		passanger.travel("LN", "Noida", bus);
		
	}
}
