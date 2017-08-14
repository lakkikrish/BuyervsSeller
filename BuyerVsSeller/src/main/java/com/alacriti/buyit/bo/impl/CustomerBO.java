package com.alacriti.buyit.bo.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.alacriti.buyit.dao.impl.CustomerDAO;
import com.alacriti.buyit.vo.LoginConformationVO;
import com.alacriti.buyit.vo.LoginVO;
import com.alacriti.buyit.vo.RegisterVO;

public class CustomerBO extends BaseBO {
	public CustomerBO(Connection connection) {
		super(connection);
	}

	private static final Logger log = Logger.getLogger(CustomerBO.class);

	public LoginConformationVO customerLogin(LoginVO userVO) throws SQLException, Exception {
		log.debug("In CustomerBO ****** customerLogin ");
		try {
			CustomerDAO customerDAO = new CustomerDAO(getConnection());
			return customerDAO.customerLogin(userVO);

		} catch (Exception e) {
			log.error("Exception in retrieveMessage " + e.getMessage(), e);
			throw e;
		}
	}

	public boolean addCustomer(RegisterVO userVO) throws SQLException,
			Exception, AddressException, MessagingException {
		log.debug("In CustomerBO ****** addCustomer ");
		boolean registered = false;

		try {
			CustomerDAO customerDAO = new CustomerDAO(getConnection());
			registered = customerDAO.addCustomer(userVO);
			if (registered) {
				return sendMail(userVO.getEmail());
			}

		} catch (AddressException ae) {
			ae.printStackTrace();
			throw ae;
		} catch (MessagingException me) {
			me.printStackTrace();
			throw me;
		} catch (Exception e) {
			log.error("Exception in retrieveMessage " + e.getMessage(), e);
			throw e;
		}
		return false;
	}

	public boolean sendMail(String mailId) throws AddressException,
			MessagingException {
		String host = "localhost";
		final String user = "admin@buyit.com";// change accordingly

		String to = mailId;// change accordingly
		try {
			// Get the session object
			Properties props = new Properties();
			props.put("smtp.gmail.com", "localhost");
			props.put("mail.smtp.socketFactory.port", "25");

			Session mailSession = Session.getInstance(props);
			Message emailMessage = new MimeMessage(mailSession);
			emailMessage.setFrom(new InternetAddress(user));
			emailMessage.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to));
			emailMessage.setSubject("test subject");
			emailMessage.setContent("you are successfully registered.",
					"text/html");
			javax.mail.Transport.send(emailMessage);
			log.debug("Mail sent");
			return true;
		} catch (AddressException ae) {
			ae.printStackTrace();
			throw ae;
		} catch (MessagingException me) {
			me.printStackTrace();
			throw me;
		}

	}

}
