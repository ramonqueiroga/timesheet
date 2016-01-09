package br.com.timesheet.email;

import java.util.Map;

public class EmailRecuperacaoSenha implements ICriaEmail{

	@Override
	public String criaCorpoEmail(Map<String, String> parameters) {
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("Olá, \n");
		mensagem.append("Foi solicitado a recuperação de senha para o site TimeSheet referente ao cadastro desse usuário (email).\n");
		mensagem.append("Segue então a senha recuperada: " + parameters.get("senha") + ".\n");
		mensagem.append("Att,\n");
		mensagem.append("Administracao TimeSheet.\n");
		return mensagem.toString();
	}

}
