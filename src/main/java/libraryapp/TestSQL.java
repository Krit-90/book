package libraryapp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sqlrequest.AuthorSQL;
import sqlrequest.BookSQL;
import sqlrequest.GenreSQL;

public class TestSQL {

	public static void main(String[] args) {
		AuthorSQL aSQL = new AuthorSQL();
		BookSQL bSQL = new BookSQL();
		GenreSQL gSQL = new GenreSQL();
		List<Author> authorList = new ArrayList<Author>();
		
		
		Author au = new Author((long) 1, "Глеб", "Абдулаев", "Геннадьевич");
		Author au2 = new Author();
		au2.setId((long) 2);
		au2.setName("Наталья");
		au2.setSurname("Прохорова");
		au2.setFathername("Александровна");
		
		Book b = new Book((long) 1, "Том 1", 1234, "Ставрополь", "Москва");
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
