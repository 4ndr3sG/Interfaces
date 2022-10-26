package ch.makery.address;

import ch.makery.address.view.ControladorUno;
/*	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
*/
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	private BorderPane rootLayout;
	@Override
	public void start(Stage primaryStage) {
		
		
			try {
				
				/*// Carga el dise�o del archivo FXML en la variable rootLayout*/
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("view/RestauranteView.fxml"));
				rootLayout = (BorderPane) loader.load();
				
				 ControladorUno menuController = loader.getController();
				 menuController.setRootLayout(rootLayout);
				 

				// Mostramos la escena del BorderPane de la variable rootLayot
				Scene scene = new Scene(rootLayout);
				primaryStage.setScene(scene);
				primaryStage.setTitle("Controles");
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

