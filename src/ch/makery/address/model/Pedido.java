package ch.makery.address.model;

import java.io.Serializable;
import java.util.Objects;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pedido {
	
	private final StringProperty pedido;
	private final DoubleProperty precio;
	int total = 0;
	

	public Pedido(String pedido, double precio) {
		super();
		this.pedido = new SimpleStringProperty(pedido);
		this.precio = new SimpleDoubleProperty(precio);
	}


	public StringProperty pedidoProperty() {
		return this.pedido;
	}
	
	public DoubleProperty precioProperty() {
		return this.precio;
	}


	public String getPedido() {
		return this.pedidoProperty().get();
	}
	
	public double getPrecio() {
		return this.precioProperty().get();
	}
	


	public void setPedido(String pedido) {
		this.pedidoProperty().set(pedido);
	}
	
	public void setPrecio(int precio) {
		this.precioProperty().set(precio);
	}


	@Override
	public int hashCode() {
		return Objects.hash(pedido);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(pedido, other.pedido);
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


	
	
	
	
	
	
	
	/*
	private String entrante;
	private String primero;
	private String segundos;
	private String postre;
	private String bebida;
	
	
	public Pedido(String entrante, String primero, String segundos, String postre, String bebida) {
		super();
		this.entrante = entrante;
		this.primero = primero;
		this.segundos = segundos;
		this.postre = postre;
		this.bebida = bebida;
	}


	public String getEntrante() {
		return entrante;
	}


	public void setEntrante(String entrante) {
		this.entrante = entrante;
	}


	public String getPrimero() {
		return primero;
	}


	public void setPrimero(String primero) {
		this.primero = primero;
	}


	public String getSegundos() {
		return segundos;
	}


	public void setSegundos(String segundos) {
		this.segundos = segundos;
	}


	public String getPostre() {
		return postre;
	}


	public void setPostre(String postre) {
		this.postre = postre;
	}


	public String getBebida() {
		return bebida;
	}


	public void setBebida(String bebida) {
		this.bebida = bebida;
	}


	@Override
	public String toString() {
		return "Pedido [entrante=" + entrante + ", primero=" + primero + ", segundos=" + segundos + ", postre=" + postre
				+ ", bebida=" + bebida + "]";
	}*/
	
	
	
	

}
