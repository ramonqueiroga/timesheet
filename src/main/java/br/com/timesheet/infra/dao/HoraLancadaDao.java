package br.com.timesheet.infra.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.timesheet.modelos.HoraLancada;
import br.com.timesheet.modelos.Usuario;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

public class HoraLancadaDao extends AbstractDao<HoraLancada>{
	
	private EntityManager manager;


	@Inject
	public HoraLancadaDao(EntityManager manager){
		super(HoraLancada.class, manager);
		this.manager = manager;
		
	}

	public List<HoraLancada> listaHorasPorUsuario(Usuario usuario){
		EasyCriteria<HoraLancada> criteria = EasyCriteriaFactory.createQueryCriteria(manager, HoraLancada.class);
		criteria.innerJoin("usuario");
		criteria.andEquals("usuario", usuario);
		return criteria.getResultList();
	}

}
