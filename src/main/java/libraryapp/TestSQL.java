package libraryapp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sqlrequest.AuthorsSQL;
import sqlrequest.BookSQL;
import sqlrequest.GenreSQL;

public class TestSQL {

	public static void main(String[] args) {
		AuthorsSQL aSQL = new AuthorsSQL();
		BookSQL bSQL = new BookSQL();
		GenreSQL gSQL = new GenreSQL();
		List<Authors> authorslist = new ArrayList<Authors>();
		
		
		Authors au = new Authors((long) 1, "Глеб", "Абдулаев", "Геннадьевич");
		Authors au2 = new Authors();
		au2.setId((long) 2);
		au2.setName("Наталья");
		au2.setSurname("Прохорова");
		au2.setFathername("Александровна");
		
		Book b = new Book((long) 1, "Том 1", "1234", "Ставрополь", "Москва");
		Genre g = new Genre((long) 3, "Комедия");
		
		try {
			aSQL.add(au);
			aSQL.add(au2);
			bSQL.add(b);
			gSQL.add(g);
		} catch (SQLException e) {e.printStackTrace();
		}
		
		

	}

}
