package com.alacriti.buyit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.alacriti.buyit.vo.LoginConformationVO;
import com.alacriti.buyit.vo.OrdersVO;
import com.alacriti.buyit.vo.ProductsDetailsVO;

public class OrderDAO extends BaseDAO{
	private static final Logger log = Logger.getLogger(OrderDAO.class);
	public OrderDAO(Connection conn) {
		super(conn);
	}

	public OrderDAO() {

	}

	
	

	public boolean placeOrder(OrdersVO orders) throws SQLException {
		log.debug("OrderDAO******placeOrder");
		System.out.println("enter into the orderplacing");
		boolean isError = false;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sqlCmd = "sqlcmd";
			stmt = getPreparedStatementPlaceOrder(getConnection(), sqlCmd);
			stmt.setInt(1, orders.getProductId());
			stmt.setInt(2, orders.getCustomerId());
			stmt.setString(3, orders.getOrderStatus());
			stmt.setInt(4, orders.getAddressId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			isError = true;
			log.error(
					"SQLException in createUserRole " + e.getMessage(), e);
			throw e;
		} finally {
			close(stmt, rs);
			return true;
		}
	}

	public int getAddresses( OrdersVO address) throws SQLException {
		log.debug("OrderDAO******placeOrder");
		System.out.println("entered into the address table");
		boolean isError = false;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		int noOfRecords=0;
		ResultSet rs=null;
		int lastid=0;
		int addressId=0;

		try 
		{
			String sqlCmd = "INSERT INTO lakshmi_buyit_address_tbl(Customer_Id,Street,City,State,Country,Zipcode,Product_Id) VALUES (?,?,?,?,?,?,?)";
			stmt = getPreparedStatementPlaceAdress(getConnection(), sqlCmd);
		
			stmt.setInt(1, address.getCustomerId());
			stmt.setString(2, address.getStreet());
			stmt.setString(3, address.getCity());
			stmt.setString(4, address.getState());
			stmt.setString(5, address.getCountry());
			stmt.setInt(6, address.getZipcode());
			stmt.setInt(7, address.getProductId());
			noOfRecords = stmt.executeUpdate();
			
			log.debug(noOfRecords);
			  rs=stmt.getGeneratedKeys();
			    if (rs.next()) {
			      addressId =rs.getInt(1);   
			               System.out.println("Auto Generated Primary Key " + addressId); 
			    }
		
			
			return addressId;
		} catch (SQLException e) {
			isError = true;
			log.error(
					"SQLException in getAddresses " + e.getMessage(), e);
			throw e;
		} finally {
			
			
			close(stmt,rs);
			
		}
	}
	public boolean getTransactionDetails(OrdersVO ordersVO) throws SQLException {
		log.debug("OrderDAO******placeOrder");

		boolean isError = false;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sqlCmd = "sql cmd";
			stmt = getPreparedStatementTransactionDetails(getConnection(), sqlCmd);
			stmt.setInt(1, ordersVO.getCustomerId());
			stmt.setString(2, ordersVO.getCardNumber());
			stmt.setString(3, ordersVO.getCardName());
			stmt.setString(4, ordersVO.getCardType());
			stmt.setString(5, ordersVO.getDate());
			stmt.setInt(6, ordersVO.getCvv());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			isError = true;
			log.error(
					"SQLException in getAddresses " + e.getMessage(), e);
			throw e;
		} finally {
			close(stmt, rs);
			return true;
		}
	
	}

	public PreparedStatement getPreparedStatementPlaceOrder(
			Connection connection, String sqlCmd) throws SQLException {
		String query = "INSERT INTO  lakshmi_buyit_order_tbl ( Product_Id,Customer_Id,OrderStatus,Address_Id) VALUES (?,?,?,?)";
		try {
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			log.error("Exception in getPreparedStatementCreateUser "
					+ e.getMessage(), e);
			throw e;
		}
	}

	public PreparedStatement getPreparedStatementPlaceAdress(
			Connection connection, String sqlCmd) throws SQLException {
	
		try 
		{
			return connection.prepareStatement(sqlCmd,Statement.RETURN_GENERATED_KEYS);
		} 
		catch (SQLException e)
		{
			log.error("Exception in getPreparedStatementCreateUser "
					+ e.getMessage(), e);
			throw e;
		}
	}


	
	
	public PreparedStatement getPreparedStatementVerificationOfBuyer(
			Connection connection, String sqlCmd) throws SQLException {
		String query = "SELECT * FROM lakshmi_buyit_order_tbl WHERE (Customer_id=? AND Product_Id=? AND OrderStatus=?)";
		try {
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			log.error("Exception in getPreparedStatementCreateUser "
					+ e.getMessage(), e);
			throw e;
		}
	}

	public boolean getValidBuyer(OrdersVO ordersVO) throws SQLException {
		log.debug("OrderDAO******getValidBuyer");

		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean isError = false;
		LoginConformationVO conform = new LoginConformationVO();
		try {
			String sqlCmd = "sql command";
			stmt = getPreparedStatementVerificationOfBuyer(getConnection(),
					sqlCmd);
			stmt.setInt(1, ordersVO.getCustomerId());
			stmt.setInt(2, ordersVO.getProductId());
			stmt.setString(3, ordersVO.getOrderStatus());
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("Customer_id") != null) {

					conform.setCheck(true);
					return conform.getCheck();
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
		return conform.getCheck();
	}

	public PreparedStatement getPreparedStatementTransactionDetails(
			Connection connection, String sqlCmd) throws SQLException {
		String query = "INSERT INTO lakshmi_buyit_transaction_tbl "
				+ "VALUES(?,?,?,?,?,?)";
		try {
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			log.error("Exception in  getPreparedStatementTransactionEntry"
					+ e.getMessage(), e);
			throw e;
		}
	}
	
	
	public PreparedStatement getPreparedStatementGiveRating(
			Connection connection, String sqlCmd) throws SQLException {
		String query = "INSERT INTO lakshmi_buyit_product_review_tbl "
				+ "VALUES(?,?,?,?,?,?)";
		try {
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			log.error("Exception in getPreparedStatementCreateUser "
					+ e.getMessage(), e);
			throw e;
		}
	}

	public void giveRating(ProductsDetailsVO productDetails)
			throws SQLException {
		log.debug("OrderDAO******giveRating");
		boolean isError = false;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sqlCmd = "sql cmd";
			stmt = getPreparedStatementGiveRating(getConnection(), sqlCmd);
			stmt.setInt(1, productDetails.getProductId());
			stmt.setString(2, productDetails.getProductName());
			stmt.setInt(3, productDetails.getRating());
			stmt.setString(4, productDetails.getComments());
			stmt.setInt(5, productDetails.getPrice());
			stmt.setInt(6, productDetails.getCategoryId());
			stmt.setInt(7, productDetails.getRating());
			stmt.executeUpdate();

		} catch (SQLException e) {
			isError = true;
			log.error(
					"SQLException in createUserRole " + e.getMessage(), e);
			throw e;
		} finally {
			close(stmt, rs);
		}
	}



}
