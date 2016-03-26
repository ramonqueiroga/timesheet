package br.com.timesheet.modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.timesheet.modelos.generico.TabelaModel;

@Entity
public class Usuario extends TabelaModel implements Serializable {

	private static final long serialVersionUID = -4982036270293800683L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer usuario_id;
	
	@NotEmpty(message="Você precisa preencher o campo nome!")
	private String nome;
	
	@NotEmpty(message="Você precisa preencher o nome de login!")
	private String login;
	
	@NotEmpty(message="Você precisa preencher a senha!")
	private String senha;
	
	@NotEmpty(message="Você precisa preencher o email!")
	@Email
	private String email;
	
	@OneToMany(mappedBy="usuario")
	private List<HoraLancada> horasLancadas;

	public Integer getUsuarioId() {
		return usuario_id;
	}

	public void setId(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
