package com.alacriti.buyervsseller.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alacriti.buyervsseller.dao.BuyerVsSellerDAO;

public class SampleDAO extends BaseDAO implements BuyerVsSellerDAO {
//	private static final AppLogger log = LogUtil.getLogger(SampleDAO.class);

	public SampleDAO() {

	}

	public SampleDAO(Connection conn) {
		super(conn);
	}

	public String selectMessage() throws SQLException {
		//log.debugPrintCurrentMethodName();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Connection connection = null;
		try {
			connection = getConnection();
			String sqlCmd = "sql command";
			stmt = super.getPreparedStatementReturnPK(connection, sqlCmd);
			rs = stmt.getGeneratedKeys();
		} catch (SQLException e) {
System.out.printf(
					"SQLException in selectMessage " + e.getMessage(), e);
			throw e;
		} finally {
			close(stmt, rs);
		}
		return "Heelloo World titlke";
	}

}
