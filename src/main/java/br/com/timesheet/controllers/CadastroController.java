package br.com.timesheet.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.timesheet.dao.UsuarioDao;
import br.com.timesheet.modelos.Usuario;
import br.com.timesheet.seguranca.Open;
import br.com.timesheet.seguranca.UsuarioLogado;

@Controller
public class CadastroController {

	private UsuarioDao usuarioDao;
	private Result result;
	private Validator validator;
	private UsuarioLogado usuarioLogado;
	
	public CadastroController(){
		this(null, null, null, null);
	}
	
	@Inject
	public CadastroController(UsuarioDao usuarioDao, UsuarioLogado usuarioLogado, Result result, Validator validator){
		this.usuarioDao = usuarioDao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.validator = validator;
	}
	
	@Open
	public void cadastraUsuario(@Valid Usuario usuario){
		validator.onErrorRedirectTo(LoginController.class).form();
		usuarioDao.adiciona(usuario);
		usuarioLogado.fazLogin(usuario);
		result.redirectTo(IndexController.class).index();
	}
	
}
