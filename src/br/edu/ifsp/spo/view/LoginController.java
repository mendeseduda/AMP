package br.edu.ifsp.spo.view;

import br.edu.ifsp.spo.MainApp;
import br.edu.ifsp.spo.model.Grupo;
import br.edu.ifsp.spo.model.Logavel;
import br.edu.ifsp.spo.servicos.GrupoServico;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public final class LoginController {

	@FXML
	private TextField usernameField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private ImageView imageLogo;

	@FXML
	private Hyperlink adminAcess;

	private Stage dialogStage;
	private GrupoServico grupoServico;
	private MainApp mainApp;
	private boolean ok;

	@FXML
	private void initialize() {
		grupoServico = new GrupoServico();
		imageLogo.setImage(new Image("file:resources/images/boi.png"));
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void keyEvent(KeyEvent e){
		if (e.getCode().equals(KeyCode.ENTER)){
			handleEntrar();
		}
	}

	@FXML
	private void handleEntrar() {
		if (isInputValid()) {
			Grupo temp = new Grupo(null, usernameField.getText(), passwordField.getText());
			ok = grupoServico.logar(temp);
			if (ok) {
				mainApp.setGrupoLogado(temp);
				mainApp.initRootLayout();
				mainApp.showTestOverview();
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Login");
				alert.setHeaderText("Falha ao logar!");
				alert.setContentText("Usuário ou senha incorreto");
				alert.showAndWait();
			}
		}

	}

	@FXML
	private void handleAcessarAdmin() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Administração");
		alert.setHeaderText("Novidades em breve!");
		alert.setContentText("Função não implementada");
		alert.showAndWait();
	}

	private boolean isInputValid() {
		String errorMessage = "";

		if (usernameField.getText() == null || usernameField.getText().length() == 0) {
			errorMessage += "Insira o nome de usuário";
		}
		if (passwordField.getText() == null || passwordField.getText().length() == 0) {
			errorMessage += "\nInsira a senha";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Campos Inválidos");
			alert.setHeaderText("Preencher os campos");
			alert.setContentText(errorMessage);
			alert.showAndWait();

			return false;
		}

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
