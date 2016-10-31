/**
 * 
 */
package com.wrap.dao;

import com.wrap.modal.WrapUserCard;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 *
 * @author ashu
 * @created Oct 19, 2016
 * @version $Revision$
 */
public interface WrapUserCardDao {
	
	boolean saveUserCardInfo(WrapUserCard argWrapUserCard);
	WrapUserCard getUserCardInfo(String argUserName);

}
