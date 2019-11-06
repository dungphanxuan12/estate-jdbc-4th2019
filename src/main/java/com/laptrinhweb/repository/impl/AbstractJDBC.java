package com.laptrinhweb.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.laptrinhweb.annotation.Column;
import com.laptrinhweb.annotation.Table;
import com.laptrinhweb.mapper.ResultSetMapper;
import com.laptrinhweb.repository.GenericJDBC;

public class AbstractJDBC<T> implements GenericJDBC<T> {

	private Class<T> zclass;

	@SuppressWarnings("unchecked")
	public AbstractJDBC() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		zclass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String DBURL = "jdbc:mysql://localhost:3306/estate-4month2019";
			String USER = "root";
			String PASSWORD = "1234";
			return DriverManager.getConnection(DBURL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List query(String sql, Object... parameters) {

		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<T>();

		Connection conn = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if (conn != null) {
				return resultSetMapper.mapRow(resultSet, this.zclass);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection conn = getConnection();
		PreparedStatement statement = null;

		try {
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);

			if (conn != null) {

				// set parameter to statement
				for (int i = 0; i < parameters.length; i++) {
					int index = i + 1;
					statement.setObject(index, parameters[i]);
				}

				statement.executeUpdate();
				conn.commit();

			}
		} catch (SQLException e) {
			try {

				if (conn != null)
					conn.rollback();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {

				if (conn != null)
					conn.close();

				if (statement != null)
					statement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection conn = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			if (conn != null) {

				// set parameter to statement
				for (int i = 0; i < parameters.length; i++) {
					int index = i + 1;
					statement.setObject(index, parameters[i]);
				}

				int RowInserted = statement.executeUpdate();
				conn.commit();

				resultSet = statement.getGeneratedKeys();

				if (RowInserted > 0) {
					while (resultSet.next()) {
						Long id = resultSet.getLong(1);
						return id;
					}

				}
			}
		} catch (SQLException e) {
			try {

				if (conn != null)
					conn.rollback();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {

				if (conn != null)
					conn.close();

				if (statement != null)
					statement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Long insert(Object object) {
		Connection conn = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		String sql = createSQLInsert();
		try {
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			if (conn != null) {
				Class<?> zClass = object.getClass();
				// set parameter to statement
				Field[] fields = zClass.getDeclaredFields();
				for (int i = 0; i < fields.length; i++) {
					int index = i + 1;
					Field field = fields[i];
					field.setAccessible(true);// phải set Accessible cho field
					statement.setObject(index, field.get(object));
				}

				Class<?> parentClass = zClass.getSuperclass();
				int indexParent = fields.length + 1;
				while (parentClass != null) {

					for (int i = 0; i < parentClass.getDeclaredFields().length; i++) {
						int index = i + 1;
						Field field = parentClass.getDeclaredFields()[i];
						field.setAccessible(true);// phải set Accessible cho field
						statement.setObject(indexParent, field.get(object));
						indexParent = indexParent + 1;
					}
					parentClass = parentClass.getSuperclass();
				}

				int RowInserted = statement.executeUpdate();
				conn.commit();

				resultSet = statement.getGeneratedKeys();

				if (RowInserted > 0) {
					while (resultSet.next()) {
						Long id = resultSet.getLong(1);
						return id;
					}

				}
			}
		} catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
			try {

				if (conn != null)
					conn.rollback();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {

				if (conn != null)
					conn.close();

				if (statement != null)
					statement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private String createSQLInsert() {
		// get table name from anotaion
		String tableName = "";

		if (zclass.isAnnotationPresent(Table.class)) {
			Table table = zclass.getAnnotation(Table.class);
			tableName = table.name();
		}

		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");

		for (Field field : zclass.getDeclaredFields()) {
			if (fields.length() > 1) {
				fields.append(",");
				params.append(",");
			}
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fields.append(column.name());
				params.append("?");

			}

		}

		// check parent class
		Class<?> parentClass = zclass.getSuperclass();
		while (parentClass != null) {
			for (Field field : parentClass.getDeclaredFields()) {
				if (fields.length() > 1) {
					fields.append(",");
					params.append(",");
				}
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					fields.append(column.name());
					params.append("?");
				}

			}
			parentClass = parentClass.getSuperclass();
		}

		String sql = "INSERT INTO " + tableName + "(" + fields.toString() + ") VALUES (" + params.toString() + ")";

		return sql;
	}

}
