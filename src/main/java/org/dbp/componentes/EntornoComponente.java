package org.dbp.componentes;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 
 * Este componente se encarga de procesar los diferentes entornos.
 * 
 * Nos vamos apollar en los diferentes profiles del entorno.
 * 
 * Nota: La prioridad de los entornos, se establecera en el orden del tipo enumerado.
 * 
 *    Este componente por un lado nos devolvera, el entorno en el que funciona la aplicación
 *    y por otro los metodos de las propiedades asociadas al entorno siguiente la siguiente 
 *    formula.
 *      <entorno>.propiedad
 *  
 * 
 * @author david
 *
 */
@Component
public class EntornoComponente {

	public enum Entorno {
		prod, integracion, dev
	}

	private Entorno entorno;

	private Environment env;
	@Autowired
	public EntornoComponente(Environment env) {
		this.env=env;
		entorno=buscarElEntorno(
				this.env.getActiveProfiles()
			   ,this.env.getProperty("entorno.defecto", Entorno.class,Entorno.dev)
			   );
	}

	
	/**
	 * Nos devuelve el entorno activo.
	 * @return
	 */
	public Entorno getEntorno() {
		return entorno;
	}

	// TODO obtener las propiedades asociadas al entorno
	
	public String getProperty(String key){
		return env.getProperty(obtenerClave(key));
	}
	
	public <T> T getProperty(String key, Class<T> targetType){
		return env.getProperty(obtenerClave(key), targetType);
	}
	
	public <T> T getProperty(String key, Class<T> targetType, T defaultValue){
		return env.getProperty(obtenerClave(key), targetType, defaultValue);
	}

	public String getRequiredProperty(String key){
		return env.getRequiredProperty(obtenerClave(key));
	}
	
	public <T> T getRequiredProperty(String key, Class<T> targetType){
		return env.getRequiredProperty(obtenerClave(key), targetType);
	}
	
	
	private String obtenerClave(String key) {
		return entorno.name()+"."+key;
	}


	/**
	 * 
	 * Se encarga de buscar el elemento, con mas prioridad.
	 * 
	 * Nota: La prioridad nos la marcara el entorno.
	 * 
	 * @param profilesActivos     Los profiles activos
	 * @return
	 */
	private Entorno buscarElEntorno(String[] profilesActivos, Entorno defecto) {
		Entorno valdev = defecto;
		if (profilesActivos != null && profilesActivos.length > 0) {
			for (Entorno ent : Entorno.values()) {
				if (ArrayUtils.contains(profilesActivos, ent.name())) {
					return ent;
				}
			}
		}
		return valdev;
	}

}
