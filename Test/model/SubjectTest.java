package model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Subject;

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
		
		//subject = new Subject(name, nrc, enrolledStudent, teacherName, teacherEmail, monitorName, monitorEmail, department, group);
	}
	
	
	private void setupEscenary2(){
		String name = "Esctructura de datos";
		String nrc ="567890E";
		int enrolledStudent = 25;
		String teacherName = "Camilo Maldonado";
		String teacherEmail = "cMal@gmail.com";
		String monitorName = "Eliecer Marin";
		String monitorEmail ="elimar@gmail.com";
		String department = "Departamento TIC";
		int group = 5;

		//subject = new Subject(name, nrc, enrolledStudent, teacherName, teacherEmail, monitorName, monitorEmail, department, group);
	
	}
	
	
	private void setupEscenary3() {
		
	}
	
	
	@Test
	public void getNameAndSetNameTest() {
		setupEscenary1();
		assertEquals("Matematicas discretas", subject.getName());
	
	
	}

}
