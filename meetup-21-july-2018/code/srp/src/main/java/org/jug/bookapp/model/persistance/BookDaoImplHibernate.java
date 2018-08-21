package org.jug.bookapp.model.persistance;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.jug.bookapp.model.persistance.exceptions.DaoException;

public class BookDaoImplHibernate implements BookDao{

	private SessionFactory factory;
	
	public BookDaoImplHibernate(SessionFactory factory){
		this.factory=factory;
	}
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookById(int bookId) throws DaoException {
		try{
			//
			throw new HibernateException("some hib hell");
			
		}catch(HibernateException e){
			throw new DaoException("some hib hello", e);
		}
		
		
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
