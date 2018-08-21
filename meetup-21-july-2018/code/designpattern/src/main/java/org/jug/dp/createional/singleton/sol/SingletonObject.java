package org.jug.dp.createional.singleton.sol;

import java.io.Serializable;

/*
 * One object per application
 * => lazy vs eager
	=> threading issue, double locking
	=> What if clonned
	=> What if deserilized?
	=> What if used java reflection?
	=> what if 2 class loader load that class twice
	=> best practices, effective java
	=> using enum
 */
class SingletonObject implements Serializable, Cloneable{
	// is is done?
	private static volatile SingletonObject object=null;
	
	private SingletonObject(){
		if(object!=null)
		 throw new NullPointerException();
	} 
	static  SingletonObject getSingletonObject(){
		if(object==null)
			synchronized (SingletonObject.class) {
				if(object==null)
				object=new SingletonObject();
			}
			
		return object;
	}
	
	private Object readResolve(){
		System.out.println("its bean called at the time of de-ser");
		return getSingletonObject();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return getSingletonObject();
	}
	
	
	
}















