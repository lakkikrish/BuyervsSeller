package com.alacriti.buyit.delegate;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.buyit.bo.impl.OrderBO;
import com.alacriti.buyit.vo.OrdersVO;

public class OrderDelegate extends BaseDelegate {
	private static final Logger log = Logger.getLogger(OrderDelegate.class);

	public boolean placeOrder(OrdersVO orderVO){
		log.debug("OrderDelegate****** placeOrder");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			OrderBO orderBO= new OrderBO(getConnection(orderVO));
			return orderBO.placeOrders(orderVO);
		} catch (Exception e) {
			log.error("Exception in getMessage " + e.getMessage(), e);
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return false;
	}
	public boolean getValidBuyer(OrdersVO ordersVO) {
		log.debug("OrderDelegate****getValidBuyer");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			OrderBO orderBO= new OrderBO(getConnection(ordersVO));
			return orderBO.getValidBuyer(ordersVO);
		} catch (Exception e) {
			log.error("Exception in getMessage " + e.getMessage(), e);
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return false;
	}
}
