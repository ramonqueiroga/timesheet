package br.com.timesheet.infra.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

public abstract class AbstractDao<T> implements GenericDao<T> {
	
	private Class<T> classe;
	private EntityManager manager;
	
	public AbstractDao(Class<T> classe, EntityManager manager) {
		this.classe = classe;
		this.manager = manager;
	}

	@Override
	public boolean adiciona(T t) {
		try{
			manager.getTransaction().begin();
			manager.persist(t);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			manager.getTransaction().rollback();
			return false;
		}finally{
			manager.close();
		}
	}

	@Override
	public boolean remove(T t) {
		try{
			manager.getTransaction().begin();
			manager.remove(manager.merge(t));
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			manager.getTransaction().rollback();
			return false;
		}finally{
			manager.close();
		}
	}

	@Override
	public boolean atualiza(T t) {
		try{
			manager.getTransaction().begin();
			manager.merge(t);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			manager.getTransaction().rollback();
			return false;
		}finally{
			manager.close();
		}
	}

	@Override
	public T buscaPorId(Integer id) {
		T t = manager.find(classe, id);
		return t;
	}

	@Override
	public List<T> listaTodos() {
		EasyCriteria<T> criteria = EasyCriteriaFactory.createQueryCriteria(manager, classe);
		return criteria.getResultList();
	}

}
