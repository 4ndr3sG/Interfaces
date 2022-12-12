package ch.makery.address.view;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import ch.makery.address.model.Empleado;
import ch.makery.address.model.Pedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    
    private static List<Empleado> lista = new ArrayList<Empleado>();
    static String RUTA_FICHERO = "src//application//" ;
    
    @FXML
    void crearGrafico(ActionEvent event) {
    	try {
    		 // Cargamos el archivo Controles Dinámicos
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(ControladorEmpleadosIn.class.getResource("pieChart.fxml"));
    		AnchorPane listadoControles = (AnchorPane) loader.load();
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
    @FXML
    void crearGrafico2(ActionEvent event) {
    	try {
    		 // Cargamos el archivo Controles Dinámicos
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(ControladorEmpleadosIn.class.getResource("RestauranteGrafico.fxml"));
    		AnchorPane listadoControles = (AnchorPane) loader.load();
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
    
    private static void eliminarRegistro(String dni) throws ClassNotFoundException, FileNotFoundException, IOException{
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(RUTA_FICHERO + "clientes.dat"));
            //Persona[]tablPersonasIn = (Persona[]) entrada.readObject();

            List<Empleado> lista2 = new ArrayList<>();
            lista2.addAll((List<Empleado>)entrada.readObject());
            for(int i = 0;i<lista2.size();i++){
                if (lista2.get(i).getNombre().equals(dni)) {
                    //System.out.println(lista2.get(i).toString()); 
                    lista2.remove(i);
                }
            }
            System.out.println(lista2.toString());

        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(RUTA_FICHERO + "clientes.dat"));
            salida.writeObject(lista2);
            salida.close();
            
        
    }
    
    private static void crearRegistro(String ciudad,String fecha, String tempMax) {
        /*Creamos un flujo binario y escribimos en el */
    	Empleado reg = new Empleado(ciudad, fecha, tempMax);
        ObjectInputStream entrada;
		try {
			entrada = new ObjectInputStream(new FileInputStream(RUTA_FICHERO + "clientes.dat"));
			List<Empleado> lista2 = new ArrayList<>();
			try {
				lista2.addAll((List<Empleado>)entrada.readObject());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lista= (List<Empleado>) lista2;
			lista.add(reg);
        //System.out.println("tablapersonas in : "+lista2.toString());
			entrada.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        try(ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(RUTA_FICHERO + "clientes.dat"))) {
            salida.writeObject(lista);
            salida.close();
            

        } catch (IOException ioe) {
            ioe.printStackTrace();

        }
    }
    
    private static List verRegistro() throws ClassNotFoundException{
    	List<Empleado> lista2 = new ArrayList<>();
        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(RUTA_FICHERO + "clientes.dat")) ) {
            //Persona[]tablPersonasIn = (Persona[]) entrada.readObject();

            
            lista2.addAll((List<Empleado>)entrada.readObject());
            for(int i = 0;i<lista2.size();i++){
                
                    System.out.println(lista2.get(i).toString()); 
                
            }

        } catch (IOException e) {

            e.printStackTrace();
        } 
       return lista2;
    }
    
    
    private ObservableList<Empleado> empleados = FXCollections.observableArrayList(
    	    new Empleado("Mario","Bross","Mañana"),
    	    new Empleado("Felipe","Neduro","Tarde"),
    	    new Empleado("Maria","Cristal","Tarde"),
    	    new Empleado("Andres","Guzman","Mañana"));

    @FXML
    public void initialize() {
    	try {
    		lista=verRegistro();
    		empleados.addAll(lista);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
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
    		// Se muestra un alert si algún campo está vacío
    		Alert errorAlert = new Alert(AlertType.CONFIRMATION);
        	
    		errorAlert.setTitle("CONFIRMACION");
    		errorAlert.setHeaderText("Desea ELIMINAR al empleado");
    		errorAlert.setContentText("Seleccione opción: ");
    		
    		
    		Optional<ButtonType> result = errorAlert.showAndWait();
    		if (result.isPresent() && result.get() == ButtonType.OK) {
    			try {
    	    		 // Cargamos el archivo Controles Dinámicos
    	    		FXMLLoader loader = new FXMLLoader();
    	    		loader.setLocation(ControladorEmpleadosIn.class.getResource("MiDialogo2.fxml"));
    	    		AnchorPane listadoControles = (AnchorPane) loader.load();
    	    		// Se sitúa en el centro del diseño principal
    	    		// Se crea un nuevo Stage para mostrar el di�logo
    		        Stage dialogStage = new Stage();
    		        dialogStage.setTitle("Introduzca password");
    		        dialogStage.initModality(Modality.WINDOW_MODAL);
    		        //dialogStage.initOwner(primaryStage);
    		        Scene scene = new Scene(listadoControles);
    		        dialogStage.setScene(scene);
    	    		//rootLayout.setCenter(listadoControles);
    	    		
    	    		 dialogStage.showAndWait();
    	    		 } catch (IOException e) {
    	    		e.printStackTrace();
    	    		 }
    			try {
					eliminarRegistro(p.getNombre().toString());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			this.empleados.remove(p);
        		this.TablaEmpleados.refresh();
    		}
    		
    		/*this.empleados.remove(p);
    		this.TablaEmpleados.refresh();*/
    		
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
    		crearRegistro(nombre, apellido, turno);
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
