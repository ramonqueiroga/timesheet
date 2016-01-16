package br.com.timesheet.email.recuperasenha;

import br.com.timesheet.email.ICriaEmail;
import br.com.timesheet.email.ParametrosEmail;

public class EmailRecuperacaoSenha implements ICriaEmail{

	@Override
	public String criaCorpoEmail(ParametrosEmail parametrosEmail) {
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("Olá, \n");
		mensagem.append("Foi solicitado a recuperação de senha para o site TimeSheet referente ao cadastro desse usuário (email).\n");
		mensagem.append("Segue então a senha recuperada: " + parametrosEmail.getParametros().get("senha") + ".\n");
		mensagem.append("Att,\n");
		mensagem.append("Administracao TimeSheet.\n");
		return mensagem.toString();
	}

}
