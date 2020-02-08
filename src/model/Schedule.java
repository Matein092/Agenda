package model;

import java.io.*;
import java.util.*;

import exceptions.ExistStudentException;
import exceptions.NoExistContactException;
import exceptions.NotLoadStudentsException;

public class Schedule {

	// Association
	
	public final static String STUDENTS_PATH = ".\\data\\Students.csv";
	public final static String COURSES_PATH = ".\\data\\Courses.csv";

	private HashMap<Integer, Contact> contacts;
	private int size;

	// Constructor
	public Schedule() {
		contacts = new HashMap<Integer, Contact>();
	}

	// Métodos

	/**
	 * Carga los datos de los estudiantes.
	 * @throws IOException - error que se lanza si el archivo con los datos de los estudiantes no se encuentra.
	 */
	public void chargeData() throws IOException {

		BufferedReader bF = new BufferedReader(new FileReader(STUDENTS_PATH));
		String line = "";
		Contact contact;
		while ((line = bF.readLine()) != null) {
			if (line.charAt(0) != '#') {
				String[] data = line.split(";");
				contact = new Contact(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), data[6],
						data[7], Integer.parseInt(data[8]), data[9]);
				size++;
				int index = size - 1;
				contacts.put(index, contact);
			}
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
		if (contacts.get(id) != null && contacts.get(id).getId() == id) {
			objContact = contacts.get(id);
		}
		return objContact;
	}

	/**
	 * Busca un estudiante a partir de la fecha de nacimiento.
	 * @param bornDate - La fecha de nacimiento.
	 * @return - El estudiante.
	 * @throws NoExistContactException - Si el estudiante no existe.
	 */
	public Contact searchByBornDate(String bornDate) throws NoExistContactException {
		Contact objContact = null;
		if (contacts.get(bornDate).getBornDate() == bornDate) {
			objContact = new Contact(contacts.get(bornDate).getName(), contacts.get(bornDate).getLastName(),
					contacts.get(bornDate).getTelephone(), contacts.get(bornDate).getEmail(),
					contacts.get(bornDate).getId(), contacts.get(bornDate).getSemester(),
					contacts.get(bornDate).getAvatar(), contacts.get(bornDate).getBornDate(),
					contacts.get(bornDate).getAge(), contacts.get(bornDate).getProgram());
		} else {
			throw new NoExistContactException();
		}
		return objContact;
	}
	
	/**
	 * Busca un estudiante a partir del nombre.
	 * @param name - El nombre.
	 * @return - El estudiante.
	 * @throws NoExistContactException - Si el estudiante no existe.
	 */
	public Contact searchByName(String name) throws NoExistContactException {
		Contact objContact = null;
		if (contacts.get(name).getEmail() == name) {
			objContact = new Contact(contacts.get(name).getName(), contacts.get(name).getLastName(),
					contacts.get(name).getTelephone(), contacts.get(name).getEmail(), contacts.get(name).getId(),
					contacts.get(name).getSemester(), contacts.get(name).getAvatar(), contacts.get(name).getBornDate(),
					contacts.get(name).getAge(), contacts.get(name).getProgram());
		} else {
			throw new NoExistContactException();
		}
		return objContact;
	}

	/**
	 * Busca un estudiante a partir del apellido.
	 * @param lastName - El apellido.
	 * @return - El estudiante.
	 * @throws NoExistContactException - Si el estudiante no existe.
	 */
	public Contact searchByLastName(String lastName) throws NoExistContactException {
		Contact objContact = null;
		if (contacts.get(lastName).getEmail() == lastName) {
			objContact = new Contact(contacts.get(lastName).getName(), contacts.get(lastName).getLastName(),
					contacts.get(lastName).getTelephone(), contacts.get(lastName).getEmail(),
					contacts.get(lastName).getId(), contacts.get(lastName).getSemester(),
					contacts.get(lastName).getAvatar(), contacts.get(lastName).getBornDate(),
					contacts.get(lastName).getAge(), contacts.get(lastName).getProgram());
		} else {
			throw new NoExistContactException();
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
	public void modifyContact(String name, String lastName, String telephone, String email, String id, int semester,
			String avatar, String bornDate, int age, String program) {
		Contact objC = searchById(id);
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
		contacts.put(contacts.size() - 1, objC);
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
		size--;
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
			size++;
			int index = size - 1;
			contacts.put(index, contact);
			System.out.println("Guardado");
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
	 * Devuelve el tamanio de la colección de estudiantes.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Devuelve la colección de estudiantes.
	 */
	public HashMap<Integer, Contact> getContacts() {
		return contacts;
	}

}
