
package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import exceptions.ExistStudentException;
import java.io.IOException;

class ScheduleTest {

	
	private Schedule schedule;
	private Contact contact;
	private Contact contact1;
	private Contact contact2;
	private Contact contact3;
	
	private void setupEscenary1() {
		try {
			schedule = new Schedule();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Datos del contacto 1.
		String name = "Leonardo";
		String lastName = "Davinchi";
		String telephone = "456789034";
		String email = "leo1999@hotmail.com";
		String id = "A00389404";
		int semester = 5;
		String bornDate = "17/09/1999";
		int age = 19;
		String program = "Mercadeo";
		String avatar = "93wekodqmdqe@gmail.com";
		
		// Se instancia un objecto de la clase contact.
		contact = new Contact(name, lastName, telephone, email, id, semester, avatar, bornDate, age, program);
		// Se agrega un contacto al la tabla Hash.
		schedule.getContacts().put(id, contact);
		
		// Datos del contacto 2.
		String name1 = "Laura";
		String lastName1 = "Riascos";
		String telephone1 = "49613221";
		String email1 = "laurorias19@gmail.com";
		String id1 = "E5541502";
		int semester1 = 2;
		String bornDate1 = "17/09/1999";
		int age1 = 20;
		String program1 = "Diseño de medios interativos";
		String avatar1 = "4w546789u80i9k.com";
		
		// Se instancia un objecto de la clase contact.
		contact1 = new Contact(name1, lastName1, telephone1, email1, id1, semester1, avatar1, bornDate1, age1, program1);
		// Se agrega un contacto al la tabla Hash.
		schedule.getContacts().put(id1, contact1);
		
		// Datos del contacto 3.
		String name2 = "Camilo";
		String lastName2 = "Garces";
		String telephone2 = "457967553";
		String email2 = "camilo1990@gmail.com";
		String id2 = "A0045404";
		int semester2 = 9;
		String bornDate2 = "14/12/1990";
		int age2 = 25;
		String program2 = "Derecho";
		String avatar2 = "ydhujadkasd.com";
		
		// Se instancia un objecto de la clase contact.
		contact2 = new Contact(name2, lastName2, telephone2, email2, id2, semester2, avatar2, bornDate2, age2, program2);
		// Se agrega un contacto al la tabla Hash.
		schedule.getContacts().put(id2, contact2);
		
		// Datos del contacto 4.
		String name3 = "Laura";
		String lastName3 = "Sanchez";
		String telephone3 = "4435367553";
		String email3 = "laurosa19@gmail.com";
		String id3 = "A0050104";
		int semester3 = 5;
		String bornDate3 = "12/10/1996";
		int age3 = 25;
		String program3 = "Diseño de medios interactivos";
		String avatar3 = "kadjdakdsjadkasd.com";
		
		// Se instancia un objecto de la clase contact.
		contact2 = new Contact(name3, lastName3, telephone3, email3, id3, semester3, avatar3, bornDate3, age3, program3);
		// Se agrega un contacto al la tabla Hash.
		schedule.getContacts().put(id3, contact3);
		
	}
	
	
	
	private void setupEscenary2() {
		try {
			schedule = new Schedule();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Datos del contacto 1.
		String name = "Leonardo";
		String lastName = "Davinchi";
		String telephone = "456789034";
		String email = "leo1999@hotmail.com";
		String id = "A00389404";
		int semester = 5;
		String bornDate = "17/09/1999";
		int age = 19;
		String program = "Mercadeo";
		String avatar = "93wekodqmdqe@gmail.com";
		
		// Se instancia un objecto de la clase contact.
		contact = new Contact(name, lastName, telephone, email, id, semester, avatar, bornDate, age, program);
		// Se agrega un contacto al la tabla Hash.
		schedule.getContacts().put(id, contact);
		
		// Datos del contacto 2.
		String name1 = "Laura";
		String lastName1 = "Riascos";
		String telephone1 = "49613221";
		String email1 = "laurorias19@gmail.com";
		String id1 = "E5541502";
		int semester1 = 2;
		String bornDate1 = "17/09/1999";
		int age1 = 20;
		String program1 = "Diseño de medios interativos";
		String avatar1 = "4w546789u80i9k.com";
		
		// Se instancia un objecto de la clase contact.
		contact1 = new Contact(name1, lastName1, telephone1, email1, id1, semester1, avatar1, bornDate1, age1, program1);
		// Se agrega un contacto al la tabla Hash.
		schedule.getContacts().put(id1, contact1);
		
		// Datos del contacto 3.
		String name2 = "Camilo";
		String lastName2 = "Garces";
		String telephone2 = "457967553";
		String email2 = "camilo1990@gmail.com";
		String id2 = "A0045404";
		int semester2 = 9;
		String bornDate2 = "14/12/1990";
		int age2 = 25;
		String program2 = "Derecho";
		String avatar2 = "ydhujadkasd.com";
		
		// Se instancia un objecto de la clase contact.
		contact2 = new Contact(name2, lastName2, telephone2, email2, id2, semester2, avatar2, bornDate2, age2, program2);
		// Se agrega un contacto al la tabla Hash.
		schedule.getContacts().put(id2, contact2);
		
		// Datos del contacto 4.
		String name3 = "Laura";
		String lastName3 = "Sanchez";
		String telephone3 = "4435367553";
		String email3 = "laurosa19@gmail.com";
		String id3 = "A0050104";
		int semester3 = 5;
		String bornDate3 = "12/10/1996";
		int age3 = 25;
		String program3 = "Diseño de medios interactivos";
		String avatar3 = "kadjdakdsjadkasd.com";
		
		// Se instancia un objecto de la clase contact.
		contact3 = new Contact(name3, lastName3, telephone3, email3, id3, semester3, avatar3, bornDate3, age3, program3);
		// Se agrega un contacto al la tabla Hash.
		schedule.getContacts().put(id3, contact3);
	}
	
	
	private void setupEscenary3() {
		try {
			schedule = new Schedule();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Datos del contacto 1.
		String name = "Juan Pablo";
		String lastName = "Romero";
		String telephone = "312354903";
		String email = "juaPa1999@hotmail.com";
		String id = "A20349124";
		int semester = 3;
		String bornDate = "15/03/1999";
		int age = 20;
		String program = "Quimica";
		String avatar = "fghjkkp3wekodqmdqe@gmail.com";
		
		// Se instancia un objecto de la clase contact.
		contact = new Contact(name, lastName, telephone, email, id, semester, avatar, bornDate, age, program);
		// Se agrega un contacto al la tabla Hash.
		schedule.getContacts().put(id, contact);
		
		// Datos del contacto 2.
		String name1 = "Laura";
		String lastName1 = "Riascos";
		String telephone1 = "49613221";
		String email1 = "laurorias19@gmail.com";
		String id1 = "E5541502";
		int semester1 = 2;
		String bornDate1 = "17/09/1999";
		int age1 = 20;
		String program1 = "Diseño de medios interativos";
		String avatar1 = "4w546789u80i9k.com";
		
		// Se instancia un objecto de la clase contact.
		contact1 = new Contact(name1, lastName1, telephone1, email1, id1, semester1, avatar1, bornDate1, age1, program1);
		// Se agrega un contacto al la tabla Hash.
		schedule.getContacts().put(id1, contact1);
		
		// Datos del contacto 3.
		String name2 = "Camilo";
		String lastName2 = "Garces";
		String telephone2 = "457967553";
		String email2 = "camilo1990@gmail.com";
		String id2 = "A0045404";
		int semester2 = 9;
		String bornDate2 = "14/12/1990";
		int age2 = 25;
		String program2 = "Derecho";
		String avatar2 = "ydhujadkasd.com";
		
		// Se instancia un objecto de la clase contact.
		contact2 = new Contact(name2, lastName2, telephone2, email2, id2, semester2, avatar2, bornDate2, age2, program2);
		// Se agrega un contacto al la tabla Hash.
		schedule.getContacts().put(id2, contact2);
		
		// Datos del contacto 4.
		String name3 = "Daniel";
		String lastName3 = "Molina";
		String telephone3 = "467553";
		String email3 = "danMolina89@gmail.com";
		String id3 = "A00453554";
		int semester3 = 9;
		String bornDate3 = "14/12/1989";
		int age3 = 26;
		String program3 = "Bioquimica";
		String avatar3 = "kadjdakdsjadkasd.com";
		
		// Se instancia un objecto de la clase contact.
		contact3 = new Contact(name3, lastName3, telephone3, email3, id3, semester3, avatar3, bornDate3, age3, program3);
		// Se agrega un contacto al la tabla Hash.
		schedule.getContacts().put(id3, contact3);
	}
	
	

	private void setupEscenary4() {
		try {
			schedule = new Schedule();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verifica que el método searchById busca un contacto bajo el criterio de su id.
	 */
	@Test
	public void checkSerchId() {
		// Test 1
		setupEscenary1();
		schedule.searchById("A0045404");
		assertEquals("A0045404", contact.getId());
		assertNotEquals("A0045404", contact1.getId());
		assertNotEquals("A0045404", contact2.getId());
		assertNotEquals("A0045404", contact3.getId());
		
		//Test 2
		setupEscenary2();
		assertNull(schedule.searchById("A00453554"));
		assertEquals("A00453554", contact.getId());
		assertNotEquals("A00453554", contact1.getId());
		assertNotEquals("A00453554", contact2.getId());
		assertNotEquals("A00453554", contact3.getId());
		
		//Test 3
		
		setupEscenary4();
		assertNull(schedule.searchById("A00453554"));
		assertEquals("A00453554", contact.getId());
		assertNotEquals("A00453554", contact1.getId());
		assertNotEquals("A00453554", contact2.getId());
		assertNotEquals("A00453554", contact3.getId());
	}
	
	
	/**
	 * Verifica que el método searchByBornDate busca un contacto bajo el criterio de la fecha de nacimiento
	 */
	@Test
	public void checSearchByBornDate() {
		// Test 1		
		assertEquals(contact3, schedule.searchByBornDate("12/11/1996"));
		
		//Test 2
		assertNull(schedule.searchByBornDate("12/11/1980"));
		setupEscenary4();
		assertNull(schedule.searchByBornDate("12/11/1980"));
	}
	
	/**
	 * Verifica que el método searchByName busca un contacto con su nombre.
	 */
	@Test
	public void searchByName() {
		//Test 1
		setupEscenary3();
		// buscar por nombre de contacto.
		assertEquals(contact,schedule.searchByName("Juan Pablo"));
		
		//Test 2
		setupEscenary2();
		//Cuando no se encuentra un contacto con ese nombre.
		assertNull(schedule.searchByName("Carolina"));
		
		//Test 3
		setupEscenary2();
		// buscar por nombre de contacto.
		assertEquals(contact1,schedule.searchByName("Laura"));
				
	}
	
	/**
	 * Verifica que el método searchByLastName busca un contacto con su nombre.
	 */
	@Test
	public void checkSearchByLastName() {
		//Test 1
		setupEscenary3();
		// buscar por apellido 
		assertEquals(contact,schedule.searchByName("Romero"));
		
		//Test 2
		setupEscenary2();
		//Cuando no se encuentra un contacto con ese apellido.
		assertNull(schedule.searchByName("Ruiz"));
		
		//Test 3
		setupEscenary2();
		// buscar por apellido
		assertEquals(contact1,schedule.searchByName("Riascos"));
		
	}
	
	/**
	 * Verifica que el metodo modifyContact modifica un contacto de acuerdo con su id.
	 */
	@Test 
	public void checkModifyContact() {
		//Test 1
		setupEscenary1();
		
		// Datos del contacto 
		String name = "Leonardo";
		String lastName = "Davinchi";
		String telephone = "456789034";
		String email = "leodan99@hotmail.com”";
		String id = "A00389404";
		int semester = 9;
		String bornDate = "17/09/1999";
		int age = 19;
		String program = "Mercadeo";
		String avatar = "93wekodqmdqe@gmail.com";
		// Se instancia un objecto de la clase contact.
		Contact test = new Contact(name, lastName, telephone, email, id, semester, avatar, bornDate, age, program);
		//Deben de ser diferentes porque estan modificados.
		assertNotEquals(test, contact);
        //Modificar contacto
		schedule.modifyContact(id, name, lastName, telephone, email, id, semester, avatar, bornDate, age, program);
		// Se verifican si los datos se cambiaron correctamente
		assertEquals("456789034", schedule.searchById("A00389404").getTelephone());
		assertEquals("eodan99@hotmail.com", schedule.searchById("A00389404").getEmail());
		assertEquals(9, schedule.searchById("A00389404").getSemester());
		
		//Test 2
		setupEscenary2();
		assertNull(schedule.searchById("A00453554"));
		
		setupEscenary1();
		
		String name2 = "Camilo";
		String lastName2 = "Garces";
		String telephone2 = "457967553";
		String email2 = "camilo1990@gmail.com";
		String id2 = "A0045404";
		int semester2 = 9;
		String bornDate2 = "14/12/1990";
		int age2 = 25;
		String program2 = "Derecho";
		String avatar2 = "ydhujadkasd.com";
		
		// Se instancia un objecto de la clase contact.
		Contact test1= new Contact(name2, lastName2, telephone2, email2, id2, semester2, avatar2, bornDate2, age2, program2);

		//Deben de ser diferentes porque estan modificados.
		assertNotEquals(test1, contact2);
        //Modificar contacto
		schedule.modifyContact(id2, name2, lastName2, telephone2, email2, id2, semester2, avatar2, bornDate2, age2, program2);
		// Se verifican si los datos se cambiaron correctamente
		assertEquals("camin99@hotmail.com", schedule.searchById("A0045404").getEmail());
		assertEquals("456789034", schedule.searchById("A0045404").getTelephone());
		
		
		//Test 3
		setupEscenary3();
		String name3 = "Daniel";
		String lastName3 = "Molina";
		String telephone3 = "467553";
		String email3 = "danMolina89@gmail.com";
		String id3 = "A00453554";
		int semester3 = 9;
		String bornDate3 = "14/12/1989";
		int age3 = 26;
		String program3 = "Bioquimica";
		String avatar3 = "kadjdakdsjadkasd.com";
		
		// Se instancia un objecto de la clase contact.
		Contact test3 = new Contact(name3, lastName3, telephone3, email3, id3, semester3, avatar3, bornDate3, age3, program3);
		//Deben de ser diferentes porque estan modificados.
		assertNotEquals(test3, contact3);
        //Modificar contacto
		schedule.modifyContact(id3, name3, lastName3, telephone3, email3, id3, semester3, avatar3, bornDate3, age3, program3);
		// Se verifican si los datos se cambiaron correctamente
		assertEquals("danMolina89@gmail.com", schedule.searchById(id3).getEmail());
		assertEquals("436477", schedule.searchById("id3").getTelephone());
		assertEquals(5, schedule.searchById("id3").getSemester());
	
	}
	
	/***
	 * Verifica que el método deleteContactById elimina un contacto de acuerdo con su id.
	 */
	@Test
	public void CheckDeleteContact() {
		
		//Test 1
		setupEscenary1();
		//Primero se elimina el contacto.
		schedule.deleteContact("A0045404");
		//Luego se busca por medio de su id para verificar la eliminación
		assertNull(schedule.searchById("A0045404"));
		
		
		//Test 2
		// si no encuentra el contacto.
		assertNull(schedule.searchById("A00453554"));
		
		//Test 3
		setupEscenary2();
		//Primero se elimina el contacto.
		schedule.deleteContact("A0050104");
		//Luego se busca por medio de su id para verificar la eliminación
		assertNull(schedule.searchById("A0050104"));
		
		
		//Test 4
		setupEscenary3();
		//Primero se elimina el contacto.
		schedule.deleteContact("A00453554");
		//Luego se busca por medio de su id para verificar la eliminación
		assertNull(schedule.searchById("A00453554"));
		
	}
	
	
	/**
	 * Verifica que el método addContact añade correctamente un contacto a la lista.
	 * @throws ExistStudentException Lanzara una expeción si el contacto ya existe en el sistema.
	 */
	@Test
	public void checkAddContact() throws ExistStudentException {
		// Datos del contacto .
		String name = "Carolina";
		String lastName = "Davinchi";
		String telephone = "354544813";
		String email = "caro202@gmail.com";
		String id = "A00856404";
		int semester = 5;
		String bornDate = "30/01/2000";
		int age = 19;
		String program = "Ingeniria de sistemas";
		String avatar = "ad1odqmdqel.com";
		
		schedule.addContact(name, lastName, telephone, email, id, semester, avatar, bornDate, age, program);
		
		assertNotNull(schedule.searchById("A00856404"));
		
		// Datos del contacto .
		String name1 = "Camilo";
		String lastName1 = "Moreno";
		String telephone1 = "457967553";
		String email1 = "camilo1990@gmail.com";
		String id1 = "A0045404";
		int semester1 = 5;
		String bornDate1 = "14/12/1990";
		int age1 = 28;
		String program1 = "Derecho";
		String avatar1 = "sadaddiadkdkad.com";
		
		schedule.addContact(name1, lastName1, telephone1, email1, id1, semester1, avatar1, bornDate1, age1, program1);
		
		assertNotNull(schedule.searchById("A0045404"));
		
	}
	
	
	


}
