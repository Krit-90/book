package sqlrequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dao.BookDAO;
import libraryapp.AppConnect;
import libraryapp.Book;

public class BookSQL extends AppConnect implements BookDAO {
Connection connection = getConnection();
	@Override
	public void add(Book book) throws SQLException {
		String sql = "INSERT INTO BOOK (ID, TITLE, COOP, YEAR, CITY, ID_AUTHORS, ID_GENRE) VALUES ( ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			pr.setLong(1, book.getId());
			pr.setString(2, book.getTitle());
			pr.setString(3, book.getCoop());
			pr.setInt(4, book.getYear());
			pr.setString(5, book.getCity());
			pr.setLong(6, book.getAuthor().getId());
			pr.setLong(7, book.getGenre().getId());
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	@Override
	public List<Book> getAll() throws SQLException {
		List<Book> bookList = new ArrayList<Book>();
		String sql = "SELECT ID, TITLE, COOP, YEAR, CITY FROM BOOK, ID_AUTHOR, ID_GENRE";
/*		Попробовать
		SELECT
		book.id,
				book.title,
				book.coop,
				book.year,
				book.city,
				book.id_authors,
				authors.name,
				authors.surname,
				authors.fathername,
				book.id_genre,
				genre.type
		FROM "PUBLIC"."BOOK" left join authors on book.id_authors = authors.id
		left join genre on book.id_genre = genre.id*/
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			ResultSet result = pr.executeQuery(sql);
			while(result.next()) {
				bookList.add(extractBookFromResult(result));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			connection.close();
		}
		return bookList;
	}

	private Book extractBookFromResult(ResultSet result) throws SQLException {
		Book book = new Book();
		book.setId(result.getLong("ID"));
		book.setTitle(result.getString("TITLE"));
		book.setCoop(result.getString("COOP"));
		book.setYear(result.getInt("YEAR"));
		book.setCity(result.getString("City"));
		book.setId(result.getLong("ID"));
		book.setId(result.getLong("ID"));
		return book;
	}

	@Override
	public Book getById(Long id) throws SQLException{
		Book book = null;
		String sql = "SELECT ID, TITLE, COOP, YEAR, CITY FROM BOOK WHERE ID = ?";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			pr.setLong(1, id);
			ResultSet result = pr.executeQuery();
			if(result.next()) {
				book = extractBookFromResult(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return book;
	}
	@Override
	public void update(Book book) throws SQLException {
		String sql = "UPDATE BOOK SET TITLE = ?, COOP = ?, YEAR = ?, CITY = ? WHERE ID = ?";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			pr.setString(1, book.getTitle());
			pr.setString(2, book.getCoop());
			pr.setInt(3, book.getYear());
			pr.setString(4, book.getCity());
			pr.setLong(5, book.getId());
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
	}
	@Override
	public void remove(Book book) throws SQLException {
		String sql = "DELELTE FROM BOOK WHERE ID = ?";
		try (PreparedStatement pr = connection.prepareStatement(sql)) {
			pr.setLong(1, book.getId());
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
