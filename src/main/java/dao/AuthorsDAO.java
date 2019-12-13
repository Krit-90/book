package dao;

import java.sql.SQLException;
import java.util.List;
import libraryapp.Authors;

public interface AuthorsDAO {
	//create
	void add(Authors authors) throws SQLException;
	
	//read
	List<Authors> getAll() throws SQLException;
	
	Authors getById(Long id) throws SQLException;
	
	//update
	void update(Authors authors) throws SQLException;
	
	//delete
	void remove(Authors authors) throws SQLException;
	

}
