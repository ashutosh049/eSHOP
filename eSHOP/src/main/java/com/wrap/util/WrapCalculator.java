package com.wrap.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wrap.modal.WrapCart;
import com.wrap.modal.WrapCartItem;

/**
 * Helper class to perform cart operation like add items to cart, remove ,
 * update item count<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 * 
 * @author ashu
 * @created Oct 15, 2016
 * @version $Revision$
 */
public class WrapCalculator implements IWrapCalculator {
	
	@Autowired
	WrapUtil wrapUtil;

	@Override
	public WrapCart updateWrapCartItem(WrapCart argWrapCart,
			WrapCartItem argWrapCartItem,  int argCount) {

	 List<WrapCartItem> wrapCartItemlList = argWrapCart
				.getWrapCartItemlList();
		boolean itemExists = false;

		if (argWrapCart != null && wrapCartItemlList!=null && wrapCartItemlList.size()>=1 && argWrapCartItem !=null) {
			for (WrapCartItem wrapCartItem : wrapCartItemlList) {
				if (wrapCartItem.compareTo(argWrapCartItem) == 1) {
					itemExists = true;
					if (argCount > 0) {
						wrapCartItem
						.setItemCount(wrapCartItem.getItemCount() + argCount);
					}
					wrapCartItem = updateWrapCartItemVaribles(wrapCartItem);
					break;
				}
			}
		}

		if (!itemExists) {
			argWrapCartItem = updateWrapCartItemVaribles(argWrapCartItem);
			if(wrapCartItemlList==null){
				wrapCartItemlList = new ArrayList<WrapCartItem>();
			}
			wrapCartItemlList.add((WrapCartItem) wrapUtil.roundObjectVariables(argWrapCartItem));
		}
		argWrapCart.setWrapCartItemlList(wrapCartItemlList);
		argWrapCart = updateWrapCartVaribles(argWrapCart);
		
		return (WrapCart) wrapUtil.roundObjectVariables(argWrapCart);
	}

	@Override
	public WrapCart removeWrapCartItem( WrapCart argWrapCart,
			 WrapCartItem argWrapCartItem,  int argCount) {
		if (argWrapCart != null) {
			 List<WrapCartItem> wrapCartItemlList = argWrapCart
					.getWrapCartItemlList();
			for ( WrapCartItem wrapCartItem : wrapCartItemlList) {
				if (wrapCartItem.compareTo(argWrapCartItem) == 1) {
					if (wrapCartItemlList.remove(wrapCartItem)) {
						return updateWrapCartVaribles(argWrapCart);
					}
					break;
				}
			}
		}
		return argWrapCart;
	}

	private WrapCart updateWrapCartVaribles( WrapCart argWrapCart) {
		if (argWrapCart != null) {

			 List<WrapCartItem> wrapCartItemlList = argWrapCart
					.getWrapCartItemlList();

			double cartSubToal = 0;
			double cartShippingTotal = 0;
			double cartTaxTotal = 0;
			double cartDiscountTotal = 0;
			double cartPayable = 0;

			for ( WrapCartItem wrapCartItem : wrapCartItemlList) {
				cartSubToal += wrapCartItem.getItemSubToal();
				cartDiscountTotal += wrapCartItem.getItemDiscountTotal();
				cartShippingTotal += wrapCartItem.getItemShippingTotal();
				cartTaxTotal += wrapCartItem.getItemTaxTotal();
			}

			cartPayable = cartSubToal + cartShippingTotal + cartTaxTotal;
			cartPayable = cartPayable - cartDiscountTotal;

			argWrapCart.setWrapCartSubToal(cartSubToal);
			argWrapCart.setWrapCartDiscountTotal(cartDiscountTotal);
			argWrapCart.setWrapCartShippingTotal(cartShippingTotal);
			argWrapCart.setWrapCartTaxTotal(cartTaxTotal);
			argWrapCart.setWrapCartPayable(cartPayable);

		}
		return (WrapCart) wrapUtil.roundObjectVariables(argWrapCart);
	}


	private WrapCartItem updateWrapCartItemVaribles(
			 WrapCartItem argWrapCartItem) {

		 int itemCount = argWrapCartItem.getItemCount();
		 double itemSubToal = argWrapCartItem.getItemSubToal() * itemCount;
		 double itemDiscountTotal = (argWrapCartItem.getItemDiscountTotal()*itemCount);
		 double itemTaxTotal = (argWrapCartItem.getItemTaxTotal()*itemCount);
		 double itemShippingTotal = (argWrapCartItem.getItemShippingTotal()*itemCount);

		argWrapCartItem.setItemSubToal(itemSubToal);
		argWrapCartItem.setItemDiscountTotal(itemDiscountTotal);
		argWrapCartItem.setItemTaxTotal(itemTaxTotal);
		argWrapCartItem.setItemShippingTotal(itemShippingTotal);
//		return argWrapCartItem;
		return (WrapCartItem) wrapUtil.roundObjectVariables(argWrapCartItem);
	}

	

}
