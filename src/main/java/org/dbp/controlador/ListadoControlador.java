package org.dbp.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("listado")
@Controller
public class ListadoControlador {
	
	@RequestMapping
	public String listado(){
		return "listado/listado";
	}
}
