package org.jug.dp.createional.factory.ps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}
		try {
			Connection connection =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/d_jug","root","root");
			System.out.println("connection is done");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
