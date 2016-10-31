/**
 * 
 */
package com.wrap.modal;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 * 
 * @author ashu
 * @created Oct 19, 2016
 * @version $Revision$
 */
@Service
@Scope("session")
public class WrapOrder {

	private WrapUser wrapUser;
	private WrapUserAddress wrapUserAddress;
	private WrapUserCard wrapUserCard;
	private WrapCart wrapCart;
	private String orderUserId;
	private String orderAddressId;
	private String orderCardId;
	private String orderId;
	private Date orderDate;
	private double orderTotal;
	private String orderStatus;

	/**
	 * @return the wrapUser
	 */
	public WrapUser getWrapUser() {
		return wrapUser;
	}

	/**
	 * @param wrapUser
	 *            the wrapUser to set
	 */
	public void setWrapUser(WrapUser wrapUser) {
		this.wrapUser = wrapUser;
	}

	/**
	 * @return the wrapUserAddress
	 */
	public WrapUserAddress getWrapUserAddress() {
		return wrapUserAddress;
	}

	/**
	 * @param wrapUserAddress
	 *            the wrapUserAddress to set
	 */
	public void setWrapUserAddress(WrapUserAddress wrapUserAddress) {
		this.wrapUserAddress = wrapUserAddress;
	}

	/**
	 * @return the wrapUserCard
	 */
	public WrapUserCard getWrapUserCard() {
		return wrapUserCard;
	}

	/**
	 * @param wrapUserCard
	 *            the wrapUserCard to set
	 */
	public void setWrapUserCard(WrapUserCard wrapUserCard) {
		this.wrapUserCard = wrapUserCard;
	}

	/**
	 * @return the orderUserId
	 */
	public String getOrderUserId() {
		return orderUserId;
	}

	/**
	 * @param orderUserId
	 *            the orderUserId to set
	 */
	public void setOrderUserId(String orderUserId) {
		this.orderUserId = orderUserId;
	}

	/**
	 * @return the orderAddressId
	 */
	public String getOrderAddressId() {
		return orderAddressId;
	}

	/**
	 * @param orderAddressId
	 *            the orderAddressId to set
	 */
	public void setOrderAddressId(String orderAddressId) {
		this.orderAddressId = orderAddressId;
	}

	/**
	 * @return the orderCardId
	 */
	public String getOrderCardId() {
		return orderCardId;
	}

	/**
	 * @param orderCardId
	 *            the orderCardId to set
	 */
	public void setOrderCardId(String orderCardId) {
		this.orderCardId = orderCardId;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate
	 *            the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the orderTotal
	 */
	public double getOrderTotal() {
		return orderTotal;
	}

	/**
	 * @param orderTotal
	 *            the orderTotal to set
	 */
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus
	 *            the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the wrapCart
	 */
	public WrapCart getWrapCart() {
		return wrapCart;
	}

	/**
	 * @param wrapCart
	 *            the wrapCart to set
	 */
	public void setWrapCart(WrapCart wrapCart) {
		this.wrapCart = wrapCart;
	}

	/**
	 * 
	 */
	public WrapOrder() {
		// TODO Auto-generated constructor stub
	}
}
