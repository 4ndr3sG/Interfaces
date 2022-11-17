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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



import ch.makery.address.model.Pedido;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private TableColumn colPrecio;
    
    @FXML
    private ChoiceBox<String> principalesArr;

    @FXML
    private ChoiceBox<String> principalesEspa;

    @FXML
    private ChoiceBox<String> principalesTall;
    @FXML
    private TableView<Pedido> tablePedido;
    
    private ObservableList<Pedido> pedidos;
    //private ObservableList<Pedido> precio;
    
    @FXML
    private RadioButton alitas;

    @FXML
    private RadioButton arroz;

    @FXML
    private RadioButton ensalada;
    
    @FXML
    private RadioButton Helado;

    @FXML
    private RadioButton Fruta;

    @FXML
    private RadioButton Cafe;

    @FXML
    private RadioButton nuggets;

    @FXML
    private RadioButton patatas;
    
    @FXML
    private RadioButton sopa;
    
    @FXML
    private RadioButton FiletePollo;

    @FXML
    private RadioButton FileteTernera;

    @FXML
    private RadioButton Pescado;
    
    @FXML
    private RadioButton Agua;

    @FXML
    private RadioButton Refresco;

    @FXML
    private RadioButton Cerveza;
    
    @FXML
    private Text total;
    private double precioTotal;


   /* @FXML
    void agregarPedido(ActionEvent event) {
    	
   
    	String pedido = this.Entrantes.getSelectedToggle().toString();
    	//String pedidoChoice = this.principales.getValue();
    	
    	Pedido p = new Pedido(pedido);
    	//Pedido a = new Pedido(pedidoChoice);
    	
    	if(!this.pedidos.contains(p)) {
    		this.pedidos.add(p);
    		this.tablePedido.setItems(pedidos);
    	}
    	/*if(!this.pedidos.contains(a)) {
    		this.pedidos.add(a);
    		this.tablePedido.setItems(pedidos);
    	}
    }*/
    @FXML
    void finalizarPedido(ActionEvent event) {
    	
    	if(precioTotal<=0) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setTitle("Error");
    		alert.setContentText("Formato incorrecto");
    		alert.showAndWait();
    	}
    	else {
    	
    	total.setText(""+precioTotal);
    	
    	try {
    		 // Cargamos el archivo Controles Dinámicos
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(ControladorEmpleadosIn.class.getResource("RestaurantePago.fxml"));
    		BorderPane listadoControles = (BorderPane) loader.load();
    		// Se sitúa en el centro del diseño principal
    		// Se crea un nuevo Stage para mostrar el di�logo
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Crear o editar persona");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        //dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(listadoControles);
	        dialogStage.setScene(scene);
    		
    		
    		 dialogStage.showAndWait();
    		 
    		 if(dialogStage.isShowing()) {
    			 System.out.println("se muestra");
    		 }
    		 else {
    			 System.out.println(" NO   se muestra");
    			 pedidos.clear();
    			 total.setText("");
    			 precioTotal = 0;
    		 }
    		 } catch (IOException e) {
    		e.printStackTrace();
    		 }}
    }
    @FXML
    void CancelarPedido(ActionEvent event) {
    	
    	//total.setText(""+precioTotal);
    	precioTotal = 0;
    	total.setText("");
    	pedidos.clear();
    	
    }

    @FXML
    void agregarPedidoBebidas(ActionEvent event) {
    	String pedido ="";
    	double precio = 0;
    	
    	if (Agua.isSelected()) {
			pedido="Agua";
			precio = 2;
		}
    	else if(Refresco.isSelected()) {
    		pedido="Refresco";
    		precio = 2;
    	}
    	else if(Cerveza.isSelected()) {
    		pedido="Cerveza";
    		precio = 2;
    	}
    	
    	Pedido p = new Pedido(pedido,precio);
    	//Pedido a = new Pedido(pedidoChoice);
    	
    	if(!this.pedidos.contains(p)) {
    		precioTotal +=precio;
    		this.pedidos.add(p);
    		this.tablePedido.setItems(pedidos);
    		System.out.println(pedido);
    	}
    }

    @FXML
    void agregarPedidoEntrante(ActionEvent event) {
    	//String radioButtonId = Button.getCheckedRadioButtonId();
    	//alitas.setToggleGroup(Entrantes);
    	/*
    	RadioButton selectedRadioButton = (RadioButton) Entrantes.getSelectedToggle();
    	String toogleGroupValue = selectedRadioButton.getText();
 
		
    	Entrantes.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
    	@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
				if(Entrantes.getSelectedToggle() != null) {
					System.out.println(Entrantes.getSelectedToggle().getUserData().toString());
				}
				
			}
    		
		});*/
    	//String pedido = this.Entrantes.toString();
    	//String pedidoChoice = this.principales.getValue();
    	// pedido = Entrantes.getSelectedToggle().getClass().g;
    	
    	double precio = 6.95;
    	
    	String pedido ="";
    	if (alitas.isSelected()) {
			pedido="alitas";
		}
    	else if(arroz.isSelected()) {
    		pedido="arroz";
    	}
    	else if(ensalada.isSelected()) {
    		pedido="ensalada";
    	}
    	else if(nuggets.isSelected()) {
    		pedido="nuggets";
    	}
    	else if(patatas.isSelected()) {
    		pedido="patatas";
    	}
    	else if(sopa.isSelected()) {
    		pedido="sopa";
    	}
    	Pedido p =  new Pedido(pedido,precio);
    	//Pedido a = new Pedido(pedidoChoice);
    	
    	if(!this.pedidos.contains(p)) {
    		precioTotal +=precio;
    		this.pedidos.add(p);
    		this.tablePedido.setItems(pedidos);
    		System.out.println(pedido);
    	}
    	
    	Entrantes.selectedToggleProperty().addListener((observable, oldVal, newVal) -> System.out.println(newVal + " was selected"));

    }

    @FXML
    void agregarPedidoPostres(ActionEvent event) {
    	
    	String pedido ="";
    	double precio = 1.95;
    	
    	if (Helado.isSelected()) {
			pedido="Helado";
		}
    	else if(Fruta.isSelected()) {
    		pedido="Fruta";
    	}
    	else if(Cafe.isSelected()) {
    		pedido="Cafe";
    	}
    	Pedido p = new Pedido(pedido,precio);
    	//Pedido a = new Pedido(pedidoChoice);
    	
    	if(!this.pedidos.contains(p)) {
    		precioTotal +=precio;
    		this.pedidos.add(p);
    		this.tablePedido.setItems(pedidos);
    		System.out.println(pedido);
    	}
    }

    @FXML
    void agregarPedidoPrincipales(ActionEvent event) {
    	
    	double precio = 4.95;
    	//String pedido = this.Entrantes.getSelectedToggle().toString();
    	int contador;
    	
    	String pedidoChoice = this.principalesArr.getValue();
    	String pedidoChoice2 = this.principalesEspa.getValue();
    	String pedidoChoice3 = this.principalesTall.getValue();
    	/*(principalesTall.getValue()!=null || principalesEspa.getValue()!=null && principalesArr.getValue()!=null)
    			|| */
    	if ((principalesTall.getValue() ==null || principalesEspa.getValue()==null || principalesArr.getValue()==null) 
    			|| (principalesTall.getValue()=="" && principalesEspa.getValue()=="" && principalesArr.getValue()=="") 
    			|| (principalesTall.getValue()!="" && principalesEspa.getValue()!="" && principalesArr.getValue()!="") 
    			|| (principalesTall.getValue()!="" && principalesEspa.getValue()!="" && principalesArr.getValue()=="") 
    			|| (principalesTall.getValue()=="" && principalesEspa.getValue()!="" && principalesArr.getValue()!="")
    			|| (principalesTall.getValue()!="" && principalesEspa.getValue()=="" && principalesArr.getValue()!="") 
    			)
    		{
			
				Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setHeaderText(null);
	    		alert.setTitle("Error");
	    		alert.setContentText("Formato incorrecto");
	    		alert.showAndWait();
	    		principalesTall.setValue("");
	    		principalesArr.setValue("");
	    		principalesEspa.setValue("");
	    		
	    		//principalesTall.getValue();
	    		//principalesTall.setValue();
	    		//principalesEspa.setValue("");
	    		//principalesArr.setValue("");
	    		
	    		//System.out.println(idEmpleado.getText() + ""+ contraEmpleado.getText());
			}
    	else {
    		/*Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    		alert.setHeaderText(null);
    		alert.setTitle("Correcto");
    		alert.setContentText("Formato correcto");
    		alert.showAndWait();*/
			if (principalesArr.getValue()!="") {
				Pedido a = new Pedido(pedidoChoice,precio);
				precioTotal +=precio;
				
				if(!this.pedidos.contains(a)) {
	    		this.pedidos.add(a);
	    		this.tablePedido.setItems(pedidos);
	    		}
			}
			if (principalesTall.getValue()!="") {
				Pedido a = new Pedido(pedidoChoice3,precio);
				precioTotal +=precio;
				if(!this.pedidos.contains(a)) {
	    		this.pedidos.add(a);
	    		this.tablePedido.setItems(pedidos);
	    		}
			}
			if (principalesEspa.getValue()!="") {
				Pedido a = new Pedido(pedidoChoice2,precio);
				precioTotal +=precio;
				if(!this.pedidos.contains(a)) {
	    		this.pedidos.add(a);
	    		this.tablePedido.setItems(pedidos);}
			}
    		System.out.println(principalesArr.getValue()!="");
    		principalesTall.setValue("");
    		principalesArr.setValue("");
    		principalesEspa.setValue("");
    		
    	
    	}
    	
    	/*
    	else if (principalesArr.getValue()!="") {
			Pedido a = new Pedido(pedidoChoice,precio);
			precioTotal +=precio;
			if(!this.pedidos.contains(a)) {
    		this.pedidos.add(a);
    		this.tablePedido.setItems(pedidos);
    	}
			else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setHeaderText(null);
	    		alert.setTitle("Error");
	    		alert.setContentText("Formato incorrecto");
	    		alert.showAndWait();
	    		//System.out.println(idEmpleado.getText() + ""+ contraEmpleado.getText());
			}
			principalesArr.setValue("");
			
		
		}
    	else if (principalesEspa.getValue()!="") {
			Pedido a = new Pedido(pedidoChoice2,precio);
			precioTotal +=precio;
			if(!this.pedidos.contains(a)) {
    		this.pedidos.add(a);
    		this.tablePedido.setItems(pedidos);
			}
			else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setHeaderText(null);
	    		alert.setTitle("Error");
	    		alert.setContentText("Formato incorrecto");
	    		alert.showAndWait();
	    		//System.out.println(idEmpleado.getText() + ""+ contraEmpleado.getText());
			}
			principalesEspa.setValue("");
			}
    	else if (principalesTall.getValue()!="") {
			Pedido a = new Pedido(pedidoChoice3,precio);
			precioTotal +=precio;
			if(!this.pedidos.contains(a)) {
    		this.pedidos.add(a);
    		this.tablePedido.setItems(pedidos);
			}
			else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setHeaderText(null);
	    		alert.setTitle("Error");
	    		alert.setContentText("Formato incorrecto");
	    		alert.showAndWait();
	    		//System.out.println(idEmpleado.getText() + ""+ contraEmpleado.getText());
			}
			principalesTall.setValue("");
			}
    	else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText(null);
    		alert.setTitle("Error");
    		alert.setContentText("Formato incorrecto");
    		alert.showAndWait();;
    		//System.out.println(idEmpleado.getText() + ""+ contraEmpleado.getText());
		}*/
    	
    	
    	//Pedido p = new Pedido(pedido);
    	
    	
    	/*if(!this.pedidos.contains(p)) {
    		this.pedidos.add(p);
    		this.tablePedido.setItems(pedidos);
    	}*/
    	
    	
    }

    @FXML
    void agregarPedidoSegundo(ActionEvent event) {
    	
    	String pedido ="";
    	double precio = 4.95;
    	
    	if (FiletePollo.isSelected()) {
			pedido="FiletePollo";
		}
    	else if(FileteTernera.isSelected()) {
    		pedido="FileteTernera";
    	}
    	else if(Pescado.isSelected()) {
    		pedido="Pescado";
    	}
    	Pedido p = new Pedido(pedido,precio);
    	//Pedido a = new Pedido(pedidoChoice);
    	
    	if(!this.pedidos.contains(p)) {
    		precioTotal +=precio;
    		this.pedidos.add(p);
    		this.tablePedido.setItems(pedidos);
    		System.out.println(pedido);
    	}
    	
    }

    @FXML
    void initialize() {
    	
    	pedidos = FXCollections.observableArrayList();
    	
    	this.colPedido.setCellValueFactory(new PropertyValueFactory<>("pedido"));
    	this.colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
    	
    	/*principales.setValue("Select value: ");
    	principales.getItems().addAll("Verdura","Pollo","Ternera","Gamba"); 
    	//principales.getSelectionModel().select("Combo3");
    	
    	principales.getSelectionModel().selectedItemProperty().addListener(
        		(observable) -> {
        			this.colPedido.setCellValueFactory(new PropertyValueFactory<>("pedido"));
        		    });   */
    	principalesArr.getItems().addAll("Verdura","Pollo","Ternera","Gamba"); 
    	principalesEspa.getItems().addAll("Verdura","Pollo","Ternera","Gamba"); 
    	principalesTall.getItems().addAll("Verdura","Pollo","Ternera","Gamba"); 
    	/*
    	principalesArr.getSelectionModel().selectedItemProperty().addListener(
        		(observable) -> {
        			this.colPedido.setCellValueFactory(new PropertyValueFactory<>("pedido"));
        		    });
    	principalesEspa.getSelectionModel().selectedItemProperty().addListener(
        		(observable) -> {
        			this.colPedido.setCellValueFactory(new PropertyValueFactory<>("pedido"));
        		    });
    	principalesTall.getSelectionModel().selectedItemProperty().addListener(
        		(observable) -> {
        			this.colPedido.setCellValueFactory(new PropertyValueFactory<>("pedido"));
        		    });*/
    }
    
    

}

