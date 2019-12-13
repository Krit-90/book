package dao;

import java.sql.SQLException;
import java.util.List;
import libraryapp.Book;

public interface BookDAO {
	
	//create
	void add(Book book) throws SQLException;
	
	//read
	List<Book> getAll() throws SQLException;
	
	Book getById(Long id) throws SQLException;
	
	//update
	void update(Book book) throws SQLException;
	
	//delete
	void remove(Book book) throws SQLException;
	

}