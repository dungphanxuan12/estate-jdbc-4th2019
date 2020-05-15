package com.laptrinhwebrework.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhwebrework.annotation.Column;
import com.laptrinhwebrework.annotation.Entity;

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
	 * The mapRow method
	 * 
	 * @param resultSet
	 * @param Class
	 * 
	 *                  If Class has anotation @Entity
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "null" })
	public List<T> mapRow(ResultSet resultSet, Class zClass) {
		List<T> results = null;

		try {
			if (zClass.isAnnotationPresent(Entity.class)) {
				ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
				Field[] fields = zClass.getDeclaredFields();
				while (resultSet.next()) {
					T object = (T) zClass.newInstance();
					for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
						String columnName = resultSetMetaData.getColumnName(i + 1);
						Object columnValue = resultSet.getObject(i + 1);
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
					results.add(object);
				}
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return results;
	}
}