package ch.makery.address.model;

import java.io.Serializable;

public class Elementos implements Serializable {
	
	private String identificador;

	public Elementos(String identificador) {
		super();
		this.identificador = identificador;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
}
