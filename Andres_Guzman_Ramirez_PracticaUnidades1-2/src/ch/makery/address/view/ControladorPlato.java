package ch.makery.address.view;
import java.net.URL;
import java.util.ResourceBundle;

import ch.makery.address.model.Alimentos;
import ch.makery.address.model.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorPlato {
	
	  @FXML
	    private TextField txtNombre;

	  @FXML
	    private TextField txtPrecio;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> categoria;
    
    @FXML
    private ChoiceBox<String> cantidad;
    
    @FXML
    private TableColumn colCantidad;

    @FXML
    private TableColumn colNombre;

    @FXML
    private TableColumn colPrecio;

    @FXML
    private TableColumn colTotal;

    @FXML
    private TableColumn colCategoria;

    @FXML
    private TableView<Alimentos> tableAlimentos;
    
    private ObservableList<Alimentos> alimentos;


    @FXML
    void initialize() {
    	alimentos = FXCollections.observableArrayList();
    	this.colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
    	this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
    	this.colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
    	this.colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    	
    	categoria.setValue("Select value: ");
    	categoria.getItems().addAll("Primeros platos","Segundos platos","Postres","Bebidas"); 
    	
    	//cantidad.setValue("Select value: ");
    	cantidad.getItems().addAll("1","2","3","4"); 
    	
    	
    }
    
    @FXML
    void agregarAlimento(ActionEvent event) {
    	
    	String categoria= this.categoria.getValue();
    	String nombre= this.txtNombre.getText();
    	int cantidad= Integer.parseInt(this.cantidad.getValue());
    	double precio=Double.parseDouble(this.txtPrecio.getText());
    	double total= precio*cantidad;
    	
    	Alimentos al = new Alimentos(categoria,nombre,cantidad,precio);
    	
    	if(!this.alimentos.contains(al)) {
    		this.alimentos.add(al);
    		this.tableAlimentos.setItems(alimentos);
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
