package com.laptrinhweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhweb.paging.Pageble;

@SuppressWarnings("hiding")
public interface GenericJDBC<T> {

//	public List<T> query(String sql, Object... parameters);
//
//	public void update(String sql, Object... parameters);
//
//	public Long insert(String sql, Object... parameters);// chưa sử dụng

	public Long insert(Object object);

	public void update(Object object);

	public void delete(Long id);

	public <T> T findById(Long id);
	
	void deleteByProperty(String where);

	List<T> findAll(Map<String,Object> properties,Pageble pageble,Object...where);
	
	int countByProperty(Map<String, Object> properties, Object... where);

}
