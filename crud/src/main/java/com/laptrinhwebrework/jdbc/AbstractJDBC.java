package com.laptrinhwebrework.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import com.laptrinhwebrework.mapper.ResultSetMapper;

/**
 * The AbstractJDBC Class
 * 
 *
 * @author Dung Phan Xuan
 * @version 1.0
 * @since 2020-05-14
 */
public class AbstractJDBC <T>{

	public Connection getConnection() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
		final String DRIVER_NAME = resourceBundle.getString("jdbc.driverName");
		final String DB_URL = resourceBundle.getString("jdbc.source.url");
		final String USER = resourceBundle.getString("jdbc.user");
		final String PASSWORD = resourceBundle.getString("jdbc.password");
		try {
			Class.forName(DRIVER_NAME);
			return DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	public <T> List<T> query(String sql, Rowmapper<T> rowMapper, Object... params) {
//		List<T> result = new ArrayList<T>();
//		Connection conn = null;
//		PreparedStatement statement = null;
//		ResultSet resultSet = null;
//		try {
//			conn = getConnection();
//			conn.setAutoCommit(false);
//			statement = conn.prepareStatement(sql);
//			resultSet = statement.executeQuery();
//			if (conn != null) {
//				while (resultSet.next()) {
//					result.add(rowMapper.maprow(resultSet));
//				}
//			}
//			return result;
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				if (conn != null) {
//					conn.close();
//				}
//				if (statement != null) {
//					statement.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}

	@SuppressWarnings("hiding")
	public <T> List<T> query(String sql, Class<T> zClass, Object... params) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<T>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if (conn != null) {
				return resultSetMapper.mapRow(resultSet, zClass);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Long insert(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			if (conn != null) {

				for (int i = 0; i < params.length; i++) {
					int index = i + 1;
					statement.setObject(index, params[i]);
				}

				int rowsInserted = statement.executeUpdate();
				conn.commit();

				resultSet = statement.getGeneratedKeys();
				if (rowsInserted > 0) {
					while (resultSet.next()) {
						Long id = resultSet.getLong(1);
						return id;

					}
				}
			}
		} catch (SQLException e) {

			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {

			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return null;
	}

	public void update(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			if (conn != null) {

				for (int i = 0; i < params.length; i++) {
					int index = i + 1;
					statement.setObject(index, params[i]);
				}

				statement.executeUpdate();
				conn.commit();
			}
		} catch (SQLException e) {

			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {

			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
