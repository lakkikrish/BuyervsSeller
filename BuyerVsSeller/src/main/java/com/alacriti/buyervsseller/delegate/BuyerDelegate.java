package com.alacriti.buyervsseller.delegate;

import java.sql.Connection;
import java.util.List;

import com.alacriti.buyervsseller.bo.impl.UserRoleBO;
import com.alacriti.buyervsseller.vo.LoginVO;
import com.alacriti.buyervsseller.vo.OrdersVO;
import com.alacriti.buyervsseller.vo.ProductVO;
import com.alacriti.buyervsseller.vo.RegisterVO;

public class BuyerDelegate extends BaseDelegate {
	//private static final AppLogger log = LogUtil.getLogger(UserDelegate.class);


	public boolean getUserRole(LoginVO userVO) {
		System.out.println("in Buyer delegate ****** getUserRole");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRoleBO userRoleBO= new UserRoleBO(getConnection(userVO));
			return userRoleBO.getUserRole(userVO);
		} catch (Exception e) {
			System.out.printf("Exception in getMessage " + e.getMessage(), e);
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return false;
	}
	
	public void createUserRole(RegisterVO userRoleVO){
		System.out.println("in Buyer delegate ****** createUserRole");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRoleBO userRoleBO= new UserRoleBO(getConnection(userRoleVO));
			userRoleBO.createUserRole(userRoleVO);
		} catch (Exception e) {
			System.out.printf("Exception in getMessage " + e.getMessage(), e);
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
}
	public List getProducts(){
		//	log.logInfo("In User delegate*********createUserRole");
			System.out.println("in Buyer delegate ****** getProducts");
			boolean rollBack = false;
			Connection connection = null;
			try {
				connection = startDBTransaction();
				setConnection(connection);
				UserRoleBO userRoleBO= new UserRoleBO(getConnection());
				return userRoleBO.getProductDetails();
			} catch (Exception e) {
				System.out.printf("Exception in getMessage " + e.getMessage(), e);
				rollBack = true;
			} finally {
				endDBTransaction(connection, rollBack);
			}
			return null;
	}
	public List getProductDetails(ProductVO productVO){
			System.out.println("in Buyer delegate ****** getProductInfo");
			boolean rollBack = false;
			Connection connection = null;
			try {
				connection = startDBTransaction();
				setConnection(connection);
				UserRoleBO userRoleBO= new UserRoleBO(getConnection());
				return userRoleBO.getProductDetails(productVO);
			} catch (Exception e) {
				System.out.printf("Exception in getMessage " + e.getMessage(), e);
				rollBack = true;
			} finally {
				endDBTransaction(connection, rollBack);
			}
			return null;
	}
	public void placeOrder(OrdersVO orderVO){
		System.out.println("in Buyer delegate ****** createUserRole");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRoleBO userRoleBO= new UserRoleBO(getConnection(orderVO));
			userRoleBO.placeOrders(orderVO);
		} catch (Exception e) {
			System.out.printf("Exception in getMessage " + e.getMessage(), e);
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
	public boolean getValidBuyer(OrdersVO ordersVO) {
		System.out.println("getValidBuyer");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRoleBO userRoleBO= new UserRoleBO(getConnection(ordersVO));
			return userRoleBO.getValidBuyer(ordersVO);
		} catch (Exception e) {
			System.out.printf("Exception in getMessage " + e.getMessage(), e);
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return false;
	}
}

