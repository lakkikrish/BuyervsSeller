package com.alacriti.buyervsseller.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.buyervsseller.vo.ConformationVo;
import com.alacriti.buyervsseller.vo.LoginVO;
import com.alacriti.buyervsseller.vo.OrdersVO;
import com.alacriti.buyervsseller.vo.ProductInfoVO;
import com.alacriti.buyervsseller.vo.ProductVO;
import com.alacriti.buyervsseller.vo.RegisterVO;

public class UserDAO extends BaseDAO {
	// private static final AppLogger log = LogUtil.getLogger(UserDAO.class);
	static List list = new ArrayList();

	// static List<ProductInfoVO> list1 = new ArrayList<ProductInfoVO>();
	public UserDAO(Connection conn) {
		super(conn);
	}

	public UserDAO() {

	}

	public boolean getUserRole(LoginVO userVO) throws SQLException {
		// log.debugPrintCurrentMethodName();
		System.out.println("LoginValidation validatingUser: ");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean isError = false;
		ConformationVo conform = new ConformationVo();

		try {
			String sqlCmd = "sql command";

			stmt = getPreparedStatementGetUserRole(getConnection(), sqlCmd);
			stmt.setString(1, userVO.getEmail());
			stmt.setString(2, userVO.getPassword());
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("Customer_Email") != null) {
					if (rs.getString("Customer_Password") != null) {
						conform.setCheck(true);
						return conform.getCheck();

					} else
						conform.setCheck(false);
					return conform.getCheck();
				}
			}
		} catch (SQLException e) {
			System.out.printf("SQLException in getUserRole " + e.getMessage(),
					e);
			throw e;
		} finally {
			close(stmt, rs);
		}
		conform.setCheck(false);
		return conform.getCheck();
	}

	public PreparedStatement getPreparedStatementGetUserRole(
			Connection connection, String sqlCmd) throws SQLException {
		String query = "SELECT Customer_Email,Customer_Password FROM  Lakshmi_BuyervsSeller_CustomerDetails WHERE (Customer_Email=? AND CONVERT(Customer_Password USING utf8)=?)";
		try {

			return connection.prepareStatement(query);
		} catch (SQLException e) {
			System.out.printf("Exception in getPreparedStatementGetUserRole "
					+ e.getMessage(), e);
			throw e;
		}
	}

	public void createUserRole(RegisterVO details) throws SQLException {
		// log.debugPrintCurrentMethodName();
		System.out.println("enter into DAO to create createUserRole");
		System.out.println("PostingData createUser: ");
		boolean isError = false;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sqlCmd = "sql cmd";
			stmt = getPreparedStatementCreateUserRole(getConnection(), sqlCmd);
			stmt.setString(1, details.getName());
			stmt.setString(2, details.getEmail());
			stmt.setInt(3, details.getMobileno());
			stmt.setString(4, details.getPassword());
			stmt.executeUpdate();

		} catch (SQLException e) {
			isError = true;
			System.out.printf(
					"SQLException in createUserRole " + e.getMessage(), e);
			throw e;
		} finally {
			close(stmt, rs);
		}
	}

	public PreparedStatement getPreparedStatementCreateUserRole(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection
					.prepareStatement("INSERT INTO  Lakshmi_BuyervsSeller_CustomerDetails (Customer_Name,Customer_Email,Customer_PhoneNo,Customer_Password) VALUES (?,?,?,?)");
		} catch (SQLException e) {
			System.out.printf("Exception in getPreparedStatementCreateUser "
					+ e.getMessage(), e);
			throw e;
		}
	}

	public List getProductDetails() {

		System.out.println("get all product details: ");
		boolean isError = false;
		Statement stmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		// list.clear();
		try {
			System.out.println("get all product details: ");
			stmt = getCreateStatement(getConnection());
			rs = stmt
					.executeQuery("SELECT * FROM Lakshmi_BuyervsSeller_Product_Category");
			while (rs.next()) {

				list.add(new ProductVO(rs.getInt("Category_id"), rs
						.getString("Category_name")));
			}
		} catch (Exception e) {
			isError = true;
			System.out.println("Exception while getAllProducts  : " + e);
		} finally {
			close(rs);
			close(stmt);

		}
		return list;
	}

	public Statement getCreateStatement(Connection connection)
			throws SQLException {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			System.out.printf("Exception in getPreparedStatementCreateUser "
					+ e.getMessage(), e);
			throw e;
		}
	}

	public PreparedStatement searchCategory(Connection connection, String sqlCmd)
			throws SQLException {
		String query = "SELECT Product_Id, Product_Name, Category_Id, Price, Product_Description FROM Lakshmi_BuyervsSeller_ProductInformation WHERE"
				+ " Category_id =(SELECT Category_Id FROM "
				+ "Lakshmi_BuyervsSeller_Product_Category WHERE category_Name=?);";
		try {
			System.out.println("=====>query");
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("Exception in getPreparedStatementGetUserRole "
					+ e.getMessage(), e);
			throw e;
		}
	}

	public PreparedStatement searchProduct(Connection connection, String sqlCmd)
			throws SQLException {
		String query = "SELECT * FROM Lakshmi_BuyervsSeller_ProductInformation WHERE Product_Name=?";
		try {

			return connection.prepareStatement(query);
		} catch (SQLException e) {
			System.out.printf("Exception in getPreparedStatementGetUserRole "
					+ e.getMessage(), e);
			throw e;
		}
	}

	public List getProductDetails(ProductVO productVO) throws SQLException {
		// log.debugPrintCurrentMethodName();
		System.out.println("SearchValidation getProductDetails: ");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean isError = false;
		ProductInfoVO productInfo;
		List list = new ArrayList();
		try {
			productInfo = new ProductInfoVO();
			list.clear();
			String sqlCmd = "sql command";
			stmt = searchCategory(getConnection(), sqlCmd);
			System.out.println(productVO.getProductName());
			stmt.setString(1, productVO.getProductName());
			rs = stmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				System.out.println(++i);
				list.add(new ProductInfoVO(rs.getInt("Product_Id"), rs
						.getString("Product_Name"), rs.getInt("Category_Id"),
						rs.getInt("Price"), rs.getString("Product_Description")));
			}

			System.out.println(list);
			if (list.isEmpty()) {
				stmt = searchProduct(getConnection(), sqlCmd);
				stmt.setString(1, productVO.getProductName());
				rs = stmt.executeQuery();
				while (rs.next()) {
					list.add(new ProductInfoVO(rs.getInt(1), rs.getString(2),
							rs.getInt(3), rs.getInt(4), rs.getString(5)));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.printf("SQLException in getUserRole " + e.getMessage(),
					e);
			throw e;
		} finally {
			close(stmt, rs);
		}
		System.out.println("last line of getProductDetails");
		return list;
	}

	public void placeOrder(OrdersVO orders) throws SQLException {
		System.out.println("enter into DAO to create createUserRole");
		System.out.println("PostingData createUser: ");
		boolean isError = false;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sqlCmd = "sql cmd";
			stmt = getPreparedStatementCreateUserRole(getConnection(), sqlCmd);
			stmt.setInt(1, orders.getCustomerId());
			stmt.setInt(2, orders.getProductId());
			stmt.setString(3, orders.getOrderStatus());
			stmt.executeUpdate();

		} catch (SQLException e) {
			isError = true;
			System.out.printf(
					"SQLException in createUserRole " + e.getMessage(), e);
			throw e;
		} finally {
			close(stmt, rs);
		}
	}

	public void getAddresses(OrdersVO address) throws SQLException {
		System.out.println("enter into DAO to create createUserRole");
		System.out.println("PostingData createUser: ");
		boolean isError = false;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sqlCmd = "sql cmd";
			stmt = getPreparedStatementCreateUserRole(getConnection(), sqlCmd);
			stmt.setInt(1, address.getCustomerId());
			stmt.setString(2, address.getStreet());
			stmt.setString(3, address.getCity());
			stmt.setString(4, address.getState());
			stmt.setString(5, address.getCountry());
			stmt.setString(6, address.getCountry());
			stmt.setInt(7, address.getZipcode());
			stmt.executeUpdate();

		} catch (SQLException e) {
			isError = true;
			System.out.printf(
					"SQLException in createUserRole " + e.getMessage(), e);
			throw e;
		} finally {
			close(stmt, rs);
		}
	}

	public PreparedStatement getPreparedStatementPlaceOrder(
			Connection connection, String sqlCmd) throws SQLException {
		String query = "INSERT INTO  Lakshmi_BuyervsSeller_OrderDetails ( Order_Id,Product_Id,OrderStatus) VALUES (?,?,?)";
		try {
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			System.out.printf("Exception in getPreparedStatementCreateUser "
					+ e.getMessage(), e);
			throw e;
		}
	}

	public PreparedStatement getPreparedStatementPlaceAdress(
			Connection connection, String sqlCmd) throws SQLException {
		String query = "INSERT INTO  Lakshmi_BuyervsSeller_AddressInformation  (Customer_Id,Street,City,State,Country,Zipcode) VALUES (?,?,?,?,?,?,?)";
		try {
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			System.out.printf("Exception in getPreparedStatementCreateUser "
					+ e.getMessage(), e);
			throw e;
		}
	}
}