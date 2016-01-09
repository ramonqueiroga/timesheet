package br.com.timesheet.controllers;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.mail.EmailException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.timesheet.dao.UsuarioDao;
import br.com.timesheet.email.EmailEnum;
import br.com.timesheet.email.EnviaEmail;
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
		Usuario usuarioObj = dao.buscaUsuarioPorUsuarioESenha(usuario, senha);
		if (usuarioObj != null) {
			usuarioLogado.fazLogin(usuarioObj);
			result.redirectTo(UsuarioController.class).lista();
		} else {
			validator.add(new SimpleMessage("loginInvalido", "Login ou senha incorretos!"));
			validator.onErrorRedirectTo(this).form();
		}
	}

	@Open
	public void deslogaUsuario() {
		usuarioLogado.desloga();
		result.redirectTo(this).form();
	}

	@Open
	public void recuperaSenhaPorEmail(String emailTo) throws EmailException, KeyManagementException,
			NoSuchAlgorithmException {
		String senhaRecuperada = dao.buscaSenha(emailTo);
		Map<String, String> parameters = preencheParametrosEmailRecuperacaoSenha(emailTo, senhaRecuperada);
		boolean emailEnviado = EnviaEmail.enviarEmail(parameters, EmailEnum.RECUPERACAOSENHA, mailer);
		
		if(emailEnviado) {
			result.include("senhaRecuperada", "Foi enviado um email para o endereço informado com a senha recuperada");
			result.redirectTo(this).form();
		} else {
			validator.add(new SimpleMessage("erroAoEnviarEmail", "Não foi possível enviar email!"));
			validator.onErrorRedirectTo(this).form();
		}
	}
	
	private Map<String, String> preencheParametrosEmailRecuperacaoSenha(String emailTo, String senhaRecuperada){
		Map<String, String> parameters = new HashMap<>();
		parameters.put("subject", "TimeSheet - Recuperação de senha");
		parameters.put("emailTo", emailTo);
		parameters.put("senha", senhaRecuperada);
		return parameters;
	}

}
