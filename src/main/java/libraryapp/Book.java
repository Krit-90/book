package libraryapp;

public class Book{

	private long id;
	private String title;
	private String coop;
	private int year;
	private String city;

	
	public Book() {
	
	}
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

	public Book(long id, String title, int year, String city, String coop) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.city = city;
		this.coop = coop;
	}

	@Override
	public String toString() {
		return "Book [id=" + id 
				+ ", title=" + title 
				+ ", year=" + year
				+ ", city=" + city 
				+ ", coop=" + coop + "]";
	}
	
}