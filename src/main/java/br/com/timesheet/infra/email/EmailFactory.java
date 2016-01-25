package br.com.timesheet.infra.email;

import br.com.timesheet.infra.email.recuperacaosenha.EmailRecuperacaoSenha;

public class EmailFactory {
	
	public ICriaEmail criaObjetoEmail(EmailEnum emailEnum){
		switch (emailEnum) {
		case RECUPERACAOSENHA:
			return new EmailRecuperacaoSenha();
		default:
			return null;
		}
	}

}
