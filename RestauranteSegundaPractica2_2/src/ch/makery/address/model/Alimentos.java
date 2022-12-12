package ch.makery.address.model;

import java.util.Objects;

public class Alimentos {
	
	
	private String nombre;
	private String categoria; 
	private int cantidad;
	private double precio;
	private double total;
	

	public Alimentos(String categoria,String nombre, int cantidad, double precio) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total =precio*cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Alimentos [nombre=" + nombre + ", categoria=" + categoria + ", unidades=" + cantidad + ", precio="
				+ precio + ", total=" + total + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, nombre, precio, total, cantidad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimentos other = (Alimentos) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total) && cantidad == other.cantidad;
	}
	

}
