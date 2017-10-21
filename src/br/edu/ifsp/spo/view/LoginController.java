package br.edu.ifsp.spo.view;

import br.edu.ifsp.spo.MainApp;
import br.edu.ifsp.spo.model.Grupo;
import br.edu.ifsp.spo.model.Logavel;
import br.edu.ifsp.spo.servicos.GrupoServico;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private void handleEntrar() {
		if (isInputValid()) {
			ok = grupoServico.logar(usernameField.getText(), passwordField.getText());
			if (ok) {
				mainApp.initRootLayout();
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Login");
				alert.setHeaderText("Falha ao logar!");
				alert.setContentText("Usu�rio ou senha incorreto");
				alert.showAndWait();
			}
		}

	}

	@FXML
	private void handleAcessarAdmin(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Administra��o");
		alert.setHeaderText("Novidades em breve!");
		alert.setContentText("Fun��o n�o implementada");
		alert.showAndWait();
	}

	private boolean isInputValid() {
		String errorMessage = "";

		if (usernameField.getText() == null || usernameField.getText().length() == 0) {
			errorMessage += "Insira o nome de usu�rio";
		}
		if (passwordField.getText() == null || passwordField.getText().length() == 0) {
			errorMessage += "\nInsira a senha";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Campos Inv�lidos");
			alert.setHeaderText("Preencher os campos");
			alert.setContentText(errorMessage);
			alert.showAndWait();

			return false;
		}

	}

	private boolean verifyLogin(String username, String password) {
		return grupoServico.logar(username, password);
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
