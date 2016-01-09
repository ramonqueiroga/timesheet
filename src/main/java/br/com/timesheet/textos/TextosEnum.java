package br.com.timesheet.textos;

public enum TextosEnum {

	BEM_VINDO("Bem vindo ao sistema de controle de horas TimeSheet.<br/> Esse sitema tem como "
			+ "objetivo fornecer um melhor controle de horas para funcionarios e terceiros, com relatórios"
			+ " e bloqueios por jornada, entre outras funcionalidades mais.");
	
	private String texto;

	private TextosEnum(String texto){
		this.texto = texto;
	}
	
	public String getTexto(){
		return this.texto;
	}
	
}
