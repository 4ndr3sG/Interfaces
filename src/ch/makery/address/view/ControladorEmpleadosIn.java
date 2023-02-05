package ch.makery.address.view;



import java.io.IOException;

import ch.makery.address.MainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorEmpleadosIn {

    @FXML
    private PasswordField contraEmpleado;

    @FXML
    private TextField idEmpleado;
    
    private BorderPane rootLayout;
    
    

    @FXML
    void crearEmpleado(ActionEvent event) {
    	
    	try {
    		 // Cargamos el archivo Controles Dinámicos
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(ControladorEmpleadosIn.class.getResource("MiDialogo.fxml"));
    		AnchorPane listadoControles = (AnchorPane) loader.load();
    		// Se sitúa en el centro del diseño principal
    		// Se crea un nuevo Stage para mostrar el di�logo
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Acceso Administrador");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        //dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(listadoControles);
	        dialogStage.setScene(scene);
    		//rootLayout.setCenter(listadoControles);
    		
    		 dialogStage.showAndWait();
    		 } catch (IOException e) {
    		e.printStackTrace();
    		 }
   
    }

    @FXML
    void ingresarEmpleado(ActionEvent event) {
    	
    	if(idEmpleado.getText().equals("admin")&& contraEmpleado.getText().equals("admin")) {
    		/*Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		alert.setHeaderText(null);
    		alert.setTitle("Correct");
    		alert.setContentText("CORRECTO");
    		alert.showAndWait();*/
    		try {
         		 // Cargamos el archivo Controles Dinámicos
         		FXMLLoader loader = new FXMLLoader();
         		loader.setLocation(ControladorEmpleadosIn.class.getResource("RestauranteEmpleado.fxml"));
         		BorderPane listadoControles = (BorderPane) loader.load();
         		// Se sitúa en el centro del diseño principal
         		// Se crea un nuevo Stage para mostrar el di�logo
    	        Stage dialogStage = new Stage();
    	        dialogStage.setTitle("Acceso Administrativo");
    	        dialogStage.initModality(Modality.WINDOW_MODAL);
    	        //dialogStage.initOwner(primaryStage);
    	        Scene scene = new Scene(listadoControles);
    	        dialogStage.setScene(scene);
         		//rootLayout.setCenter(listadoControles);
         		
         		 dialogStage.showAndWait();
         		 } catch (IOException e) {
         		e.printStackTrace();
         		 }
    	}
    	else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setTitle("Error");
    		alert.setContentText("Formato incorrecto");
    		alert.showAndWait();
    		System.out.println(idEmpleado.getText() + ""+ contraEmpleado.getText());
    	}
    }

}
