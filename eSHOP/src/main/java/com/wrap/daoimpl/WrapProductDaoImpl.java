/**
 * 
 */
package com.wrap.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.wrap.dao.WrapProductDao;
import com.wrap.imodal.WrapProductColor;
import com.wrap.imodal.WrapProductSize;
import com.wrap.modal.WrapProduct;
import com.wrap.util.WrapUtil;

/**
 * @author ashu
 * 
 */
public class WrapProductDaoImpl implements WrapProductDao {

	@Autowired
	WrapUtil wrapUtil;
	@Autowired
	WrapCategoryDaoImpl wrapCategoryDaoImpl;

	@Override
	public List<WrapProduct> getWrapProductsByTabByColByCatIds(String argTabId,
			String argColId, String argCatId) {
		String sqlQuery = "SELECT wrapTabId, wrapColId, wrapCatId, wrapProdId, "
				+ "wrapProdName, wrapProdDescription, wrapProdInStockItemsCount, "
				+ "wrapProdIsInStock, wrapProdMarkedPrice, wrapProdDiscountPercent, "
				+ "wrapProdTaxPercent, wrapProdShippingChargePercent, wrapProdSize, "
				+ "wrapProdColor, wrapProdImagePath, wrapProdSortOrder"
				+ " FROM wrap_product "
				+ " WHERE wrapTabId=? "
				+ " AND wrapColId=?"
				+ " AND wrapCatId=?"
				+ " ORDER BY wrapProdSortOrder";
		List<WrapProduct> wrapProdList = wrapUtil.getJdbcTemplate().query(
				sqlQuery, new Object[] { argTabId, argColId, argCatId },
				new RowMapper<WrapProduct>() {
					@Override
					public WrapProduct mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						WrapProduct wrapProd = new WrapProduct();
						wrapProd.setWrapTabId(rs.getString("wrapTabId"));
						wrapProd.setWrapColId(rs.getString("wrapColId"));
						wrapProd.setWrapCatId(rs.getString("wrapCatId"));
						wrapProd.setWrapProdId(rs.getString("wrapProdId"));
						wrapProd.setWrapProdName(rs.getString("wrapProdName"));
						wrapProd.setWrapProdDescription(rs
								.getString("wrapProdDescription"));
						wrapProd.setWrapProdInStockItemsCount(rs
								.getInt("wrapProdInStockItemsCount"));
						wrapProd.setWrapProdIsInStock(rs
								.getBoolean("wrapProdIsInStock"));
						wrapProd.setWrapProdMarkedPrice(wrapUtil.round(
								rs.getDouble("wrapProdMarkedPrice"), 2));
						wrapProd.setWrapProdDiscountPercent(wrapUtil.round(
								rs.getDouble("wrapProdDiscountPercent"), 2));
						wrapProd.setWrapProdTaxPercent(wrapUtil.round(
								rs.getDouble("wrapProdTaxPercent"), 2));
						wrapProd.setWrapProdShippingChargePercent(wrapUtil.round(
								rs.getDouble("wrapProdShippingChargePercent"),
								2));
						wrapProd.setWrapProdSize(WrapProductSize.valueOf(rs
								.getString("wrapProdSize")));
						wrapProd.setWrapProdColor(WrapProductColor.valueOf(rs
								.getString("wrapProdColor")));
						wrapProd.setWrapProdImagePath(rs
								.getString("wrapProdImagePath"));
						wrapProd.setWrapProdSortOrder(rs
								.getInt("wrapProdSortOrder"));
						double discountAmt = wrapProd.getWrapProdMarkedPrice()
								* (wrapProd.getWrapProdDiscountPercent() / 100);
						wrapProd.setWrapProdDiscountedPrice(wrapProd
								.getWrapProdMarkedPrice() - discountAmt);
						return wrapProd;
					}
				});
		return wrapProdList;
	}

	@Override
	public WrapProduct getWrapProductsByTabByColByCatByProdIds(String argTabId,
			String argColId, String argCatId, String argProdId) {
		String sqlQuery = "SELECT wrapTabId, wrapColId, wrapCatId, wrapProdId, "
				+ "wrapProdName, wrapProdDescription, wrapProdInStockItemsCount, "
				+ "wrapProdIsInStock, wrapProdMarkedPrice, wrapProdDiscountPercent, "
				+ "wrapProdTaxPercent, wrapProdShippingChargePercent, wrapProdSize, "
				+ "wrapProdColor, wrapProdImagePath, wrapProdSortOrder"
				+ " FROM wrap_product "
				+ " WHERE wrapTabId=? "
				+ " AND wrapColId=?"
				+ " AND wrapCatId=?"
				+ " AND wrapProdId=?"
				+ " ORDER BY wrapProdSortOrder";
		WrapProduct product = wrapUtil.getJdbcTemplate().queryForObject(
				sqlQuery,
				new Object[] { argTabId, argColId, argCatId, argProdId },
				new RowMapper<WrapProduct>() {
					@Override
					public WrapProduct mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						WrapProduct wrapProd = new WrapProduct();
						wrapProd.setWrapTabId(rs.getString("wrapTabId"));
						wrapProd.setWrapColId(rs.getString("wrapColId"));
						wrapProd.setWrapCatId(rs.getString("wrapCatId"));
						wrapProd.setWrapProdId(rs.getString("wrapProdId"));
						wrapProd.setWrapProdName(rs.getString("wrapProdName"));
						wrapProd.setWrapProdDescription(rs
								.getString("wrapProdDescription"));
						wrapProd.setWrapProdInStockItemsCount(rs
								.getInt("wrapProdInStockItemsCount"));
						wrapProd.setWrapProdIsInStock(rs
								.getBoolean("wrapProdIsInStock"));
						wrapProd.setWrapProdMarkedPrice(wrapUtil.round(
								rs.getDouble("wrapProdMarkedPrice"), 2));
						wrapProd.setWrapProdDiscountPercent(wrapUtil.round(
								rs.getDouble("wrapProdDiscountPercent"), 2));
						wrapProd.setWrapProdTaxPercent(wrapUtil.round(
								rs.getDouble("wrapProdTaxPercent"), 2));
						wrapProd.setWrapProdShippingChargePercent(wrapUtil.round(
								rs.getDouble("wrapProdShippingChargePercent"),
								2));
						wrapProd.setWrapProdSize(WrapProductSize.valueOf(rs
								.getString("wrapProdSize")));
						wrapProd.setWrapProdColor(WrapProductColor.valueOf(rs
								.getString("wrapProdColor")));
						wrapProd.setWrapProdImagePath(rs
								.getString("wrapProdImagePath"));
						wrapProd.setWrapProdSortOrder(rs
								.getInt("wrapProdSortOrder"));
						double discountAmt = wrapProd.getWrapProdMarkedPrice()
								* (wrapProd.getWrapProdDiscountPercent() / 100);
						double discountPrice = wrapProd
								.getWrapProdMarkedPrice() - discountAmt;
						wrapProd.setWrapProdDiscountedPrice(wrapUtil.round(
								discountPrice, 2));
						return wrapProd;
					}
				});
		return product;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wrap.dao.WrapProductDao#getAlsoBaughtTogetherWrapProductsByTabByColIds
	 * (java.lang.String, java.lang.String, int)
	 */
	@Override
	public List<WrapProduct> getAlsoBaughtTogetherWrapProductsByTabByColIds(
			String argTabId, String argColId, String argCatId, int rowCount) {

		String sqlQuery = "SELECT wrapTabId, wrapColId, wrapCatId, wrapProdId, "
				+ "wrapProdName, wrapProdDescription, wrapProdInStockItemsCount, "
				+ "wrapProdIsInStock, wrapProdMarkedPrice, wrapProdDiscountPercent, "
				+ "wrapProdTaxPercent, wrapProdShippingChargePercent, wrapProdSize, "
				+ "wrapProdColor, wrapProdImagePath, wrapProdSortOrder"
				+ " FROM wrap_product "
				+ " WHERE wrapTabId=? "
				+ " AND wrapColId=?"
				+ " AND NOT wrapCatId=?"
				+ " ORDER BY RAND() LIMIT ?";
		List<WrapProduct> wrapProdList = wrapUtil.getJdbcTemplate().query(
				sqlQuery,
				new Object[] { argTabId, argColId, argCatId, rowCount },
				new RowMapper<WrapProduct>() {
					@Override
					public WrapProduct mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						WrapProduct wrapProd = new WrapProduct();
						wrapProd.setWrapTabId(rs.getString("wrapTabId"));
						wrapProd.setWrapColId(rs.getString("wrapColId"));
						wrapProd.setWrapCatId(rs.getString("wrapCatId"));
						wrapProd.setWrapProdId(rs.getString("wrapProdId"));
						wrapProd.setWrapProdName(rs.getString("wrapProdName"));
						wrapProd.setWrapProdDescription(rs
								.getString("wrapProdDescription"));
						wrapProd.setWrapProdInStockItemsCount(rs
								.getInt("wrapProdInStockItemsCount"));
						wrapProd.setWrapProdIsInStock(rs
								.getBoolean("wrapProdIsInStock"));
						wrapProd.setWrapProdMarkedPrice(wrapUtil.round(
								rs.getDouble("wrapProdMarkedPrice"), 2));
						wrapProd.setWrapProdDiscountPercent(wrapUtil.round(
								rs.getDouble("wrapProdDiscountPercent"), 2));
						wrapProd.setWrapProdTaxPercent(wrapUtil.round(
								rs.getDouble("wrapProdTaxPercent"), 2));
						wrapProd.setWrapProdShippingChargePercent(wrapUtil.round(
								rs.getDouble("wrapProdShippingChargePercent"),
								2));
						wrapProd.setWrapProdSize(WrapProductSize.valueOf(rs
								.getString("wrapProdSize")));
						wrapProd.setWrapProdColor(WrapProductColor.valueOf(rs
								.getString("wrapProdColor")));
						wrapProd.setWrapProdImagePath(rs
								.getString("wrapProdImagePath"));
						wrapProd.setWrapProdSortOrder(rs
								.getInt("wrapProdSortOrder"));
						double discountAmt = wrapProd.getWrapProdMarkedPrice()
								* (wrapProd.getWrapProdDiscountPercent() / 100);
						double discountPrice = wrapProd
								.getWrapProdMarkedPrice() - discountAmt;
						wrapProd.setWrapProdDiscountedPrice(wrapUtil.round(
								discountPrice, 2));
						return wrapProd;
					}
				});
		return wrapProdList;

	}

	public List<WrapProduct> getAllWrapProducts() {
		String sqlQuery = "SELECT wrapTabId, wrapColId, wrapCatId, wrapProdId, "
				+ "wrapProdName, wrapProdDescription, wrapProdInStockItemsCount, "
				+ "wrapProdIsInStock, wrapProdMarkedPrice, wrapProdDiscountPercent, "
				+ "wrapProdTaxPercent, wrapProdShippingChargePercent, wrapProdSize, "
				+ "wrapProdColor, wrapProdImagePath, wrapProdSortOrder"
				+ " FROM wrap_product " + " ORDER BY wrapProdSortOrder";
		List<WrapProduct> wrapProdList = wrapUtil.getJdbcTemplate().query(
				sqlQuery, new Object[] {}, new RowMapper<WrapProduct>() {
					@Override
					public WrapProduct mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						WrapProduct wrapProd = new WrapProduct();
						wrapProd.setWrapTabId(rs.getString("wrapTabId"));
						wrapProd.setWrapColId(rs.getString("wrapColId"));
						wrapProd.setWrapCatId(rs.getString("wrapCatId"));
						wrapProd.setWrapProdId(rs.getString("wrapProdId"));
						wrapProd.setWrapProdName(rs.getString("wrapProdName"));
						wrapProd.setWrapProdDescription(rs
								.getString("wrapProdDescription"));
						wrapProd.setWrapProdInStockItemsCount(rs
								.getInt("wrapProdInStockItemsCount"));
						wrapProd.setWrapProdIsInStock(rs
								.getBoolean("wrapProdIsInStock"));
						wrapProd.setWrapProdMarkedPrice(wrapUtil.round(
								rs.getDouble("wrapProdMarkedPrice"), 2));
						wrapProd.setWrapProdDiscountPercent(wrapUtil.round(
								rs.getDouble("wrapProdDiscountPercent"), 2));
						wrapProd.setWrapProdTaxPercent(wrapUtil.round(
								rs.getDouble("wrapProdTaxPercent"), 2));
						wrapProd.setWrapProdShippingChargePercent(wrapUtil.round(
								rs.getDouble("wrapProdShippingChargePercent"),
								2));
						wrapProd.setWrapProdSize(WrapProductSize.valueOf(rs
								.getString("wrapProdSize")));
						wrapProd.setWrapProdColor(WrapProductColor.valueOf(rs
								.getString("wrapProdColor")));
						wrapProd.setWrapProdImagePath(rs
								.getString("wrapProdImagePath"));
						wrapProd.setWrapProdSortOrder(rs
								.getInt("wrapProdSortOrder"));
						double discountAmt = wrapProd.getWrapProdMarkedPrice()
								* (wrapProd.getWrapProdDiscountPercent() / 100);
						wrapProd.setWrapProdDiscountedPrice(wrapProd
								.getWrapProdMarkedPrice() - discountAmt);
						return wrapProd;
					}
				});
		return wrapProdList;
	}

	public boolean updateWrapProduct(WrapProduct argWrapProduct) {
		String updateQuery = "update wrap_product "
				+ "SET wrapProdName=?, wrapProdDescription=?, wrapProdInStockItemsCount=?, "
				+ "wrapProdIsInStock=?, wrapProdMarkedPrice=?, wrapProdDiscountPercent=?, "
				+ "wrapProdTaxPercent=?, wrapProdShippingChargePercent=?, wrapProdSize=?, "
				+ "wrapProdColor=?, wrapProdImagePath=?, wrapProdSortOrder=? "
				+ "WHERE wrapTabId=? AND wrapColId=? AND wrapCatId=? AND wrapProdId=?";
		int res = wrapUtil.getJdbcTemplate().update(
				updateQuery,
				new Object[] { argWrapProduct.getWrapProdName(),
						argWrapProduct.getWrapProdDescription(),
						argWrapProduct.getWrapProdInStockItemsCount(),
						argWrapProduct.isWrapProdIsInStock(),
						argWrapProduct.getWrapProdMarkedPrice(),
						argWrapProduct.getWrapProdDiscountPercent(),
						argWrapProduct.getWrapProdTaxPercent(),
						argWrapProduct.getWrapProdShippingChargePercent(),
						argWrapProduct.getWrapProdSize().toString(),
						argWrapProduct.getWrapProdColor().toString(),
						argWrapProduct.getWrapProdImagePath(),
						argWrapProduct.getWrapProdSortOrder(),
						argWrapProduct.getWrapTabId(),
						argWrapProduct.getWrapColId(),
						argWrapProduct.getWrapCatId(),
						argWrapProduct.getWrapProdId() });
		return res >= 1;
	}

	public boolean updateWrapProductCount(WrapProduct argWrapProduct) {
		String updateQuery = "update wrap_product "
				+ "SET wrapProdInStockItemsCount=?, "
				+ "wrapProdIsInStock=? "
				+ "WHERE wrapTabId=? AND wrapColId=? AND wrapCatId=? AND wrapProdId=?";
		int res = wrapUtil.getJdbcTemplate().update(
				updateQuery,
				new Object[] { argWrapProduct.getWrapProdInStockItemsCount(),
						argWrapProduct.isWrapProdIsInStock(),
						argWrapProduct.getWrapTabId(),
						argWrapProduct.getWrapColId(),
						argWrapProduct.getWrapCatId(),
						argWrapProduct.getWrapProdId() });
		return res >= 1;
	}

	public boolean updateWrapProduct_TabId(String argTabId) {
		String updateQuery = "update wrap_product " + "SET wrapProdId=? "
				+ "WHERE wrapTabId=?";
		int res = wrapUtil.getJdbcTemplate().update(updateQuery,
				new Object[] { argTabId, argTabId });
		return res >= 1;
	}

	public boolean createWrapProduct(WrapProduct argWrapProduct) {
		String updateQuery = "INSERT INTO wrap_product (wrapTabId, wrapColId, wrapCatId, wrapProdId, "
				+ "wrapProdName, wrapProdDescription, wrapProdInStockItemsCount, "
				+ "wrapProdIsInStock, wrapProdMarkedPrice, wrapProdDiscountPercent, "
				+ "wrapProdTaxPercent, wrapProdShippingChargePercent, wrapProdSize, "
				+ "wrapProdColor, wrapProdImagePath, wrapProdSortOrder"
				+ ") "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int res = wrapUtil.getJdbcTemplate().update(
				updateQuery,
				new Object[] { argWrapProduct.getWrapTabId(),
						argWrapProduct.getWrapColId(),
						argWrapProduct.getWrapCatId(),
						argWrapProduct.getWrapProdId(),
						argWrapProduct.getWrapProdName(),
						argWrapProduct.getWrapProdDescription(),
						argWrapProduct.getWrapProdInStockItemsCount(),
						argWrapProduct.isWrapProdIsInStock(),
						argWrapProduct.getWrapProdMarkedPrice(),
						argWrapProduct.getWrapProdDiscountPercent(),
						argWrapProduct.getWrapProdTaxPercent(),
						argWrapProduct.getWrapProdShippingChargePercent(),
						argWrapProduct.getWrapProdSize().toString(),
						argWrapProduct.getWrapProdColor().toString(),
						argWrapProduct.getWrapProdImagePath(),
						argWrapProduct.getWrapProdSortOrder() });
		return res >= 1;
	}

	// get random new arrivals
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wrap.dao.WrapProductDao#getAlsoBaughtTogetherWrapProductsByTabByColIds
	 * (java.lang.String, java.lang.String, int)
	 */
	public List<WrapProduct> getRandomProucts(int rowCount) {

		String sqlQuery = "SELECT wrapTabId, wrapColId, wrapCatId, wrapProdId, "
				+ "wrapProdName, wrapProdDescription, wrapProdInStockItemsCount, "
				+ "wrapProdIsInStock, wrapProdMarkedPrice, wrapProdDiscountPercent, "
				+ "wrapProdTaxPercent, wrapProdShippingChargePercent, wrapProdSize, "
				+ "wrapProdColor, wrapProdImagePath, wrapProdSortOrder"
				+ " FROM wrap_product " + " ORDER BY RAND() LIMIT ?";
		List<WrapProduct> wrapProdList = wrapUtil.getJdbcTemplate().query(
				sqlQuery, new Object[] { rowCount },
				new RowMapper<WrapProduct>() {
					@Override
					public WrapProduct mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						WrapProduct wrapProd = new WrapProduct();
						wrapProd.setWrapTabId(rs.getString("wrapTabId"));
						wrapProd.setWrapColId(rs.getString("wrapColId"));
						wrapProd.setWrapCatId(rs.getString("wrapCatId"));
						wrapProd.setWrapProdId(rs.getString("wrapProdId"));
						wrapProd.setWrapProdName(rs.getString("wrapProdName"));
						wrapProd.setWrapProdDescription(rs
								.getString("wrapProdDescription"));
						wrapProd.setWrapProdInStockItemsCount(rs
								.getInt("wrapProdInStockItemsCount"));
						wrapProd.setWrapProdIsInStock(rs
								.getBoolean("wrapProdIsInStock"));
						wrapProd.setWrapProdMarkedPrice(wrapUtil.round(
								rs.getDouble("wrapProdMarkedPrice"), 2));
						wrapProd.setWrapProdDiscountPercent(wrapUtil.round(
								rs.getDouble("wrapProdDiscountPercent"), 2));
						wrapProd.setWrapProdTaxPercent(wrapUtil.round(
								rs.getDouble("wrapProdTaxPercent"), 2));
						wrapProd.setWrapProdShippingChargePercent(wrapUtil.round(
								rs.getDouble("wrapProdShippingChargePercent"),
								2));
						wrapProd.setWrapProdSize(WrapProductSize.valueOf(rs
								.getString("wrapProdSize")));
						wrapProd.setWrapProdColor(WrapProductColor.valueOf(rs
								.getString("wrapProdColor")));
						wrapProd.setWrapProdImagePath(rs
								.getString("wrapProdImagePath"));
						wrapProd.setWrapProdSortOrder(rs
								.getInt("wrapProdSortOrder"));
						double discountAmt = wrapProd.getWrapProdMarkedPrice()
								* (wrapProd.getWrapProdDiscountPercent() / 100);
						double discountPrice = wrapProd
								.getWrapProdMarkedPrice() - discountAmt;
						wrapProd.setWrapProdDiscountedPrice(wrapUtil.round(
								discountPrice, 2));
						return wrapProd;
					}
				});
		return wrapProdList;

	}

	public boolean deleteWrapProductByTabId(String argTabId) {
		int res = wrapUtil.getJdbcTemplate().update(
				"delete from wrap_product where wrapTabId=?", argTabId);
		return res >= 1;
	}

	public boolean deleteWrapProductByTabColId(String argTabId, String argColId) {
		int res = wrapUtil.getJdbcTemplate().update(
				"delete from wrap_product where wrapTabId=? AND wrapColId=?",
				argTabId, argColId);
		return res >= 1;
	}

	public boolean deleteWrapProductByTabColCatId(String argTabId,
			String argColId, String argCatId) {
		int res = wrapUtil
				.getJdbcTemplate()
				.update("delete from wrap_product where wrapTabId=? AND wrapColId=? AND wrapCatId=?",
						argTabId, argColId, argCatId);
		return res >= 1;
	}

	public boolean deleteWrapProduct(WrapProduct argWrapProduct) {
		String updateQuery = "DELETE FROM wrap_product "
				+ "WHERE wrapTabId=? AND wrapColId=? AND wrapCatId=? AND wrapProdId=?";
		int res = wrapUtil.getJdbcTemplate().update(
				updateQuery,
				new Object[] { argWrapProduct.getWrapTabId(),
						argWrapProduct.getWrapColId(),
						argWrapProduct.getWrapCatId(),
						argWrapProduct.getWrapProdId() });
		return res >= 1;
	}

}
