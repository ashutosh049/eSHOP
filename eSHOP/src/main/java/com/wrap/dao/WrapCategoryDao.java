package com.wrap.dao;

import java.util.List;

import com.wrap.modal.WrapCategory;

public interface WrapCategoryDao {

	List<WrapCategory> getWrapCategoriesByTabByColIds(String argTabId, String argColId);
	List<WrapCategory> getWrapCategoriesByTabByColIdsExceptCatId(String argTabId, String argColId,String argCatId);
	List<WrapCategory> getWrapNavigationList(String argTabId, String argColId);
	
	
}
