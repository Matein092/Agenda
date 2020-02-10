package model;

public class Subject {

	// Attributes
	private String name;
	private String nrc;
	private String teacherName;
	private int creditHours;
	private int enrolledStudent;
	
	public Subject(String name, String nrc, String teacherName, int creditHours) {
		this.name = name;
		this.nrc = nrc;
		this.teacherName = teacherName;
		this.creditHours = creditHours;
		this.enrolledStudent = 0;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	public int getEnrolledStudent() {
		return enrolledStudent;
	}

	public void setEnrolledStudent(int enrolledStudent) {
		this.enrolledStudent = enrolledStudent;
	}



}
