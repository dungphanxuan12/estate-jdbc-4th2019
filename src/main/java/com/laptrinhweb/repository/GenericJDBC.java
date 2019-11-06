package com.laptrinhweb.repository;

import java.util.List;

public interface GenericJDBC<T> {

	public List<T> query(String sql, Object... parameters);

	public void update(String sql, Object... parameters);

	public Long insert(String sql, Object... parameters);

	Long insert(Object object);
}
