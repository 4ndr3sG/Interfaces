package ch.makery.address.view;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ControladorAyuda {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enviar;
    
    private BorderPane rootLayout;

    @FXML
    void enviarSugerencia(ActionEvent event) {

    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Enviado con Exito");
		alert.setContentText("Su formulario ha sido enviado con éxito \n Gracias");
		alert.showAndWait();
		Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    
	    //stage.getScene().getWindow().;
	    //stage.cleanup();
		//rootLayout.setCenter(null);
    	
    }

    @FXML
    void initialize() {
        //assert enviar != null : "fx:id=\"enviar\" was not injected: check your FXML file 'RestauranteContacto.fxml'.";

    }

}
