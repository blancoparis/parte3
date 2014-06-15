package org.dbp.json;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ElementoLista implements Serializable{

	@NotNull
	private Long id;
	private String descripcion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
