package com.coe7.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO <T>{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager getEM(){
		return entityManager;
	}
	public abstract T save(T object);
}
