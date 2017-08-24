package br.edu.ifsp.spo.view;

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
    private void initialize() {
        exerciseNameColumn.setCellValueFactory(cellData -> cellData.getValue().exerciseNameProperty());
        exerciseSendedColumn.setCellValueFactory(cellData -> cellData.getValue().exerciseSendedProperty());

        WebEngine engine  = exerciseWebView.getEngine();
        String url = TestOverviewController.class.getResource("jogo.html").toExternalForm();
        engine.load(url);
    }

    public void setMainApp(MainApp mainApp){
    	this.mainApp = mainApp;

    	exerciseTable.setItems(mainApp.getExerciseData());
    }
}
