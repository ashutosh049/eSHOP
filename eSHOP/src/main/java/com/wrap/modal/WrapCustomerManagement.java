/**
 * 
 */
package com.wrap.modal;

import java.util.List;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 *
 * @author ashu
 * @created Oct 21, 2016
 * @version $Revision$
 */
public class WrapCustomerManagement {

	List<WrapCustomer> customerList;
	private int totalUserCount;
	private int activeUserCount;
	private int inactiveUserCount;

	/**
	 * 
	 */
	public WrapCustomerManagement() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the customerList
	 */
	public List<WrapCustomer> getCustomerList() {
		return customerList;
	}

	/**
	 * @param customerList the customerList to set
	 */
	public void setCustomerList(List<WrapCustomer> customerList) {
		this.customerList = customerList;
	}

	/**
	 * @return the totalUserCount
	 */
	public int getTotalUserCount() {
		return totalUserCount;
	}

	/**
	 * @param totalUserCount the totalUserCount to set
	 */
	public void setTotalUserCount(int totalUserCount) {
		this.totalUserCount = totalUserCount;
	}

	/**
	 * @return the activeUserCount
	 */
	public int getActiveUserCount() {
		return activeUserCount;
	}

	/**
	 * @param activeUserCount the activeUserCount to set
	 */
	public void setActiveUserCount(int activeUserCount) {
		this.activeUserCount = activeUserCount;
	}

	/**
	 * @return the inactiveUserCount
	 */
	public int getInactiveUserCount() {
		return inactiveUserCount;
	}

	/**
	 * @param inactiveUserCount the inactiveUserCount to set
	 */
	public void setInactiveUserCount(int inactiveUserCount) {
		this.inactiveUserCount = inactiveUserCount;
	}
	
	
}
