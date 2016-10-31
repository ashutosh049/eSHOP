/**
 * 
 */
package com.wrap.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.wrap.dao.WrapColumnDao;
import com.wrap.modal.WrapColumn;
import com.wrap.util.WrapUtil;

/**
 * @author ashu
 * 
 */
public class WrapColumnDaoImpl implements WrapColumnDao {

	@Autowired
	WrapUtil wrapUtil;

	@Override
	public List<WrapColumn> getWrapColumnListByTabId(String argTabID) {

		String sqlQuery = "SELECT wrapTabId, wrapColId, wrapColName, wrapColSortOrder FROM wrap_column "
				+ " ORDER BY wrapTabId,wrapColSortOrder";
		List<WrapColumn> wrapColumnList = wrapUtil.getJdbcTemplate().query(
				sqlQuery, new Object[] {}, new RowMapper<WrapColumn>() {
					@Override
					public WrapColumn mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						WrapColumn wrapCol = new WrapColumn();
						wrapCol.setWrapTabId(rs.getString("wrapTabId"));
						wrapCol.setWrapColId(rs.getString("wrapColId"));
						wrapCol.setWrapColName(rs.getString("wrapColName"));
						wrapCol.setWrapColSortOrder(rs
								.getInt("wrapColSortOrder"));
						return wrapCol;
					}
				});
		if (argTabID != null && argTabID != "") {
			sqlQuery = "SELECT wrapTabId, wrapColId, wrapColName, wrapColSortOrder FROM wrap_column "
					+ "WHERE wrapTabId=? ORDER BY wrapColSortOrder";
			wrapColumnList = wrapUtil.getJdbcTemplate().query(sqlQuery,
					new Object[] { argTabID }, new RowMapper<WrapColumn>() {
				@Override
				public WrapColumn mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					WrapColumn wrapCol = new WrapColumn();
					wrapCol.setWrapTabId(rs.getString("wrapTabId"));
					wrapCol.setWrapColId(rs.getString("wrapColId"));
					wrapCol.setWrapColName(rs.getString("wrapColName"));
					wrapCol.setWrapColSortOrder(rs
							.getInt("wrapColSortOrder"));
					return wrapCol;
				}
			});
		}

		return wrapColumnList;
	}

	public boolean updateWrapCol(WrapColumn argWrapColumn) {
		String updateQuery = "update wrap_column "
				+ "SET wrapColName=?, wrapColSortOrder=? "
				+ "WHERE wrapTabId=? AND wrapColId=?";
		int res = wrapUtil.getJdbcTemplate().update(
				updateQuery,
				new Object[] { argWrapColumn.getWrapColName(),
						argWrapColumn.getWrapColSortOrder(),
						argWrapColumn.getWrapTabId(),
						argWrapColumn.getWrapColId() });
		return res >= 1;
	}

	public boolean updateWrapColBYTabId(String argTabId) {
		String updateQuery = "update wrap_column " + "SET wrapTabId=?"
				+ "WHERE wrapTabId=?";
		int res = wrapUtil.getJdbcTemplate().update(updateQuery,
				new Object[] { argTabId, argTabId });
		return res >= 1;
	}

	public boolean createWrapCol(WrapColumn argWrapColumn) {
		String updateQuery = "INSERT INTO wrap_column (wrapTabId, wrapColId, wrapColName, wrapColSortOrder)"
				+ "VALUES(?,?,?,?)";
		int res = wrapUtil.getJdbcTemplate().update(
				updateQuery,
				new Object[] { argWrapColumn.getWrapTabId(),
						argWrapColumn.getWrapColId(),
						argWrapColumn.getWrapColName(),
						argWrapColumn.getWrapColSortOrder() });
		return res >= 1;
	}

	public boolean deleteWrapColByTabId(String argTabId) {
		int res = wrapUtil.getJdbcTemplate().update(
				"delete from wrap_column where wrapTabId=?", argTabId);
		return res >= 1;
	}

	public boolean deleteWrapColByTabColId(String argTabId, String argColId) {
		int res = wrapUtil.getJdbcTemplate().update(
				"delete from wrap_column where wrapTabId=? AND wrapColId=?",
				argTabId, argColId);
		return res >= 1;
	}

}
