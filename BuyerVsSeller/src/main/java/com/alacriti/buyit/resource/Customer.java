package com.alacriti.buyit.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import com.alacriti.buyit.delegate.CustomerDelegate;
import com.alacriti.buyit.util.SessionUtil;
import com.alacriti.buyit.vo.ConformationVO;
import com.alacriti.buyit.vo.LoginConformationVO;
import com.alacriti.buyit.vo.LoginVO;
import com.alacriti.buyit.vo.RegisterVO;

@XmlRootElement
@Path("/customer")
public class Customer {

	private static final Logger log = Logger.getLogger(Customer.class);

	@POST
	@Path("registration")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCustomer(RegisterVO userRoleVO) {
		log.debug("entered in Resources getRegistered:");
		CustomerDelegate customerDelegate = new CustomerDelegate();
		customerDelegate.addCustomer(userRoleVO);
		return Response.status(200).entity(userRoleVO).build();

	}

	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LoginConformationVO customerLogin(LoginVO userRoleVO,
			@Context HttpServletRequest request) {
		log.debug("entered in Resources login:");
		CustomerDelegate customerDelegate = new CustomerDelegate();
		LoginConformationVO conformation;
		conformation = customerDelegate.customerLogin(userRoleVO);
		if (conformation.getCheck()) {

			System.out.println("creating session for login");
			HttpSession session = request.getSession();
			session.setAttribute("customerId", conformation.getCustId());
			session.setAttribute("customerName", conformation.getCustName());
			System.out.println("this how session looks like :" + session);
			System.out.println("created session for login");

		}
		return conformation;
	}

	// return Response.status(200).entity(userRoleVO).build();

	@GET
	@Path("checkSession")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean checkSessoin(@Context HttpServletRequest request) {
		SessionUtil sessionUtil = new SessionUtil();
		// HttpSession session= request.getSession(false);
		// System.out.println("session in checkSession :"+session.getId());
		return sessionUtil.checkForSession(request);
	}

	@GET
	@Path("logout")
	@Produces(MediaType.TEXT_PLAIN)
	public ConformationVO destroySessoin(@Context HttpServletRequest request) {
		request.getSession().invalidate();
		System.out.println("in destroy session resource : ============>>>>>"
				+ request.getSession(false));
		ConformationVO conformationVO=new ConformationVO();
		if (request.getSession(false) != null) {
			conformationVO.setFlag(true);
			return conformationVO;
		} else
			conformationVO.setFlag(false);

			return conformationVO;
	}

}
