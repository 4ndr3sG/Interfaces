module PracticaRestaurante {
	
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	exports ch.makery.address; 
	//exports ch.makery.address.view; 
	opens ch.makery.address.view;
	 opens ch.makery.address.model ;
	
	opens application to javafx.graphics, javafx.fxml;
}
