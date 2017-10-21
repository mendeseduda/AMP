package br.edu.ifsp.spo;

import java.io.IOException;

import br.edu.ifsp.spo.model.Exercise;
import br.edu.ifsp.spo.servicos.GrupoServico;
import br.edu.ifsp.spo.view.LoginController;
import br.edu.ifsp.spo.view.TestOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Exercise> exerciseData =  FXCollections.observableArrayList();

    public MainApp() {
		exerciseData.add(new Exercise("Jogo", "Sim", "resources/exercises/jogo.html"));
		exerciseData.add(new Exercise("César", "Sim", "resources/exercises/regras.html"));
		exerciseData.add(new Exercise("Joãozinho", "Não", "resources/exercises/exemplo.html"));
    }

    public ObservableList<Exercise> getExerciseData(){
    	return exerciseData;
    }

	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BOI | Login");

        showLogin();

	}

	public void initRootLayout() {
        try {
        	//Carrega o root layout
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Inicia o a cena com o root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void showLogin(){
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
            //Carrega o test overview
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TestOverview.fxml"));
            AnchorPane testOverview = (AnchorPane) loader.load();

            // Coloca o test overview dentro root layout
            rootLayout.setCenter(testOverview);

            //Permite que o controller tenha acesso a main
            TestOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
		launch(args);
	}
}
