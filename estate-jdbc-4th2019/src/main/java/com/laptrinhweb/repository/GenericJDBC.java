package com.laptrinhweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhweb.paging.Pageble;

public interface GenericJDBC<T> {

	/**
	 * Insert Object into database
	 * 
	 * @param object
	 * @return id
	 */
	public Long insert(Object object);

	/**
	 * Update database with Object value
	 * 
	 * @param object
	 */
	public void update(Object object);

	/**
	 * Delete object by id
	 * 
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * Find Object belong <T> type by id
	 * 
	 * @param <T>
	 * @param id
	 * @return Object <T>
	 */
	@SuppressWarnings("hiding")
	public <T> T findById(Long id);

	/**
	 * Delete Object by properties
	 * 
	 * @param properties
	 */
	void deleteByProperty(String where);

	/**
	 * 
	 * @param properties
	 * @param pageble
	 * @param where
	 * @return
	 */
	List<T> findAll(Map<String, Object> properties, Pageble pageble, Object... where);

	/**
	 * 
	 * @param properties
	 * @param where
	 * @return
	 */
	int countByProperty(Map<String, Object> properties, Object... where);

}
