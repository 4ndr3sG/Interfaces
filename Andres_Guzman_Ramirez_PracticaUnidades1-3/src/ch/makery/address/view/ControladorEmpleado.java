package ch.makery.address.view;
import java.net.URL;
import java.util.ResourceBundle;

import ch.makery.address.model.Empleado;
import ch.makery.address.model.Pedido;
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
import javafx.scene.input.MouseEvent;

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
    
    private ObservableList<Empleado> empleados = FXCollections.observableArrayList(
    	    new Empleado("Mario","Bross","Mañana"),
    	    new Empleado("Felipe","Neduro","Tarde"),
    	    new Empleado("Maria","Cristal","Tarde"),
    	    new Empleado("Andres","Guzman","Mañana"));

    @FXML
    public void initialize() {
    
    	TablaEmpleados.setItems(empleados);
    	
    	this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    	this.colTurno.setCellValueFactory(new PropertyValueFactory<>("turno"));
    	
        
      
    }
    @FXML
    void eliminarPersona(ActionEvent event) {
    	Empleado p = this.TablaEmpleados.getSelectionModel().getSelectedItem();
    	
    	if(p==null) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setTitle("Error");
    		alert.setContentText("Formato incorrecto");
    		alert.showAndWait();
    	}
    	
    	else {
    		
    		this.empleados.remove(p);
    		this.TablaEmpleados.refresh();
    		
    	}
    }

    @FXML
    void seleccionar(MouseEvent event) {
    	Empleado p = this.TablaEmpleados.getSelectionModel().getSelectedItem();
    	
    	if(p==null) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setTitle("Error");
    		alert.setContentText("Formato incorrecto");
    		alert.showAndWait();
    	}
    }
    
    @FXML
    void agregarPersona(ActionEvent event) {
    	
    	String nombre= this.txtNombre.getText();
    	String apellido= this.txtApellido.getText();
    	String turno= this.txtTurno.getText();
    	
    	Empleado em = new Empleado(nombre,apellido,turno);
    	 if(em.getNombre()==""||em.getApellido()==""||em.getTurno()=="") {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setTitle("Error");
    		alert.setContentText("Formato incorrecto");
    		alert.showAndWait();
    	}
    	else if(!this.empleados.contains(em)) {
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
