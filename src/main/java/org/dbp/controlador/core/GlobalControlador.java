package org.dbp.controlador.core;

import org.dbp.componentes.JsonComponente;
import org.dbp.json.global.ResultadoJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class GlobalControlador {

 	@Autowired private JsonComponente jsonComponente; 
	/**
	 * 
	 * Gestionar la excepcion, cuando no se ha podido lear un json.
	 * 
	 *  
	 * 
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value=HttpMessageNotReadableException.class)
	public ResultadoJson<String> handelException(HttpMessageNotReadableException e){
		if(  e.getCause()  instanceof InvalidFormatException){
			return jsonComponente.procesarErrorBindeo(String.class, (InvalidFormatException)e.getCause());
		}else{
			return jsonComponente.procesarError(String.class, "error.global.bindeo.excepcionNoValida");
		}
		
	}
	
}
