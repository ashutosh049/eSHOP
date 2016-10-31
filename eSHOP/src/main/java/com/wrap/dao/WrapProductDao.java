package com.wrap.dao;

import java.util.List;

import com.wrap.modal.WrapProduct;

public interface WrapProductDao {
	
	public List<WrapProduct> getWrapProductsByTabByColByCatIds(String argTabId, String argColId, String argCatId);
	public WrapProduct getWrapProductsByTabByColByCatByProdIds(String argTabId, String argColId, String argCatId,String argProdId);
	public List<WrapProduct> getAlsoBaughtTogetherWrapProductsByTabByColIds(String argTabId, String argColId, String argCatId, int rowCount);

}
