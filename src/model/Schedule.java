package model;

import exceptions.ExistStudentException;
import exceptions.NoExistContactException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Schedule {

	// Association
	
	public final static String STUDENTS_PATH = ".\\data\\Students.csv";



	private Map<String, Contact> contacts;

	// Constructor
	public Schedule() throws IOException {
		contacts = new HashMap<String, Contact>();
		chargeData();
	}

	// Métodos

	/**
	 * Carga los datos de los estudiantes.
	 * @throws IOException - error que se lanza si el archivo con los datos de los estudiantes no se encuentra.
	 */
	public void chargeData() throws IOException {

		BufferedReader bF = new BufferedReader(new FileReader(STUDENTS_PATH));
		String line = "";
		Contact contact = null;
		while ((line = bF.readLine()) != null) {
			if (line.charAt(0) != '#') {
				String[] data = line.split(";");
				contact = new Contact(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), data[6],
						data[7], Integer.parseInt(data[8]), data[9]);
				loadNRCs(data[11],contact);
				contact.loadSubjects();
				contacts.put(contact.getId(), contact);
			}
		}
		bF.close();
	}

	private void loadNRCs(String data, Contact contact){
		String[] nrcs = data.split(",");
		for (int i = 0; i < contact.getNrcs().size(); i++) {
			contact.getNrcs().add(nrcs[i]);
		}

	}


	public void saveData() throws IOException {
		FileWriter writer = new FileWriter(STUDENTS_PATH);

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

}
