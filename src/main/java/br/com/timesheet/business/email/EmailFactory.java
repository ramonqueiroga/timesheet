package br.com.timesheet.business.email;


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
