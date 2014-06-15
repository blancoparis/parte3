package org.dbp.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("inicio")
@Controller
public class InicioControlador {

	@RequestMapping
	public String inicio(){
		return "inicio/inicio";
	}
	
}
