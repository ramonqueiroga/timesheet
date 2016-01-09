package br.com.timesheet.email;

import java.util.Map;

public interface ICriaEmail {
	
	public String criaCorpoEmail(Map<String, String> parameters);

}
