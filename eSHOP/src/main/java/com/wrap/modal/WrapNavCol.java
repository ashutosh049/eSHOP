/**
 * 
 */
package com.wrap.modal;

import java.util.List;

/**
 * @author ashu
 * 
 */
public class WrapNavCol {
	private WrapColumn wrapColumn;
	private List<WrapNavCat> wrapNavCatList;

	public WrapNavCol() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the wrapColumn
	 */
	public WrapColumn getWrapColumn() {
		return wrapColumn;
	}

	/**
	 * @param wrapColumn
	 *            the wrapColumn to set
	 */
	public void setWrapColumn(WrapColumn wrapColumn) {
		this.wrapColumn = wrapColumn;
	}

	/**
	 * @return the wrapNavCatList
	 */
	public List<WrapNavCat> getWrapNavCatList() {
		return wrapNavCatList;
	}

	/**
	 * @param wrapNavCatList
	 *            the wrapNavCatList to set
	 */
	public void setWrapNavCatList(List<WrapNavCat> wrapNavCatList) {
		this.wrapNavCatList = wrapNavCatList;
	}

}
