package br.com.timesheet.textos;

import javax.inject.Named;

@Named
public class TextosEstaticos {

	public String bemVindo(){
		return TextosEnum.BEM_VINDO.getTexto();
	}
	
}
