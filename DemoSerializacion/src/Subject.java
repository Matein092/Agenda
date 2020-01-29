
public class Subject {
	
	private String nrc;
	private int creditHour;
	private String level;
	private String instructor;
	private String campus;
	private String tower;
	private String room;
	private String schedule;
	public Subject(String nrc, int creditHour, String level, String instructor, String campus, String tower,
			String room, String schedule) {
		super();
		this.nrc = nrc;
		this.creditHour = creditHour;
		this.level = level;
		this.instructor = instructor;
		this.campus = campus;
		this.tower = tower;
		this.room = room;
		this.schedule = schedule;
	}
	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public int getCreditHour() {
		return creditHour;
	}
	public void setCreditHour(int creditHour) {
		this.creditHour = creditHour;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getTower() {
		return tower;
	}
	public void setTower(String tower) {
		this.tower = tower;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	

}
