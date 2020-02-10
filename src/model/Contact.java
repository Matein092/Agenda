package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Contact {

	public final static String COURSES_PATH = ".\\data\\Courses.csv";

	// Attributes
	private String name;
	private String lastName;
	private String telephone;
	private String email;
	private String id;
	private int semester;
	private String avatar;
	private String bornDate;
	private int age;
	private String program;
	private ArrayList<String> nrcs;



	// Association
	private HashMap<String, Subject> subjects;

	// Constructor
	public Contact(String name, String lastName, String telephone, String email, String id, int semester, String avatar,
			String birthday, int age, String program) {
		this.name = name;
		this.lastName = lastName;
		this.telephone = telephone;
		this.email = email;
		this.id = id;
		this.semester = semester;
		this.avatar = avatar;
		this.bornDate = birthday;
		this.age = age;
		this.program = program;
		subjects = new HashMap<String, Subject>();
		nrcs = new ArrayList<String>();
	}

	// Métodos


	public void loadSubjects() throws IOException {

		BufferedReader bF = new BufferedReader(new FileReader(COURSES_PATH));
		String line = "";

		while ((line = bF.readLine()) != null) {
			if (line.charAt(0) != '#') {
				String[] data = line.split(";");
				for (int i = 0; i < nrcs.size(); i++) {
					if (nrcs.get(i).equals(data[2])) {
						Subject subject = null;
						subject = new Subject(data[0], data[1], data[2], Integer.parseInt(data[3]));
						subjects.put(subject.getNrc(), subject);
					}
				}
			}

		}
		bF.close();
	}


	public Subject searchSubject(String nrc) {
		Subject objSubject = null;
		for (Subject subject : subjects.values()) {
			if (subject.getNrc().equals(nrc)){
				objSubject = subject;
			}
		}
		return objSubject;
	}

	public void modifySubject(String name, String nrc, String teacherName, int creditHours) {
		Subject objS = searchSubject(nrc);
		if (objS != null) {
			objS.setName(name);
			objS.setNrc(nrc);
			objS.setTeacherName(teacherName);
			objS.setCreditHours(creditHours);
		}
	}

	public void addSubject(String name, String nrc, String teacherName, int creditHours) {
		Subject subject = searchSubject(nrc);
		if (subject == null) {
			subject = new Subject(name, nrc, teacherName, creditHours);
			subjects.put(nrc, subject);
		}
	}

	public void deleteSubject(String nrc) {
		Subject subject = searchSubject(nrc);
		if (subject != null){
			subjects.remove(nrc);
		}
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
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

	public HashMap<String, Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(HashMap<String, Subject> subjects) {
		this.subjects = subjects;
	}

	public ArrayList<String> getNrcs() {
		return nrcs;
	}

	public void setNrcs(ArrayList<String> nrcs) {
		this.nrcs = nrcs;
	}

	@Override
    public java.lang.String toString() {
        return "Contact{" +
                       "name=" + name +
                       ", lastName=" + lastName +
                       ", telephone=" + telephone +
                       ", email=" + email +
                       ", id=" + id +
                       ", semester=" + semester +
                       ", avatar=" + avatar +
                       ", bornDate=" + bornDate +
                       ", age=" + age +
                       ", program=" + program +
                       ", subj=" + subjects +
                       '}';
    }
}
