package br.edu.ifsp.spo.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import br.edu.ifsp.spo.MainApp;
import br.edu.ifsp.spo.model.Exercise;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class TestOverviewController {

	@FXML
	private TableView<Exercise> exerciseTable;
	@FXML
	private TableColumn<Exercise, String> exerciseNameColumn;
	@FXML
	private TableColumn<Exercise, String> exerciseSendedColumn;

	@FXML
	private WebView exerciseWebView;

	private MainApp mainApp;

	public TestOverviewController() {
	}

	@FXML
	private void initialize() throws FileNotFoundException {
		//Inicia duas colunas da table view
		exerciseNameColumn.setCellValueFactory(
				cellData -> cellData.getValue().exerciseNameProperty());
		exerciseSendedColumn.setCellValueFactory(
				cellData -> cellData.getValue().exerciseSendedProperty());

			//Quando o programa for iniciado
			showExerciseDescription(null);

			exerciseTable.getSelectionModel().selectedItemProperty().addListener(
					(observable, oldValue, newValue) -> showExerciseDescription(newValue)
					);
	}

	private void showExerciseDescription(Exercise exercise) {
		if (exercise != null) {
			WebEngine engine = exerciseWebView.getEngine();
			Scanner scanner;
			try {
				scanner = new Scanner(exercise.getExerciseDescription());
				String webstr = scanner.useDelimiter("\\Z").next();
				engine.loadContent(webstr);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		exerciseTable.setItems(mainApp.getExerciseData());
	}
}
