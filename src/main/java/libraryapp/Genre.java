package libraryapp;

public class Genre {

	private long id;
	private String type;
	public Genre() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Genre(long id, String type) {
		this.id = id;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Genre [id=" + id 
				+ ", type=" + type + "]";
	}
}
