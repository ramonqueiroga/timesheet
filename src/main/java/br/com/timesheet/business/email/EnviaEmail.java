package br.com.timesheet.business.email;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.timesheet.infra.seguranca.SslUtil;

public class EnviaEmail {

	//desabilita ssl para que possa realizar uma chamada https localhost (temporario até achar uma solução melhor)
	static {
		try {
			SslUtil.desabilitaSsl();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static boolean enviarEmail(ParametrosEmail parametrosEmail, EmailEnum tipoEmail, Mailer mailer) {
		try {
			mailer.send(montaEmail(parametrosEmail, tipoEmail));
		} catch (EmailException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	private static Email montaEmail(ParametrosEmail parametrosEmail, EmailEnum tipoEmail) throws EmailException {
		EmailFactory factory = new EmailFactory();
		ICriaEmail corpoEmail = factory.criaObjetoEmail(tipoEmail);
		corpoEmail.criaCorpoEmail(parametrosEmail);
		
		Email email = new SimpleEmail();
		email.setSubject(parametrosEmail.getParametros().get("subject"));
		email.addTo(parametrosEmail.getParametros().get("emailTo"));
		email.setMsg(corpoEmail.criaCorpoEmail(parametrosEmail));

		return email;
	}


}
