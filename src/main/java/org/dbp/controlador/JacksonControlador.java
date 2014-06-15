package org.dbp.controlador;



import javax.validation.Valid;

import org.dbp.json.ElementoLista;
import org.dbp.json.ElementoListaXml;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("jackson")
@Controller
public class JacksonControlador {
	@RequestMapping()
	public String inicio(){
		return "jackson/jackson";
	}
	@RequestMapping("contenedor")
	public String contenedor(){
		return "jackson/partes/contenedor";
	}
	@RequestMapping("ventanaModal")
	public String ventanaModal(){
		return "jackson/partes/ventanaModal";
	}
	/**
	 * 
	 * Es un ejemplo de sumar un elemento, recuperar un json y devolverlo.
	 * 
	 * @param elemento
	 * @param incremento
	 * @return
	 */
	@RequestMapping("sumar/{incremento}")
	public @ResponseBody ElementoLista sumar1(@Valid @RequestBody  ElementoLista elemento,@PathVariable Long incremento){
		elemento.setId(elemento.getId()+incremento);
		return elemento;
	}

	
	/**
	 * Produce un json
	 * @return
	 */
	@RequestMapping("json")
	public @ResponseBody ElementoLista obtenerJson(){
		ElementoLista valdev = new ElementoLista();
		valdev.setId(1L);
		valdev.setDescripcion("Json");
		return valdev;
	}
	/**
	 * Produce un xml
	 * @return
	 */
	@RequestMapping(value="xml")
	public @ResponseBody ElementoListaXml obtenerXml(){
		ElementoListaXml valdev = new ElementoListaXml();
		valdev.setId(1L);
		valdev.setDescripcion("Json");
		return valdev;
	}
	
}
