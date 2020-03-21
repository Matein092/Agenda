package model;

import exceptions.ExistStudentException;
import exceptions.NoExistContactException;
import exceptions.NotExistSubjectException;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Schedule {

    // Association

    public final static String STUDENTS_PATH = ".\\data\\Students.csv";
    public final static String COURSES_PATH = ".\\data\\Courses.csv";
    public final static String SCHEDULE_JOIN = ".\\data\\Join.csv";

    public final static String DATA_CONTACT = ".\\data\\Join.dat";
    public final static String DATA_CONTACTS = ".\\data\\Join.dat";
    public final static String DATA_JOIN = ".\\data\\Join.dat";

    private Contact contact;
    private Map<String, Contact> contacts;
    private ArrayList<Join> join;

    private List<Subject> aux2;
    private List<Subject> allSubjects;


    // Constructor
    public Schedule() throws NumberFormatException, IOException {
        contacts = new HashMap<String, Contact>();
        contact = new Contact();
        join = new ArrayList<Join>();
        aux2 = new ArrayList<>();
        allSubjects = new ArrayList<>();

        readJoin();
        chargeData();

    }


    // ---------- Serializacion -------------------

    public void loadObjectData(){
        try {
            loadJoin();
            loadContac();
            loadContacts();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void loadContac() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        File file = new File(DATA_CONTACT);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            ois = new ObjectInputStream(new FileInputStream(file));
            contact = (Contact) ois.readObject();
        }
        ois.close();
    }
    private void loadContacts() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        File file = new File(DATA_CONTACTS);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            ois = new ObjectInputStream(new FileInputStream(file));
            contacts = (Map<String, Contact>) ois.readObject();
        }
        ois.close();
    }
    private void loadJoin() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        File file = new File(DATA_JOIN);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            ois = new ObjectInputStream(new FileInputStream(file));
            join = (ArrayList<Join>) ois.readObject();
        }
        ois.close();
    }


    public void saveObjectData(){}

    private void saveContat() throws IOException {
        File file = new File(DATA_CONTACT);
        if (file.exists()) {
            file.delete();
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(contact);
        oos.close();
    }
    private void saveContats() throws IOException {
        File file = new File(DATA_CONTACTS);
        if (file.exists()) {
            file.delete();
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(contacts);
        oos.close();
    }
    private void saveJoin() throws IOException {
        File file = new File(DATA_JOIN);
        if (file.exists()) {
            file.delete();
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(join);
        oos.close();
    }

    //----------------------------------------------------------------



    private void readJoin() throws NumberFormatException, IOException {
        BufferedReader bF = new BufferedReader(new FileReader(SCHEDULE_JOIN));
        String line = bF.readLine();
        while ((line = bF.readLine()) != null) {
            String[] data = line.split(";");
            String id = data[0];
            String nrc = data[1];
            //System.out.println(""+id+" -->> "+nrc);
            join.add(new Join(id, nrc));
        }
        bF.close();
    }


    @SuppressWarnings("unused")
    public List<Subject> searchSubjectByContact(String id) throws NotExistSubjectException {
        List<Subject> subjects = new ArrayList<Subject>();
        int i = 0;
        while (i < join.size()) {
            if (join.get(i).getId().equals(id)) {
                Subject subject = contact.searchSubject(join.get(i).getNrc());
                if (subject != null) {
                    subjects.add(subject);
                }
            }
            i++;
        }
        if (subjects == null) {
            throw new NoExistContactException();
        }
        return subjects;

    }

    // Métodos

    /**
     * Carga los datos de los estudiantes.
     *
     * @throws NumberFormatException
     * @throws IOException           - error que se lanza si el archivo con los datos de los estudiantes no se encuentra.
     */
    public void chargeData() throws NumberFormatException, IOException {
        BufferedReader bF = new BufferedReader(new FileReader(STUDENTS_PATH));
        String line = bF.readLine();
        Contact contact;
        while ((line = bF.readLine()) != null) {
            String[] data = line.split(";");
            String id = data[0];
            String name = data[1];
            String lastName = data[2];
            String telephone = data[3];
            String email = data[4];
            int semester = Integer.parseInt(data[5]);
            String avatar = data[6];
            String bornDate = data[7];
            int age = Integer.parseInt(data[8]);
            String program = data[9];
            // Add Contact
            contact = new Contact(id, name, lastName, telephone, email, semester, avatar, bornDate, age, program);
            contacts.put(contact.getId(), contact);
            //Carga la información de la materia.
            chargeDataSubject();
        }

        bF.close();
    }

    private void chargeDataSubject() throws IOException {
        BufferedReader bF = new BufferedReader(new FileReader(COURSES_PATH));
        String line = bF.readLine();
        while ((line = bF.readLine()) != null) {
            String[] data = line.split(";");
            String name = data[0];
            String teacherName = data[1];
            String nrc = (data[2]);
            int credits = Integer.parseInt(data[3]);
            int enrolledStudent = Integer.parseInt(data[4]);
            // Add Subject
            contact.addSubject(name, teacherName, nrc, credits, enrolledStudent);
            Subject nSubject = new Subject(name,teacherName,nrc,credits,enrolledStudent);
            aux2.add(nSubject);


        }

        bF.close();
    }

    /**
     * Busca un estudiante por su código
     *
     * @param id - El código del estudiante.
     * @return - devuelve el estudiante con el código dado.
     * @throws NoExistContactException - Error que se lanza si no se encuentra el estudiante.
     */
    public Contact searchById(String id) {
        Contact objContact = null;
        for (Contact cont : contacts.values()) {
            if (cont.getId().equals(id)) {
                objContact = cont;
            }
        }
        return objContact;
    }

    /**
     * Busca un estudiante a partir de la fecha de nacimiento.
     *
     * @param bornDate - La fecha de nacimiento.
     * @return - El estudiante.
     */
    public ArrayList<Contact> searchByBornDate(String bornDate) {
        Contact objContact = null;
        ArrayList<Contact> listContact = new ArrayList<Contact>();
        for (Contact cont : contacts.values()) {
            if (cont.getBornDate().equals(bornDate)) {
                objContact = cont;
                listContact.add(objContact);
            }
        }
        return listContact;
    }

    /**
     * Busca un estudiante a partir del nombre.
     *
     * @param name - El nombre.
     * @return - El estudiante.
     */
    public ArrayList<Contact> searchByName(String name) {
        Contact objContact = null;
        ArrayList<Contact> listContact = new ArrayList<Contact>();
        for (Contact cont : contacts.values()) {
            if (cont.getName().equals(name)) {
                objContact = cont;
                listContact.add(objContact);
            }
        }
        return listContact;
    }

    /**
     * Busca un estudiante a partir del apellido.
     *
     * @param lastName - El apellido.
     * @return - El estudiante.
     */
    public ArrayList<Contact> searchByLastName(String lastName) {
        Contact objContact = null;
        ArrayList<Contact> listContact = new ArrayList<Contact>();
        for (Contact cont : contacts.values()) {
            if (cont.getLastName().equals(lastName)) {
                objContact = cont;
                listContact.add(objContact);
            }
        }
        return listContact;
    }

    /**
     * modifica los datos de un estudiante.
     *
     * @param name      - El nuevo nombre.
     * @param lastName  - El nuevo apellido.
     * @param telephone - El nuevo telefono.
     * @param email     - El nuevo correo electronico.
     * @param id        - El nuevo código.
     * @param semester  -El nuevo semestre.
     * @param avatar    - La nueva foto.
     * @param bornDate  - La nueva fecha de nacimiento.
     * @param age       - La nueva edad.
     * @param program   - El nuevo programa.
     */
    public void modifyContact(String currentId, String name, String lastName, String telephone, String email, String id, int semester,
                              String avatar, String bornDate, int age, String program) throws NullPointerException {
        Contact objC = searchById(currentId);
        deleteContact(currentId);
        if (objC != null) {
            deleteContact(id);
            objC.setName(name);
            objC.setLastName(lastName);
            objC.setTelephone(telephone);
            objC.setEmail(email);
            objC.setId(id);
            objC.setSemester(semester);
            objC.setAvatar(avatar);
            objC.setAge(age);
            objC.setBornDate(bornDate);
            objC.setProgram(program);
        }
        contacts.put(objC.getId(), objC);
    }

    /**
     * Elimina un estudiante a partir de su código.
     *
     * @param id - El código del estudiante.
     */
    public void deleteContact(String id) {
        Contact contact = searchById(id);
        if (contact != null) {
            contacts.remove(id);
        }
    }

    /**
     * Agrega un nuevo estudiante.
     *
     * @param name      -El nombre.
     * @param lastName  -El apellido.
     * @param telephone - El telefono.
     * @param email     - El correo electrónico.
     * @param id        - El código.
     * @param semester  - El semestre.
     * @param avatar    - La foto
     * @param bornDate  - La fecha de nacimiento.
     * @param age       - La edad.
     * @param program   - El programa.
     * @throws ExistStudentException
     */
    public void addContact(String name, String lastName, String telephone, String email, String id, int semester,
                           String avatar, String bornDate, int age, String program) throws ExistStudentException {
        Contact contact = searchById(id);
        if (contact == null) {
            contact = new Contact(name, lastName, telephone, email, id, semester, avatar, bornDate, age, program);
            contacts.put(contact.getId(), contact);
        } else if (contact != null) {
            throw new ExistStudentException();
        }

    }

    /**
     * @param a     Array with all the subjects of all the students
     * @param first
     * @param last
     * @return nrc of the most repeated subject
     */
    public int mode(int a[], int first, int last) {
        int i, frec, maxfrec, moda;
        if (first == last)
            return a[first];
        moda = a[first];
        maxfrec = frequency(a, a[first], first, last);
        for (i = first + 1; i <= last; i++) {
            frec = frequency(a, a[i], i, last);
            if (frec > maxfrec) {
                maxfrec = frec;
                moda = a[i];
            }
        }
        return moda;
    }

    /**
     * @param a
     * @param p
     * @param first
     * @param last
     * @return
     */
    private int frequency(int[] a, int p, int first, int last) {
        int sum;
        if (first > last)
            return 0;
        sum = 0;
        for (int i = first; i <= last; i++)
            if (a[i] == p)
                sum++;

        return sum;
    }


    /**
     *  Obtiene todas las materias de todos los contactos
     * @return allSubjects - las lista.
     */
    public List<Subject> allSubjectsList(String name, String teacherName, String nrc, int credits, int enrolledStudent){
        List<Subject> allSubjets = new ArrayList<>();
        allSubjets.add(new Subject(name, teacherName, nrc, credits, enrolledStudent));
        return allSubjets;
    }



    /**
     * Devuelve la colección de estudiantes.
     */
    public Map<String, Contact> getContacts() {
        return contacts;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public ArrayList<Join> getJoin() {
        return join;
    }

    public void setJoin(ArrayList<Join> join) {
        this.join = join;
    }

    public List<Subject> getAllSubjects() {

        List<String> aux = aux2.stream().map(sub->sub.getNrc()).distinct().collect(Collectors.toList());

        //allSubjects.clear();

        for (int i=0; i<aux.size(); i++){
            int counter = 1;
            for (int j = 0; j < aux2.size(); j++) {
                if (aux.get(i).equals(aux2.get(j).getNrc()) && counter<2){
                    allSubjects.add(aux2.get(j));
                    counter++;
                }else {

                }
            }
        }
        return allSubjects;
    }

    public void setAllSubjects(List<Subject> allSubjects) {
        this.allSubjects = allSubjects;
    }
}
