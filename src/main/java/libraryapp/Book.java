package libraryapp;

public class Book{

	private long id;
	private String title;
	private String coop;
	private int year;
	private String city;
	private Author author;
	private Genre genre;

	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCoop() {
		return coop;
	}
	public void setCoop(String coop) {
		this.coop = coop;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Book() {
	}
	public Book(long id, String title, String coop, int year, String city, Author author, Genre genre) {
		this.id = id;
		this.title = title;
		this.coop = coop;
		this.year = year;
		this.city = city;
		this.author = author;
		this.genre = genre;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Book [id=")
				.append(id)
				.append(", title=")
				.append(title)
				.append(", year=")
				.append(year)
				.append(", city=")
				.append(city)
				.append(", coop=")
				.append(coop)
				.append(", authors=")
				.append(author)
				.append(", genre=")
				.append(genre)
				.append("]").toString();
	}

}