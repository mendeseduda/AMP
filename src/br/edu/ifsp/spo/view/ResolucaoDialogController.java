package br.edu.ifsp.spo.view;

import br.edu.ifsp.spo.model.Exercicio;
import br.edu.ifsp.spo.model.Resolucao;
import br.edu.ifsp.spo.servicos.ResolucaoServico;
import br.edu.ifsp.spo.servicos.ResolucaoServicoInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ResolucaoDialogController {

	@FXML
	private Label title;

	@FXML
	private TextArea codeArea;

	private Stage dialogStage;
	private Resolucao resolucao;
	private ResolucaoServico resolucaoServico;


	@FXML
    private void initialize() {
		resolucaoServico = new ResolucaoServico();
	}

	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

	@FXML
	private void handleEnviar() {
		String text = codeArea.getText();
		if (text.length() != 0){
			resolucao.setResolucao(text);
			resolucaoServico.inserirResolucao(resolucao);
			resolucao.getExercicio().setExercicioEnviado("Sim");
			dialogStage.close();
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Código inválido");
			alert.setHeaderText("Nada para ser enviado");
			alert.setContentText("Por favor preencha a área de resolução para enviar");
			alert.showAndWait();
		}
	}

	public void setTitle() {
		title.setText(resolucao.getExercicio().getNomeExercicio());
	}

	public void setResolucao(Resolucao resolucao) {
		this.resolucao = resolucao;
	}

}
