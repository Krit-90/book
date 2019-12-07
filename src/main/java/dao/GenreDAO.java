package dao;

import java.sql.SQLException;
import java.util.List;

import libraryapp.Genre;

public interface GenreDAO {
	
	//create
	void add(Genre genre) throws SQLException;
	
	//read
	List<Genre> getAll() throws SQLException;
	
	Genre getById(Long id) throws SQLException;
	
	//update
	void update(Genre genre) throws SQLException;
	
	//delete
	void remove(Genre genre) throws SQLException;
	

}