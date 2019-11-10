package com.laptrinhweb.repository;

import java.util.List;

public interface GenericJDBC<T> {

	public List<T> query(String sql, Object... parameters);

	public void update(String sql, Object... parameters);

	public Long insert(String sql, Object... parameters);// chưa sử dụng

	public Long insert(Object object);

	public void update(Object object);

	public void delete(Long id);

	@SuppressWarnings("hiding")
	public <T> T findById(Long id);

}
