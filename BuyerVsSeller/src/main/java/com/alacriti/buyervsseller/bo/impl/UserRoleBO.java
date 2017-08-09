package com.alacriti.buyervsseller.bo.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.alacriti.buyervsseller.dao.impl.UserDAO;
import com.alacriti.buyervsseller.vo.LoginVO;
import com.alacriti.buyervsseller.vo.OrdersVO;
import com.alacriti.buyervsseller.vo.ProductVO;
import com.alacriti.buyervsseller.vo.RegisterVO;

public class UserRoleBO extends BaseBO {

	public UserRoleBO(Connection connection) {
		super(connection);
	}

	// private static final AppLogger log = LogUtil.getLogger(UserRoleBO.class);

	public boolean getUserRole(LoginVO userVO) throws SQLException, Exception {
		// log.debugPrintCurrentMethodName();
		System.out.println("enter into BO to create getUserRole");
		try {
			UserDAO userDAO = new UserDAO(getConnection());
			return userDAO.getUserRole(userVO);

		} catch (Exception e) {
			System.out.printf("Exception in retrieveMessage " + e.getMessage(),
					e);
			throw e;
		}
	}

	public void createUserRole(RegisterVO userVO) throws SQLException,
			Exception {
		// log.debugPrintCurrentMethodName();
		System.out.println("enter into BO to create createUserRole");

		try {
			UserDAO userDAO = new UserDAO(getConnection());
			userDAO.createUserRole(userVO);

		} catch (Exception e) {
			System.out.printf("Exception in retrieveMessage " + e.getMessage(),
					e);
			throw e;
		}
	}

	public List getProductDetails() throws SQLException, Exception {
		System.out.println("enter into BO to pass the all products");
		try {
			UserDAO userDAO = new UserDAO(getConnection());
			return userDAO.getProductDetails();

		} catch (Exception e) {
			System.out.printf("Exception in retrieveMessage " + e.getMessage(),
					e);
			throw e;
		}
	}

	public List getProductDetails(ProductVO productVO) throws SQLException,
			Exception {
		System.out.println("enter into BO to pass the all product details");
		List list = null;
		try {
			UserDAO userDAO = new UserDAO(getConnection());
			list = userDAO.getProductDetails(productVO);
			
		} catch (Exception e) {
			System.out.printf("Exception in retrieveMessage " + e.getMessage(),
					e);
			throw e;
		}
		System.out.println("last line of getProductDetails in BO");
		return list;
	}

	public void placeOrders(OrdersVO order) throws Exception {
		System.out.println("enter into BO to create createUserRole");

		try {
			UserDAO userDAO = new UserDAO(getConnection());
			userDAO.placeOrder(order);
			userDAO.getAddresses(order);
		} catch (Exception e) {
			System.out.printf("Exception in retrieveMessage " + e.getMessage(),
					e);
			throw e;
		}
	}

	public boolean getValidBuyer(OrdersVO ordersVO) throws SQLException, Exception {
		// log.debugPrintCurrentMethodName();
		System.out.println("enter into BO to create getUserRole");
		try {
			UserDAO userDAO = new UserDAO(getConnection());
			return userDAO.getValidBuyer(ordersVO);

		} catch (Exception e) {
			System.out.printf("Exception in retrieveMessage " + e.getMessage(),
					e);
			throw e;
		}
	}
}
