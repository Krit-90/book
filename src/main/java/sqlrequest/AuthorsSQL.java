package sqlrequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.AuthorsDAO;
import libraryapp.AppConnect;
import libraryapp.Authors;

public class AuthorsSQL extends AppConnect implements AuthorsDAO {
	Connection connection = getConnection();
	
	
	@Override
	public void add(Authors authors) throws SQLException {
		PreparedStatement pr = null;
		//Запрос не проходит, хотя подключение есть
		String sql = "DROP TABLE OK";// более наглядный и простой запрос для проверки
				//"INSERT INTO AUTHORS("ID", "NAME", "SURNAME", "FATHERNAME" )VALUES ( ?, ?, ?, ?)";
		try {
			System.out.println(connection.isClosed());
			connection.setAutoCommit(true);
			pr = connection.prepareStatement(sql);			
			
			//pr.setLong(1, authors.getId());
			//pr.setString(2, authors.getName());
			//pr.setString(3, authors.getSurname());
			//pr.setString(4, authors.getFathername());
			pr.executeUpdate();
			connection.commit();
			System.out.println("success");
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			pr.close();
			//connection.close(); //Закомментил, чтобы избежать ошибки "нет соединения"
		}
		
	}

	@Override
	public List<Authors> getAll() throws SQLException {
		PreparedStatement pr = null;
		
		List<Authors> authorsList = new ArrayList<Authors>();
		
		String sql = "SELECT ID, NAME, SURNAME, FATHERNAME FROM AUTHORS";
		try {
			pr = connection.prepareStatement(sql);
			ResultSet result = pr.executeQuery(sql);
			while(result.next()) {
				Authors authors = new Authors();
				
				authors.setId(result.getLong("ID"));
				authors.setName(result.getString("NAME"));
				authors.setSurname(result.getString("SURNAME"));
				authors.setFathername(result.getString("FATHERNAME"));
				authorsList.add(authors);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			pr.close();
			connection.close();
		}
		
		return authorsList;
	}

	@Override
	public Authors getById(Long id) throws SQLException{
		Authors authors = new Authors();
		PreparedStatement pr = null;
		String sql = "SELECT ID, NAME, SURNAME, FATHERNAME FROM AUTHORS WHERE ID = ?";
		
		try {
			pr = connection.prepareStatement(sql);
			pr.setLong(1, id);
			ResultSet result = pr.executeQuery();
			
			authors.setId(result.getLong("ID"));
			authors.setName(result.getString("NAME"));
			authors.setSurname(result.getString("SURNAME"));
			authors.setFathername(result.getString("FATHERNAME"));
			
			pr.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			pr.close();
			connection.close();
		}
		return authors;
	}

	@Override
	public void update(Authors authors) throws SQLException {
		PreparedStatement pr = null;
		String sql = "UPDATE AUTHORS SET NAME = '?', SURNAME = '?', FATHERNAME = '?' WHERE ID = ?";
		try {
			pr = connection.prepareStatement(sql);
			
			pr.setString(1, authors.getName());
			pr.setString(2, authors.getSurname());
			pr.setString(3, authors.getFathername());
			pr.setLong(4, authors.getId());
			pr.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			pr.close();
			connection.close();
		}
		
	}

	@Override
	public void remove(Authors authors) throws SQLException {
		PreparedStatement pr = null;
		String sql = "DELETE FROM AUTHORS WHERE ID = ?";
		try {
			pr = connection.prepareStatement(sql);
			pr.setLong(1, authors.getId());
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pr.close();
			connection.close();
		}
		
		
	}

}
