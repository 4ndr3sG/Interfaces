package ch.makery.address.model;

import java.io.Serializable;

public class PedidoFin implements Serializable {

	private String nombre;
	private int precio;
	
	
	public PedidoFin(String nombre, int precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	
}
