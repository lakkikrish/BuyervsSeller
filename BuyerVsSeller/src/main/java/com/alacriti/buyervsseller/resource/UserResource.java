package com.alacriti.buyervsseller.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alacriti.buyervsseller.delegate.BuyerDelegate;
import com.alacriti.buyervsseller.vo.LoginVO;
import com.alacriti.buyervsseller.vo.OrdersVO;
import com.alacriti.buyervsseller.vo.ProductVO;
import com.alacriti.buyervsseller.vo.RegisterVO;


@Path("BuyervsSeller")
public class UserResource {
	//private static final AppLogger log = LogUtil.getLogger(UserResource.class);
	@POST
	@Path("Registration")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUserRole(RegisterVO userRoleVO) {
		//log.logDebug("userRoleVO.RoleName********"+userRoleVO.getRoleName());
		System.out.println("entered in Resources getRegistered:");
		BuyerDelegate buyerDelegate= new BuyerDelegate();
		buyerDelegate.createUserRole(userRoleVO);
		return Response.status(200).entity(userRoleVO).build();

	}
	@POST
	@Path("Login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean userLogin(LoginVO userRoleVO) {
		//log.logDebug("userRoleVO.RoleName********"+userRoleVO.getRoleName());
		System.out.println("entered in Resources login:");
		BuyerDelegate buyerDelegate= new BuyerDelegate();
		return buyerDelegate.getUserRole(userRoleVO);
//		return Response.status(200).entity(userRoleVO).build();

	}
	@GET
	@Path("Products")
	@Produces(MediaType.APPLICATION_JSON)
	public List getProducts(){
		System.out.println("get the productlist");
		System.out.println("getProducts: ");
		BuyerDelegate buyerDelegate= new BuyerDelegate();
		return buyerDelegate.getProducts();
	}
	@POST
	@Path("/{product}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List getProductDetails(@PathParam("product") ProductVO productVO) {
		System.out.println("search for products:");
		BuyerDelegate buyerDelegate= new BuyerDelegate();
		return buyerDelegate.getProductDetails(productVO);
//		return Response.status(200).entity(userRoleVO).build();

	}
	@POST
	@Path("search")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void placeOrders(OrdersVO orderVO) {
		System.out.println("making order for product:");
		BuyerDelegate buyerDelegate= new BuyerDelegate();
		 buyerDelegate.placeOrder(orderVO);
//		return Response.status(200).entity(userRoleVO).build();

	}
	/*
	@GET
	@Path("/getUserRole/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserRole(@PathParam("param") int RoleId) {
		UserRoleVO userVO= new UserRoleVO();
		userVO.setRoleTypeId(RoleId);
		//log.logDebug("Roleid***********"+userVO.getRoleTypeId());
		BuyerDelegate buyerDelegate= new BuyerDelegate();
		buyerDelegate.getUserRole(userVO);
		
		return Response.status(200).entity(userVO).build();

	}*/

}