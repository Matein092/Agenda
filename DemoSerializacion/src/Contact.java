
public class Contact {
	
	private String name;
	private String birthday;
	private int code;
	private int numberPhone;
	private String email;
	private String career;
	private String level;
	public Contact(String name, String birthday, int code, int numberPhone, String email, String career, String level) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.code = code;
		this.numberPhone = numberPhone;
		this.email = email;
		this.career = career;
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(int numberPhone) {
		this.numberPhone = numberPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	

}
