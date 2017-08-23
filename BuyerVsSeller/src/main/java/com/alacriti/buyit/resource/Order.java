package com.alacriti.buyit.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.alacriti.buyit.delegate.OrderDelegate;
import com.alacriti.buyit.util.SessionUtil;
import com.alacriti.buyit.vo.ConformationVO;
import com.alacriti.buyit.vo.OrdersVO;

@Path("/order")

public class Order {
	private static final Logger log = Logger.getLogger(Order.class);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response placeOrders(OrdersVO orderVO,
			@Context HttpServletRequest request) {
		log.debug("making order for product:");
		int id = 0;
		OrderDelegate orderDelegate;
		HttpSession session = request.getSession(false);
		ConformationVO conformationVO=null;
		if (session != null) {
			id = (Integer) session.getAttribute("customerId");
			orderVO.setCustomerId(id);

			orderDelegate = new OrderDelegate();
			conformationVO =new ConformationVO();
			System.out.println(orderVO.getCity());
			System.out.println(orderVO.getCountry());

			conformationVO.setFlag(orderDelegate.placeOrder(orderVO));
			//return conformationVO;
			 return Response.status(200).entity(conformationVO).build();
		}
		conformationVO.setFlag(false);
		
		 return Response.status(200).entity(conformationVO).build();

	}

	/*
	 * @GET
	 * 
	 * @Path("/{customerId}/{productId}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 *  //public boolean
	 * getValidBuyer(@PathParam("customerId,productId,orderStatus") OrdersVO
	 * ordersVO) {
	 *  public boolean getValidBuyer(@PathParam("customerId") int
	 * custId,@PathParam("productId") int productId, @PathParam("orderStatus")
	 * String orderStatus) {
	 * 
	 * 
	 * log.debug("validating buyer:");
	 *  OrdersVO ordVo = new OrdersVO();
	 * ordVo.setCustomerId(custId); 
	 * ordVo.setProductId(productId);
	 * ordVo.setOrderStatus(orderStatus); 
	 * log.debug(ordVo.getOrderStatus());
	 * OrderDelegate orderDelegate= new OrderDelegate(); 
	 * return orderDelegate.getValidBuyer(ordVo);
	 * 
	 * // return Response.status(200).entity(userRoleVO).build();
	 * 
	 * }
	 */
	

}
