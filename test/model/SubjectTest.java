package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import exceptions.ExistStudentException;
import java.io.IOException;

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
		int creditsHours = 3;

		subject = new Subject(name,nrc,teacherName,creditsHours);
		subject.setEnrolledStudent(enrolledStudent);

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
		int creditsHours = 3;

		subject = new Subject(name,nrc,teacherName,creditsHours);
		subject.setEnrolledStudent(enrolledStudent);

	}
	
	/**
	 * Escenario nulo
	 */
	private void setupEscenary3() {
		subject = null;
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
		assertNull(subject,"No se ha instanciado un objecto de la clase Subject");
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
				assertNull(subject,"No se ha instanciado un objecto de la clase Subject");
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
		assertNull(subject,"No se ha instanciado un objecto de la clase Subject");
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
				assertNull(subject,"No se ha instanciado un objecto de la clase Subject");
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
		assertNull(subject, "No se ha instanciado un objecto de la clase Subject");
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
		assertNull(subject, "No se ha instanciado un objecto de la clase Subject");
	}



	


	

}