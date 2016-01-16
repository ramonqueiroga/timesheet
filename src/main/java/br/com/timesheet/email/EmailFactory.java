package br.com.timesheet.email;

import br.com.timesheet.email.recuperasenha.EmailRecuperacaoSenha;

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
