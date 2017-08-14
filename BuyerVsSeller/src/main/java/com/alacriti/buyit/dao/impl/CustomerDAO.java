package com.alacriti.buyit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.alacriti.buyit.vo.LoginConformationVO;
import com.alacriti.buyit.vo.LoginVO;
import com.alacriti.buyit.vo.RegisterVO;

public class CustomerDAO extends BaseDAO{
	
	public CustomerDAO(Connection conn) {
		super(conn);
	}

	public CustomerDAO() {

	}

	private static final Logger log = Logger.getLogger(CustomerDAO.class);
	
	public LoginConformationVO customerLogin(LoginVO userVO) throws SQLException {
		log.debug("CustomerDAO******customerLogin");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean isError = false;
		LoginConformationVO conform = new LoginConformationVO();

		try {
			String sqlCmd = "sql command";

			stmt = getPreparedStatementcustomerLogin(getConnection(), sqlCmd);
			stmt.setString(1, userVO.getEmail());
			stmt.setString(2, userVO.getPassword());
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("Customer_Email") != null) {
					if (rs.getString("Customer_Password") != null) {
						conform.setCheck(true);
						conform.setCustName(rs.getString("Customer_Name"));
						conform.setCustId(rs.getInt("Customer_Id"));
						return conform;

					} else
						conform.setCheck(false);
					return conform;
				}
			}
		} catch (SQLException e) {
			log.error("SQLException in getUserRole " + e.getMessage(),
					e);
			throw e;
		} finally {
			close(stmt, rs);
		}
		conform.setCheck(false);
		return conform;
	}

	public PreparedStatement getPreparedStatementcustomerLogin(
			Connection connection, String sqlCmd) throws SQLException {
		String query = "SELECT Customer_Id,Customer_Name,Customer_Email,Customer_Password FROM  lakshmi_buyit_customer_tbl WHERE (Customer_Email=? AND CONVERT(Customer_Password USING utf8)=?)";
		try {

			return connection.prepareStatement(query);
		} catch (SQLException e) {
			log.error("Exception in getPreparedStatementcustomerLogin "
					+ e.getMessage(), e);
			throw e;
		}
	}

	
	
	public boolean addCustomer(RegisterVO details) throws SQLException {
		log.debug("CustomerDAO******addCustomer");

		boolean isError = false;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sqlCmd = "sql cmd";
			stmt = getPreparedStatementaddCustomer(getConnection(), sqlCmd);
			stmt.setString(1, details.getName());
			stmt.setString(2, details.getEmail());
			stmt.setInt(3, details.getMobileno());
			stmt.setString(4, details.getPassword());
			stmt.executeUpdate();
	
			return true;

		} catch (SQLException e) {
			isError = true;
			log.error(
					"SQLException in createUserRole " + e.getMessage(), e);
			throw e;
		} finally {
			close(stmt, rs);
		}
	}

	public PreparedStatement getPreparedStatementaddCustomer(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection
					.prepareStatement("INSERT INTO  lakshmi_buyit_customer_tbl (Customer_Name,Customer_Email,Customer_PhoneNo,Customer_Password) VALUES (?,?,?,?)");
		} catch (SQLException e) {
			log.error("Exception in getPreparedStatementCreateUser "
					+ e.getMessage(), e);
			throw e;
		}
	}
}
