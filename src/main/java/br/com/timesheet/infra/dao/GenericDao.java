package br.com.timesheet.infra.dao;

import java.util.List;

public interface GenericDao<T> {
	
	public boolean adiciona(T t);
	public boolean remove(T t);
	public boolean atualiza(T t);
	public T buscaPorId(Integer id);
	public List<T> listaTodos();
	
}
