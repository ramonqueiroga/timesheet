package br.com.timesheet.seguranca;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.timesheet.modelos.Usuario;

@Named
@SessionScoped
public class UsuarioLogado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public void fazLogin(Usuario usuario) {
		this.usuario = usuario;
	}

	public void desloga() {
		this.usuario = null;
	}

	public boolean isLogado() {
		return this.usuario != null;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
