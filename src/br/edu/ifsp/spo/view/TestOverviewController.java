package br.edu.ifsp.spo.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import br.edu.ifsp.spo.MainApp;
import br.edu.ifsp.spo.model.Exercicio;
import br.edu.ifsp.spo.model.Prova;
import br.edu.ifsp.spo.model.Resolucao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class TestOverviewController {

	@FXML
	private TableView<Exercicio> exerciseTable;

	@FXML
	private TableColumn<Exercicio, String> exerciseNameColumn;

	@FXML
	private TableColumn<Exercicio, String> exerciseSendedColumn;

	@FXML
	private WebView exerciseWebView;

	private MainApp mainApp;

	public TestOverviewController() {
	}

	@FXML
	private void initialize() throws FileNotFoundException {
		exerciseNameColumn.setCellValueFactory(cellData -> cellData.getValue().nomeExercicioProperty());
		exerciseSendedColumn.setCellValueFactory(cellData -> cellData.getValue().exercicioEnviadoProperty());
	}

	@FXML
	private void handleEnviar() {
		Exercicio exercicioSelected = exerciseTable.getSelectionModel().getSelectedItem();
		if (exercicioSelected != null) {
			Resolucao temp = new Resolucao(exercicioSelected, mainApp.getGrupoLogado());
			showResolucaoDialog(temp, exercicioSelected.getNomeExercicio());
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Nenhuma seleção");
			alert.setHeaderText("Nenhum Exercicio Selecionado");
			alert.setContentText("Por favor selecione um exercicio");
			alert.showAndWait();
		}
	}

	private void showResolucaoDialog(Resolucao resolucao, String exercicioNome) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ResolucaoDialog.fxml"));
			AnchorPane resolucaoDialog = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Enviar resolução | " + exercicioNome);
			dialogStage.getIcons().add(new Image("file:resources/images/icone.png"));
			dialogStage.initOwner(mainApp.getPrimaryStage());
			Scene scene = new Scene(resolucaoDialog);
			dialogStage.setScene(scene);

			ResolucaoDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setResolucao(resolucao);
			controller.setTitle();

			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public void setProva(Prova prova) {
		exerciseTable.setItems(prova.getExercicios());
	}
}
