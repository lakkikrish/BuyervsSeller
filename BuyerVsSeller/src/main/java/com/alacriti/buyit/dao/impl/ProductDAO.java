package com.alacriti.buyit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.buyit.vo.ProductInfoVO;
import com.alacriti.buyit.vo.ProductVO;

public class ProductDAO extends BaseDAO{
	public ProductDAO(Connection conn) {
		super(conn);
	}

	public ProductDAO() {

	}

	
	private static final Logger log = Logger.getLogger(ProductDAO.class);

	
	public List getCategories() {

		log.debug("ProductDAO******getCategories");

		boolean isError = false;
		Statement stmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			log.debug("get all product details: ");
			stmt = getCreateStatementgetCategories(getConnection());
			rs = stmt
					.executeQuery("SELECT * FROM lakshmi_buyit_product_category_tbl");
			while (rs.next()) {

				list.add(new ProductVO(rs.getInt("Category_id"), rs
						.getString("Category_name"), rs.getString("image")));
			}
		} catch (Exception e) {
			isError = true;
			log.debug("Exception while getAllProducts  : " + e);
		} finally {
			close(rs);
			close(stmt);
		}
		return list;
	}

	public Statement getCreateStatementgetCategories(Connection connection)
			throws SQLException {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			log.error("Exception in getPreparedStatementCreateUser "
					+ e.getMessage(), e);
			throw e;
		}
	}

	

	public PreparedStatement getPrepareStatementgetProductsOfCategory(
			Connection connection, String sqlCmd) throws SQLException {
		String query = "SELECT Product_Id, Product_Name, Price,image FROM lakshmi_buyit_product_tbl WHERE"
				+ " Category_id =?";
		try {
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Exception in getPreparedStatementcustomerLogin "
					+ e.getMessage(), e);
			throw e;
		}
	}

	public List getProductsOfCategory(ProductVO productVO) throws SQLException {
		log.debug("ProductDAO******getProductsOfCategory");

		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean isError = false;
		ProductInfoVO productInfo;
		List list = new ArrayList();
		try {
			productInfo = new ProductInfoVO();
			list.clear();
			String sqlCmd = "sql command";
			stmt = getPrepareStatementgetProductsOfCategory(getConnection(),
					sqlCmd);
			log.debug(productVO.getProductId());
			stmt.setInt(1, productVO.getProductId());
			rs = stmt.executeQuery();
			while (rs.next()) {

				list.add(new ProductInfoVO(rs.getInt("Product_Id"), rs
						.getString("Product_Name"), rs.getInt("Price"), rs
						.getString("image")));
			}
			log.debug(list);

		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQLException in getUserRole " + e.getMessage(),
					e);
			throw e;
		} finally {
			close(stmt, rs);
		}
		return list;
	}

	
	
	public PreparedStatement getPrepareStatementgetParticularProductDetails(
			Connection connection, String sqlCmd) throws SQLException {
		String query = "SELECT pi.Product_Id,Product_Name,pi.Category_Id,pi.Price,Product_Description,image,Rating,Comments"
				+ " FROM lakshmi_buyit_product_tbl as pi "
				+"left join lakshmi_buyit_product_review_tbl as pd on pi.Product_Id=pd.Product_Id where pi.Product_id=?";
		try {
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Exception in getPreparedStatementcustomerLogin "
					+ e.getMessage(), e);
			throw e;
		}
	}
	
	
	public List getParticularProductDetails(ProductVO productVO)
			throws SQLException {
		log.debug("DAO for get" + productVO.getProductId()
				+ "ProductDetails: ");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean isError = false;
		ProductInfoVO productInfo;
		List list = new ArrayList();
		try {
			productInfo = new ProductInfoVO();
			list.clear();
			String sqlCmd = "sql command";
			stmt = getPrepareStatementgetParticularProductDetails(getConnection(), sqlCmd);
			stmt.setInt(1, productVO.getProductId());
			log.debug(productVO.getProductId());
			rs = stmt.executeQuery();
			while (rs.next()) {

				list.add(new ProductInfoVO(rs.getInt(1), rs.getString(2), rs
						.getInt(3), rs.getInt(4), rs.getString(5), rs
						.getString(6), rs.getInt(7), rs.getString(8)));
			}
			log.debug(list);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQLException in getUserRole " + e.getMessage(),
					e);
			throw e;
		} finally {
			close(stmt, rs);
		}
		log.debug("last line of getProductDetails");
		return list;
	}

	
	public List getSearchProduct(ProductVO productVO) throws SQLException {
		log.debug("ProductDAO******getSearchProduct");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean isError = false;
		ProductInfoVO productInfo;
		List list = new ArrayList();
		try {
			productInfo = new ProductInfoVO();
			list.clear();
			String sqlCmd = "sql command";
			stmt = searchByCategoryName(getConnection(), sqlCmd);
			log.debug(productVO.getProductName());
			stmt.setString(1, productVO.getProductName()+"%");
			rs = stmt.executeQuery();
			while (rs.next()) {

				list.add(new ProductInfoVO(rs.getInt(1), rs.getString(2), rs
						.getInt(3), rs.getInt(4), rs.getString(5), rs
						.getString(6), rs.getInt(7), rs.getString(8)));
			}

			log.debug(list);
			if (list.isEmpty()) {
				stmt = searchByProductName(getConnection(), sqlCmd);
				stmt.setString(1, productVO.getProductName()+"%");
				rs = stmt.executeQuery();
				while (rs.next()) {
					list.add(new ProductInfoVO(rs.getInt(1), rs.getString(2),
							rs.getInt(3), rs.getInt(4), rs.getString(5), rs
									.getString(6), rs.getInt(7), rs
									.getString(8)));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("SQLException in getUserRole " + e.getMessage(),
					e);
			throw e;
		} finally {
			close(stmt, rs);
		}
		log.debug("last line of getProductDetails");
		return list;
	}

	public PreparedStatement searchByCategoryName(Connection connection, String sqlCmd)
			throws SQLException {
		String query = "SELECT pi.Product_Id,Product_Name,pi.Category_Id,pi.Price,Product_Description,image,Rating,Comments"
				+ " FROM lakshmi_buyit_product_tbl as pi "
				+ "left join lakshmi_buyit_product_review_tbl as pd on pi.Product_Id=pd.Product_Id where "
				+ "pi.Category_id =(SELECT Category_Id FROM "
				+ "lakshmi_buyit_product_category_tbl WHERE category_Name LIKE ?);";
		try {
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Exception in getPreparedStatementcustomerLogin "
					+ e.getMessage(), e);
			throw e;
		}
	}

	public PreparedStatement searchByProductName(Connection connection, String sqlCmd)
			throws SQLException {
		String query = "SELECT pi.Product_Id,Product_Name,pi.Category_Id,pi.Price,Product_Description,image,Rating,Comments"
				+ " FROM lakshmi_buyit_product_tbl as pi "
				+ "left join lakshmi_buyit_product_review_tbl as pd on pi.Product_Id=pd.Product_Id WHERE pi.Product_Name LIKE ?";
		try {

			return connection.prepareStatement(query);
		} catch (SQLException e) {
			log.error("Exception in getPreparedStatementcustomerLogin "
					+ e.getMessage(), e);
			throw e;
		}
	}


}
