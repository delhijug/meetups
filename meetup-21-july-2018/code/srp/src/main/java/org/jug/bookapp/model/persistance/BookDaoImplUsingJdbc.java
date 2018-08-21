package org.jug.bookapp.model.persistance;

import java.util.List;

import org.jug.bookapp.model.persistance.exceptions.DaoException;

public class BookDaoImplUsingJdbc implements  BookDao{

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookById(int bookId) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBook(int bookId) {
		// TODO Auto-generated method stub
		
	}

}
