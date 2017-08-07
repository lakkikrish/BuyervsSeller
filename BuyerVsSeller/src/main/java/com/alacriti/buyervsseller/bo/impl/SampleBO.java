package com.alacriti.buyervsseller.bo.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.alacriti.buyervsseller.bo.ISampleBO;
import com.alacriti.buyervsseller.dao.BuyerVsSellerDAO;
import com.alacriti.buyervsseller.dao.impl.SampleDAO;


public class SampleBO extends BaseBO implements ISampleBO {
	//private static final AppLogger log = LogUtil.getLogger(SampleBO.class);

	public SampleBO() {

	}

	public SampleBO(Connection conn) {
		super(conn);
	}
	public String retrieveMessage() throws Exception {
		//log.debugPrintCurrentMethodName();
		BuyerVsSellerDAO accountDAO = null;
		String msg = null;
		try {
			accountDAO = new SampleDAO(getConnection());
			msg = accountDAO.selectMessage();
		} catch (SQLException e) {
			System.out.printf("DAOException in retrieveMessage" + e.getMessage(), e);
			System.out.println("SQLException Occured");
			throw new Exception();
		} catch (Exception e) {
			System.out.printf("Exception in retrieveMessage " + e.getMessage(), e);
			throw new Exception();
		}
		return msg;
	}
}
