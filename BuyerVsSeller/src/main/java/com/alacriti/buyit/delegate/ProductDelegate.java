package com.alacriti.buyit.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.buyit.bo.impl.ProductBO;
import com.alacriti.buyit.vo.ProductVO;

public class ProductDelegate extends BaseDelegate {

	private static final Logger log = Logger.getLogger(OrderDelegate.class);

	public List getCategories() {
		log.debug("in Buyer delegate ****** getProducts");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			ProductBO productBO = new ProductBO(getConnection());
			return productBO.getCategories();
		} catch (Exception e) {
			log.error("Exception in getMessage " + e.getMessage(), e);
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return null;
	}

	public List getParticularProductDetails(ProductVO productVO) {
		log.debug("in Buyer delegate ****** getProductInfo");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			ProductBO productBO = new ProductBO(getConnection());
			return productBO.getParticularProductDetails(productVO);
		} catch (Exception e) {
			log.error("Exception in getMessage " + e.getMessage(), e);
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return null;
	}

	public List getProductsOfCategory(ProductVO productVO) {
		log.debug("in Buyer delegate ****** getProductsOfCategory");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			ProductBO productBO = new ProductBO(getConnection());
			return productBO.getProductsOfCategory(productVO);
		} catch (Exception e) {
			log.error("Exception in getMessage " + e.getMessage(), e);
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return null;
	}

	public List getSearchProduct(ProductVO productVO) {
		log.debug("in Buyer delegate ****** getSearch");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			ProductBO productBO = new ProductBO(getConnection());
			return productBO.getSearchProduct(productVO);
		} catch (Exception e) {
			log.error("Exception in getMessage " + e.getMessage(), e);
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return null;
	}
}
