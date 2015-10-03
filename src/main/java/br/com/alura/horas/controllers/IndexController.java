package br.com.alura.horas.controllers;

import br.com.alura.horas.seguranca.Open;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

@Controller
public class IndexController {

	@Path("/home")
	@Open
	public void index(){}
	
}
