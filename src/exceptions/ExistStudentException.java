package exceptions;

public class ExistStudentException extends Exception {
    public ExistStudentException() {
        super("El estudiante ya existe.");
    }
}
