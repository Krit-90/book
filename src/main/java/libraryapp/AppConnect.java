package libraryapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppConnect {
	private static final String url ="jdbc:hsqldb:file:src/main/resources/db/library";
	private static final String driver ="org.hsqldb.jdbcDriver";
	private static final String user = "SA";
	private static final String password = "";
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(true);
			System.out.println("Соединение установленно");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Не удалось установить соединения :(");
		}
		return connection;
	}

}
