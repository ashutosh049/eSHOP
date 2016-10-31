/**
 * 
 */
package com.wrap.dao;

import java.util.List;

import com.wrap.modal.WrapOrder;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 *
 * @author ashu
 * @created Oct 19, 2016
 * @version $Revision$
 */
public interface WrapOrderDao {

	List<WrapOrder> getWrapOrder(String orderUserId);
	boolean createWrapOrder(WrapOrder argWrapOrder);
	
}
