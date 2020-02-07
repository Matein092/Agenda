package model;
import java.io.*;
import java.util.*;

	public class Schedule {
	
		//Association
		
		//private List<Contact> contacts;
		
		private HashMap<String, Contact> contId;
		private HashMap<String, Contact> contBd;
		private HashMap<String, Contact> contEm;
		private int size;
		private HashMap<Integer, Contact> contacts;
		//Constructor
		public Schedule() {
			//contacts = new ArrayList<Contact>();
			contId = new HashMap<String, Contact>();
			contBd = new HashMap<String, Contact>();
			contacts = new HashMap<Integer, Contact>();
			contEm = new HashMap<String, Contact>();
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
					contId.put(contact.getId(), contact);
					contBd.put(contact.getBirthday(), contact);
					contBd.put(contact.getEmail(), contact);
					size++;
					int index = size-1;
					contacts.put(index, contact);
					//System.out.println(contact.toString());
				}
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		/**
		 * @param id
		 * @return
		 */
		public Contact searchById(String id) {
			Contact objContact = null;
			//for(int i = 0; i < contacts.size(); i++) {
				if(contId.get(id).getId() == id) {
					objContact = new Contact(contId.get(id).getName(),contId.get(id).getLastName(),  contId.get(id).getTelephone(), contId.get(id).getEmail(), contId.get(id).getId(), contId.get(id).getSemester(), contId.get(id).getAvatar(), contId.get(id).getBirthday(), contId.get(id).getAge(), contId.get(id).getProgram());
				}else {
					
			//	}
			}
			
			return objContact;
		}
		
		public Contact searchByBirthDay(String birthday) {
			Contact objContact = null;
			//for(int i = 0; i < contacts.size(); i++) {
				if(contBd.get(birthday).getBirthday() == birthday) {
					objContact = new Contact(contBd.get(birthday).getName(),contBd.get(birthday).getLastName(), contBd.get(birthday).getTelephone(), contBd.get(birthday).getEmail(), contBd.get(birthday).getId(), contBd.get(birthday).getSemester(), contBd.get(birthday).getAvatar(), contBd.get(birthday).getBirthday(), contBd.get(birthday).getAge(), contBd.get(birthday).getProgram());
				}else {
					
				//}
			}
			return objContact;
		}
		
		public Contact searchByEmail(String email) {
			Contact objContact = null;
			if (contEm.get(email).getEmail() == email) {
				objContact = new Contact(contEm.get(email).getName(),contEm.get(email).getLastName(), contEm.get(email).getTelephone(), contEm.get(email).getEmail(), contEm.get(email).getId(), contEm.get(email).getSemester(), contEm.get(email).getAvatar(), contEm.get(email).getBirthday(), contEm.get(email).getAge(), contEm.get(email).getProgram());
			} else {

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
			Contact objC = searchByBirthDay(birthday);
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
		
		public void modifyContactByEmail(String name, String lastName, String telephone, String email, String id, int semester, String avatar,String birthday, int age, String program) {
			Contact objC = searchByBirthDay(email);
			if (objC != null) {
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
		
		public void deleteContactById(String id) {
			Contact contact = searchById(id);
			if(contact != null){
				//for(int i = 0; i < contacts.size(); i++) {
					//if(contact.equals((contacts).get(i))) {
						contId.remove(id);
					//}
				//}
			}
		}
		
		public void deleteContactByBirthday(String birthday) {
			Contact contact = searchByBirthDay(birthday);
			if(contact != null) {
			//for(int i = 0; i < contacts.size(); i++) {
				//if(contact.equals((contacts).get(i))) {
					contBd.remove(birthday);
			}
		}
		
		public void deleteContactByEmail(String email) {
			contEm.remove(email);
		}
		
		public void addContact(String name, String lastName, String telephone, String email, String id, int semester, String avatar,
				String birthday, int age, String program) {
			Contact contact = searchById(id);
			if(contact == null) {
				contact = new Contact(name, lastName, telephone, email, id, semester, avatar, birthday,age,program);
				contId.put(id, contact);
				contBd.put(birthday, contact);
				contEm.put(email, contact);
				size++;
				int index = size-1;
				contacts.put(index, contact);
			}
		}
		
		public int mode(int a[], int first, int last) {
			int i, frec, maxfrec, moda;
			if (first == last) return a[first];
			moda = a[first];
			maxfrec = frequency(a, a[first], first, last);
			for (i = first + 1; i<=last; i++) {
				frec = frequency (a, a[i], i, last);
				if (frec > maxfrec) {
					maxfrec = frec;
					moda = a[i];
				}
			}
			return moda;
		}
				
		private int frequency(int[] a, int p, int first, int last) {
			int sum;
			if (first > last) return 0;
			sum = 0;
			for (int i = first; i<= last; i++)
				if(a[i] == p)
					sum++;
	 
			return sum;
		}

		public HashMap<String, Contact> getContId() {
			return contId;
		}

		public HashMap<String, Contact> getContBd() {
			return contBd;
		}


		public int getSize() {
			return size;
		}


		public HashMap<Integer, Contact> getContacts() {
			return contacts;
		}


		public HashMap<String, Contact> getContEm() {
			return contEm;
		}
		
}
