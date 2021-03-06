package br.com.timesheet.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.timesheet.infra.seguranca.Open;
import br.com.timesheet.infra.seguranca.UsuarioLogado;

@Controller
public class IndexController {

	private Result result;
	private UsuarioLogado usuarioLogado;

	public IndexController() {
		this(null, null);
	}
	
	@Inject
	public IndexController(UsuarioLogado usuarioLogado, Result result) {
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		
	}
	
	@Path("/home")
	public void index(){
		result.include("textoPagina", (usuarioLogado.getUsuario() != null ? usuarioLogado.getUsuario().getNome() + ", seja bem-vindo(a)!" : "Seja bem-vindo(a)!"));
	}
	
}
