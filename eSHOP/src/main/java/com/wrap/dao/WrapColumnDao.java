/**
 * 
 */
package com.wrap.dao;

import java.util.List;

import com.wrap.modal.WrapColumn;

/**
 * @author ashu
 *
 */
public interface WrapColumnDao {

	List<WrapColumn> getWrapColumnListByTabId(String argTabID);
	
}
