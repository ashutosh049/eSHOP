/**
 * 
 */
package com.wrap.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.wrap.dao.WrapUserAddressDao;
import com.wrap.modal.WrapUserAddress;
import com.wrap.util.WrapUtil;

/**
 * DESCRIPTION GOES HERE<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 * 
 * @author ashu
 * @created Oct 19, 2016
 * @version $Revision$
 */
public class WrapUserAddressDaoImpl implements WrapUserAddressDao {

	@Autowired
	WrapUtil wrapUtil;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wrap.dao.WrapUserAddressDao#getWrapUserAddress(java.lang.String)
	 */
	@Override
	public WrapUserAddress getWrapUserAddress(String argUserName) {

		String sqlQuery = "SELECT userName, user_address_id, addresstitle, "
				+ "addressLine1, addressLine2, city, state, country, "
				+ "postalcode, mobilenumber, additionalinfo "
				+ " FROM wrap_user_address " + " WHERE userName=? ";
		WrapUserAddress wrapUserAddress = null;
		try {
			wrapUserAddress = wrapUtil.getJdbcTemplate().queryForObject(
					sqlQuery, new Object[] { argUserName },
					new RowMapper<WrapUserAddress>() {
						@Override
						public WrapUserAddress mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							WrapUserAddress address = new WrapUserAddress();
							address.setUserName(rs.getString("userName"));
							address.setUser_address_id(rs
									.getString("user_address_id"));
							address.setDefaultAddress(rs.getBoolean("isDefault"));
							address.setAddresstitle(rs
									.getString("addresstitle"));
							address.setAddressLine1(rs
									.getString("addressLine1"));
							address.setAddressLine2(rs
									.getString("addressLine2"));
							address.setCity(rs.getString("city"));
							address.setState(rs.getString("state"));
							address.setCountry(rs.getString("country"));
							address.setPostalcode(rs.getString("postalcode"));
							address.setMobilenumber(rs
									.getString("mobilenumber"));
							address.setAdditionalinfo(rs
									.getString("additionalinfo"));

							return address;
						}
					});
		} catch (Exception e) {
			return null;
		}
		return wrapUserAddress;

	}

	public List<WrapUserAddress> getWrapUserAddressList(String argUserName) {

		String sqlQuery = "SELECT userName, user_address_id, isDefault, addresstitle, "
				+ "addressLine1, addressLine2, city, state, country, "
				+ "postalcode, mobilenumber, additionalinfo "
				+ " FROM wrap_user_address " + " WHERE userName=? ";
		List<WrapUserAddress> WrapUserAddressList = new ArrayList<WrapUserAddress>();
		try {
			WrapUserAddressList = wrapUtil.getJdbcTemplate().query(sqlQuery,
					new Object[] { argUserName },
					new RowMapper<WrapUserAddress>() {
				@Override
				public WrapUserAddress mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					WrapUserAddress address = new WrapUserAddress();
					address.setUserName(rs.getString("userName"));
					address.setUser_address_id(rs
							.getString("user_address_id"));
					address.setDefaultAddress(rs.getBoolean("isDefault"));
					address.setAddresstitle(rs
							.getString("addresstitle"));
					address.setAddressLine1(rs
							.getString("addressLine1"));
					address.setAddressLine2(rs
							.getString("addressLine2"));
					address.setCity(rs.getString("city"));
					address.setState(rs.getString("state"));
					address.setCountry(rs.getString("country"));
					address.setPostalcode(rs.getString("postalcode"));
					address.setMobilenumber(rs
							.getString("mobilenumber"));
					address.setAdditionalinfo(rs
							.getString("additionalinfo"));

					return address;
				}
			});
		} catch (Exception e) {
			return null;
		}
		return WrapUserAddressList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wrap.dao.WrapUserAddressDao#getWrapUserAddress(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public WrapUserAddress getWrapUserAddress(String argUserName,
			String argAddressId) {
		String sqlQuery = "SELECT userName, user_address_id, isDefault,addresstitle, "
				+ "addressLine1, addressLine2, city, state, country, "
				+ "postalcode, mobilenumber, additionalinfo "
				+ " FROM wrap_user_address "
				+ " WHERE userName=? AND user_address_id=?";
		WrapUserAddress wrapUserAddress = wrapUtil.getJdbcTemplate()
				.queryForObject(sqlQuery,
						new Object[] { argUserName, argAddressId },
						new RowMapper<WrapUserAddress>() {
					@Override
					public WrapUserAddress mapRow(ResultSet rs,
							int rowNum) throws SQLException {
						WrapUserAddress address = new WrapUserAddress();
						address.setUserName(rs.getString("userName"));
						address.setUser_address_id(rs
								.getString("user_address_id"));
						address.setDefaultAddress(rs.getBoolean("isDefault"));
						address.setAddresstitle(rs
								.getString("addresstitle"));
						address.setAddressLine1(rs
								.getString("addressLine1"));
						address.setAddressLine2(rs
								.getString("addressLine2"));
						address.setCity(rs.getString("city"));
						address.setState(rs.getString("state"));
						address.setCountry(rs.getString("country"));
						address.setPostalcode(rs
								.getString("postalcode"));
						address.setMobilenumber(rs
								.getString("mobilenumber"));
						address.setAdditionalinfo(rs
								.getString("additionalinfo"));

						return address;
					}
				});
		return wrapUserAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wrap.dao.WrapUserAddressDao#creaetWrapUserAddress(com.wrap.modal.
	 * WrapUserAddress)
	 */
	@Override
	public boolean createWrapUserAddress(WrapUserAddress argWrapUserAddress) {
		
		int res = wrapUtil
				.getJdbcTemplate()
				.update("insert into wrap_user_address (userName, user_address_id,isDefault, addresstitle, addressLine1, addressLine2, city, state, country, postalcode, mobilenumber, additionalinfo)"
						+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
						argWrapUserAddress.getUserName(),
						argWrapUserAddress.getUser_address_id(),
						"1",
						argWrapUserAddress.getAddresstitle(),
						argWrapUserAddress.getAddressLine1(),
						argWrapUserAddress.getAddressLine2(),
						argWrapUserAddress.getCity(),
						argWrapUserAddress.getState(),
						argWrapUserAddress.getCountry(),
						argWrapUserAddress.getPostalcode(),
						argWrapUserAddress.getMobilenumber(),
						argWrapUserAddress.getAdditionalinfo());
		makeDefaultAddress(argWrapUserAddress);
		return res == 1;
	}

	public int getUserAccountCount(String argUserName) {
		String sql = "select count(*) from wrap_user_address where userName='"
				+ argUserName + "'";
		return wrapUtil.getJdbcTemplate().queryForObject(sql, Integer.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wrap.dao.WrapUserAddressDao#updateWrapUserAddress(com.wrap.modal.
	 * WrapUserAddress)
	 */
	@Override
	public boolean updateWrapUserAddress(WrapUserAddress argWrapUserAddress) {
		String updateQuery = "update wrap_user_address "
				+ "SET addresstitle=?, " + "addressLine1=?, "
				+ "addressLine2=?, " + "city=?, " + "state=?, " + "country=?, "
				+ "postalcode=?, " + "mobilenumber=?, " + "additionalinfo=? "
				+ "WHERE userName=?";
		int res = wrapUtil.getJdbcTemplate().update(
				updateQuery,
				new Object[] { argWrapUserAddress.getAddresstitle(),
						argWrapUserAddress.getAddressLine1(),
						argWrapUserAddress.getAddressLine2(),
						argWrapUserAddress.getCity(),
						argWrapUserAddress.getState(),
						argWrapUserAddress.getCountry(),
						argWrapUserAddress.getPostalcode(),
						argWrapUserAddress.getMobilenumber(),
						argWrapUserAddress.getAdditionalinfo(),
						argWrapUserAddress.getUserName() });
		return res == 1;
	}
	
	public void makeDefaultAddress(WrapUserAddress argWrapUserAddress) {
		String removeDefault = "update wrap_user_address "
				+ "SET isDefault=0 "
				+ "WHERE userName=?";
		wrapUtil.getJdbcTemplate().update(
				removeDefault,
				new Object[] {argWrapUserAddress.getUserName() });
		
		String makeDefault = "update wrap_user_address "
				+ "SET isDefault=1 "
				+ "WHERE userName=? AND user_address_id=?";
		wrapUtil.getJdbcTemplate().update(
				makeDefault,
				new Object[] {argWrapUserAddress.getUserName(),argWrapUserAddress.getUser_address_id() });
	}

}
