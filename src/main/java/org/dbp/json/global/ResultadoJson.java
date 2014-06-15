package org.dbp.json.global;

import java.io.Serializable;
import java.util.List;

import org.dbp.json.global.subs.CampoError;
/**
 * 
 * Nos devuelve el resultado al json.
 * 
 * @author david
 *
 * @param <T>
 */
public class ResultadoJson<T extends Serializable> implements Serializable{

	private EstadoJson estado;
	private String mensaje;
	private List<CampoError> camposError;
	private T objeto;
	
	public List<CampoError> getCamposError() {
		return camposError;
	}
	public void setCamposError(List<CampoError> camposError) {
		this.camposError = camposError;
	}
	public EstadoJson getEstado() {
		return estado;
	}
	public void setEstado(EstadoJson estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public T getObjeto() {
		return objeto;
	}
	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}
	
}
