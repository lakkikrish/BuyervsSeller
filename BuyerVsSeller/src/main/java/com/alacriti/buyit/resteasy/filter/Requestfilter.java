package com.alacriti.buyit.resteasy.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ServerResponse;

@Provider
public class Requestfilter implements ContainerRequestFilter {
	@Context
	HttpServletRequest request;
	private static final Logger log = Logger.getLogger(Requestfilter.class);
	private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse(
			"Nobody can access this resource", 403, new Headers<Object>());;

	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		try {
			if (request.getRequestURI().contains("order")) {
				HttpSession session = request.getSession(false);
				if (session == null) {
					// abort the request with 403 status
					requestContext.abortWith(ACCESS_FORBIDDEN);
				}
			}
			log.debug("after servlet request");
		} catch (ClassCastException C) {
			log.error("this is filter error" + C);
		}

	}
}
