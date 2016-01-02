package br.com.timesheet.textos;

import javax.inject.Named;

import br.com.timesheet.enums.TextosEnum;

@Named
public class TextosEstaticos {

	public String bemVindo(){
		return TextosEnum.BEM_VINDO.getTexto();
	}
	
}
