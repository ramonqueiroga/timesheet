package br.com.alura.horas.controllers;

import javax.inject.Inject;

import br.com.alura.horas.seguranca.Open;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {

	private Result result;

	public IndexController() {}
	
	@Inject
	public IndexController(Result result) {
		this.result = result;
		
	}
	
	@Path("/home")
	@Open
	public void index(){
		result.include("textoPagina", "Seja bem-vindo!");
	}
	
}
