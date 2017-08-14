package com.alacriti.buyit.delegate;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.alacriti.buyit.bo.impl.CustomerBO;
import com.alacriti.buyit.vo.LoginConformationVO;
import com.alacriti.buyit.vo.LoginVO;
import com.alacriti.buyit.vo.RegisterVO;

public class CustomerDelegate extends BaseDelegate{
	
	
		private static final Logger log = Logger.getLogger(CustomerDelegate.class);


		public LoginConformationVO customerLogin(LoginVO userVO) {
			log.debug("getUserRole*******In Delegate");
			boolean rollBack = false;
			Connection connection = null;
			LoginConformationVO conformation=null;
			try {
				connection = startDBTransaction();
				setConnection(connection);
				CustomerBO customerBO= new CustomerBO(getConnection(userVO));
				conformation= customerBO.customerLogin(userVO);
				return conformation;
			} catch (Exception e) {
				log.error("Exception in getMessage " + e.getMessage(), e);
				rollBack = true;
			} finally {
				endDBTransaction(connection, rollBack);
			}
			return conformation;
		}
		
		public boolean addCustomer(RegisterVO userRoleVO){
			log.debug("addCustomer*******In Delegate");
			boolean rollBack = false;
			Connection connection = null;
			try {
				connection = startDBTransaction();
				setConnection(connection);
				CustomerBO customerBO= new CustomerBO(getConnection(userRoleVO));
				return customerBO.addCustomer(userRoleVO);
			} catch (Exception e) {
				log.error("Exception in getMessage " + e.getMessage(), e);
				rollBack = true;
			} finally {
				endDBTransaction(connection, rollBack);
			}
			return false;
	}

}
