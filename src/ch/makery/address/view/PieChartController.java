package ch.makery.address.view;
	
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import ch.makery.address.model.Empleado;
import ch.makery.address.model.PedidoFin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class PieChartController {
	
	@FXML
    private PieChart pieChart;
	 private static List<PedidoFin> lista = new ArrayList<PedidoFin>();
	 static String RUTA_FICHERO = "src//application//" ;
	
	
	private static List verRegistro() throws ClassNotFoundException{
    	List<PedidoFin> lista2 = new ArrayList<>();
        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(RUTA_FICHERO + "personas.dat")) ) {
            //Persona[]tablPersonasIn = (Persona[]) entrada.readObject();

            
            lista2.addAll((List<PedidoFin>)entrada.readObject());
            for(int i = 0;i<lista2.size();i++){
                
                    System.out.println(lista2.get(i).toString()); 
                
            }

        } catch (IOException e) {

            e.printStackTrace();
        } 
       return lista2;
    }
	@FXML
    private void initialize() {
		
		try {
			lista=verRegistro();
			ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList();
			for(int i = 0 ; i<lista.size();i++) {
				pieChartData.add(new PieChart.Data(lista.get(i).getPrecio()+" ", lista.get(i).getPrecio()));
				/*lista.get(i).getNombre();
				lista.get(i).getPrecio();*/
			}
			pieChart.setData(pieChartData);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*// Rellenamos los datos del gr�fico
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
		
		pieChart.setData(pieChartData);*/

    }

}
