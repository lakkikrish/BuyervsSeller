package com.alacriti.buyit.bo.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.buyit.dao.impl.ProductDAO;
import com.alacriti.buyit.delegate.CustomerDelegate;
import com.alacriti.buyit.vo.ProductVO;

public class ProductBO extends BaseBO{
	private static final Logger log = Logger.getLogger(ProductBO.class);

	public ProductBO(Connection connection) {
		super(connection);
	}

	public List getCategories() throws SQLException, Exception {
		log.debug("In ProductBO ****** getCategories ");
		try {
			ProductDAO productDAO = new ProductDAO(getConnection());
			return productDAO.getCategories();

		} catch (Exception e) {
			log.error("Exception in retrieveMessage " + e.getMessage(),
					e);
			throw e;
		}
	}

	public List getParticularProductDetails(ProductVO productVO)
			throws SQLException, Exception {
		log.debug("In ProductBO ****** getParticularProductDetails ");	
		List list = null;
		ProductDAO productDAO;
		try {
			productDAO = new ProductDAO(getConnection());
			list = productDAO.getParticularProductDetails(productVO);
		} catch (Exception e) {
			log.error("Exception in retrieveMessage " + e.getMessage(),
					e);
			throw e;
		}
		log.debug("last line of getProductDetails in BO");
		return list;
	}

	public List getProductsOfCategory(ProductVO productVO) throws SQLException,
			Exception {
		log.debug("In ProductBO ****** getProductsOfCategory ");
		List list = null;
		try {
			ProductDAO productDAO = new ProductDAO(getConnection());
			list = productDAO.getProductsOfCategory(productVO);

		} catch (Exception e) {
			log.error("Exception in retrieveMessage " + e.getMessage(),
					e);
			throw e;
		}
		log.debug("last line of getProductDetails in BO");
		return list;
	}

	public List getSearchProduct(ProductVO productVO) throws SQLException,
			Exception {
		log.debug("In ProductBO ****** getSearchProduct ");
		List list = null;
		try {
			ProductDAO productDAO = new ProductDAO(getConnection());
			list = productDAO.getSearchProduct(productVO);

		} catch (Exception e) {
			log.error("Exception in retrieveMessage " + e.getMessage(),
					e);
			throw e;
		}
		log.debug("last line of getProductDetails in BO");
		return list;
	}

}
