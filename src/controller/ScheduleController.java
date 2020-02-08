package controller;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Contact;
import model.Schedule;
import sun.font.TextLabel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.ExistStudentException;
import exceptions.NoExistContactException;

/*
 * 
 */
public class ScheduleController implements Initializable {

	@FXML
	private TextField tfContactPath;
	@FXML
	private Button btloadContact;
	@FXML
	private Label lbMenLoad;
	@FXML
	private ImageView ivPhoto;
	@FXML
	private TextField tfName;
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
	private TextField tfCreditHours;
	@FXML
	private TextField tfInstructor;
	@FXML
	private TextField tfCampus;
	@FXML
	private TextField tfBuilding;
	@FXML
	private TextField tfRoom;
	@FXML
	private TextField tfTime;
	@FXML
	private ListView<?> lvCourses;
	@FXML
	private Button btNewCourse;
	@FXML
	private Button btSaveCourse;
	@FXML
	private Button btDeleteCourse;
	@FXML
	private Button btUpdateCourse;
	@FXML
	private Label lbCoursesAverage;
	@FXML
	private Label lbMostEnrolledCourse;
	@FXML
	private Label lbLessEnrolledCourse;
	@FXML
	private ListView<?> lvAllCourses;
	@FXML
	private TextField tfNRCSummary;
	@FXML
	private TextField tfCreditHoursSummary;
	@FXML
	private TextField tfLevelSummary;
	@FXML
	private TextField tfInstructorSummary;
	@FXML
	private TextField tfCampusSummary;
	@FXML
	private TextField tfBuildingSummary;
	@FXML
	private TextField tfRoomSummary;
	@FXML
	private TextField tfTimeSummary;
	@FXML
	private Label lbStudentsPerCourse;
	@FXML
	private Label lbCreditHoursAverage;
	@FXML
	private Button btExplorer;
	@FXML
	private TextField tfLastName;
	@FXML
	private TextField tfAge;
	@FXML
	private TextField tfCreditsnumber;

	/*
	 * Indica la posición de un estudiante en la hastTable.
	 */
	private int pos;

	// Asociación

	/**
	 * Es la clase princiapl del modelo
	 */
	private Schedule schedule;

	// Inicializador

	/**
	 * Inicializa la interfaz de usuario.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		schedule = new Schedule();
		pos = 0;
		cbCriterio.getItems().addAll("NOMBRE", "APELLIDO", "FECHA NACIMIENTO", "CÓDIGO");
		try {
			schedule.chargeData(); // Carga los datos de los estudiantes
			printContacts(); // Muestra los datos de los estudiantes en la interfaz de usuario.
		} catch (IOException e) {
			Alert men = new Alert(Alert.AlertType.ERROR);
			men.setTitle("Error");
			men.setHeaderText("Datos de estudiantes no encontrado");
			men.setContentText("El archivo que contiene los datos de los estudiantes no se ha encontrado.");
			men.showAndWait();
		}
	}

	// Métodos

	/**
	 * Muestra los datos de los estudiantes a partir de la posición.
	 */
	public void printContacts() {
		printContact(searchPosContact(pos));
	}

	/**
	 * Busca un contacto a partir de la posición en la HastTable.
	 * 
	 * @param pos - La posición del contacto.
	 * @return Un contacto, null si no lo encuentra.
	 */
	public Contact searchPosContact(int pos) {
		Contact contact = null;
		if (pos >= 0 && pos < schedule.getContacts().size()) {
			contact = schedule.getContacts().get(pos);
		}
		return contact;
	}

	/**
	 * Muesta los datos de un estudiante.
	 * 
	 * @param contact - El a mostrar.
	 */
	public void printContact(Contact contact) {

		try {
			tfName.setText("");
			if (!contact.getName().equals("")) {
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

	/**
	 * Muestra el estudiante anterior.
	 */
	@FXML
	public void passBackContact() {
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
	public void passNextContact() {
		if (pos < schedule.getSize() - 1) {
			pos += 1;
			printContacts();
		} else if (pos == schedule.getSize() - 1) {
			printContacts();
		}
	}

	/**
	 * Limpia los campos para ingresar un nuevo estudiante.
	 */
	@FXML
	public void newContactClick() {
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
	 * Carga la imagen de un estidiante.
	 */
	@FXML
	public void loadImageContact() {

	}

	/**
	 * Guarda un nuevo estudiante.
	 */
	@FXML
	public void saveContactClick() {
		try {
			schedule.addContact(tfName.getText(), tfLastName.getText(), tfTelephone.getText(), tfEmail.getText(),
					tfCode.getText(), Integer.parseInt(tfSemester.getText()), "", dpBornDate.getValue() + "",
					Integer.parseInt(tfAge.getText()), tfCareer.getText());
		} catch (NumberFormatException | ExistStudentException e) {
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
	public void deleteContactClick() {
		schedule.deleteContact(tfCode.getText());
	}

	/**
	 * Actualiza los datos de un estudiante actual.
	 */
	@FXML
	public void updateContactClick() {
	}

}
