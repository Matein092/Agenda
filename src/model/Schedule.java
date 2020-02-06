package model;
import java.io.*;
import java.util.*;

	public class Schedule {
	
		public enum CRITERIO {NAME,LASTNAME,TELEPHONE,EMAIL,ID,SEMESTER,AGE,}
	
		//Association
		private List<Contact> contacts;
		
		//Constructor
		public Schedule() {
			contacts = new ArrayList<Contact>();
		}
		
	
		public void chargeData(File file) throws FileNotFoundException {
			FileReader fr = new FileReader(file);
			BufferedReader bF = new BufferedReader(fr);
			String line;
			Contact contact;
			try {
			while ((line = bF.readLine()) != null) {
				if (line.charAt(0) != '#') {
					String[] data = line.split(";");
					contact = new Contact(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]),
							data[6], data[7], Integer.parseInt(data[8]), data[9]);
					contacts.add(contact);
					//System.out.println(contact.toString());
				}
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		

		
		
		
		
		public Contact searchById(String id) {
			Contact objContact = null;
			for(int i = 0; i < contacts.size(); i++) {
				if(contacts.get(i).getId() == id) {
					objContact = new Contact(contacts.get(i).getName(),contacts.get(i).getLastName(),  contacts.get(i).getTelephone(), contacts.get(i).getEmail(), contacts.get(i).getId(), contacts.get(i).getSemester(), contacts.get(i).getAvatar(), contacts.get(i).getBirthday(), contacts.get(i).getAge(), contacts.get(i).getProgram());
				}else {
					
				}
			}
			return objContact;
		}
		
		public Contact searchByBirthDay(String birthday) {
			Contact objContact = null;
			for(int i = 0; i < contacts.size(); i++) {
				if(contacts.get(i).getId() == birthday) {
					objContact = new Contact(contacts.get(i).getName(),contacts.get(i).getLastName(),  contacts.get(i).getTelephone(), contacts.get(i).getEmail(), contacts.get(i).getId(), contacts.get(i).getSemester(), contacts.get(i).getAvatar(), contacts.get(i).getBirthday(), contacts.get(i).getAge(), contacts.get(i).getProgram());
				}else {
					
				}
			}
			return objContact;
		}
		
		public void modifyContactById(String name, String lastName, String telephone, String email, String id, int semester, String avatar,
				String birthday, int age, String program) {
			Contact objC = searchById(id);
			if(objC != null) {
				objC.setName(name);
				objC.setLastName(lastName);
				objC.setTelephone(telephone);
				objC.setEmail(email);
				objC.setId(id);
				objC.setSemester(semester);
				objC.setAvatar(avatar);
				objC.setAge(age);
				objC.setBirthday(birthday);
				objC.setProgram(program);
			}
		}
		
		public void modifyContactByBirthDay(String name, String lastName, String telephone, String email, String id, int semester, String avatar,
				String birthday, int age, String program) {
			Contact objC = searchById(birthday);
			if(objC != null) {
				objC.setName(name);
				objC.setLastName(lastName);
				objC.setTelephone(telephone);
				objC.setEmail(email);
				objC.setId(id);
				objC.setSemester(semester);
				objC.setAvatar(avatar);
				objC.setAge(age);
				objC.setBirthday(birthday);
				objC.setProgram(program);
			}else {
				
			}
			
		}
		
		public void deleteContactById(String id) {
			Contact contact = searchById(id);
			if(contact != null){
				for(int i = 0; i < contacts.size(); i++) {
					if(contact.equals((contacts).get(i))) {
						contacts.remove(i);
					}
				}
			}
		}
		
		public void deleteContactByBirthday(String birthday) {
			Contact contact = searchById(birthday);
			for(int i = 0; i < contacts.size(); i++) {
				if(contact.equals((contacts).get(i))) {
					contacts.remove(i);
					
				}
			}
		}
		public void addContact(String name, String lastName, String telephone, String email, String id, int semester, String avatar,
				String birthday, int age, String program) {
			Contact contact = searchById(id);
			if(contact == null) {
				contact = new Contact(name, lastName, telephone, email, id, semester, avatar, birthday,age,program);
				contacts.add(contact);
			}
		}

		
		public List<Contact> getContacts() {
			return contacts;
		}
		
		
		
		
		
		
	
}
