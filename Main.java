package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;


public class Main extends Application {

	private BorderPane rootLayout;
	@Override
	public void start(Stage primaryStage) {
	 try {
	 // Carga el diseño del archivo FXML en la variable rootLayout
	 FXMLLoader loader = new FXMLLoader();
	 loader.setLocation(Main.class.getResource("Restaurante.fxml"));
	 rootLayout = (BorderPane) loader.load();
	
	 Controlador menuController = loader.getController();
	 menuController.setRootLayout(rootLayout);
		 
		 
	 // Mostramos la escena del BorderPane de la variable rootLayot
	 Scene scene = new Scene(rootLayout);
	 primaryStage.setScene(scene);
	 primaryStage.show();
	 } catch(Exception e) {
	e.printStackTrace();
	 }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
