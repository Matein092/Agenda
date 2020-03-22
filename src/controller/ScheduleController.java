package controller;

import exceptions.ExistStudentException;
import exceptions.NoExistContactException;
import exceptions.NotExistSubjectException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Contact;
import model.Join;
import model.Schedule;
import model.Subject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/*
 *
 */
public class ScheduleController implements Initializable {

    @FXML
    private ImageView ivPhoto;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfCode;

    @FXML
    private TextField tfTelephone;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfCareer;

    @FXML
    private TextField tfSemester;

    @FXML
    private DatePicker dpBornDate;

    @FXML
    private TextField tfAge;

    @FXML
    private Button btNewContact;

    @FXML
    private Button btSaveContact;

    @FXML
    private Button btDeleteContact;

    @FXML
    private Button btUpdateContact;

    @FXML
    private TextField tfSearch;

    @FXML
    private ComboBox<String> cbCriterio;

    @FXML
    private TextField tfNRC;

    @FXML
    private TextField tfNameSubject;

    @FXML
    private TextField tfCredits;

    @FXML
    private TextField tfTeacher;

    @FXML
    private TextField tfEnrolledStudent;

    @FXML
    private ListView<String> lvCourses;

    @FXML
    private Label lbCoursesAverage;

    @FXML
    private Label lbMostEnrolledCourse;

    @FXML
    private Label lbLessEnrolledCourse;

    @FXML
    private ListView<String> lvAllCourses;

    @FXML
    private TextField tfNRCSummary;

    @FXML
    private TextField tfCreditHoursSummary;

    @FXML
    private TextField tfInstructorSummary;

    @FXML
    private TextField tfEnrolleStudentsSummary;

    @FXML
    private TextField tfNameSubjectSummary;

    @FXML
    private Label lbStudentsPerCourse;

    @FXML
    private Label lbCreditHoursAverage;
    
    @FXML
	private Label numberS;
	
	@FXML
	private Label numberC;


    /*
     * Indica la posición de un estudiante en la hastTable.
     */
    private int pos;

    // Asociación

    /**
     * Es la clase princiapl del modelo
     */
    private Schedule schedule;
    private String currentId;
    private String currentNRC;
    private Subject cSubject;
    private Contact currentContact;

    // Inicializador

    /**
     * Inicializa la interfaz de usuario.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            schedule = new Schedule();
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
            Alert men = new Alert(Alert.AlertType.ERROR);
            men.setTitle("Error");
            men.setHeaderText("Datos de estudiantes no encontrado");
            men.setContentText("El archivo que contiene los datos de los estudiantes no se ha encontrado.");
            men.showAndWait();
        }

        pos = 0;
        currentId = "";
        currentNRC = "";
        cSubject = null;
        currentContact = null;
        cbCriterio.getItems().add("Seleccione un criterio");
        cbCriterio.getSelectionModel().select(0);
        cbCriterio.getItems().addAll("EMAIL", "APELLIDO", "TELEFONO", "CÓDIGO");

        printContacts(); // Muestra los datos de los estudiantes en la interfaz de usuario.

        printAllSubjects();
    }

    // Métodos

    public void printAllSubjects() {
        for (Subject cSubject : schedule.getAllSubjects()){
            lvAllCourses.getItems().add(cSubject.getNrc() + "-" + cSubject.getName());
        }
    }

    @FXML
    public void lvAllCoursesPressed(MouseEvent event){
        String seletion = lvAllCourses.getSelectionModel().getSelectedItem();

        if (seletion != null) {
            String[] data = seletion.split("-");
            String nrc = data[0];
            // Busca la materia del contacto.
            Subject cSubject = null;
            boolean found = false;
            for(int i=0; i<schedule.getAllSubjects().size() && !found;i++){
                if (schedule.getAllSubjects().get(i).getNrc().equals(nrc)){
                    cSubject = schedule.getAllSubjects().get(i);
                    found = true;
                }
            }
            if (cSubject != null) {
                tfNRCSummary.setText(cSubject.getNrc());
                tfNameSubjectSummary.setText(cSubject.getName());
                tfCreditHoursSummary.setText(String.valueOf(cSubject.getCredits()));
                tfInstructorSummary.setText(cSubject.getTeacherName());
                tfEnrolleStudentsSummary.setText(String.valueOf(cSubject.getEnrolledStudent()));
            }
        }
    }

    /**
     * Muestra los datos de los estudiantes a partir de la posición.
     */
    public void printContacts() {
        printContact(searchPosContact(pos));
        printListViewSubject();
    }

    /**
     * Busca un contacto a partir de la posición en la HastTable.
     *
     * @param pos - La posición del contacto.
     * @return Un contacto, null si no lo encuentra.
     */
    public Contact searchPosContact(int pos) {
        Contact contact = null;
        List<Contact> contactList = new ArrayList<Contact>(schedule.getContacts().values());
        if (pos >= 0 && pos < contactList.size()) {
            contact = contactList.get(pos);
            currentId = contact.getId();
            currentContact = contact;
           // schedule.setContact(contact);
        }
        return contact;
    }

    /**
     * Muesta los datos de un estudiante.
     *
     * @param contact - El a mostrar.
     */
    private void printContact(Contact contact) {
        try {
            tfName.setText("");
            if (!contact.getName().equals("")) {
            	lbCoursesAverage.setText(contact.getName());
				lbCreditHoursAverage.setText(contact.getName());
                tfName.setText(contact.getName());
            }

            tfLastName.setText("");
            tfLastName.setText(contact.getLastName());

            tfCode.setText("");
            tfCode.setText(contact.getId());

            tfTelephone.setText("");
            tfTelephone.setText(contact.getTelephone());

            tfEmail.setText("");
            tfEmail.setText(contact.getEmail());

            if (!contact.getAvatar().equals("")) {
                ivPhoto.setImage(new Image(contact.getAvatar()));

            } else {
                ivPhoto.setImage(new Image(".\\img\\Contact.jpg"));
            }

            tfCareer.setText("");
            tfCareer.setText(contact.getProgram());

            dpBornDate.setPromptText("");
            dpBornDate.setPromptText(contact.getBornDate());
            dpBornDate.setEditable(false);

            tfSemester.setText("");
            tfSemester.setText(contact.getSemester() + "");

            tfAge.setText("");
            tfAge.setText(contact.getAge() + "");

        } catch (NoExistContactException e) {
            Alert men = new Alert(Alert.AlertType.ERROR);
            men.setTitle("Error");
            men.setHeaderText("Estudiante no encontrado");
            men.setContentText("El estudiante buscado no existe.");
            men.showAndWait();
        }
    }


    //------------------------000-------------------

    /**
     * Las materias de un contacto en especifico.
     */
    private void printListViewSubject() {
        lvCourses.getItems().clear();
        clearCourse();
        String msg = "";
        int credits = 0;
        List<Subject> founds = null;
        try {
        	lbMostEnrolledCourse.setText("Modelado de sistemas de informacion");
        	lbLessEnrolledCourse.setText("Frances I");
        	founds = schedule.searchSubjectByContact(tfCode.getText());
			numberS.setText(Integer.toString(founds.size()));
			for(int i = 0; i < founds.size();i++) {
				credits += founds.get(i).getCredits();
			}
			numberC.setText(Integer.toString(credits));
        } catch (NotExistSubjectException e) {
            Alert men = new Alert(Alert.AlertType.ERROR);
            men.setTitle("Error");
            men.setHeaderText("Estudiante no encontrado");
            men.setContentText("El estudiante buscado no existe.");
            men.showAndWait();
        }

        if (founds != null) {
            for (int i = 0; i < founds.size(); i++) {
                lvCourses.getItems().add(founds.get(i).getNrc() + "-" + founds.get(i).getName());

            }
        }
    }

    //---------------------------000---------------

    @FXML
    public void ListViewCourse(MouseEvent event) {

        String seletion = lvCourses.getSelectionModel().getSelectedItem();

        if (seletion != null) {
            String[] data = seletion.split("-");
            String nrc = data[0];
            currentNRC = nrc;
            // Busca la materia del contacto.
            cSubject = schedule.getContact().searchSubject(nrc);

            if (cSubject != null) {
                tfNRC.setText(cSubject.getNrc());
                tfNameSubject.setText(cSubject.getName());
                tfCredits.setText(String.valueOf(cSubject.getCredits()));
                tfTeacher.setText(cSubject.getTeacherName());
                tfEnrolledStudent.setText(String.valueOf(cSubject.getEnrolledStudent()));
            }
        }
    }

    @FXML
    public void btDeleteCourse(ActionEvent event) {

        String nrcSubject = tfNRC.getText();
        String elementToClear = lvCourses.getSelectionModel().getSelectedItem();
        lvCourses.getItems().remove(elementToClear);
        schedule.getContact().deleteSubject(nrcSubject);
        clearCourse();
    }

    private void clearCourse() {
        tfNRC.clear();
        tfNameSubject.clear();
        tfCredits.clear();
        tfTeacher.clear();
        tfEnrolledStudent.clear();
    }

    @FXML
    void btNewCourse(ActionEvent event) {
        clearCourse();
    }

    
    ///////////////
    @FXML
    public void btSaveCourse(ActionEvent event) {

    	String id = tfCode.getText();
    	String nameContact = tfName.getText();
    	String lastName = tfLastName.getText();
    	String telephone = tfTelephone.getText();
    	String email = tfEmail.getText();
    	int semester = Integer.parseInt(tfSemester.getText());
    	String avatar = "";
    	String bornDate = "";
    	int age = Integer.parseInt(tfAge.getText());
    	String program = tfCareer.getText();
    	
    	Contact contact = new Contact(id, nameContact, lastName, telephone, email, semester, avatar, bornDate, age, program);
    	
    	
        String nrc = tfNRC.getText();
        String name = tfNameSubject.getText();
        int credits = Integer.parseInt(tfCredits.getText());
        String teacherName = tfTeacher.getText();
        int enrolledStudent = Integer.parseInt(tfEnrolledStudent.getText());
        
        Subject subject = new Subject(name, teacherName, nrc, credits, enrolledStudent);
        
     /**   	
        schedule.getJoin().add(new Join(currentId, nrc));
        schedule.getContact().addSubject(name, nrc, teacherName, credits, enrolledStudent);
        schedule.getContact().getSubj().put(nrc, new Subject(name, nrc, teacherName, credits, enrolledStudent));
        */
        
        
        // Esta linea representa a las comentadas
        schedule.addSubjectByContactInJoin(contact,subject);
        
        lvCourses.getItems().add(subject.getNrc()+ "-" + subject.getName());
        clearCourse();
        schedule.savedData();
    }

    @FXML
    public void btUpdateCourse(ActionEvent event) {

        schedule.getContact().deleteSubject(cSubject.getNrc());

        cSubject.setName(tfNameSubject.getText());
        cSubject.setNrc(tfNRC.getText());
        cSubject.setTeacherName(tfTeacher.getText());
        cSubject.setCredits(Integer.parseInt(tfCredits.getText()));
        cSubject.setEnrolledStudent(Integer.parseInt(tfEnrolledStudent.getText()));

        schedule.getContact().getSubj().put(cSubject.getNrc(), cSubject);
    }

    /////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////Contacto//////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////

    /**
     * Muestra el estudiante anterior.
     */
    @FXML
    public void passBackContact(ActionEvent event) {
        if (pos > 0) {
            pos -= 1;
            printContacts();
        } else if (pos == 0) {
            printContacts();
        }
    }

    /**
     * Muestra el siguiente estudiante.
     */
    @FXML
    public void passNextContact(ActionEvent event) {
        if (pos < schedule.getContacts().size() - 1) {
            pos += 1;
            printContacts();
        } else if (pos == schedule.getContacts().size() - 1) {
            printContacts();
        }
    }

    /**
     * Limpia los campos para ingresar un nuevo estudiante.
     */
    @FXML
    public void newContactClick(ActionEvent event) {
        ivPhoto.setImage(new Image(".\\img\\Contact.jpg"));
        tfName.setText("");
        tfLastName.setText("");
        tfCode.setText("");
        dpBornDate.setPromptText("");
        dpBornDate.setEditable(true);
        tfTelephone.setText("");
        tfEmail.setText("");
        tfCareer.setText("");
        tfSemester.setText("");
        tfAge.setText("");
    }

    /**
     * Guarda un nuevo estudiante.
     */
    @FXML
    public void saveContactClick(ActionEvent event) {
        try {
            schedule.addContact(tfName.getText(), tfLastName.getText(), tfTelephone.getText(), tfEmail.getText(),
                    tfCode.getText(), Integer.parseInt(tfSemester.getText()), "", dpBornDate.getValue() + "",
                    Integer.parseInt(tfAge.getText()), tfCareer.getText());
            schedule.printReport();
        } catch (NumberFormatException | FileNotFoundException | ExistStudentException e) {
            Alert men = new Alert(Alert.AlertType.WARNING);
            men.setTitle("Avertencia");
            men.setHeaderText("Estudiante ya existe");
            men.setContentText("El estudiante a agregar ya está en la colección.");
            men.showAndWait();
        }
        
        
    }

    /**
     * Elimina un estudiante
     */
    @FXML
    public void deleteContactClick(ActionEvent event) {

        schedule.deleteContact(tfCode.getText());

        ivPhoto.setImage(new Image(".\\img\\Contact.jpg"));
        tfName.setText("");
        tfLastName.setText("");
        tfCode.setText("");
        dpBornDate.setValue(null);
        dpBornDate.setPromptText("");
        dpBornDate.setEditable(true);
        tfTelephone.setText("");
        tfEmail.setText("");
        tfCareer.setText("");
        tfSemester.setText("");
        tfAge.setText("");

        pos += 1;
        printContacts();
        
    }

    /**
     * Actualiza los datos de un estudiante actual.
     */
    @FXML
    public void updateContactClick(ActionEvent event) {
        try {

            schedule.modifyContact(currentId,
                    tfName.getText(),
                    tfLastName.getText(),
                    tfTelephone.getText(),
                    tfEmail.getText(),
                    tfCode.getText(),
                    Integer.parseInt(tfSemester.getText()),
                    "",
                    dpBornDate.getValue() + "",
                    Integer.parseInt(tfAge.getText()),
                    tfCareer.getText());
        } catch (NullPointerException e) {
            Alert men = new Alert(Alert.AlertType.WARNING);
            men.setTitle("Avertencia");
            men.setHeaderText("Estudiante no existe");
            men.setContentText("El estudiante a modificar no existe.");
            men.showAndWait();
        }

    }

    // NOMBRE", "APELLIDO", "FECHA NACIMIENTO", "CÓDIGO"
    @FXML
    public void searchForCriterio() {
        try {
            if (cbCriterio.getValue().equals("EMAIL")) {
                if (tfSearch.getText() != null || !tfSearch.equals("")) {
                	printContact(schedule.searchByEmail(tfSearch.getText()));
                    printListViewSubject();
                    cbCriterio.getSelectionModel().select(0);
                    tfSearch.setText("");
                }
            } else if (cbCriterio.getValue().equals("APELLIDO")) {
                if (tfSearch.getText() != null || !tfSearch.equals("")) {
                	printContact(schedule.searchByLastName(tfSearch.getText()));
                    printListViewSubject();
                    cbCriterio.getSelectionModel().select(0);
                    tfSearch.setText("");
                }
            } else if (cbCriterio.getValue().equals("TELEFONO")) {
                if (tfSearch.getText() != null || !tfSearch.equals("")) {
                	printContact(schedule.searchByPhone(tfSearch.getText()));
                    printListViewSubject();
                    cbCriterio.getSelectionModel().select(0);
                    tfSearch.setText("");
                }
            } else if (cbCriterio.getValue().equals("CÓDIGO")) {
                if (tfSearch.getText() != null || !tfSearch.equals("")) {
                    printContact(schedule.searchById(tfSearch.getText()));
                    printListViewSubject();
                    cbCriterio.getSelectionModel().select(0);
                    tfSearch.setText("");
                }
            }
        }catch (NullPointerException e){
            Alert men = new Alert(Alert.AlertType.ERROR);
            men.setTitle("Error");
            men.setHeaderText("Estudiante no encontrado");
            men.setContentText("El estudiante buscado no existe.");
            men.showAndWait();
        }
    }
    

    @FXML
    private void cerrarVentana(ActionEvent event) {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        schedule.savedData();
        stage.close();
    }

}
