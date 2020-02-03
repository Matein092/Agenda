package model;

public class Contact {

	/**
	 * 
	 */
	private String name;
	private String lastName;
	private String telephone;
	private String email;
	private double id;
	private int semester;
	private String avatar;
	private String birhtday;
	private int age;
	private String program;
	
	
	
	
	

	public Contact(String name, String lastName, String telephone, String email, double id, int semester, String avatar,
			String birhtday, int age, String program) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.telephone = telephone;
		this.email = email;
		this.id = id;
		this.semester = semester;
		this.avatar = avatar;
		this.birhtday = birhtday;
		this.age = age;
		this.program = program;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}//
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getBirhtday() {
		return birhtday;
	}
	public void setBirhtday(String birhtday) {
		this.birhtday = birhtday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	
	
	
}
