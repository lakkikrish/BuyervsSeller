package com.alacriti.buyit.delegate;

import java.sql.Connection;
import java.sql.SQLException;

import com.alacriti.buyit.datasource.MySqlDataSource;
import com.alacriti.buyit.vo.LoginVO;
import com.alacriti.buyit.vo.OrdersVO;
import com.alacriti.buyit.vo.RegisterVO;

public class BaseDelegate {


	private Connection connection;

	public void setConnection(Connection _connection) {
		this.connection = _connection;
	}

	public Connection getConnection() {
		return connection;
	}
	public Connection getConnection(OrdersVO orderVO) {
		return connection;
	}

	public Connection getConnection(RegisterVO userRoleVO) {
		return connection;
	}
	public Connection getConnection(LoginVO userRoleVO) {
		return connection;
	}

	protected void endDBTransaction(Connection connection) {
		System.out.println("endDBTransaction");
		try {
			connection.commit();
			System.out.println("committed connection");
		} catch (SQLException e) {
			System.out.printf("SQLException in endDBTransaction " + e.getMessage(), e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.printf("SQLException in endDBTransaction" + e1.getMessage(), e1);
			}
		} catch (Exception e) {
			System.out.printf("Exception in endDBTransaction" + e.getMessage(), e);
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.out.printf("SQLException in endDBTransaction" + e.getMessage(), e);
			}
		}

	}

	protected void endDBTransaction(Connection connection, boolean isRollback) {
		
		if (isRollback) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				System.out.printf("SQLException in endDBTransaction " + e.getMessage(), e);
			}

			finally {
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					System.out.printf("SQLException in endDBTransaction " + e.getMessage(), e);
				}
			}
		} else {
			endDBTransaction(connection);
		}

	}

	protected Connection startDBTransaction() {
		Connection conn = null;
		try {
			if (conn == null || conn.isClosed())
				conn = MySqlDataSource.getInstance().getConnection();

			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.printf("SQLException in startDBTransaction " + e.getMessage(), e);
		}
		return conn;

	}
}
