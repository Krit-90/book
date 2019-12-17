package dao;

import java.sql.SQLException;
import java.util.List;

import libraryapp.Author;

public interface AuthorsDAO {
	//create
	void add(Author author) throws SQLException;
	
	//read
	List<Author> getAll() throws SQLException;
	
	Author getById(Long id) throws SQLException;
	
	//update
	void update(Author author) throws SQLException;
	
	//delete
	void remove(Author author) throws SQLException;
	

}
