package com.alacriti.buyervsseller.util;

import java.sql.Connection;

public class ClosingConnection {
	public static void closeConnection(Connection conn, boolean isError) {
		System.out.println("ClosingConnection closeConnection: isError " + isError
				);

		if (conn != null) {
			if (isError) {
				try {
					System.out.println("Rollback");
					conn.rollback();
				} catch (Exception e) {
					System.out
							.println("Exception occured while rollback the connectio n: "
									+ e);
				}
			} else {
				try {
					System.out.println("Comit");

					conn.commit();
				} catch (Exception e) {
					System.out
							.println("Exception occured while commit the connectio n: "
									+ e);
				}
			}
			
			
			try {
				conn.close();
			} catch (Exception e) {
				System.out
						.println("Exception occured while close the connectio n: "
								+ e);
			}
		} else {
			System.out.println("Connection is null, Skipping the close part");
		}

	}

}
