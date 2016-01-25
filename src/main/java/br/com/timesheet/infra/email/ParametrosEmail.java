package br.com.timesheet.infra.email;

import java.util.Map;

public class ParametrosEmail {

	private Map<String, String> parametros;
	
	public ParametrosEmail(Map<String, String> parametros) {
		this.parametros = parametros;
	}
	
	public Map<String, String> getParametros(){
		return this.parametros;
	}
	
}
