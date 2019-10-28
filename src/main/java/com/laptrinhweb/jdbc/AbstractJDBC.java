package com.laptrinhweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.laptrinhweb.mapper.ResultSetMapper;

public class AbstractJDBC<T> {

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
	/*
	 * @SuppressWarnings("hiding") public <T> List<T> query(String sql, RowMapper<T>
	 * rowMapper, Object... parameters) { List<T> results = new ArrayList<T>();
	 * 
	 * Connection conn = getConnection(); PreparedStatement statement = null;
	 * ResultSet resultSet = null;
	 * 
	 * try { statement = conn.prepareStatement(sql); resultSet =
	 * statement.executeQuery(); if (conn != null) { while (resultSet.next()) {
	 * results.add(rowMapper.mapRow(resultSet)); } return results; }
	 * 
	 * } catch (SQLException e) { System.out.println(e.getMessage()); } finally {
	 * try { if (conn != null) conn.close();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } } return null; }
	 */

	public <T> List<T> query(String sql, Class<T> zclass, Object... parameters) {

		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<T>();

		Connection conn = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if (conn != null) {
				return resultSetMapper.mapRow(resultSet, zclass);
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

	// trả về id
	// Object truyền được nhiều parameters[] trả về một mảng
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

}
