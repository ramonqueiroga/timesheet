package br.com.timesheet.infra.produtores;

import javax.ejb.ApplicationException;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationException
public class EntityManagerProducer {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("timesheet");
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
	
	public void close(@Disposes EntityManager manager){
		manager.close();
	}

}
