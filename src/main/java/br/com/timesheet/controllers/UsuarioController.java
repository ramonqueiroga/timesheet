package br.com.timesheet.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.timesheet.infra.dao.UsuarioDao;
import br.com.timesheet.modelos.Usuario;

@Controller
public class UsuarioController {
	
	private UsuarioDao usuarioDao;
	private Result result;
	private Validator validator;

	@Inject
	public UsuarioController(UsuarioDao usuarioDao, Result result, Validator validator){
		this.usuarioDao = usuarioDao;
		this.result = result;
		this.validator = validator;
	}
	
	public UsuarioController() {
		this(null, null, null);
	}
	
	public void form(){
		result.include("textoPagina", "Cadastro de usuários");
	}
	
	@IncludeParameters
	public void adiciona(@Valid Usuario usuario){
		validator.onErrorRedirectTo(this).form();
		usuarioDao.adiciona(usuario);
		result.redirectTo(this).lista();
	}
	
	public void lista(){
		List<Usuario> listaTodos = usuarioDao.listaTodos();
		result.include("usuarios", listaTodos);
		result.include("textoPagina", "Usuários cadastrados");
	}

}
