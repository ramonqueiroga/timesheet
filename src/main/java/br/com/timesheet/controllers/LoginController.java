package br.com.timesheet.controllers;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.timesheet.dao.UsuarioDao;
import br.com.timesheet.modelos.Usuario;
import br.com.timesheet.seguranca.Open;
import br.com.timesheet.seguranca.SslUtil;
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

	@Open
	public void recuperaSenhaPorEmail(String emailRecuperacao)
			throws EmailException, KeyManagementException,
			NoSuchAlgorithmException {
		// TODO criar logica para recuperação de senha (buscar na base de dados
		// a senha do email referido.
		// Foi desabilitado o SSL para que fosse possivel fazer o teste do envio
		// de email. Depois verificar como que funciona essa questão trabalhando
		// com tomcat

		SslUtil.desabilitaSsl();
		Email email = new SimpleEmail();
		email.setSubject("Testando email");
		email.addTo(emailRecuperacao);
		email.setMsg("Mensagem de recuperação de email");
		mailer.send(email);
		result.include("senhaRecuperada",
				"Foi enviado um email com a senha recuperada");
		result.redirectTo(this).form();
	}

	public String pagina() {
		return "Login";
	}
}
