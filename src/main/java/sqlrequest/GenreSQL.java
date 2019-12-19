package sqlrequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dao.GenreDAO;
import libraryapp.AppConnect;
import libraryapp.Genre;

public class GenreSQL extends AppConnect implements GenreDAO {
Connection connection = getConnection();
	@Override
	public void add(Genre genre) throws SQLException {
		String sql = "INSERT INTO GENRE ( ID, TYPE ) VALUES ( ?, ?)";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			pr.setLong(1, genre.getId());
			pr.setString(2, genre.getType());
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	@Override
	public List<Genre> getAll() throws SQLException {
		List<Genre> genreList = new ArrayList<Genre>();
		String sql = "SELECT ID, TYPE FROM GENRE";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			ResultSet result = pr.executeQuery();
			while(result.next()) {
				genreList.add(extractGenreFromResult(result));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			connection.close();
		}
		return genreList;
	}

	@Override
	public Genre getById(Long id) throws SQLException{
		Genre genre = null;
		String sql = "SELECT ID, TYPE FROM GENRE WHERE ID = ?";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			pr.setLong(1, id);
			ResultSet result = pr.executeQuery();
			if(result.next()) {
				genre = extractGenreFromResult(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return genre;
	}

	private Genre extractGenreFromResult(ResultSet result) throws SQLException {
		Genre genre = new Genre();
		genre.setId(result.getLong("ID"));
		genre.setType(result.getString("TYPE"));
		return genre;
	}

	@Override
	public void update(Genre genre) throws SQLException {
		String sql = "UPDATE GENRE SET TYPE = ? WHERE ID = ?";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			pr.setString(1, genre.getType());
			pr.setLong(2, genre.getId());
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	@Override
	public void remove(Genre genre) throws SQLException {
		String sql = "DELETE FROM GENRE WHERE ID = ?";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			pr.setLong(1, genre.getId());
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
