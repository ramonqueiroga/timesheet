package br.com.alura.horas.textos;

import javax.inject.Named;

import br.com.alura.horas.enums.TextosEnum;

@Named
public class TextosEstaticos {

	public String bemVindo(){
		return TextosEnum.BEM_VINDO.getTexto();
	}
	
}
