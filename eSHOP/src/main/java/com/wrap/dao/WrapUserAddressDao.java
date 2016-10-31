/**
 * 
 */
package com.wrap.dao;

import com.wrap.modal.WrapUserAddress;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 * 
 * @author ashu
 * @created Oct 19, 2016
 * @version $Revision$
 */
public interface WrapUserAddressDao {

	WrapUserAddress getWrapUserAddress(String argUserName);

	WrapUserAddress getWrapUserAddress(String argUserName, String argAddressId);

	boolean createWrapUserAddress(WrapUserAddress argWrapUserAddress);

	boolean updateWrapUserAddress(WrapUserAddress argWrapUserAddress);

}
