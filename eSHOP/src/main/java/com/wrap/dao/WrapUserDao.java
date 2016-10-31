/**
 * 
 */
package com.wrap.dao;

import java.util.List;

import com.wrap.modal.WrapCustomer;
import com.wrap.modal.WrapUser;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 *
 * @author ashu
 * @created Oct 19, 2016
 * @version $Revision$
 */
public interface WrapUserDao {

	WrapUser getWrapUserByUsername(String argUsername);
	List<WrapCustomer> getWrapCustomers();
	boolean createWrapUser(WrapUser argWrapUser);
	boolean updateWrapUserInfo(WrapUser argWrapUser);
}
