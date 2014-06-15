package org.dbp.componentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.dbp.json.global.EstadoJson;
import org.dbp.json.global.ResultadoJson;
import org.dbp.json.global.subs.CampoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

/**
 * 
 * Es el componente encargado de trabajar con el json.
 * 
 * @author david
 *
 */
@Component
public class JsonComponente {

	@Autowired MessageSource messageSource;
	
	/**
	 * 
	 * Este método se encarga de procesar los errores del bindeo producidos por el invalid formato.
	 * 
	 * @param datos						Los datos de devolución.
	 * @param invalidFormatException	La excepcion con el error de vindeo.
	 * @return
	 */
	public <T extends Serializable> ResultadoJson<T> procesarErrorBindeo(Class<T> clase,InvalidFormatException invalidFormatException){
		ResultadoJson<T> valdev=instanciarResultadoJson(clase);
		valdev.setEstado(EstadoJson.ERROR_VALIDACION);
		addCampoError(valdev, invalidFormatException);
		return valdev;
	}

	/**
	 * 
	 * TODO: Pendiente de probar.
	 * 
	 * @param clase	
	 * @param error
	 * @return
	 */
	public <T extends Serializable> ResultadoJson<T> procesarError(Class<T> clase,String error){
		 ResultadoJson<T> valdev=new  ResultadoJson<T>();
		return valdev;
	}
	
	
	
	
	
	
	/**
	 * 
	 * Inicializamos el resultado json, con los datos por defecto. 
	 * 
	 * @param clase	La clase con la que vamos a instanciarlo
	 * @return
	 */
	private <T extends Serializable> ResultadoJson<T> instanciarResultadoJson(Class<T> clase){
		ResultadoJson<T> valdev=new  ResultadoJson<T>();
		valdev.setCamposError(new ArrayList<CampoError>());
		return valdev;
	}
	
	
	/**
	 * Mira en la excepcion cual es el path para llegar al campo con el que estamos trabajando.
	 * 
	 * @param invalidFormatException	Excepcion de invalidación para el formato.
	 * @param addPadre 	Añadir el padre.
	 * @return
	 */
	private String obtenerElCampo(
			InvalidFormatException invalidFormatException,Boolean addPadre) {
		String campo="";
		for(Reference referenciaPath :invalidFormatException.getPath()){
			if(StringUtils.isNotBlank(campo)){
				campo+=".";
			}
			if(addPadre){
				campo+=referenciaPath.getFrom().getClass().getSimpleName()+"."+referenciaPath.getFieldName();
			}else{
				campo+=referenciaPath.getFieldName();
			}
		}
		return campo;
	}
	
	
	/**
	 * Se encarga de crear los mensajes de un campo de error. Basandonos en el error que nos 
	 * devuelve el jackson.
	 * @param valdev
	 * @param invalidFormatException
	 */
	private <T extends Serializable> void addCampoError(
			ResultadoJson<T> valdev,
			InvalidFormatException invalidFormatException) {
		String campo = obtenerElCampo(invalidFormatException,false);
		String mensajeDeError=mensajeDeErrorDeBindeo(invalidFormatException);
		addCampoError(valdev,campo,mensajeDeError);
	}
	/**
	 * Se encarga de gestionar los mensajes de error de las validaciones
	 * @param invalidFormatException
	 * @return
	 */
	private String mensajeDeErrorDeBindeo(InvalidFormatException invalidFormatException){
		String valdev="";
		String objetoCampo=obtenerElCampo(invalidFormatException,true);
		Locale locale=LocaleContextHolder.getLocale();
		valdev=messageSource.getMessage(objetoCampo+invalidFormatException.getTargetType()+".errorBindeo", new Object[]{invalidFormatException.getValue()},valdev, locale);
		if(StringUtils.isBlank(valdev)){
			String campo=obtenerElCampo(invalidFormatException,false);
			valdev=messageSource.getMessage(campo+objetoCampo+invalidFormatException.getTargetType()+".errorBindeo", new Object[]{invalidFormatException.getValue()},valdev, locale);
			if(StringUtils.isBlank(valdev)){
				valdev=messageSource.getMessage(invalidFormatException.getTargetType()+".errorBindeo", new Object[]{invalidFormatException.getValue()},"Error al bindear los datos", locale);
			}
		}
		return valdev;
	}
	/**
	 * Añade el siguiente mensaje de error en el sistema.
	 * @param resultado
	 * @param path
	 * @param mensaje
	 * @return
	 */
	private <T extends Serializable> ResultadoJson<T> addCampoError(ResultadoJson<T> resultado ,String path,String mensaje){
		CampoError campoError =new CampoError();
		campoError.setPath(path);
		campoError.setMensaje(mensaje);
		resultado.getCamposError().add(campoError);
		return resultado;
	}
}
