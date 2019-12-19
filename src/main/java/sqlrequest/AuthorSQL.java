package sqlrequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dao.AuthorsDAO;
import libraryapp.AppConnect;
import libraryapp.Author;

public class AuthorSQL extends AppConnect implements AuthorsDAO {
	Connection connection = getConnection();
	@Override
	public void add(Author author) throws SQLException {
		String sql = "INSERT INTO AUTHORS(ID, NAME, SURNAME, FATHERNAME) VALUES ( ?, ?, ?, ?)";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			System.out.println(connection.isClosed());
			pr.setLong(1, author.getId());
			pr.setString(2, author.getName());
			pr.setString(3, author.getSurname());
			pr.setString(4, author.getFathername());
			pr.executeUpdate();
			System.out.println("success");
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public void drop() throws SQLException {
		String sql = "DROP TABLE OK";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			System.out.println(connection.isClosed());
			pr.executeUpdate();
			System.out.println("success");
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			connection.close();
		}
	}


	@Override
	public List<Author> getAll() throws SQLException {
		List<Author> authorList = new ArrayList<Author>();
		String sql = "SELECT ID, NAME, SURNAME, FATHERNAME FROM AUTHORS";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			ResultSet result = pr.executeQuery();
			while(result.next()) {
				authorList.add(extractAuthorFromResult(result));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			connection.close();
		}
		return authorList;
	}

	@Override
	public Author getById(Long id) throws SQLException{
		Author author = null;

		String sql = "SELECT ID, NAME, SURNAME, FATHERNAME FROM AUTHORS WHERE ID = ?";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			pr.setLong(1, id);
			ResultSet result = pr.executeQuery();
			author = extractAuthorFromResult(result);

			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return author;
	}

	private Author extractAuthorFromResult(ResultSet result) throws SQLException {
		Author author = new Author();
		author.setId(result.getLong("ID"));
		author.setName(result.getString("NAME"));
		author.setSurname(result.getString("SURNAME"));
		author.setFathername(result.getString("FATHERNAME"));
		return author;
	}

	@Override
	public void update(Author author) throws SQLException {
		String sql = "UPDATE AUTHORS SET NAME = '?', SURNAME = '?', FATHERNAME = '?' WHERE ID = ?";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			pr.setString(1, author.getName());
			pr.setString(2, author.getSurname());
			pr.setString(3, author.getFathername());
			pr.setLong(4, author.getId());
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	@Override
	public void remove(Author author) throws SQLException {
		String sql = "DELETE FROM AUTHORS WHERE ID = ?";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			pr.setLong(1, author.getId());
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
