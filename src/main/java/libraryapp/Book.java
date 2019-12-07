package libraryapp;

public class Book{

	private Long id;
	private String title;
	private String coop;
	private String year;
	private String city;

	
	public Book() {
	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
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

	public Book(Long id, String title, String year, String city, String coop) {
		super();
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