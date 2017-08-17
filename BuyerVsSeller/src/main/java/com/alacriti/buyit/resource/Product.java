package com.alacriti.buyit.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.buyit.delegate.ProductDelegate;
import com.alacriti.buyit.vo.ProductVO;
@Path("/")
public class Product {
	
	private static final Logger log = Logger.getLogger(Product.class);

	@GET
	@Path("category")
	@Produces(MediaType.APPLICATION_JSON)
	public List getCategories() {
		if (log.isDebugEnabled())
			log.debug("start getCategories()");

		ProductDelegate productDelegate = new ProductDelegate();
		
		log.debug("end getCategories()");

		return productDelegate.getCategories();
	}

	@GET
	@Path("category/{categoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List getProductDetails(@PathParam("categoryId") int categoryId) {
		log.debug("get product details of a category:");
		ProductDelegate productDelegate = new ProductDelegate();
		ProductVO productVO = new ProductVO();
		productVO.setProductId(categoryId);
		return productDelegate.getProductsOfCategory(productVO);

	}

	@GET
	@Path("category/{categoryId}/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List getProductDetails(@PathParam("categoryId") int categoryId,
			@PathParam("productId") int productId) {
		log.debug("THE PRODUCT DETAILS:");
		ProductDelegate productDelegate = new ProductDelegate();
		ProductVO productVO = new ProductVO();
		productVO.setProductId(productId);
		return productDelegate.getParticularProductDetails(productVO);

	}

	@GET
	@Path("/{productName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List getSearchProduct(@PathParam("productName") String productName) {
		log.debug("THE PRODUCT DETAILS:while search");
		ProductDelegate productDelegate = new ProductDelegate();
		ProductVO productVO = new ProductVO();
		productVO.setProductName(productName);
		return productDelegate.getSearchProduct(productVO);

	}

}
