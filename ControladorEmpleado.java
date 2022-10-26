package ch.makery.address.view;
import java.net.URL;
import java.util.ResourceBundle;

import ch.makery.address.model.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorEmpleado {
	
	@FXML
	private TextField txtApellido;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtTurno;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Empleado> TablaEmpleados;

    @FXML
    private TableColumn colApellido;

    @FXML
    private TableColumn colNombre;

    @FXML
    private TableColumn colTurno;
    
    private ObservableList<Empleado> empleados;

    @FXML
    public void initialize() {
    	empleados = FXCollections.observableArrayList();
    	this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    	this.colTurno.setCellValueFactory(new PropertyValueFactory<>("turno"));
    	Empleado em2 = new Empleado("Mario","Bross","Mañana");
    	Empleado em3 = new Empleado("Felipe","Neduro","Tarde");
    	Empleado em4 = new Empleado("Maria","Cristal","Tarde");
    	Empleado em5 = new Empleado("Andres","Guzman","Mañana");
    	this.empleados.add(em2);
    	this.empleados.add(em3);
    	this.empleados.add(em4);
    	this.empleados.add(em5);
        
      
    }
    
    @FXML
    void agregarPersona(ActionEvent event) {
    	
    	String nombre= this.txtNombre.getText();
    	String apellido= this.txtApellido.getText();
    	String turno= this.txtTurno.getText();
    	
    	Empleado em = new Empleado(nombre,apellido,turno);
    	
    	if(!this.empleados.contains(em)) {
    		this.empleados.add(em);
    		this.TablaEmpleados.setItems(empleados);
    	}
    	else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setTitle("Error");
    		alert.setContentText("Formato incorrecto");
    		alert.showAndWait();
    	}
   
    }
  

}
