package com.alacriti.buyit.bo.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.alacriti.buyit.dao.impl.OrderDAO;
import com.alacriti.buyit.delegate.CustomerDelegate;
import com.alacriti.buyit.util.SessionUtil;
import com.alacriti.buyit.vo.AddressInfoVO;
import com.alacriti.buyit.vo.OrderInfoVO;
import com.alacriti.buyit.vo.OrdersVO;
import com.alacriti.buyit.vo.TransactionVO;

public class OrderBO extends BaseBO {
	private static final Logger log = Logger.getLogger(CustomerDelegate.class);

	public OrderBO(Connection connection) {
		super(connection);
	}

	public boolean placeOrders(OrdersVO order) throws Exception {
		log.debug("enter into BO to create createUserRole");
		OrderInfoVO orderInfoVO;
		AddressInfoVO addressInfoVO;
		TransactionVO transactionVO;
		int orderid;
		try {
			OrderDAO orderDAO = new OrderDAO(getConnection());
			addressInfoVO = new AddressInfoVO();
			orderInfoVO = new OrderInfoVO();
			transactionVO = new TransactionVO();
			if (order.getPaymentType() == 0) {
				orderid=orderDAO.getAddresses(order);
					System.out.println("back to the bo ready to enter into the place order");
					order.setOrderStatus("1");
					order.setAddressId(orderid);
					
					System.out.println(order.getAddressId());
					return orderDAO.placeOrder(order);
			} else {
					boolean completeTransaction = orderDAO.getTransactionDetails(order);
					System.out.println("payment details " +completeTransaction);
					orderDAO.getAddresses(order);
					orderid=orderDAO.getAddresses(order);
					order.setAddressId(orderid);
					System.out.println(order.getAddressId());
					if (completeTransaction) {
					order.setOrderStatus("1");
						return orderDAO.placeOrder(order);
					}
				
				return false;
			}
		} catch (Exception e) {
			log.error("Exception in retrieveMessage " + e.getMessage(), e);
			throw e;
		}
	}

	public boolean getValidBuyer(OrdersVO ordersVO) throws SQLException,
			Exception {
		log.debug("enter into BO to create getUserRole");
		try {
			OrderDAO orderDAO = new OrderDAO(getConnection());
			return orderDAO.getValidBuyer(ordersVO);

		} catch (Exception e) {
			log.error("Exception in retrieveMessage " + e.getMessage(), e);
			throw e;
		}
	}

}
