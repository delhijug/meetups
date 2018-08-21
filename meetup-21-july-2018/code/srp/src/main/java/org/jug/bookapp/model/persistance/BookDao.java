package org.jug.bookapp.model.persistance;

import java.util.List;

import org.jug.bookapp.model.persistance.exceptions.DaoException;

public interface BookDao {
	public List<Book> getAllBooks();
	public Book getBookById(int bookId)throws DaoException;
	public void addBook(Book book);
	public void updateBook(Book book);
	public void removeBook(int bookId);
}
