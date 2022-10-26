package ch.makery.address.view;
/*
import ch.makery.address.model.Alimentos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorPedido {
	
	private ObservableList<String> alimentos;

	
	 void initialize() {
	    	alimentos = FXCollections.observableArrayList();
	    	this.colPedidos.setCellValueFactory(new PropertyValueFactory<>("pedidos"));
	        
	    	
	 
	 }
}*/

import java.net.URL;
import java.util.ResourceBundle;

import ch.makery.address.model.Pedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorPedido {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup Entrantes;

    @FXML
    private TableColumn colPedido;
    
    @FXML
    private ChoiceBox<String> principales;

    @FXML
    private TableView<Pedido> tablePedido;
    
    private ObservableList<Pedido> pedidos;

    @FXML
    void agregarPedido(ActionEvent event) {
    	
    	String pedido = this.Entrantes.getSelectedToggle().toString();
    	
    	Pedido p = new Pedido(pedido);
    	
    	if(!this.pedidos.contains(p)) {
    		this.pedidos.add(p);
    		this.tablePedido.setItems(pedidos);
    	}
    }

    @FXML
    void initialize() {
    	pedidos = FXCollections.observableArrayList();
    	this.colPedido.setCellValueFactory(new PropertyValueFactory<>("pedido"));
    	
    	principales.setValue("Select value: ");
    	principales.getItems().addAll("Verdura","Pollo","Ternera","Gamba"); 
        
       
    }
    
    

}

