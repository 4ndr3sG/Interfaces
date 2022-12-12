package ch.makery.address.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MiDialogoController {

	@FXML
    private PasswordField password;

    @FXML
    private TextField username;
    
    @FXML
    private Button btnAceptar;
    
    // Campos auxiliares para intercambiar datos con la clase Main
    private Stage dialogStage;
    private Label label;
      	
    @FXML
    private void initialize() {
    	
    }
    @FXML
    void cancelar(ActionEvent event) {
    	Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }
    
    @FXML
    private void cargarUsuario(ActionEvent event) {
    	if ((username.getText() == null) || (username.getText().length() == 0) || 
    		(password.getText() == null) || (password.getText().length() == 0)) {
    		
    		// Se muestra un alert si algún campo está vacío
    		Alert errorAlert = new Alert(AlertType.ERROR);
        	
    		errorAlert.setTitle("Hay campos incorrectos");
    		errorAlert.setHeaderText("Por favor, rellena correctamente los campos");
    		errorAlert.setContentText("El usuario o la contraseña están vacíos");
    		
    		errorAlert.showAndWait();
    	} else {
    		/*label.setText("Usuario: " + username.getText() + " Password: " + password.getText());
    		*/
    		try {
        		 // Cargamos el archivo Controles Dinámicos
        		FXMLLoader loader = new FXMLLoader();
        		loader.setLocation(ControladorEmpleadosIn.class.getResource("RestauranteCrearPlato.fxml"));
        		BorderPane listadoControles = (BorderPane) loader.load();
        		// Se sitúa en el centro del diseño principal
        		// Se crea un nuevo Stage para mostrar el di�logo
   	        Stage dialogStage = new Stage();
   	        dialogStage.setTitle("Crear o editar persona");
   	        dialogStage.initModality(Modality.WINDOW_MODAL);
   	        //dialogStage.initOwner(primaryStage);
   	        Scene scene = new Scene(listadoControles);
   	        dialogStage.setScene(scene);
        		//rootLayout.setCenter(listadoControles);
        		
        		 dialogStage.showAndWait();
        		 } catch (IOException e) {
        		e.printStackTrace();
        		 }
    		//dialogStage.close();
    		Node source = (Node) event.getSource();
    	    Stage stage = (Stage) source.getScene().getWindow();
    	    stage.close();
    	}        
    }

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
	    
}
