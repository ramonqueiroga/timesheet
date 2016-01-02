package br.com.timesheet.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;

import br.com.timesheet.modelos.Usuario;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

public class UsuarioDao extends AbstractDao<Usuario>{

	private EntityManager manager;

	@Inject
	public UsuarioDao(EntityManager manager) {
		super(Usuario.class, manager);
		this.manager = manager;
	}
	
	public Usuario busca(String usuario, String senha) throws NonUniqueResultException{
		try{
			EasyCriteria<Usuario> criteria = EasyCriteriaFactory.createQueryCriteria(manager, Usuario.class);
			criteria.andEquals("login", usuario);
			criteria.andEquals("senha", senha);
			return criteria.getSingleResult();
		}catch(NonUniqueResultException ex){
			throw new NonUniqueResultException("Mais de um resultado foi retornado da consulta");
		}
		
	}

}
