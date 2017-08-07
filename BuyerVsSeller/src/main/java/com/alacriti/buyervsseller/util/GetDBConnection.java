package com.alacriti.buyervsseller.util;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GetDBConnection {
public static Connection getConnection() throws Exception {
	System.out.println("GetDBConnection getConnection: ");

	DataSource ds = null;
	Connection conn = null;
	try {
		ds = (DataSource) new InitialContext()
				.lookup("java:jboss/datasources/TRAINEEE");
		conn = ds.getConnection();
		conn.setAutoCommit(false);

	} catch (Exception e) {
		System.out.println("Error while getting the connection :+e");

		throw e;
	}

	return conn;
}
}