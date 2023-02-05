package ch.makery.address.view;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import ch.makery.address.model.Elementos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

public class ControladorGraficoPedidos {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<String, Integer> barChart;
    
    @FXML
    private CategoryAxis xAxisBar;

    private ObservableList<String> elementosNames = FXCollections.observableArrayList();
    private static List<Elementos> lista = new ArrayList<Elementos>();
	static String RUTA_FICHERO = "src//application//" ;
	
	
	private static List verRegistro() throws ClassNotFoundException{
  	List<Elementos> lista2 = new ArrayList<>();
      try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(RUTA_FICHERO + "registro.dat")) ) {
          //Persona[]tablPersonasIn = (Persona[]) entrada.readObject();

          
          lista2.addAll((List<Elementos>)entrada.readObject());
          for(int i = 0;i<lista2.size();i++){
              
                  //System.out.println(lista2.get(i).toString()); 
              
          }

      } catch (IOException e) {

          e.printStackTrace();
      } 
     return lista2;
	}
	public static void countFrequencies(ArrayList<String> list)
    {
  
        // hash set is created and elements of
        // arraylist are insertd into it
        Set<String> st = new HashSet<String>(list);
        for (String s : st)
            System.out.println(s + ": " + Collections.frequency(list, s));
    }
    
    @FXML
    void initialize() {
        //assert barChart != null : "fx:id=\"barChart\" was not injected: check your FXML file 'RestauranteGraficoPedidos.fxml'.";
    	
    	barChart.getData().add(initDatos1());
		
	       
    }
    
    private XYChart.Series<String, Integer> initDatos1() {
		XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
		
		series1.setName("2003");
		//series1.getData().add(new XYChart.Data<String, Integer>("Austria", 25601));
		
		try {
			lista = verRegistro();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0 ; i<lista.size();i++) {
			System.out.println(lista.get(i).getIdentificador());
			list.add(lista.get(i).getIdentificador());
			/*lista.get(i).getNombre();
			lista.get(i).getPrecio();*/
		}
		 Set<String> st = new HashSet<String>(list);
	        for (String s : st)
	        	series1.getData().add(new XYChart.Data<String, Integer>(s , Collections.frequency(list, s)));
	            //System.out.println(s + ": " + Collections.frequency(list, s));
	        	//series1.getData().add(new XYChart.Data<String, Integer>(s , Collections.frequency(list, s));
		
		/*
		series1.getData().add(new XYChart.Data<String, Double>("Brazil", 20148.82));
		series1.getData().add(new XYChart.Data<String, Double>("France", 10000.0));
		series1.getData().add(new XYChart.Data<String, Double>("Italy", 35407.15));
		series1.getData().add(new XYChart.Data<String, Double>("USA", 12000.0));  
		*/
		return series1;
	}

}
