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
public class WrapCartItem implements Comparable<WrapCartItem> {

	private String itemTabId;
	private String itemColId;
	private String itemCatId;
	private String itemId;
	private String itemName;
	private String itemDescription;
	private WrapProductSize itemSize;
	private WrapProductColor itemColor;
	private String itemImagePath;
	private int itemCount;
	private double itemMarkedPrice;
	private double itemDiscountTotal;
	private double itemTaxTotal;
	private double itemShippingTotal;
	private double itemSubToal;

	/**
	 * 
	 */
	public WrapCartItem() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the itemTabId
	 */
	public String getItemTabId() {
		return itemTabId;
	}

	/**
	 * @param itemTabId
	 *            the itemTabId to set
	 */
	public void setItemTabId(final String itemTabId) {
		this.itemTabId = itemTabId;
	}

	/**
	 * @return the itemColId
	 */
	public String getItemColId() {
		return itemColId;
	}

	/**
	 * @param itemColId
	 *            the itemColId to set
	 */
	public void setItemColId(final String itemColId) {
		this.itemColId = itemColId;
	}

	/**
	 * @return the itemCatId
	 */
	public String getItemCatId() {
		return itemCatId;
	}

	/**
	 * @param itemCatId
	 *            the itemCatId to set
	 */
	public void setItemCatId(final String itemCatId) {
		this.itemCatId = itemCatId;
	}

	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}


	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(final String itemId) {
		this.itemId = itemId;
	}


	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}


	/**
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(final String itemName) {
		this.itemName = itemName;
	}


	/**
	 * @return the itemDescription
	 */
	public String getItemDescription() {
		return itemDescription;
	}


	/**
	 * @param itemDescription
	 *            the itemDescription to set
	 */
	public void setItemDescription(final String itemDescription) {
		this.itemDescription = itemDescription;
	}


	/**
	 * @return the itemSize
	 */
	public WrapProductSize getItemSize() {
		return itemSize;
	}


	/**
	 * @param itemSize
	 *            the itemSize to set
	 */
	public void setItemSize(final WrapProductSize itemSize) {
		this.itemSize = itemSize;
	}


	/**
	 * @return the itemColor
	 */
	public WrapProductColor getItemColor() {
		return itemColor;
	}


	/**
	 * @param itemColor
	 *            the itemColor to set
	 */
	public void setItemColor(final WrapProductColor itemColor) {
		this.itemColor = itemColor;
	}


	/**
	 * @return the itemImagePath
	 */
	public String getItemImagePath() {
		return itemImagePath;
	}


	/**
	 * @param itemImagePath
	 *            the itemImagePath to set
	 */
	public void setItemImagePath(final String itemImagePath) {
		this.itemImagePath = itemImagePath;
	}


	/**
	 * @return the itemCount
	 */
	public int getItemCount() {
		return itemCount;
	}


	/**
	 * @param itemCount
	 *            the itemCount to set
	 */
	public void setItemCount(final int itemCount) {
		this.itemCount = itemCount;
	}


	/**
	 * @return the itemDiscountTotal
	 */
	public double getItemDiscountTotal() {
		return itemDiscountTotal;
	}


	/**
	 * @param itemDiscountTotal
	 *            the itemDiscountTotal to set
	 */
	public void setItemDiscountTotal(final double itemDiscountTotal) {
		this.itemDiscountTotal = itemDiscountTotal;
	}


	/**
	 * @return the itemTaxTotal
	 */
	public double getItemTaxTotal() {
		return itemTaxTotal;
	}


	/**
	 * @param itemTaxTotal
	 *            the itemTaxTotal to set
	 */
	public void setItemTaxTotal(final double itemTaxTotal) {
		this.itemTaxTotal = itemTaxTotal;
	}


	/**
	 * @return the itemShippingTotal
	 */
	public double getItemShippingTotal() {
		return itemShippingTotal;
	}


	/**
	 * @param itemShippingTotal
	 *            the itemShippingTotal to set
	 */
	public void setItemShippingTotal(final double itemShippingTotal) {
		this.itemShippingTotal = itemShippingTotal;
	}


	/**
	 * @return the itemSubToal
	 */
	public double getItemSubToal() {
		return itemSubToal;
	}


	/**
	 * @param itemSubToal
	 *            the itemSubToal to set
	 */
	public void setItemSubToal(final double itemSubToal) {
		this.itemSubToal = itemSubToal;
	}
	


	/**
	 * @return the itemMarkedPrice
	 */
	public double getItemMarkedPrice() {
		return itemMarkedPrice;
	}

	/**
	 * @param itemMarkedPrice the itemMarkedPrice to set
	 */
	public void setItemMarkedPrice(double itemMarkedPrice) {
		this.itemMarkedPrice = itemMarkedPrice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final WrapCartItem argWrapCartItem) {
		/*****
		 * private String itemId; private String itemName; private String
		 * itemDescription; private WrapProductSize itemSize; private
		 * WrapProductColor itemColor; private String itemImagePath; private int
		 * itemCount; private double itemDiscountTotal; private double
		 * itemTaxTotal; private double itemShippingTotal; private double
		 * itemSubToal;
		 * ***/

		if (itemTabId.equals(argWrapCartItem.itemTabId)) {
			if (itemColId.equals(argWrapCartItem.itemColId)) {
				if (itemCatId.equals(argWrapCartItem.itemCatId)) {
					if (itemId.equals(argWrapCartItem.itemId)) {
						return 1;
					}
				}
			}
		}

		return 0;
	}

}
