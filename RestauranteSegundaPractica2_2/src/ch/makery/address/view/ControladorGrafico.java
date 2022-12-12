package ch.makery.address.view;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ch.makery.address.model.Elementos;
import ch.makery.address.model.PedidoFin;
import javafx.fxml.FXML;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class ControladorGrafico {
	
	public static void countFrequencies(ArrayList<String> list)
    {
  
        // hash set is created and elements of
        // arraylist are insertd into it
        Set<String> st = new HashSet<String>(list);
        for (String s : st)
            System.out.println(s + ": " + Collections.frequency(list, s));
    }
	
	@FXML
    private BubbleChart<Integer, Integer> bubbleChart;

	// El rango de xAxis e yAxis se ha especificado en el FXML
	@FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;
    
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

	
	@FXML
    private void initialize() {
		// Se formatea el eje Y con el s�mbolo de euros
		yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis, null, " �"));
		
		try {
			lista = verRegistro();
			ArrayList<String> list = new ArrayList<String>();
			for(int i = 0 ; i<lista.size();i++) {
				System.out.println(lista.get(i).getIdentificador());
				list.add(lista.get(i).getIdentificador());
				/*lista.get(i).getNombre();
				lista.get(i).getPrecio();*/
			}
			
			countFrequencies(list);
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// Los datos se a�aden con el objeto series que admite varias distribuciones
		// El tercer par�mero que se a�ade en las series se hace referencia al radio de cada circunferencia 
		// que representa los datos
		XYChart.Series<Integer, Integer> series1 = new XYChart.Series<Integer, Integer>();
		
        series1.setName("Product 1"+lista.size());
        series1.getData().add(new XYChart.Data<Integer, Integer>(3, 35, 2));
        series1.getData().add(new XYChart.Data<Integer, Integer>(12, 60, 1.8));
        /*series1.getData().add(new XYChart.Data<Integer, Integer>(15, 15, 7));
        series1.getData().add(new XYChart.Data<Integer, Integer>(22, 30, 2.5));
        series1.getData().add(new XYChart.Data<Integer, Integer>(28, 20, 1));
        series1.getData().add(new XYChart.Data<Integer, Integer>(35, 41, 5.5));
        series1.getData().add(new XYChart.Data<Integer, Integer>(42, 17, 9));
        series1.getData().add(new XYChart.Data<Integer, Integer>(49, 30, 1.8));*/
        
        // Se a�ade la primera distribuci�n
        bubbleChart.getData().add(series1);
                
        XYChart.Series<Integer, Integer> series2 = new XYChart.Series<Integer, Integer>();
        series2.setName("Product 2");
        series2.getData().add(new XYChart.Data<Integer, Integer>(8, 15, 2));
        series2.getData().add(new XYChart.Data<Integer, Integer>(13, 23, 1));
       /* series2.getData().add(new XYChart.Data<Integer, Integer>(15, 45, 3));
        series2.getData().add(new XYChart.Data<Integer, Integer>(24, 30, 4.5));
        series2.getData().add(new XYChart.Data<Integer, Integer>(38, 78, 1));
        series2.getData().add(new XYChart.Data<Integer, Integer>(40, 41, 7.5));
        series2.getData().add(new XYChart.Data<Integer, Integer>(45, 57, 2));
        series2.getData().add(new XYChart.Data<Integer, Integer>(47, 23, 3.8));*/
        
        // Se a�ade la segunda distribuci�n
        bubbleChart.getData().add(series2);
    }

}
