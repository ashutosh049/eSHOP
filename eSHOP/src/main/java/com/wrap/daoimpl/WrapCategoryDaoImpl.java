package com.wrap.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.wrap.dao.WrapCategoryDao;
import com.wrap.modal.WrapCategory;
import com.wrap.util.WrapUtil;

public class WrapCategoryDaoImpl implements WrapCategoryDao {

	@Autowired
	WrapUtil wrapUtil;

	@Override
	public List<WrapCategory> getWrapCategoriesByTabByColIds(String argTabId,
			String argColId) {
		String sqlQuery = "SELECT wrapTabId, wrapColId, wrapCatId, wrapCatName, wrapCatSizeList, wrapCatColorList, wrapCatSortOrder"
				+ " FROM wrap_category "
				+ " WHERE wrapTabId=? "
				+ " AND wrapColId=?" + " ORDER BY wrapCatSortOrder";
		List<WrapCategory> wrapCategoryList = wrapUtil.getJdbcTemplate().query(
				sqlQuery, new Object[] { argTabId, argColId },
				new RowMapper<WrapCategory>() {
					@Override
					public WrapCategory mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						WrapCategory wrapCat = new WrapCategory();
						wrapCat.setWrapTabId(rs.getString("wrapTabId"));
						wrapCat.setWrapColId(rs.getString("wrapColId"));
						wrapCat.setWrapCatId(rs.getString("wrapCatId"));
						wrapCat.setWrapCatName(rs.getString("wrapCatName"));
						wrapCat.setWrapCatSortOrder(rs
								.getInt("wrapCatSortOrder"));
						return wrapCat;
					}
				});
		return wrapCategoryList;
	}

	@Override
	public List<WrapCategory> getWrapNavigationList(String argTabId,
			String argColId) {
		String sqlQuery = "SELECT wrapTabId, wrapColId, wrapCatId, wrapCatName, wrapCatSizeList, wrapCatColorList, wrapCatSortOrder"
				+ " FROM wrap_category "
				+ " WHERE wrapTabId=? "
				+ " AND wrapColId=?" + " ORDER BY wrapCatSortOrder";
		List<WrapCategory> wrapCategoryList = wrapUtil.getJdbcTemplate().query(
				sqlQuery, new Object[] { argTabId, argColId },
				new RowMapper<WrapCategory>() {
					@Override
					public WrapCategory mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						WrapCategory wrapCat = new WrapCategory();
						wrapCat.setWrapTabId(rs.getString("wrapTabId"));
						wrapCat.setWrapColId(rs.getString("wrapColId"));
						wrapCat.setWrapCatId(rs.getString("wrapCatId"));
						wrapCat.setWrapCatName(rs.getString("wrapCatName"));
						wrapCat.setWrapCatSortOrder(rs
								.getInt("wrapCatSortOrder"));
						return wrapCat;
					}
				});
		return wrapCategoryList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wrap.dao.WrapCategoryDao#getWrapCategoriesByTabByColIdsExceptCatId
	 * (java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<WrapCategory> getWrapCategoriesByTabByColIdsExceptCatId(
			String argTabId, String argColId, String argCatId) {

		String sqlQuery = "SELECT wrapTabId, wrapColId, wrapCatId, wrapCatName, wrapCatSizeList, wrapCatColorList, wrapCatSortOrder"
				+ " FROM wrap_category "
				+ " WHERE wrapTabId=? "
				+ " AND wrapColId=?"
				+ " AND NOT wrapCatId=? "
				+ " ORDER BY wrapCatSortOrder";
		List<WrapCategory> wrapCategoryList = wrapUtil.getJdbcTemplate().query(
				sqlQuery, new Object[] { argTabId, argColId, argCatId },
				new RowMapper<WrapCategory>() {
					@Override
					public WrapCategory mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						WrapCategory wrapCat = new WrapCategory();
						wrapCat.setWrapTabId(rs.getString("wrapTabId"));
						wrapCat.setWrapColId(rs.getString("wrapColId"));
						wrapCat.setWrapCatId(rs.getString("wrapCatId"));
						wrapCat.setWrapCatName(rs.getString("wrapCatName"));
						wrapCat.setWrapCatSortOrder(rs
								.getInt("wrapCatSortOrder"));
						return wrapCat;
					}
				});
		return wrapCategoryList;

	}

	public WrapCategory getWrapCategoryByTabColCatId(String argTabId,
			String argColId, String argCatId) {

		String sqlQuery = "SELECT wrapTabId, wrapColId, wrapCatId, wrapCatName, wrapCatSizeList, wrapCatColorList, wrapCatSortOrder"
				+ " FROM wrap_category "
				+ " WHERE wrapTabId=? "
				+ " AND wrapColId=?"
				+ " AND wrapCatId=? "
				+ " ORDER BY wrapCatSortOrder";
		WrapCategory wrapCategory = wrapUtil.getJdbcTemplate().queryForObject(
				sqlQuery, new Object[] { argTabId, argColId, argCatId },
				new RowMapper<WrapCategory>() {
					@Override
					public WrapCategory mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						WrapCategory wrapCat = new WrapCategory();
						wrapCat.setWrapTabId(rs.getString("wrapTabId"));
						wrapCat.setWrapColId(rs.getString("wrapColId"));
						wrapCat.setWrapCatId(rs.getString("wrapCatId"));
						wrapCat.setWrapCatName(rs.getString("wrapCatName"));
						wrapCat.setWrapCatSortOrder(rs
								.getInt("wrapCatSortOrder"));
						return wrapCat;
					}
				});
		return wrapCategory;

	}

	public boolean updateWrapCat(WrapCategory argWrapCategory) {
		String updateQuery = "update wrap_category "
				+ "SET wrapCatName=?, wrapCatSortOrder=? "
				+ "WHERE wrapTabId=? AND wrapColId=? AND wrapCatId=?";
		int res = wrapUtil.getJdbcTemplate().update(
				updateQuery,
				new Object[] { argWrapCategory.getWrapCatName(),
						argWrapCategory.getWrapCatSortOrder(),
						argWrapCategory.getWrapTabId(),
						argWrapCategory.getWrapColId(),
						argWrapCategory.getWrapCatId() });
		return res >= 1;
	}

	public boolean updateWrapCat_TabId(String argTabId) {
		String updateQuery = "update wrap_category " + "SET wrapTabId=?"
				+ "WHERE wrapTabId=?";
		int res = wrapUtil.getJdbcTemplate().update(updateQuery,
				new Object[] { argTabId, argTabId });
		return res >= 1;
	}

	public boolean createWrapCat(WrapCategory argWrapCategory) {
		String updateQuery = "INSERT INTO wrap_category (wrapTabId, wrapColId, wrapCatId, "
				+ "wrapCatName, wrapCatSizeList, wrapCatColorList, wrapCatSortOrder)"
				+ "VALUES(?,?,?,?,?,?,?)";
		int res = wrapUtil.getJdbcTemplate().update(
				updateQuery,
				new Object[] { argWrapCategory.getWrapTabId(),
						argWrapCategory.getWrapColId(),
						argWrapCategory.getWrapCatId(),
						argWrapCategory.getWrapCatName(), null, null,
						argWrapCategory.getWrapCatSortOrder() });
		return res >= 1;
	}

	public boolean deleteWrapCatByTabId(String argTabId) {
		int res = wrapUtil.getJdbcTemplate().update(
				"delete from wrap_category where wrapTabId=?", argTabId);
		return res >= 1;
	}

	public boolean deleteWrapCatByTabColId(String argTabId, String argColId) {
		int res = wrapUtil.getJdbcTemplate().update(
				"delete from wrap_category where wrapTabId=? AND wrapColId=?",
				argTabId, argColId);
		return res >= 1;
	}

	public boolean deleteWrapCatByTabColCatId(String argTabId, String argColId,
			String argCatId) {
		int res = wrapUtil
				.getJdbcTemplate()
				.update("delete from wrap_category where wrapTabId=? AND wrapColId=? AND wrapCatId=?",
						argTabId, argColId, argCatId);
		return res >= 1;
	}

}
