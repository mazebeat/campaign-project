package com.mazecode.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractDao<E> implements EntityDao<E> {
	
	private final Class<E> entityClass;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public AbstractDao() {
		this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public E findById(final Serializable id) {
		return (E) getSession().get(entityClass, id);
	}
	
	@Override
	public void save(E entity) {
		getSession().saveOrUpdate(entity);
	}
	
	public List<E> findAll() {
		return (List<E>) getSession().createNativeQuery("SELECT * FROM users ORDER By username").list();
	}
	
}
