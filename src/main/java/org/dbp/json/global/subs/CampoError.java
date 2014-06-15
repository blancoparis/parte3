package org.dbp.json.global.subs;

import java.io.Serializable;
/**
 * 
 * Nos define el erro de un campo en cuestión
 * 
 * @author david
 *
 */
public class CampoError implements Serializable {

	private String path;
	private String mensaje;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
