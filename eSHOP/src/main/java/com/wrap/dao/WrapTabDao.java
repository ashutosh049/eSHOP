package com.wrap.dao;

import java.util.List;

import com.wrap.modal.WrapTab;

public interface WrapTabDao {

	List<WrapTab> getWrapTabs();
	WrapTab getWrapTabByTabId(String argTabId);
	
}
