package com.addworld.data.repositories;

public interface AddworldRepository<T> {

	public void insert(T element);
	
	public void update(T element);
	
	public void delete(T element);
	
	public T findById(Integer id);
	
}
