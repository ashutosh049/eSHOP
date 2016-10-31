/**
 * 
 */
package com.wrap.modal;

import com.wrap.imodal.WrapProductColor;
import com.wrap.imodal.WrapProductSize;

import java.util.List;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 *
 * @author ashu
 * @created Oct 15, 2016
 * @version $Revision$
 */
public class WrapCategory{

	private String wrapTabId;
	private String wrapColId;
	private String wrapCatId;
	private String wrapCatName;
	private List<WrapProductSize> wrapCatSizeList;
	private List<WrapProductColor> wrapCatColorList;
	private int wrapCatSortOrder;
	
	public WrapCategory() {
		// TODO Auto-generated constructor stub
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
	 * @return the wrapCatId
	 */
	public String getWrapCatId() {
		return wrapCatId;
	}

	/**
	 * @param wrapCatId the wrapCatId to set
	 */
	public void setWrapCatId(String wrapCatId) {
		this.wrapCatId = wrapCatId;
	}

	/**
	 * @return the wrapCatName
	 */
	public String getWrapCatName() {
		return wrapCatName;
	}

	/**
	 * @param wrapCatName the wrapCatName to set
	 */
	public void setWrapCatName(String wrapCatName) {
		this.wrapCatName = wrapCatName;
	}

	/**
	 * @return the wrapCatSizeList
	 */
	public List<WrapProductSize> getWrapCatSizeList() {
		return wrapCatSizeList;
	}

	/**
	 * @param wrapCatSizeList the wrapCatSizeList to set
	 */
	public void setWrapCatSizeList(List<WrapProductSize> wrapCatSizeList) {
		this.wrapCatSizeList = wrapCatSizeList;
	}

	/**
	 * @return the wrapCatColorList
	 */
	public List<WrapProductColor> getWrapCatColorList() {
		return wrapCatColorList;
	}

	/**
	 * @param wrapCatColorList the wrapCatColorList to set
	 */
	public void setWrapCatColorList(List<WrapProductColor> wrapCatColorList) {
		this.wrapCatColorList = wrapCatColorList;
	}

	/**
	 * @return the wrapCatSortOrder
	 */
	public int getWrapCatSortOrder() {
		return wrapCatSortOrder;
	}

	/**
	 * @param wrapCatSortOrder the wrapCatSortOrder to set
	 */
	public void setWrapCatSortOrder(int wrapCatSortOrder) {
		this.wrapCatSortOrder = wrapCatSortOrder;
	}

	
	
}
