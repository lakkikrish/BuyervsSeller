package com.alacriti.buyit.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.alacriti.buyit.resource.Customer;

public class SessionUtil {
	private static final Logger log = Logger.getLogger(Customer.class);

	public boolean checkForSession(HttpServletRequest request) {
		log.debug("checkForSession");
		HttpSession session = request.getSession(false);
		log.debug(" status of session:");
		log.debug(session);
		if (session == null)
			return false;
		else
			return true;
	}
}
