package ch.makery.address.view;
import java.net.URL;
import java.util.ResourceBundle;

import ch.makery.address.model.Alimentos;
import ch.makery.address.model.Empleado;
import ch.makery.address.model.Pedido;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
    	
    	//categoria.setValue("Select value: ");
    	categoria.getItems().addAll("Primeros platos","Segundos platos","Postres","Bebidas"); 
    	
    	//cantidad.setValue("Select value: ");
    	cantidad.getItems().addAll("1","2","3","4"); 
    	// Los eventos de teclado se crean directamente sobre el objeto Scene
    	
    	txtPrecio.addEventFilter(KeyEvent.KEY_TYPED, e -> {

    				    String type = e.getEventType().getName();
    				    String source = e.getSource().getClass().getSimpleName();
    				    String target = e.getTarget().getClass().getSimpleName();

    				    System.out.println("filter: " + type + ", " + source + ", " + target);
    				    
    				    if (!Character.isDigit(e.getCharacter().charAt(0))) {
    				        System.out.println("caracter: " + e.getCharacter() + ", no permitido.");
    				        e.consume();
    				    }
    				});
    	
    	
    }
    
    @FXML
    void agregarAlimento(ActionEvent event) {
    	
    	/*String categoria= this.categoria.getValue();
    	String nombre= this.txtNombre.getText();
    	int cantidad= Integer.parseInt(this.cantidad.getValue());
    	double precio=Double.parseDouble(this.txtPrecio.getText());
    	double total= precio*cantidad;
    	al.getCategoria().isEmpty() || al.getNombre().isEmpty() || al.getCantidad()==0 
    			||al.getPrecio() == 0 */
    	/*if((categoria.equals("")||categoria.isEmpty()) && (cantidad==0) && (nombre.equals("")||nombre.isEmpty()) && (precio==0) ) {
    		
    	}*/
    	if (((this.categoria.getValue()!=null) && (!this.txtNombre.getText().isEmpty())
    			&& (this.cantidad.getValue()!=null) && (!this.txtPrecio.getText().isEmpty())
    			)) {
    		/*|| ((this.categoria.getValue()==null) && (this.txtNombre.getText().isEmpty())
    	    			&& (this.cantidad.getValue()==null) && (this.txtPrecio.getText().isEmpty()))*/
			
    		
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
    	else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setTitle("Error");
    		alert.setContentText("Formato incorrecto");
    		alert.showAndWait();
    		System.out.println(this.categoria.getValue());
    		System.out.println(this.txtNombre.getText().isEmpty());
    		System.out.println(this.cantidad.getValue());
    		System.out.println(txtPrecio.getText().isEmpty());
    	}
    	
    	
    	
    	//Alimentos al = new Alimentos(categoria,nombre,cantidad,precio);
    	/**/
    	/*
    	else {
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
    	}}*/
    }
    @FXML
    void eliminarAlimento(ActionEvent event) {
    	Alimentos p = this.tableAlimentos.getSelectionModel().getSelectedItem();
    	
    	if(p==null) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setTitle("Error");
    		alert.setContentText("Formato incorrecto");
    		alert.showAndWait();
    	}
    	else {
    		
    		this.alimentos.remove(p);
    		this.tableAlimentos.refresh();
    		
    	}
    }

    @FXML
    void seleccionar(MouseEvent event) {
    	Alimentos p = this.tableAlimentos.getSelectionModel().getSelectedItem();
    	
    	if(p==null) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setTitle("Error");
    		alert.setContentText("Formato incorrecto");
    		alert.showAndWait();
    	}
    }

}
