package model;


import java.util.*;

public class Contact {

	
	// Attributes
	private String id;
	private String name;
	private String lastName;
	private String telephone;
	private String email;
	private int semester;
	private String avatar;
	private String bornDate;
	private int age;
	private String program;
	// Association
	private HashMap<String, Subject> subj;
	
	
	
	public Contact() {
		subj = new HashMap<>();
	}

	// Constructor
	public Contact(String id, String name, String lastName, String telephone, String email, int semester, String avatar,
			String bornDate, int age, String program) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.telephone = telephone;
		this.email = email;
		this.semester = semester;
		this.avatar = avatar;
		this.bornDate = bornDate;
		this.age = age;
		this.program = program;

		
	}

	
	
	
	
	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
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




	//////////////////////////////////////////////////////////////////
	//////////////////////Metodos materia/////////////////////////////
	//////////////////////////////////////////////////////////////////
	
	
	
	
	/**
	 * Buscar primero el subject == faltas
	 * @param name
	 * @param nrc
	 * @param enrolledStudent
	 * @param teacherName
	 * @param teacherEmail
	 * @param monitorName
	 * @param monitorEmail
	 * @param department
	 * @param group
	 */
	public void addSubject(String nrc, String name, int credits, String teacherName, int enrolledStudent,
			String teacherEmail, String monitorName, String monitorEmail, String department, int group) {
		
		Subject subject = new Subject(nrc, name, credits, teacherName, enrolledStudent, teacherEmail, monitorName, monitorEmail, department, group);
		subj.put(nrc, subject);
	}


	public HashMap<String, Subject> getSubj() {
		return subj;
	}

	public void setSubj(HashMap<String, Subject> subj) {
		this.subj = subj;
	}
	
	
	/**
	 *  Permite buscar una materia de un contacto.
	 * @param nrc
	 * @return
	 */
	public Subject searchSubject(String nrc) {
		Subject subject = null;
		for (Subject s: subj.values()) {
			if (s.getNrc().equals(nrc)) {
				subject = s;
			}
		}
		return subject;
	}

	/**
	 * Este metodo se encarga de eliminar los contactos
	 * @param nrc
	 */
	public void deleteSubject(String nrc) {
		Subject subject = searchSubject(nrc);
		if(subject != null) {
			subj.remove(nrc);
		}
	}


	public String showSubjectByNrc(String nrc) {
		String msg = " ";
		msg = subj.get(nrc).toString();
		return msg;
	}

	

	@Override
	public String toString() {
		return "Contact [name=" + name + ", lastName=" + lastName + ", telephone=" + telephone + ", email=" + email
				+ ", id=" + id + ", semester=" + semester + ", avatar=" + avatar + ", birthday=" + bornDate + ", age="
				+ age + ", program=" + program + ", subjects=" + subj + "]";
	}

}



/**
public void modifySubject(String name, int nrc, int enrolledStudent, String teacherName, String teacherEmail,
		String monitorName, String monitorEmail, String department, int group) {
	Subject objS = searchSubject(nrc);
	if (objS != null) {
		objS.setName(name);
		objS.setNrc(nrc);
		objS.setTeacherName(teacherName);
		objS.setTeacherEmail(teacherEmail);
		objS.setMonitorName(monitorName);
		objS.setMonitorEmail(monitorEmail);
		objS.setDepartment(department);
		objS.setGroup(group);
	} else {

	}

}

*/
/**
public void addSubject(String name, int nrc, int enrolledStudent, String teacherName, String teacherEmail,
		String monitorName, String monitorEmail, String department, int group) {
	Subject subject = searchSubject(nrc);
	if (subject == null) {
		subject = new Subject(name, nrc, enrolledStudent, teacherName, teacherEmail, monitorName, monitorEmail,
				department, group);

		// subjects.add(subject);

		subj.put(nrc, subject);

	}
}

*/
/*
 * public List<Subject> getSubjects() { return subjects; }
 * 
 * public void setSubjects(List<Subject> subjects) { this.subjects = subjects; }
 */



/**
public Subject searchSubject(int nrc) {
	Subject objSubject = null;
	// for(int i = 0; i < subjects.size(); i++) {
	if (subj.get(nrc).getNrc() == nrc) {
		objSubject = new Subject(subj.get(nrc).getName(), subj.get(nrc).getNrc(),
				subj.get(nrc).getEnrolledStudent(), subj.get(nrc).getTeacherName(), subj.get(nrc).getTeacherEmail(),
				subj.get(nrc).getMonitorName(), subj.get(nrc).getMonitorEmail(), subj.get(nrc).getDepartment(),
				subj.get(nrc).getGroup());
	} else {

	}
	// }
	return objSubject;
}

*/