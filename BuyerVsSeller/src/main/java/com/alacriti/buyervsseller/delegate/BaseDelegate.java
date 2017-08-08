package com.alacriti.buyervsseller.delegate;

import java.sql.Connection;
import java.sql.SQLException;

import com.alacriti.buyervsseller.datasource.MySqlDataSource;
import com.alacriti.buyervsseller.vo.LoginVO;
import com.alacriti.buyervsseller.vo.OrdersVO;
import com.alacriti.buyervsseller.vo.RegisterVO;

public class BaseDelegate {

	//private static final AppLogger log = LogUtil.getLogger(BaseDelegate.class);

	private Connection connection;

	public void setConnection(Connection _connection) {
		//log.debugPrintCurrentMethodName();
		this.connection = _connection;
	}

	public Connection getConnection() {
		//log.debugPrintCurrentMethodName();
		return connection;
	}
	public Connection getConnection(OrdersVO orderVO) {
		//log.debugPrintCurrentMethodName();
		return connection;
	}

	public Connection getConnection(RegisterVO userRoleVO) {
		//log.debugPrintCurrentMethodName();
		return connection;
	}
	public Connection getConnection(LoginVO userRoleVO) {
		//log.debugPrintCurrentMethodName();
		return connection;
	}

	protected void endDBTransaction(Connection connection) {
		//log.debugPrintCurrentMethodName();
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
		//log.debugPrintCurrentMethodName();
		
		if (isRollback) {
			try {
				connection.rollback();
				//log.logInfo("Rolled Back on some exception....!!!");
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
		//log.debugPrintCurrentMethodName();
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
