package model;

public class Subject {

	// Attributes
	private String name;
	private String nrc;
	private int enrolledStudent;
	private String teacherName;
	private String teacherEmail;
	private String monitorName;
	private String monitorEmail;
	private String department;
	private int group;
	
	public Subject(String name, String nrc, int enrolledStudent, String teacherName, String teacherEmail,

			String monitorName, String monitorEmail, String department, int group) {
		this.name = name;
		this.nrc = nrc;
		this.teacherName = teacherName;
		this.enrolledStudent = enrolledStudent;
		this.teacherEmail = teacherEmail;
		this.monitorName = monitorName;
		this.monitorEmail = monitorEmail;
		this.department = department;
		this.group = group;
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

	public int getEnrolledStudent() {
		return enrolledStudent;
	}

	public void setEnrolledStudent(int enrolledStudent) {
		this.enrolledStudent = enrolledStudent;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getMonitorName() {
		return monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	public String getMonitorEmail() {
		return monitorEmail;
	}

	public void setMonitorEmail(String monitorEmail) {
		this.monitorEmail = monitorEmail;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

}
