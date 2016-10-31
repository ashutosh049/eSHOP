/**
 * 
 */
package com.wrap.modal;

/**
 * Top level hierarchy in wrap products.It may also be viewed as navigation bar<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 * 
 * @author ashu
 * @created Oct 15, 2016
 * @version $Revision$
 */
public class WrapTab {

	private String wrapTabId;
	private String wrapTabName;
	private int wrapTabSortOrder;

	public WrapTab() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the wrapTabId
	 */
	public String getWrapTabId() {
		return wrapTabId;
	}

	/**
	 * @param wrapTabId
	 *            the wrapTabId to set
	 */
	public void setWrapTabId(String wrapTabId) {
		this.wrapTabId = wrapTabId;
	}

	/**
	 * @return the wrapTabName
	 */
	public String getWrapTabName() {
		return wrapTabName;
	}

	/**
	 * @param wrapTabName
	 *            the wrapTabName to set
	 */
	public void setWrapTabName(String wrapTabName) {
		this.wrapTabName = wrapTabName;
	}

	/**
	 * @return the wrapTabSortOrder
	 */
	public int getWrapTabSortOrder() {
		return wrapTabSortOrder;
	}

	/**
	 * @param wrapTabSortOrder
	 *            the wrapTabSortOrder to set
	 */
	public void setWrapTabSortOrder(int wrapTabSortOrder) {
		this.wrapTabSortOrder = wrapTabSortOrder;
	}

}
