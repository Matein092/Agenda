import java.io.*;
import java.util.*;

public class Agenda {
	public final static String FILE = "..\\..\\..\\agenda.txt";
	private List<Contact> contact;
	private Subject[] subject;
	public Agenda(List<Contact> contact, Subject[] subject) {
		super();
		this.contact = contact;
		this.subject = subject;
	}
	
	
	public void createContact(String name, String birthday, int code, int numberPhone, String email, String career, String level) {
		
	}
	
	public void createSubject(String nrc, int creditHour, String level, String instructor, String campus, String tower,
			String room, String schedule) {}
	
	public void modifyContact() {}
	
	
	public void save() throws IOException, FileNotFoundException{
		File myFile = new File(FILE);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(myFile));
		oos.writeObject(ro|||ot);
		oos.close();
	}
	
	public void load() throws IOException, ClassNotFoundException {
		File myFile = new File(FILE);
		if (myFile.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(myFile));
			root = (Contact)ois.readObject();
			ois.close();
			System.out.println(root);
		}
	}
}
