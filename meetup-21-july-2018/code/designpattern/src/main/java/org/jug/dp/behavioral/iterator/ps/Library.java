package org.jug.dp.behavioral.iterator.ps;
import java.util.*;
public class Library {
	private List<Book> books;
	public Library(){
		books=new ArrayList<Book>();
	}
	
	public void addBook(Book book){
		books.add(book);
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
