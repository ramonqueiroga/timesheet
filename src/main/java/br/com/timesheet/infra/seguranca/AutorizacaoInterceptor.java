package br.com.timesheet.infra.seguranca;
import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.timesheet.controllers.LoginController;
import br.com.timesheet.infra.seguranca.UsuarioLogado;


@Intercepts
public class AutorizacaoInterceptor {

	private UsuarioLogado usuarioLogado;
	private Result result;
	private ControllerMethod method;

	public AutorizacaoInterceptor() {}
	
	@Inject
	public AutorizacaoInterceptor(UsuarioLogado usuarioLogado, Result result, ControllerMethod method){
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.method = method;
	}
	
	
	@Accepts
	public boolean accept(){
		return !method.containsAnnotation(Open.class);
	}
	
	@AroundCall
	public void intercept(SimpleInterceptorStack stack){
		if(usuarioLogado.isLogado()){
			stack.next();
		}else{
			result.redirectTo(LoginController.class).form();
		}
	}
	
}
