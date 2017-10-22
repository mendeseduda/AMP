package br.edu.ifsp.spo;

import java.io.File;
import java.io.IOException;

import br.edu.ifsp.spo.model.Exercicio;
import br.edu.ifsp.spo.model.Exercise;
import br.edu.ifsp.spo.model.Grupo;
import br.edu.ifsp.spo.model.Maratona;
import br.edu.ifsp.spo.model.Prova;
import br.edu.ifsp.spo.servicos.ExercicioServico;
import br.edu.ifsp.spo.servicos.GrupoServico;
import br.edu.ifsp.spo.servicos.ProvaServico;
import br.edu.ifsp.spo.view.LoginController;
import br.edu.ifsp.spo.view.TestOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private Grupo grupoLogado;
	private Maratona maratona;
	private Prova p;

	public MainApp() {
		new GrupoServico().cadastrar("admin", "admin", null);
		ExercicioServico servico = new ExercicioServico();
		ProvaServico ps = new ProvaServico();
		p = ps.cadastrarProva(1, "Prova", new File("maratona.txt"));
		p.getExercicios().add(servico.cadastrarExercicio(1, "Teste1", "Teste1.java", p));
		p.getExercicios().add(servico.cadastrarExercicio(2, "Teste2", "Teste2.java", p));
		maratona = new Maratona(p);
	}

	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("BOI | Login");
		this.primaryStage.getIcons().add(new Image("file:resources/images/icone.png"));
		showLogin();

	}

	public void changeScene(Scene scene, String title) {
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle(title);
		primaryStage.show();
	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			changeScene(scene, "BOI");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Login.fxml"));
			AnchorPane login = (AnchorPane) loader.load();

			LoginController controller = loader.getController();
			controller.setMainApp(this);

			Scene scene = new Scene(login);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public void showTestOverview() {
		try {
			// Carrega o test overview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/TestOverview.fxml"));
			AnchorPane testOverview = (AnchorPane) loader.load();

			// Coloca o test overview dentro root layout
			rootLayout.setCenter(testOverview);

			// Permite que o controller tenha acesso a main
			TestOverviewController controller = loader.getController();
			controller.setProva(p);
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setGrupoLogado(Grupo grupoLogado) {
		this.grupoLogado = grupoLogado;
	}

	public Grupo getGrupoLogado() {
		return grupoLogado;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
