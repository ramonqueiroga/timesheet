package br.com.timesheet.email;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.timesheet.seguranca.SslUtil;

public class EnviaEmail {

	public static boolean enviarEmail(Map<String, String> parameters, EmailEnum tipoEmail, Mailer mailer) {
		try {
			EmailFactory factory = new EmailFactory();
			ICriaEmail corpoEmail = factory.criaObjetoEmail(tipoEmail);
			String criaCorpoEmail = corpoEmail.criaCorpoEmail(parameters);
			
			SslUtil.desabilitaSsl(); //desabilita ssl para que possa realizar uma chamada https localhost
			
			Email email = new SimpleEmail();
			email.setSubject(parameters.get("subject"));
			email.addTo(parameters.get("emailTo"));
			email.setMsg(criaCorpoEmail);
			mailer.send(email);
			
		} catch (EmailException | KeyManagementException | NoSuchAlgorithmException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}


}
