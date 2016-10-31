/**
 * 
 */
package com.wrap.modal;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 *
 * @author ashu
 * @created Oct 15, 2016
 * @version $Revision$
 */
@Service
@Scope("session")
public class WrapCart {
	private double wrapCartSubToal;
	private double wrapCartShippingTotal;
	private double wrapCartTaxTotal;
	private double wrapCartDiscountTotal;
	private double wrapCartPayable;
	private List<WrapCartItem> wrapCartItemlList;

	/**
	 * 
	 */
	public WrapCart() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the wrapCartSubToal
	 */
	public double getWrapCartSubToal() {
		return wrapCartSubToal;
	}

	/**
	 * @param wrapCartSubToal
	 *            the wrapCartSubToal to set
	 */
	public void setWrapCartSubToal(final double wrapCartSubToal) {
		this.wrapCartSubToal = wrapCartSubToal;
	}

	/**
	 * @return the wrapCartShippingTotal
	 */
	public double getWrapCartShippingTotal() {
		return wrapCartShippingTotal;
	}

	/**
	 * @param wrapCartShippingTotal
	 *            the wrapCartShippingTotal to set
	 */
	public void setWrapCartShippingTotal(final double wrapCartShippingTotal) {
		this.wrapCartShippingTotal = wrapCartShippingTotal;
	}

	/**
	 * @return the wrapCartTaxTotal
	 */
	public double getWrapCartTaxTotal() {
		return wrapCartTaxTotal;
	}

	/**
	 * @param wrapCartTaxTotal
	 *            the wrapCartTaxTotal to set
	 */
	public void setWrapCartTaxTotal(final double wrapCartTaxTotal) {
		this.wrapCartTaxTotal = wrapCartTaxTotal;
	}

	/**
	 * @return the wrapCartDiscountTotal
	 */
	public double getWrapCartDiscountTotal() {
		return wrapCartDiscountTotal;
	}

	/**
	 * @param wrapCartDiscountTotal
	 *            the wrapCartDiscountTotal to set
	 */
	public void setWrapCartDiscountTotal(final double wrapCartDiscountTotal) {
		this.wrapCartDiscountTotal = wrapCartDiscountTotal;
	}

	/**
	 * @return the wrapCartPayable
	 */
	public double getWrapCartPayable() {
		return wrapCartPayable;
	}

	/**
	 * @param wrapCartPayable
	 *            the wrapCartPayable to set
	 */
	public void setWrapCartPayable(final double wrapCartPayable) {
		this.wrapCartPayable = wrapCartPayable;
	}

	/**
	 * @return the wrapCartItemlList
	 */
	public List<WrapCartItem> getWrapCartItemlList() {
		return wrapCartItemlList;
	}

	/**
	 * @param wrapCartItemlList
	 *            the wrapCartItemlList to set
	 */
	public void setWrapCartItemlList(final List<WrapCartItem> wrapCartItemlList) {
		this.wrapCartItemlList = wrapCartItemlList;
	}

}
