package exceptions;

public class NotExistSubjectException extends Exception{
	public NotExistSubjectException() {
		super("La materia no se encuentra matriculada en el curso");
	}
}
