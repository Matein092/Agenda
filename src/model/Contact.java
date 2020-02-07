package model;
import java.util.*;

public class Contact {

	//Attributes
	private String name;
	private String lastName;
	private String telephone;
	private String email;
	private	String id;
	private int semester;
	private String avatar;
	private String birthday;
	private int age;
	private String program;
	
	//Association
	private List<Subject> subjects;
	private HashMap<Integer, Subject> subj;
		
	//Constructor
	public Contact(String name, String lastName, String telephone, String email, String id, int semester, String avatar,
			String birthday, int age, String program) {
		this.name = name;
		this.lastName = lastName;
		this.telephone = telephone;
		this.email = email;
		this.id = id;
		this.semester = semester;
		this.avatar = avatar;
		this.birthday = birthday;
		this.age = age;
		this.program = program;
		//subjects = new ArrayList<Subject>();
		subj = new HashMap<Integer, Subject>();
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
	
	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	
	/*
	 * public List<Subject> getSubjects() { return subjects; }
	 * 
	 * public void setSubjects(List<Subject> subjects) { this.subjects = subjects; }
	 */
	
	
	public Subject searchSubject(int nrc){
		Subject objSubject = null;
		//for(int i = 0; i < subjects.size(); i++) {
			if(subj.get(nrc).getNrc() == nrc ) {
				objSubject = new Subject(subj.get(nrc).getName(),subj.get(nrc).getNrc(),  subj.get(nrc).getEnrolledStudent(), subj.get(nrc).getTeacherName(), subj.get(nrc).getTeacherEmail(), subj.get(nrc).getMonitorName(), subj.get(nrc).getMonitorEmail(), subj.get(nrc).getDepartment(), subj.get(nrc).getGroup());
			}else {
				
			}
		//}
		return objSubject;
	}
	
	public HashMap<Integer, Subject> getSubj() {
		return subj;
	}

	public void setSubj(HashMap<Integer, Subject> subj) {
		this.subj = subj;
	}

	public void modifySubject(String name, int nrc, int enrolledStudent, String teacherName, String teacherEmail,
			String monitorName, String monitorEmail, String department, int group) {
		Subject objS = searchSubject(nrc);
		if(objS != null) {
			objS.setName(name);
			objS.setNrc(nrc);
			objS.setTeacherName(teacherName);
			objS.setTeacherEmail(teacherEmail);
			objS.setMonitorName(monitorName);
			objS.setMonitorEmail(monitorEmail);
			objS.setDepartment(department);
			objS.setGroup(group);
		}else {
			
		}
		
	}

	public String showSubjectByNrc(int nrc) {
		String msg = " ";
		for(int i = 0; i < subjects.size(); i++) {
			if(subjects.get(i).getNrc() == nrc) {
				msg = subjects.get(i).toString();
			}
		}

		return msg;
	}
	
	public void addSubject(String name, int nrc, int enrolledStudent, String teacherName, String teacherEmail,
			String monitorName, String monitorEmail, String department, int group) {
		Subject subject = searchSubject(nrc);
		if(subject == null) {
			subject = new Subject(name, nrc, enrolledStudent, teacherName, teacherEmail, monitorName, monitorEmail, department,group);

			subjects.add(subject);

			subj.put(nrc, subject);

		}
	}
	
	public void deleteSubject(int nrc) {
		Subject contact = searchSubject(nrc);
		for(int i = 0; i < subjects.size(); i++) {
			if(contact.equals((subjects).get(i))) {
				subjects.remove(i);
				
			}
		}
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", lastName=" + lastName + ", telephone=" + telephone + ", email=" + email
				+ ", id=" + id + ", semester=" + semester + ", avatar=" + avatar + ", birthday=" + birthday + ", age="
				+ age + ", program=" + program + ", subjects=" + subj + "]";
	}
	
	
	
}
