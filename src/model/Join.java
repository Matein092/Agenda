package model;

/**
 * Clase auxiliar de el archivo join, el cual contiene los id de los contactos y nrc de sus materias.
 */
public class Join {

	private String id;
	private String nrc;

	public Join(String id, String nrc) {
		super();
		this.id = id;
		this.nrc = nrc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

}
