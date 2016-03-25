package br.com.timesheet.business.email;

import java.util.HashMap;
import java.util.Map;

public class EmailHelper {

	public ParametrosEmail preencheParametrosEmailRecuperacaoSenha(String emailTo, String senhaRecuperada) {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("subject", "TimeSheet - Recuperação de senha");
		parameters.put("emailTo", emailTo);
		parameters.put("senha", senhaRecuperada);
		ParametrosEmail parametersEmail = new ParametrosEmail(parameters);
		return parametersEmail;
	}
	
}
