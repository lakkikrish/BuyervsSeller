package com.alacriti.buyit.bo.impl;

import java.sql.Connection;

import org.apache.log4j.Logger;


public class BaseBO {
	private static final Logger log = Logger.getLogger(BaseBO.class);

	private Connection connection = null;

	public BaseBO() {
	}

	public BaseBO(Connection connection) {
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
