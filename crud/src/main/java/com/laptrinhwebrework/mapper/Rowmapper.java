package com.laptrinhwebrework.mapper;

import java.sql.ResultSet;

public interface Rowmapper<T> {
	T maprow(ResultSet resultSet);
}
