package ch.makery.address.view;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import ch.makery.address.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ControladorUno {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    private BorderPane rootLayout;
    
    private MainApp mainApp;

	private Stage dialogStage;

    @FXML
    void salir(ActionEvent event) {
    	//rootLayout.setCenter(null);
    	 System.exit(0);
    }
    
    @FXML
    void ingresarEmpleado(ActionEvent event) {
    	try {
      		 // Cargamos el archivo Controles Dinámicos
      		FXMLLoader loader = new FXMLLoader();
      		loader.setLocation(ControladorUno.class.getResource("RestauranteEmpleado.fxml"));
      		BorderPane listadoControles = (BorderPane) loader.load();
      		// Se sitúa en el centro del diseño principal
      		System.out.println( listadoControles.toString());
      		
      		this.rootLayout.setCenter(listadoControles);
      		
      		 } catch (IOException e) {
      		e.printStackTrace();
      		 }
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        //personTable.setItems(this.mainApp.getPersonData());
               
        // TODO Versi�n con map
        //personTable.setItems(this.mainApp.getMapData()); 
    }
    @FXML
    void inicioSesion(ActionEvent event) {
    	try {
   		 // Cargamos el archivo Controles Dinámicos
   		FXMLLoader loader = new FXMLLoader();
   		loader.setLocation(ControladorUno.class.getResource("RestauranteEmpleados.fxml"));
   		BorderPane listadoControles = (BorderPane) loader.load();
   		// Se sitúa en el centro del diseño principal
   		rootLayout.setCenter(listadoControles);
   		
   		 } catch (IOException e) {
   		e.printStackTrace();
   		 }

    }
    
    @FXML
    void crearAlimentos(ActionEvent event) {
    	try {
   		 // Cargamos el archivo Controles Dinámicos
   		FXMLLoader loader = new FXMLLoader();
   		loader.setLocation(ControladorUno.class.getResource("RestauranteCrearPlato.fxml"));
   		BorderPane listadoControles = (BorderPane) loader.load();
   		// Se sitúa en el centro del diseño principal
   		rootLayout.setCenter(listadoControles);
   		
   		 } catch (IOException e) {
   		e.printStackTrace();
   		 }

    }
    
    @FXML
    void sobreNostros(ActionEvent event) {
    	try {
      		 // Cargamos el archivo Controles Dinámicos
      		FXMLLoader loader = new FXMLLoader();
      		loader.setLocation(ControladorUno.class.getResource("RestauranteContacto.fxml"));
      		BorderPane listadoControles = (BorderPane) loader.load();
      		// Se sitúa en el centro del diseño principal
      		rootLayout.setCenter(listadoControles);
      		
      		 } catch (IOException e) {
      		e.printStackTrace();
      		 }
    }
    
    void reGresar(ActionEvent event) {
    	try {
      		 // Cargamos el archivo Controles Dinámicos
      		FXMLLoader loader = new FXMLLoader();
      		loader.setLocation(ControladorUno.class.getResource("RestauranteView.fxml"));
      		BorderPane listadoControles = (BorderPane) loader.load();
      		// Se sitúa en el centro del diseño principal
      		rootLayout.setCenter(listadoControles);
      		
      		 } catch (IOException e) {
      		e.printStackTrace();
      		 }
    }

    @FXML
    void verCarta(ActionEvent event) {
    	try {
      		 // Cargamos el archivo Controles Dinámicos
      		FXMLLoader loader = new FXMLLoader();
      		loader.setLocation(ControladorUno.class.getResource("RestauranteCarta.fxml"));
      		BorderPane listadoControles = (BorderPane) loader.load();
      		// Se sitúa en el centro del diseño principal
      		rootLayout.setCenter(listadoControles);
      		
      		 } catch (IOException e) {
      		e.printStackTrace();
      		 }
    }
    
    
    @FXML
    void abrirAyuda(ActionEvent event) {
    	try {
      		 // Cargamos el archivo Controles Dinámicos
      		FXMLLoader loader = new FXMLLoader();
      		loader.setLocation(ControladorUno.class.getResource("RestauranteAyuda.fxml"));
      		BorderPane listadoControles = (BorderPane) loader.load();
      		// Se sitúa en el centro del diseño principal
      		rootLayout.setCenter(listadoControles);
      		
      		 } catch (IOException e) {
      		e.printStackTrace();
      		 }
    }

    @FXML
    void initialize() {

    }

	public void setRootLayout(BorderPane rootLayout2) {

		this.rootLayout = rootLayout2;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;		
	}
	public Stage getDialogStage() {
		return dialogStage;
	}

}
