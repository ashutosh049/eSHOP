/**
 * 
 */
package com.wrap.modal;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 *
 * @author ashu
 * @created Oct 15, 2016
 * @version $Revision$
 */
public class WrapColumn extends WrapTab {

	private String wrapTabId;
	private String wrapColId;
	private String wrapColName;
	private int wrapColSortOrder;
	
	public WrapColumn() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the wrapColId
	 */
	public String getWrapColId() {
		return wrapColId;
	}
	/**
	 * @param wrapColId the wrapColId to set
	 */
	public void setWrapColId(String wrapColId) {
		this.wrapColId = wrapColId;
	}
	/**
	 * @return the wrapColName
	 */
	public String getWrapColName() {
		return wrapColName;
	}
	/**
	 * @param wrapColName the wrapColName to set
	 */
	public void setWrapColName(String wrapColName) {
		this.wrapColName = wrapColName;
	}
	/**
	 * @return the wrapColSortOrder
	 */
	public int getWrapColSortOrder() {
		return wrapColSortOrder;
	}
	/**
	 * @param wrapColSortOrder the wrapColSortOrder to set
	 */
	public void setWrapColSortOrder(int wrapColSortOrder) {
		this.wrapColSortOrder = wrapColSortOrder;
	}

	/**
	 * @return the wrapTabId
	 */
	public String getWrapTabId() {
		return wrapTabId;
	}

	/**
	 * @param wrapTabId the wrapTabId to set
	 */
	public void setWrapTabId(String wrapTabId) {
		this.wrapTabId = wrapTabId;
	}
	
	

}
