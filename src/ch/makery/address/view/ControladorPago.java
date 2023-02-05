package ch.makery.address.view;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControladorPago {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Text total;
    
    
    
    @FXML
    void pagoCaja(ActionEvent event) {
    	
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Correcto");
		alert.setContentText("Pago correcto");
		alert.showAndWait();
		//alert.close();
		Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }

    @FXML
    void pagoTarjeta(ActionEvent event) {
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Correcto");
		alert.setContentText("Pago correcto");
		alert.showAndWait();
		//alert.close();
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
    }

    @FXML
    void initialize() {
    	
    	//total.setText("6.95");
    }

}
