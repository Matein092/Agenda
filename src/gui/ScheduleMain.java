package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScheduleMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ScheduleGUI.fxml"));
			primaryStage.setTitle("Mini Agenda");
			primaryStage.setScene(new Scene(root));
			primaryStage.setResizable(true);
			primaryStage.show();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
