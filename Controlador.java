import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Controlador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button boton;
    
    private BorderPane rootLayout;

    @FXML
    void abrirPantalla(ActionEvent event) {
    	
    	try {
    		 // Cargamos el archivo Controles Dinámicos
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(Controlador.class.getResource("Restaurante2.fxml"));
    		BorderPane listadoControles = (BorderPane) loader.load();
    		// Se sitúa en el centro del diseño principal
    		rootLayout.setCenter(listadoControles);
    		
    		 } catch (IOException e) {
    		e.printStackTrace();
    		 }

    }

	public void setRootLayout(BorderPane rootLayout2) {

		this.rootLayout = rootLayout2;
		
	}
	



}
