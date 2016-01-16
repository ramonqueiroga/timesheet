package br.com.timesheet.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.NonUniqueResultException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.timesheet.dao.UsuarioDao;
import br.com.timesheet.email.EmailEnum;
import br.com.timesheet.email.EnviaEmail;
import br.com.timesheet.email.ParametrosEmail;
import br.com.timesheet.modelos.Usuario;
import br.com.timesheet.seguranca.Open;
import br.com.timesheet.seguranca.UsuarioLogado;

@Controller
public class LoginController {

	private UsuarioDao dao;
	private UsuarioLogado usuarioLogado;
	private Result result;
	private Validator validator;
	private Mailer mailer;

	@Inject
	public LoginController(UsuarioDao dao, UsuarioLogado usuarioLogado,
			Result result, Validator validator, Mailer mailer) {
		this.dao = dao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.validator = validator;
		this.mailer = mailer;
	}
	
	public LoginController() {
		this(null, null, null, null, null);
	}

	@Open
	public void form() {
	}

	@Open
	public void autentica(String usuario, String senha) {
		try {
			Usuario usuarioObj = dao.buscaUsuarioPorUsuarioESenha(usuario, senha);
			if (usuarioObj != null) {
				usuarioLogado.fazLogin(usuarioObj);
				result.redirectTo(UsuarioController.class).lista();
			} else {
				validator.add(new I18nMessage("Login", "login.invalido"));
				validator.onErrorRedirectTo(this).form();
			}
		} catch (NonUniqueResultException ex) {
			validator.add(new I18nMessage("MultiplosUsuarios", "multiplos.usuarios"));
			validator.onErrorRedirectTo(this).form();
		}
	}

	@Open
	public void deslogaUsuario() {
		usuarioLogado.desloga();
		result.redirectTo(this).form();
	}

	@Open
	public void recuperaSenhaPorEmail(String emailTo) {
		try {
			String senhaRecuperada = dao.buscaSenha(emailTo);
			ParametrosEmail parameters = preencheParametrosEmailRecuperacaoSenha(emailTo, senhaRecuperada);
			boolean emailEnviado = EnviaEmail.enviarEmail(parameters, EmailEnum.RECUPERACAOSENHA, mailer);

			validator.check(emailEnviado, new I18nMessage("erroAoEnviarEmail", "erro.ao.enviar.email"));
			validator.onErrorRedirectTo(this).form();

			result.include("senhaRecuperada", "Foi enviado um email para o endereço informado com a senha recuperada!");
			result.redirectTo(this).form();
		} catch (Exception ex) {
			validator.add(new SimpleMessage("Erro recuperacao senha", ex.getMessage(), Severity.ERROR));
			validator.onErrorRedirectTo(this).form();
		}
	}

	private ParametrosEmail preencheParametrosEmailRecuperacaoSenha(String emailTo, String senhaRecuperada) {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("subject", "TimeSheet - Recuperação de senha");
		parameters.put("emailTo", emailTo);
		parameters.put("senha", senhaRecuperada);
		ParametrosEmail parametersEmail = new ParametrosEmail(parameters);
		return parametersEmail;
	}

}
