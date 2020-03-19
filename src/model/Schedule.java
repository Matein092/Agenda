package model;

import exceptions.ExistStudentException;
import exceptions.NoExistContactException;
import exceptions.NotExistSubjectException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schedule {

	// Association
	
	public final static String STUDENTS_PATH = ".\\data\\Students.csv";
	public final static String COURSES_PATH = ".\\data\\Courses.csv";
	public final static String SCHEDULE_JOIN =".\\data\\Join.csv"; 
	
	private Contact contact;
	private Map<String, Contact> contacts;
	private ArrayList<Join> join;

	// Constructor
	public Schedule() throws NumberFormatException, IOException  {
		contacts = new HashMap<String, Contact>();
		contact = new Contact();
		join = new ArrayList<Join>();
		readJoin();
		chargeData();
	
	}
	
	
	
	
	
	private void readJoin() throws NumberFormatException, IOException {
		BufferedReader bF = new BufferedReader(new FileReader(SCHEDULE_JOIN));
		String line = bF.readLine();
		while ((line = bF.readLine()) != null) {
				String[] data = line.split(";");
				String id = data[0];
				String nrc = data[1];
				join.add(new Join(id, nrc));		
		}
		bF.close();
	}
	
	
	
	@SuppressWarnings("unused")
	public List<Subject> searchSubjectByContact(String id) throws NotExistSubjectException{
		
		
		List<Subject> subjects = new ArrayList<Subject>();
		int i = 0;
		 while(i < join.size()) {
			 if(join.get(i).getId().equals(id)) {
				 Subject subject = contact.searchSubject(join.get(i).getNrc());
				 if(subject != null) {
					 subjects.add(subject);
				 }
			 }
			 
			 i++;
		 }
		 
		 if(subjects == null) {
			 throw new NoExistContactException();
		 }
		 return subjects;
		
	}
	
	
	
	// Métodos

	/**
	 * Carga los datos de los estudiantes.
	 * @throws NumberFormatException 
	 * @throws IOException - error que se lanza si el archivo con los datos de los estudiantes no se encuentra.
	 */
	public void chargeData() throws NumberFormatException, IOException {

		BufferedReader bF = new BufferedReader(new FileReader(STUDENTS_PATH));
		String line = bF.readLine();
		Contact contact;
		while ((line = bF.readLine()) != null) {
				String[] data = line.split(";");
				
				String id = data[0];
				String name = data[1];
				String lastName = data[2];
				String telephone = data[3];
				String email = data[4];
				int semester = Integer.parseInt(data[5]);
				String avatar = data[6];
				String bornDate = data[7];
				int age = Integer.parseInt(data[8]);
				String program = data[9];
		
				// Add Contact
				contact = new Contact(id, name, lastName, telephone, email, semester, avatar, bornDate, age, program);
				contacts.put(contact.getId(), contact);
				//Carga la información de la materia.
				chargeDataSubject();
		}
		bF.close();
		
		
	}

	private void chargeDataSubject() throws IOException {
		BufferedReader bF = new BufferedReader(new FileReader(COURSES_PATH));
		String line = bF.readLine();
		
		while ((line = bF.readLine()) != null) {
				String[] data = line.split(";");
				
				String nrc = data[0];
				String name = data[1];
				int credits = Integer.parseInt(data[2]);
				String teacherName = data[3];
				int enrolledStudent = Integer.parseInt(data[4]);
				String teacherEmail = data[5];
				String monitorName = data[6];
				String monitorEmail = data[7];
				String department = data[8];
				int group = Integer.parseInt(data[9]);
		
				// Add Subject
				
				contact.addSubject(nrc, name, credits, teacherName, enrolledStudent, teacherEmail, monitorName, monitorEmail, department, group);
				
			
		}
		bF.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Busca un estudiante por su código
	 * @param id - El código del estudiante.
	 * @throws NoExistContactException - Error que se lanza si no se encuentra el estudiante.
	 * @return - devuelve el estudiante con el código dado.
	 * 
	 */
	public Contact searchById(String id){
		Contact objContact = null;
		for (Contact cont: contacts.values()) {
			if (cont.getId().equals(id)) {
				objContact = cont;
			}

		}
		return objContact;
	}

	/**
	 * Busca un estudiante a partir de la fecha de nacimiento.
	 * @param bornDate - La fecha de nacimiento.
	 * @return - El estudiante.
	 */
	public Contact searchByBornDate(String bornDate) {
		Contact objContact = null;
		for (Contact cont : contacts.values()) {
			if (cont.getBornDate().equals(bornDate)) {
				objContact = cont;
			}
		}
		return objContact;
	}
	
	/**
	 * Busca un estudiante a partir del nombre.
	 * @param name - El nombre.
	 * @return - El estudiante.
	 */
	public Contact searchByName(String name) {
		Contact objContact = null;
		for (Contact cont : contacts.values()) {
			if (cont.getName().equals(name)) {
				objContact = cont;
			}
		}
		return objContact;
	}

	/**
	 * Busca un estudiante a partir del apellido.
	 * @param lastName - El apellido.
	 * @return - El estudiante.
	 */
	public Contact searchByLastName(String lastName) {
		Contact objContact = null;
		for (Contact cont : contacts.values()) {
			if (cont.getLastName().equals(lastName)) {
				objContact = cont;
			}
		}
		return objContact;
	}

	/**
	 * modifica los datos de un estudiante.
	 * @param name - El nuevo nombre.
	 * @param lastName - El nuevo apellido.
	 * @param telephone - El nuevo telefono.
	 * @param email - El nuevo correo electronico.
	 * @param id - El nuevo código.
	 * @param semester -El nuevo semestre.
	 * @param avatar - La nueva foto.
	 * @param bornDate - La nueva fecha de nacimiento.
	 * @param age - La nueva edad.
	 * @param program - El nuevo programa.
	 */
	public void modifyContact(String currentId, String name, String lastName, String telephone, String email, String id, int semester,
			String avatar, String bornDate, int age, String program) throws NullPointerException {
		Contact objC = searchById(currentId);
		deleteContact(currentId);
		if (objC != null) {
			deleteContact(id);
			objC.setName(name);
			objC.setLastName(lastName);
			objC.setTelephone(telephone);
			objC.setEmail(email);
			objC.setId(id);
			objC.setSemester(semester);
			objC.setAvatar(avatar);
			objC.setAge(age);
			objC.setBornDate(bornDate);
			objC.setProgram(program);
		}
		contacts.put(objC.getId(), objC);
	}

	/**
	 * Elimina un estudiante a partir de su código.
	 * @param id - El código del estudiante.
	 */
	public void deleteContact(String id) {
		Contact contact = searchById(id);
		if (contact != null) {
			contacts.remove(id);
		}
	}

	/**
	 * Agrega un nuevo estudiante.
	 * @param name -El nombre.
	 * @param lastName -El apellido.
	 * @param telephone - El telefono.
	 * @param email - El correo electrónico.
	 * @param id - El código.
	 * @param semester - El semestre.
	 * @param avatar - La foto
	 * @param bornDate - La fecha de nacimiento. 
	 * @param age - La edad.
	 * @param program - El programa.
	 * @throws ExistStudentException 
	 */
	public void addContact(String name, String lastName, String telephone, String email, String id, int semester,
			String avatar, String bornDate, int age, String program) throws ExistStudentException {
		Contact contact = searchById(id);
		if (contact == null) {
			contact = new Contact(name, lastName, telephone, email, id, semester, avatar, bornDate, age, program);
			contacts.put(contact.getId(), contact);
		}else if(contact != null) {
			throw new ExistStudentException();
		}
		
	}

	/**
	 * 
	 * @param a     Array with all the subjects of all the students
	 * @param first
	 * @param last
	 * @return nrc of the most repeated subject
	 */
	public int mode(int a[], int first, int last) {
		int i, frec, maxfrec, moda;
		if (first == last)
			return a[first];
		moda = a[first];
		maxfrec = frequency(a, a[first], first, last);
		for (i = first + 1; i <= last; i++) {
			frec = frequency(a, a[i], i, last);
			if (frec > maxfrec) {
				maxfrec = frec;
				moda = a[i];
			}
		}
		return moda;
	}

	/**
	 * 
	 * @param a
	 * @param p
	 * @param first
	 * @param last
	 * @return
	 */
	private int frequency(int[] a, int p, int first, int last) {
		int sum;
		if (first > last)
			return 0;
		sum = 0;
		for (int i = first; i <= last; i++)
			if (a[i] == p)
				sum++;

		return sum;
	}

	/**
	 * Devuelve la colección de estudiantes.
	 */
	public Map<String, Contact> getContacts() {
		return contacts;
	}





	public Contact getContact() {
		return contact;
	}





	public void setContact(Contact contact) {
		this.contact = contact;
	}

	
	
	
}
