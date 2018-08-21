package org.jug.dp.behavioral.iterator.ps;
import java.util.*;
public class Demo {

	public static void main(String[] args) {
		List<Book>books=Arrays.asList
		(new Book(121, "A121", "head first", "raj", 300),
		new Book(121, "A121", "head first", "raj", 300),
		new Book(121, "A121", "head first", "raj", 300)
		);
		
		Library library=new Library();
		library.addBook(new Book(121, "raj", "head first", "raj", 500));
		
		
	}
}
