package model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubjectTest {

	/**
	 * Relación con subject
	 */
	private Subject subject;
	
	private void setupEscenary1(){
		
		String name = "Matematicas discretas";
		String nrc = "5673890A";
		int enrolledStudent = 20;
		String teacherName = "Anibal Camacho";
		String teacherEmail = "anibalC@gmail.com";
		String monitorName = "Mateo Zuluaga";
		String monitorEmail = "matezu@hotmail.com";
		String department = "Departamento TIC";
		int group = 9;
		
		subject = new Subject(name, nrc, enrolledStudent, teacherName, teacherEmail, monitorName, monitorEmail, department, group);
	}
	
	
	private void setupEscenary2(){
		String name = "Estructura de datos";
		String nrc ="567890E";
		int enrolledStudent = 25;
		String teacherName = "Camilo Maldonado";
		String teacherEmail = "cMal@gmail.com";
		String monitorName = "Eliecer Marin";
		String monitorEmail ="elimar@gmail.com";
		String department = "Departamento TIC";
		int group = 5;

		subject = new Subject(name, nrc, enrolledStudent, teacherName, teacherEmail, monitorName, monitorEmail, department, group);
	
	}
	
	/**
	 * Escenario nulo
	 */
	private void setupEscenary3() {
		subject = null;
	}
	
	
	
	
	/**
	 * Verifica que el metodo getName retorna correctamente el nombre de la materia
	 */
	@Test
	public void checkGetNameTest() {
		// Test 1
		setupEscenary1();
		assertEquals("Matematicas discretas", subject.getName());
		// Test 2
		setupEscenary2();
		assertEquals("Estructura de datos", subject.getName());
		// Test 3
		setupEscenary3();
		assertNull("No se ha instanciado un objecto de la clase Subject", subject);
	}
	
	
	/**
	 * Verifica que el método setName cambia correctamente el nombre de la materia.
	 */
	@Test
	public void checkSetNameTest() {
		// Test 1
		setupEscenary1();
		assertEquals("Matematicas discretas", subject.getName());
		// Modificar nombre del contacto
		subject.setName("Fundamentos de derecho");
		assertEquals("Fundamentos de derecho", subject.getName());
		assertFalse(subject.getName().equalsIgnoreCase("Matematicas discretas"));
		
		
		// Test 2
		setupEscenary2();
		assertEquals("Estructura de datos", subject.getName());
		// Modificar nombre del contacto
		subject.setName("Ingenieria de procesos");
		assertEquals("Ingenieria de procesos", subject.getName());
		assertFalse(subject.getName().equalsIgnoreCase("Matematicas discretas"));
		
		// Test 3
		setupEscenary3();
		assertNull("No se ha instanciado un objecto de la clase Subject", subject);
		
	}
	
	/**
	 * Verifica que el metodo getNrc retorna correctamente el nrc de la materia
	 */
	
	@Test
	public void checkGetNrc() {
		//Test 1
		setupEscenary1();
		assertEquals("5673890A", subject.getNrc());
		//Test 2
		setupEscenary2();
		assertEquals("567890E", subject.getNrc());
		// Test 3
		setupEscenary3();
		assertNull("No se ha instanciado un objecto de la clase Subject", subject);		
	}
	
	
	/**
	 * Verifica que el método setNRC cambia correctamente el nombre de la materia.
	 */
	@Test 
	public void checkSetNrc() {
				//Test 1
				setupEscenary1();
				assertEquals("5673890A", subject.getNrc());
				//Modifica el nrc de la materia
				subject.setNrc("5673342E");
				assertEquals("5673342E", subject.getNrc());
				assertNotEquals("5673890A", subject.getNrc());
				
				//Test 2
				setupEscenary2();
				assertEquals("567890E", subject.getNrc());
				//Modifica el nrc de la materia
				subject.setNrc("4567890A");
				assertEquals("4567890A", subject.getNrc());
				assertNotEquals("567890E", subject.getNrc());
				
				// Test 3
				setupEscenary3();
				assertNull("No se ha instanciado un objecto de la clase Subject", subject);	
	}
	
	/**
	 * Verifica que el metodo getTeacherName retorna correctamente el nombre del profesor.
	 */
	@Test
	public void checkGetTeacherName() {
		//Test 1
		setupEscenary1();
		assertEquals("Anibal Camacho", subject.getTeacherName());
		//Test 2
		setupEscenary2();
		assertEquals("Camilo Maldonado", subject.getTeacherName());
		// Test 3
		setupEscenary3();
		assertNull("No se ha instanciado un objecto de la clase Subject", subject);		
	}
	
	
	/**
	 * Verifica que el método setTeacherName cambia correctamente el nombre del profesor.
	 */
	@Test
	public void checkSetTeacherName() {
				//Test 1
				setupEscenary1();
				assertEquals("Anibal Camacho", subject.getTeacherName());
				
				//Modifica el nombre del profesor que dicta la materia
				subject.setTeacherName("Laura Moreno");
				assertEquals("Laura Moreno", subject.getTeacherName());
				assertNotEquals("Anibal Camacho", subject.getTeacherName());
				
				
				//Test 2
				setupEscenary2();
				assertEquals("Camilo Maldonado", subject.getTeacherName());
				//Modifica el nombre del profesor que dicta la materia
				subject.setTeacherName("Maria Mina");
				assertEquals("Maria Mina", subject.getTeacherName());
				assertNotEquals("Camilo Maldonado", subject.getTeacherName());
				
				// Test 3
				setupEscenary3();
				assertNull("No se ha instanciado un objecto de la clase Subject", subject);		
	}
	
	
	/**
	 * Verifica que el método getEnrolledStudent retorna el número de estudiantes matriculados en el curso
	 */
	@Test
	public void checkGetEnrolledStuden() {
		//Test 1
		setupEscenary1();
		assertEquals(20, subject.getEnrolledStudent());
	
		
		//Test 2
		setupEscenary2();
		assertEquals(25, subject.getEnrolledStudent());
		
		// Test 3
		setupEscenary3();
		assertNull("No se ha instanciado un objecto de la clase Subject", subject);	
	}
	
	/**
	 * Verifica que el método setEnrolledStudent cambia correctamente el número de estudiantes matriculados en el curso.
	 */
	@Test
	public void checkSetEnrolledStuden() {
		//Test 1
		setupEscenary1();
		assertEquals(20, subject.getEnrolledStudent());
		
		//Modifica el numero de estudiantes pertenecientes a una materia
		subject.setEnrolledStudent( 30 );
		assertEquals(30, subject.getEnrolledStudent());
		assertNotEquals(20, subject.getEnrolledStudent());
		
		
		//Test 2
		setupEscenary2();
		assertEquals(25, subject.getEnrolledStudent());
		//Modifica el numero de estudiantes pertenecientes a una materia
		subject.setEnrolledStudent( 18 );
		assertEquals(18, subject.getEnrolledStudent());
		assertNotEquals(25, subject.getEnrolledStudent());

		// Test 3
		setupEscenary3();
		assertNull("No se ha instanciado un objecto de la clase Subject", subject);		
	}

	/**
	 *  Verifica que el método getTeacherEmail retorna correctamente el correo electrónico del profesor.
	 */
	@Test
	public void checkgetTeacherEmail() {
			//Test 1
			setupEscenary1();
			assertEquals("anibalC@gmail.com", subject.getTeacherEmail());
			
			//Test 2
			setupEscenary2();
			assertEquals("cMal@gmail.com", subject.getTeacherEmail());
			// Test 3
			setupEscenary3();
			assertNull("No se ha instanciado un objecto de la clase Subject", subject);		
	
	}
	
	/**
	 * Verifica que el método setTeacherEmail cambia correctamente el correo electrónico del profesor.
	 */
	@Test
	public void checkSetTeacherEmail() {
			//Test 1
			setupEscenary1();
			assertEquals("anibalC@gmail.com", subject.getTeacherEmail());
			
			//Modifica el correo electronico del profesor que dicta el curso
			subject.setTeacherEmail("adna@gmailcom");
			assertEquals("adna@gmailcom", subject.getTeacherEmail());
			assertNotEquals("anibalC@gmail.com", subject.getTeacherEmail());
			//Test 2
			setupEscenary2();
			assertEquals("cMal@gmail.com", subject.getTeacherEmail());
			
			//Modifica el correo electronico del profesor que dicta el curso
			subject.setTeacherEmail("moa@gmailcom");
			assertEquals("moa@gmailcom", subject.getTeacherEmail());
			assertNotEquals("cMal@gmail.com", subject.getTeacherEmail());
			// Test 3
			setupEscenary3();
			assertNull("No se ha instanciado un objecto de la clase Subject", subject);		
	
	}
	

	/**
	 * Verifica que el método getMonitorName retorna correctamente el nombre del monitor del curso.
	 */
	@Test
	public void checkGetMonitorName() {
		//Test 1
		setupEscenary1();
		assertEquals("Mateo Zuluaga", subject.getMonitorName());
		
		//Test 2
		setupEscenary2();
		assertEquals("Eliecer Marin", subject.getMonitorName());
		// Test 3
		setupEscenary3();
		assertNull("No se ha instanciado un objecto de la clase Subject", subject);				
	}
	/**
	 * Verifica que el método setMonitorName cambia correctamente el nombre del monitor del curso.
	 */
	@Test
	public void checkSetMonitorName() {
		//Test 1
		setupEscenary1();
		assertEquals("Mateo Zuluaga", subject.getMonitorName());
		
		//Modifica el nombre del monitor del curso.
		subject.setMonitorName("Juan David");
		assertEquals("Juan David", subject.getMonitorName());
		assertNotEquals("Mateo Zuluaga", subject.getMonitorName());
		//Test 2
		setupEscenary2();
		assertEquals("Eliecer Marin", subject.getMonitorName());
		
		//Modifica el nombre del monitor del curso.
		subject.setMonitorName("Lorena moreno");
		assertEquals("Lorena moreno", subject.getMonitorName());
		assertNotEquals("Eliecer Marin", subject.getMonitorName());
		// Test 3
		setupEscenary3();
		assertNull("No se ha instanciado un objecto de la clase Subject", subject);				
	}
	
	/**
	 * Verifica que el método getMonitorEmail retorna correctamente el email del monitor del curso.
	 */
	@Test
	public void checkGetMonitorEmail() {
		setupEscenary1();
		assertEquals("matezu@hotmail.com", subject.getMonitorEmail());
		
		//Test 2
		setupEscenary2();
		assertEquals("elimar@gmail.com", subject.getMonitorEmail());
		// Test 3
		setupEscenary3();
		assertNull("No se ha instanciado un objecto de la clase Subject", subject);
	}
	
	
	/**
	 * Verifica que el método setMonitorEmail cambia correctamente el email del monitor del curso.
	 */
	@Test
	public void checkSetMonitorEmail() {
		setupEscenary1();
		assertEquals("matezu@hotmail.com", subject.getMonitorEmail());
		//Modifica el email del monitor del curso.
		subject.setMonitorEmail("asldkad@gmail.com");
		assertEquals("asldkad@gmail.com", subject.getMonitorEmail());
		assertNotEquals("matezu@hotmail.com", subject.getMonitorEmail());
		
		//Test 2
		setupEscenary2();
		assertEquals("elimar@gmail.com", subject.getMonitorEmail());
		// Test 3
		setupEscenary3();
		assertNull("No se ha instanciado un objecto de la clase Subject", subject);
		
	}
	
	
	/**
	 * Verifica que el método getDepartment retorna correctamente el departamento al cual pertenece el curso.
	 */
	@Test
	public void checkGetDepartament() {
		//Test 1
		setupEscenary1();
		assertEquals("Departamento TIC", subject.getDepartment());
		
		//Test 2
		setupEscenary2();
		assertEquals("Departamento TIC", subject.getDepartment());
		// Test 3
		setupEscenary3();
		assertNull("No se ha instanciado un objecto de la clase Subject", subject);
	}
	
	/**
	 * Verifica que el método setDepartment cambia correctamente el departamento al cual pertenece el curso.
	 */
	@Test
	public void checkSetDepartament() {
		setupEscenary1();
		
		setupEscenary1();
		assertEquals("Departamento TIC", subject.getDepartment());
		
		//Modifica el departamento al que pertenece el curso.
		subject.setDepartment("Derecho");
		assertEquals("Derecho", subject.getDepartment());
		assertNotEquals("Departamento TIC", subject.getDepartment());
		
		//Test 2
		setupEscenary2();
		assertEquals("Departamento TIC", subject.getDepartment());
		//Modifica el departamento al que pertenece el curso.
		subject.setDepartment("Estadistica");
		assertEquals("Estadistica", subject.getDepartment());
		assertNotEquals("Departamento TIC", subject.getDepartment());
		
		// Test 3
		setupEscenary3();
		assertNull("No se ha instanciado un objecto de la clase Subject", subject);
		
	}
	
	
	/**
	 * Verifica que el método getGroup retorna correctamente el grupo al cual pertenece el curso.
	 */
	@Test
	public void checkGetGroup() {
		//Test 1
		setupEscenary1();
		assertEquals(9, subject.getGroup());
		
		//Test 2
		setupEscenary2();
		assertEquals(5, subject.getGroup());
		// Test 3
		setupEscenary3();
		assertNull("No se ha instanciado un objecto de la clase Subject", subject);
	}
	
	/**
	 * Verifica que el método setGroup cambia correctamente el grupo al cual pertenece el curso.
	 */
	@Test
	public void checkSetGroup() {
		//Test 1
		setupEscenary1();
		assertEquals(9, subject.getGroup());
		
		//Modifica el grupo al que pertenece el curso.
		subject.setGroup(9);
		assertEquals(9, subject.getGroup());

		//Test 2
		setupEscenary2();
		assertEquals(5, subject.getGroup());
	
		//Modifica el grupo al que pertenece el curso.
		subject.setGroup(1);
		assertEquals(1, subject.getGroup());
		assertNotEquals(9, subject.getGroup());
		// Test 3
		setupEscenary3();
		assertNull("No se ha instanciado un objecto de la clase Subject", subject);
	}
	
	

}