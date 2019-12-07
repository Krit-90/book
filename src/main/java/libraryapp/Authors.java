package libraryapp;

public class Authors{

	private Long id;
	private String name;
	private String surname;
	private String fathername;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public Authors() {
	}
	public Authors(Long id, String name, String surname, String fathername) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.fathername = fathername;
	}
	@Override
	public String toString() {
		return "Authors [id=" + id 
				+ ", name=" + name 
				+ ", surname=" + surname 
				+ ", fathername=" + fathername + "]";
	}
}
