package exceptions;

public class NoExistContactException extends NullPointerException {

	public NoExistContactException() {
		super("El estudiante no se encuentra");
	}
}
