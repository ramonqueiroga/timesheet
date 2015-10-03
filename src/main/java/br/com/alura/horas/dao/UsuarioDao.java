package br.com.alura.horas.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.alura.horas.modelos.Usuario;

@RequestScoped
public class UsuarioDao {

	private EntityManager manager;

	@Inject
	public UsuarioDao(EntityManager manager) {
		this.manager = manager;
	}

	public UsuarioDao() {
	}

	public void adiciona(Usuario usuario) {
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
	}

	public List<Usuario> listaTodos() {
		TypedQuery<Usuario> usuarioLista = manager.createQuery(
				"select u from Usuario u", Usuario.class);
		return usuarioLista.getResultList();
	}

	public Usuario busca(String login, String senha) {
		TypedQuery<Usuario> query = manager.createQuery(
						"select u from Usuario u where u.login = :login and u.senha = :senha", Usuario.class);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		try{
			return query.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

}
