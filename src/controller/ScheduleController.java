package controller;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import model.Schedule.CRITERIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScheduleController implements Initializable {

	    @FXML private TextField tfContactPath;
	    @FXML private Button btloadContact;
	    @FXML private Label lbMenLoad;
	    @FXML private ImageView ivPhoto;
	    @FXML private Label lbName;
	    @FXML private TextField tfCode;
        @FXML private TextField tfTelephone;
        @FXML private TextField tfEmail;
	    @FXML private TextField tfCareer;
	    @FXML private TextField tfSemester;
	    @FXML private DatePicker dpBornDate;
	    @FXML private Button btNewContact;
	    @FXML private Button btSaveContact;
	    @FXML private Button btDeleteContact;
	    @FXML private Button btUpdateContact;
	    @FXML private TextField tfSearch;
	    @FXML private ComboBox<CRITERIO> cbCriterio;
	    @FXML private TextField tfNRC;
	    @FXML private TextField tfCreditHours;
	    @FXML private TextField tfInstructor;
	    @FXML private TextField tfCampus;
	    @FXML private TextField tfBuilding;
	    @FXML private TextField tfRoom;
	    @FXML private TextField tfTime;
	    @FXML private ListView<?> lvCourses;
	    @FXML private Button btNewCourse;
	    @FXML private Button btSaveCourse;
	    @FXML private Button btDeleteCourse;
	    @FXML private Button btUpdateCourse;
	    @FXML private Label lbCoursesAverage;
	    @FXML private Label lbMostEnrolledCourse;
	    @FXML private Label lbLessEnrolledCourse;
	    @FXML private ListView<?> lvAllCourses;
	    @FXML private TextField tfNRCSummary;
	    @FXML private TextField tfCreditHoursSummary;
	    @FXML private TextField tfLevelSummary;
	    @FXML private TextField tfInstructorSummary;
	    @FXML private TextField tfCampusSummary;
	    @FXML private TextField tfBuildingSummary;
	    @FXML private TextField tfRoomSummary;
	    @FXML private TextField tfTimeSummary;
	    @FXML private Label lbStudentsPerCourse;
	    @FXML private Label lbCreditHoursAverage;
	    @FXML private Button btExplorer;
	    @FXML private Label lbLastName;
	    @FXML private TextField tfAge;

	    private File file;
	    private int pos;
	    private Schedule schedule;
	    
	    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

		schedule = new Schedule();
		pos = 0;


    	//cbCriterio.getItems().addAll("NAME","LASTNAME","TELEPHONE","EMAIL","ID","SEMESTER","AGE");
        cbCriterio.getItems().addAll(
        		Schedule.CRITERIO.NAME,
        		Schedule.CRITERIO.LASTNAME,
        		Schedule.CRITERIO.TELEPHONE,
        		Schedule.CRITERIO.EMAIL,
        		Schedule.CRITERIO.ID,
        		Schedule.CRITERIO.SEMESTER,
        		Schedule.CRITERIO.AGE);

	
        
      }

	@FXML
	public void explorerClick(ActionEvent event) {
		try {
			FileChooser chooser = new FileChooser();
			chooser.setInitialDirectory(new File(".\\data"));
			file = chooser.showOpenDialog(new Stage());
			tfContactPath.setText(file.getName());
			lbMenLoad.setText("Se encontró la lista de estudiantes.");
		} catch (Exception e) {
			lbMenLoad.setText("No se encontró la lista de estudiantes.");
		}
	}

	
	@FXML
	public void loadContacsClick(ActionEvent event) {
		try {
			if (file.exists()) {
				schedule.chargeData(file);
				printContacts();
			}
			lbMenLoad.setText("La lista de estudiantes se cargó correctamente.");
		} catch (FileNotFoundException e) {
			lbMenLoad.setText("Error al cargar la lista de estudiantes.");
		} catch (IOException e) {
			lbMenLoad.setText("Error al cargar la lista de estudiantes.");
		}
	}
    
	
	public void printContacts() {
		printContact(searchPosContact(pos));
	}

	
	public Contact searchPosContact(int pos) {
		Contact contact = null;
		if(pos>=0 && pos<schedule.getContacts().size()) {
			contact = schedule.getContacts().get(pos);
		}
		return contact;
	}
	
	public void printContact(Contact contact) {
		
		if(!contact.getName().equals("")) {
			lbName.setText(contact.getName());
		}
		
		lbLastName.setText(contact.getLastName());
		
		tfCode.setText(contact.getId());
		
		tfTelephone.setText(contact.getTelephone());
		
		tfEmail.setText(contact.getEmail());
		
		if(!contact.getAvatar().equals("")) {
			ivPhoto.setImage(new Image(contact.getAvatar().toString()));
		}
		
		tfCareer.setText(contact.getProgram());
		
		dpBornDate.setPromptText(contact.getBirthday());
		
		tfSemester.setText(contact.getSemester()+"");
		
		tfAge.setText(contact.getAge()+"");
		

	}

	@FXML
	public void passBackContact() {
		if (pos>=0) {
			pos -= 1;
			printContacts();
		}
	}
	
	@FXML 
	public void passNextContact() {
		if (pos < schedule.getContacts().size()) {
			pos+=1;
			printContacts();
		}
		
	}



}
