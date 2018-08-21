package org.jug.dp.createional.singleton.sol;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

	/*public static void create(){
		SingletonObject object=SingletonObject.getSingletonObject();
		System.out.println(object.hashCode());
	}*/
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, CloneNotSupportedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		
		
		//SingletonObject object2=(SingletonObject) object.clone();
		
		Constructor []constructors=SingletonObject.class.getDeclaredConstructors();
		
		constructors[0].setAccessible(true);
		SingletonObject object2= (SingletonObject) constructors[0].newInstance();
		
		
		System.out.println(object2.hashCode());
		SingletonObject object=SingletonObject.getSingletonObject();
		System.out.println(object.hashCode());
		//Ser
	/*	ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("a.ser")));
		oos.writeObject(object);
	
		//Deser 
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("a.ser")));
		
		SingletonObject object2=(SingletonObject) ois.readObject();
		
		System.out.println(object.hashCode());
		System.out.println(object2.hashCode());*/
		
		/*ExecutorService ex=Executors.newFixedThreadPool(2);
		ex.submit(Demo::create);
		ex.submit(Demo::create);
		ex.shutdown();*/
		
		
		//System.out.println(object1.hashCode());
		//System.out.println(object2.hashCode());
	}

}
