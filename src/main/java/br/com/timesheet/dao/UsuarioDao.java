package br.com.timesheet.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import br.com.timesheet.modelos.Usuario;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

public class UsuarioDao extends AbstractDao<Usuario> {

	private EntityManager manager;

	@Inject
	public UsuarioDao(EntityManager manager) {
		super(Usuario.class, manager);
		this.manager = manager;
	}

	public Usuario buscaUsuarioPorUsuarioESenha(String usuario, String senha)
			throws NonUniqueResultException {
		try {
			EasyCriteria<Usuario> criteria = EasyCriteriaFactory
					.createQueryCriteria(manager, Usuario.class);
			criteria.andEquals("login", usuario);
			criteria.andEquals("senha", senha);
			return criteria.getSingleResult();
		} catch (NonUniqueResultException ex) {
			throw new NonUniqueResultException(
					"Mais de um resultado foi retornado pela consulta");
		}

	}

	public String buscaSenha(String email) {
		try {

			EasyCriteria<Usuario> criteria = EasyCriteriaFactory
					.createQueryCriteria(manager, Usuario.class);
			criteria.andEquals("email", email);

			Usuario usuario = criteria.getSingleResult();
			if (usuario != null) {
				return usuario.getSenha();
			} else {
				throw new NoResultException("A busca não retornou dados");
			}

		} catch (NonUniqueResultException ex) {
			throw new NonUniqueResultException(
					"Mais de um resultado foi retornado pela consulta");
		}
	}

}
