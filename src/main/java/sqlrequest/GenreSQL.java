package sqlrequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GenreDAO;
import libraryapp.AppConnect;
import libraryapp.Genre;

public class GenreSQL extends AppConnect implements GenreDAO {

Connection connection = getConnection();
	
	@Override
	public void add(Genre genre) throws SQLException {
		PreparedStatement pr = null;
		String sql = "INSERT INTO GENRE ( ID, TYPE ) VALUES ( ?, ?)";
		try {
			pr = connection.prepareStatement(sql);
			pr.setLong(1, genre.getId());
			pr.setString(2, genre.getType());

			pr.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			pr.close();
			connection.close();
		}
		
		
	}

	@Override
	public List<Genre> getAll() throws SQLException {
		PreparedStatement pr = null;
		
		List<Genre> genreList = new ArrayList<Genre>();
		
		String sql = "SELECT ID, TYPE FROM GENRE";
		try {
			pr = connection.prepareStatement(sql);
			ResultSet result = pr.executeQuery(sql);
			while(result.next()) {
				Genre genre = new Genre();
				
				genre.setId(result.getLong("ID"));
				genre.setType(result.getString("TYPE"));
				genreList.add(genre);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			pr.close();
			connection.close();
		}
		
		return genreList;
	}

	@Override
	public Genre getById(Long id) throws SQLException{
		Genre genre = new Genre();
		PreparedStatement pr = null;
		String sql = "SELECT ID, TYPE FROM GENRE WHERE ID = ?";
		
		try {
			pr = connection.prepareStatement(sql);
			pr.setLong(1, id);
			ResultSet result = pr.executeQuery();
			
			genre.setId(result.getLong("ID"));
			genre.setType(result.getString("TYPE"));
			
			pr.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			pr.close();
			connection.close();
		}
		return genre;
	}

	@Override
	public void update(Genre genre) throws SQLException {
		PreparedStatement pr = null;
		String sql = "UPDATE GENRE SET TYPE = '?' WHERE ID = ?";
		try {
			pr = connection.prepareStatement(sql);
			
			pr.setString(1, genre.getType());
			pr.setLong(2, genre.getId());
			pr.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			pr.close();
			connection.close();
		}
		
	}

	@Override
	public void remove(Genre genre) throws SQLException {
		PreparedStatement pr = null;
		String sql = "DELELTE FROM GENRE WHERE ID = ?";
		try {
			pr = connection.prepareStatement(sql);
			pr.setLong(1, genre.getId());
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pr.close();
			connection.close();
		}
		
		
	}
}
