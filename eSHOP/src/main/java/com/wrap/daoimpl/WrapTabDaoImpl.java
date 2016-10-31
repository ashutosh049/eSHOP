package com.wrap.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.wrap.dao.WrapTabDao;
import com.wrap.modal.WrapTab;
import com.wrap.util.WrapUtil;

public class WrapTabDaoImpl implements WrapTabDao {

	@Autowired
	WrapUtil wrapUtil;

	@Override
	public List<WrapTab> getWrapTabs() {
		String sqlQuery = "SELECT wrapTabId, wrapTabName, wrapTabSortOrder FROM wrap_tab ORDER BY wrapTabSortOrder";
		List<WrapTab> wrapTabList = wrapUtil.getJdbcTemplate().query(sqlQuery,
				new Object[] {}, new RowMapper<WrapTab>() {
			@Override
			public WrapTab mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				WrapTab wrapTab = new WrapTab();
				wrapTab.setWrapTabId(rs.getString("wrapTabId"));
				wrapTab.setWrapTabName(rs.getString("wrapTabName"));
				wrapTab.setWrapTabSortOrder(rs
						.getInt("wrapTabSortOrder"));
				return wrapTab;
			}
		});
		return wrapTabList;
	}

	@Override
	public WrapTab getWrapTabByTabId(String argTabId) {
		String sqlQuery = "SELECT wrapTabId, wrapTabName, wrapTabSortOrder FROM wrap_tab WHERE wrapTabId=?";
		WrapTab wrapTabList = wrapUtil.getJdbcTemplate().queryForObject(
				sqlQuery, new Object[] { argTabId }, new RowMapper<WrapTab>() {
					@Override
					public WrapTab mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						WrapTab wrapTab = new WrapTab();
						wrapTab.setWrapTabId(rs.getString("wrapTabId"));
						wrapTab.setWrapTabName(rs.getString("wrapTabName"));
						wrapTab.setWrapTabSortOrder(rs
								.getInt("wrapTabSortOrder"));
						return wrapTab;
					}
				});
		return wrapTabList;
	}

	public boolean updateWrapTab(WrapTab argWrapTab) {
		String updateTabQuery = "update wrap_tab "
				+ "SET wrapTabName=?,wrapTabSortOrder=? " + "WHERE wrapTabId=?";
		int updateTabQueryRes = wrapUtil.getJdbcTemplate().update(
				updateTabQuery,
				new Object[] { argWrapTab.getWrapTabName(),
						argWrapTab.getWrapTabSortOrder(),
						argWrapTab.getWrapTabId() });

		return updateTabQueryRes == 1;
	}

	public boolean deleteWrapTab(String argTabId) {
		int res = wrapUtil.getJdbcTemplate().update(
				"delete from wrap_tab where wrapTabId=?", argTabId);
		return res == 1;
	}

	public boolean createWrapTab(WrapTab argWrapTab) {
		int res = wrapUtil.getJdbcTemplate().update(
				"insert into wrap_tab (wrapTabId, wrapTabName, wrapTabSortOrder)"
						+ " values (?, ?, ?)", argWrapTab.getWrapTabId(),
						argWrapTab.getWrapTabName(), argWrapTab.getWrapTabSortOrder());
		return res == 1;
	}

	public int getWrapTabCount() {
		String sql = "select count(*) from wrap_tab";
		return wrapUtil.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

}
