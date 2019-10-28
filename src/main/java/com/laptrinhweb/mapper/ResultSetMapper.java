package com.laptrinhweb.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhweb.annotation.Column;
import com.laptrinhweb.annotation.Entity;

@SuppressWarnings("unchecked")
public class ResultSetMapper<T> {

	@SuppressWarnings("rawtypes")
	public List<T> mapRow(ResultSet rs, Class zClass) {

		List<T> results = new ArrayList<>();

		try {

			if (zClass.isAnnotationPresent(Entity.class)) {

				ResultSetMetaData resultSetMetaData = rs.getMetaData();
				Field[] fields = zClass.getDeclaredFields();// BuildingEntity get được field name, ward, ... trong
															// zclass

				while (rs.next()) {// lấy từng hàng trong bảng building

					T object = (T) zClass.newInstance();

					// get giá trị của 1 row trong resultSet và set vào trong Entity
					for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
						String columName = resultSetMetaData.getColumnName(i + 1);
						Object columnValue = rs.getObject(i + 1);
						// current Class
						convertResultToEntity(fields, columName, columnValue, object);
						// parent class

						Class parentClass = zClass.getSuperclass();
						while (parentClass != null) {
							Field[] fieldParents = parentClass.getDeclaredFields();
							convertResultToEntity(fieldParents, columName, columnValue, object);
							parentClass = parentClass.getSuperclass();
						}
					}
					results.add(object);
				}
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return results;

	}

	private void convertResultToEntity(Field[] fields, String columName, Object columnValue, T object)
			throws IllegalAccessException, InvocationTargetException {

		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);

				if (column.name().equals(columName) && columnValue != null) {
					BeanUtils.setProperty(object, field.getName(), columnValue);
					break;
				}
			}
		}
	}
}
