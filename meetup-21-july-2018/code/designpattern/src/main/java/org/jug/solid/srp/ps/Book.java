package org.jug.solid.srp.ps;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

class Book {
	private int id;
	private String isbn;
	private String title;
	private String author;
	private double price;
	
	public Connection  getConnection(){
		// code to get jdbc connection..
		return null;
	}

	public SessionFactory  getFactory(){
		// code to get jdbc connection..
		return null;
	}
	public void addBook(Book book)throws SQLException{
		System.out.println("adding book to db using jdbc..");
	}
       public void addBookUsingHibernate(Book book)throws HibernateException{
		System.out.println("adding book to db using hibernate....");
	}
}