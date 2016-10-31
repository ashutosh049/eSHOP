/**
 * 
 */
package com.wrap.util;

import com.wrap.modal.WrapCart;
import com.wrap.modal.WrapCartItem;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 * 
 * @author ashu
 * @created Oct 15, 2016
 * @version $Revision$
 */
public interface IWrapCalculator {

	public WrapCart updateWrapCartItem(WrapCart argWrapCart,
			final WrapCartItem argWrapCartItem, int argCount);

//	public WrapCart updateWrapCartVaribles(WrapCart argWrapCart);

	public WrapCart removeWrapCartItem(WrapCart argWrapCart,
			final WrapCartItem argWrapCartItem, int argCount);

//	public WrapCartItem updateWrapCartItemVaribles(WrapCartItem argWrapCartItem);
}
