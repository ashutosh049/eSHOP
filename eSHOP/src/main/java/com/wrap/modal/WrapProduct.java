/**
 * 
 */
package com.wrap.modal;

import com.wrap.imodal.WrapProductColor;
import com.wrap.imodal.WrapProductSize;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 * 
 * @author ashu
 * @created Oct 15, 2016
 * @version $Revision$
 */
public class WrapProduct{

	private String wrapTabId;
	private String wrapColId;
	private String wrapCatId;
	private String wrapProdId;
	private String wrapProdName;
	private String wrapProdDescription;
	private int wrapProdInStockItemsCount;
	private boolean wrapProdIsInStock;
	private double wrapProdMarkedPrice;
	private double wrapProdDiscountedPrice;
	private double wrapProdDiscountPercent;
	private double wrapProdTaxPercent;
	private double wrapProdShippingChargePercent;
	private WrapProductSize wrapProdSize;
	private WrapProductColor wrapProdColor;
	private String wrapProdImagePath;
	private int wrapProdSortOrder;

	public WrapProduct() {
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
	 * @return the wrapColId
	 */
	public String getWrapColId() {
		return wrapColId;
	}

	/**
	 * @param wrapColId
	 *            the wrapColId to set
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
	 * @param wrapCatId
	 *            the wrapCatId to set
	 */
	public void setWrapCatId(String wrapCatId) {
		this.wrapCatId = wrapCatId;
	}

	/**
	 * @return the wrapProdId
	 */
	public String getWrapProdId() {
		return wrapProdId;
	}

	/**
	 * @param wrapProdId
	 *            the wrapProdId to set
	 */
	public void setWrapProdId(String wrapProdId) {
		this.wrapProdId = wrapProdId;
	}

	/**
	 * @return the wrapProdName
	 */
	public String getWrapProdName() {
		return wrapProdName;
	}

	/**
	 * @param wrapProdName
	 *            the wrapProdName to set
	 */
	public void setWrapProdName(String wrapProdName) {
		this.wrapProdName = wrapProdName;
	}

	/**
	 * @return the wrapProdDescription
	 */
	public String getWrapProdDescription() {
		return wrapProdDescription;
	}

	/**
	 * @param wrapProdDescription
	 *            the wrapProdDescription to set
	 */
	public void setWrapProdDescription(String wrapProdDescription) {
		this.wrapProdDescription = wrapProdDescription;
	}

	/**
	 * @return the wrapProdInStockItemsCount
	 */
	public int getWrapProdInStockItemsCount() {
		return wrapProdInStockItemsCount;
	}

	/**
	 * @param wrapProdInStockItemsCount
	 *            the wrapProdInStockItemsCount to set
	 */
	public void setWrapProdInStockItemsCount(int wrapProdInStockItemsCount) {
		this.wrapProdInStockItemsCount = wrapProdInStockItemsCount;
	}

	/**
	 * @return the wrapProdIsInStock
	 */
	public boolean isWrapProdIsInStock() {
		return wrapProdIsInStock;
	}

	/**
	 * @param wrapProdIsInStock
	 *            the wrapProdIsInStock to set
	 */
	public void setWrapProdIsInStock(boolean wrapProdIsInStock) {
		this.wrapProdIsInStock = wrapProdIsInStock;
	}

	/**
	 * @return the wrapProdMarkedPrice
	 */
	public double getWrapProdMarkedPrice() {
		return wrapProdMarkedPrice;
	}

	/**
	 * @param wrapProdMarkedPrice
	 *            the wrapProdMarkedPrice to set
	 */
	public void setWrapProdMarkedPrice(double wrapProdMarkedPrice) {
		this.wrapProdMarkedPrice = wrapProdMarkedPrice;
	}

	/**
	 * @return the wrapProdDiscountPercent
	 */
	public double getWrapProdDiscountPercent() {
		return wrapProdDiscountPercent;
	}

	/**
	 * @param wrapProdDiscountPercent
	 *            the wrapProdDiscountPercent to set
	 */
	public void setWrapProdDiscountPercent(double wrapProdDiscountPercent) {
		this.wrapProdDiscountPercent = wrapProdDiscountPercent;
	}

	/**
	 * @return the wrapProdTaxPercent
	 */
	public double getWrapProdTaxPercent() {
		return wrapProdTaxPercent;
	}

	/**
	 * @param wrapProdTaxPercent
	 *            the wrapProdTaxPercent to set
	 */
	public void setWrapProdTaxPercent(double wrapProdTaxPercent) {
		this.wrapProdTaxPercent = wrapProdTaxPercent;
	}

	/**
	 * @return the wrapProdShippingChargePercent
	 */
	public double getWrapProdShippingChargePercent() {
		return wrapProdShippingChargePercent;
	}

	/**
	 * @param wrapProdShippingChargePercent
	 *            the wrapProdShippingChargePercent to set
	 */
	public void setWrapProdShippingChargePercent(
			double wrapProdShippingChargePercent) {
		this.wrapProdShippingChargePercent = wrapProdShippingChargePercent;
	}

	/**
	 * @return the wrapProdSize
	 */
	public WrapProductSize getWrapProdSize() {
		return wrapProdSize;
	}

	/**
	 * @param wrapProdSize
	 *            the wrapProdSize to set
	 */
	public void setWrapProdSize(WrapProductSize wrapProdSize) {
		this.wrapProdSize = wrapProdSize;
	}

	/**
	 * @return the wrapProdColor
	 */
	public WrapProductColor getWrapProdColor() {
		return wrapProdColor;
	}

	/**
	 * @param wrapProdColor
	 *            the wrapProdColor to set
	 */
	public void setWrapProdColor(WrapProductColor wrapProdColor) {
		this.wrapProdColor = wrapProdColor;
	}

	/**
	 * @return the wrapProdImagePath
	 */
	public String getWrapProdImagePath() {
		return wrapProdImagePath;
	}

	/**
	 * @param wrapProdImagePath
	 *            the wrapProdImagePath to set
	 */
	public void setWrapProdImagePath(String wrapProdImagePath) {
		this.wrapProdImagePath = wrapProdImagePath;
	}

	/**
	 * @return the wrapProdSortOrder
	 */
	public int getWrapProdSortOrder() {
		return wrapProdSortOrder;
	}

	/**
	 * @param wrapProdSortOrder
	 *            the wrapProdSortOrder to set
	 */
	public void setWrapProdSortOrder(int wrapProdSortOrder) {
		this.wrapProdSortOrder = wrapProdSortOrder;
	}

	/**
	 * @return the wrapProdDiscountedPrice
	 */
	public double getWrapProdDiscountedPrice() {
		return wrapProdDiscountedPrice;
	}

	/**
	 * @param wrapProdDiscountedPrice the wrapProdDiscountedPrice to set
	 */
	public void setWrapProdDiscountedPrice(double wrapProdDiscountedPrice) {
		this.wrapProdDiscountedPrice = wrapProdDiscountedPrice;
	}
	
	

}
