package com.laptrinhweb.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhweb.anotations.Column;
import com.laptrinhweb.anotations.Entity;

/**
 * The ResultSetMapper Class
 * 
 * 
 *
 * @author Dung Phan Xuan
 * @version 1.0
 * @since 2020-05-15
 */
public class ResultSetMapper<T> {

	/**
	 * 
	 * @param resultSet
	 * @param zClass
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> mapRow(ResultSet resultSet, Class zClass) {
		List<T> results = new ArrayList<>();

		try {
			if (zClass.isAnnotationPresent(Entity.class)) {
				ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

				Field[] fields = zClass.getDeclaredFields();
				while (resultSet.next()) {
					T object = (T) zClass.newInstance();

					for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {

						String columnName = resultSetMetaData.getColumnName(i + 1);
						Object columnValue = resultSet.getObject(i + 1);
						convertResultSetToEntity(fields, columnName, columnValue, object);

						Class parentClass = zClass.getSuperclass();
						while (parentClass != null) {
							Field[] parentFields = parentClass.getDeclaredFields();
							convertResultSetToEntity(parentFields, columnName, columnValue, object);
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

	/**
	 * 
	 * @param fields
	 * @param columnName
	 * @param columnValue
	 * @param object
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private void convertResultSetToEntity(Field[] fields, String columnName, Object columnValue, T object)
			throws IllegalAccessException, InvocationTargetException {
		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				if (column.name().equals(columnName)) {
					BeanUtils.setProperty(object, field.getName(), columnValue);
					break;
				}
			}
		}
	}
}