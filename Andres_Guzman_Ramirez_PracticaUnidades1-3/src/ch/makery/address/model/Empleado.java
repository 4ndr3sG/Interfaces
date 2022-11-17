package ch.makery.address.model;

import java.util.Objects;

public class Empleado {
	
	
	private String nombre;
	private String apellido;
	private String turno;
	
	
	public Empleado(String nombre, String apellido, String turno) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.turno = turno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	@Override
	public int hashCode() {
		return Objects.hash(apellido, nombre, turno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(turno, other.turno);
	}
	
	
	
	

}
