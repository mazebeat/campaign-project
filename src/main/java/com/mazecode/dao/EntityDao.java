package com.mazecode.dao;

import java.io.Serializable;
import java.util.List;

public interface EntityDao<E> {
	List<E> findAll();
	
	E findById(Serializable id);
	
	void save(E entity);
}
