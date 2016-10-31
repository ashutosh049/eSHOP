/**
 * 
 */
package com.wrap.modal;

import java.util.List;

/**
 * @author ashu
 * 
 */
public class WrapNavTab {
	private WrapTab wrapTab;
	private List<WrapNavCol> wrapNavColList;
	private String image1Path;
	private String image2Path;
	
	public WrapNavTab() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the wrapTab
	 */
	public WrapTab getWrapTab() {
		return wrapTab;
	}

	/**
	 * @param wrapTab
	 *            the wrapTab to set
	 */
	public void setWrapTab(WrapTab wrapTab) {
		this.wrapTab = wrapTab;
	}

	/**
	 * @return the wrapNavColList
	 */
	public List<WrapNavCol> getWrapNavColList() {
		return wrapNavColList;
	}

	/**
	 * @param wrapNavColList
	 *            the wrapNavColList to set
	 */
	public void setWrapNavColList(List<WrapNavCol> wrapNavColList) {
		this.wrapNavColList = wrapNavColList;
	}

	/**
	 * @return the image1Path
	 */
	public String getImage1Path() {
		return image1Path;
	}

	/**
	 * @param image1Path the image1Path to set
	 */
	public void setImage1Path(String image1Path) {
		this.image1Path = image1Path;
	}

	/**
	 * @return the image2Path
	 */
	public String getImage2Path() {
		return image2Path;
	}

	/**
	 * @param image2Path the image2Path to set
	 */
	public void setImage2Path(String image2Path) {
		this.image2Path = image2Path;
	}
	

}
