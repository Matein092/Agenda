package exceptions;

public class NoExistContactException extends NullPointerException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1044186852232276041L;
	public NoExistContactException() {
		super("El estudiante no se encuentra");
	}
}
