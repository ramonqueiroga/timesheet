package br.com.timesheet.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.timesheet.dao.UsuarioDao;
import br.com.timesheet.modelos.Usuario;
import br.com.timesheet.seguranca.Open;
import br.com.timesheet.seguranca.UsuarioLogado;

@Controller
public class LoginController {

	private UsuarioDao dao;
	private UsuarioLogado usuarioLogado;
	private Result result;
	private Validator validator;

	@Inject
	public LoginController(UsuarioDao dao,
			UsuarioLogado usuarioLogado, Result result, Validator validator) {
		this.dao = dao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.validator = validator;
	}

	public LoginController() {
	}

	@Open
	public void form() {
		result.include("textoPagina", "Faça seu login!");
	}

	@Open
	public void autentica(String usuario, String senha) {
		Usuario usuarioObj = dao.busca(usuario, senha);
		if (usuarioObj != null) {
			usuarioLogado.fazLogin(usuarioObj);
			result.redirectTo(UsuarioController.class).lista();
		} else {
			validator.add(new SimpleMessage("loginInvalido",
					"Login ou senha incorretos!"));
			validator.onErrorRedirectTo(this).form();
		}
	}

	@Open
	public void deslogaUsuario() {
		usuarioLogado.desloga();
		result.redirectTo(this).form();
	}

	public String pagina() {
		return "Login";

	}
}
