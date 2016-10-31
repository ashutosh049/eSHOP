/**
 * 
 */
package com.wrap.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.wrap.dao.WrapUserDao;
import com.wrap.modal.WrapCustomer;
import com.wrap.modal.WrapUser;
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
public class WrapUserDaoImpl implements WrapUserDao {

	@Autowired
	WrapUtil wrapUtil;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wrap.dao.WrapUserDao#getWrapUserByUsername(java.lang.String)
	 */
	@Override
	public WrapUser getWrapUserByUsername(String argUsername) {
		String sqlQuery = "SELECT userName, firstName, lastName, email, password "
				+ " FROM wrap_user " + " WHERE userName=? ";
		WrapUser wrapUSer = wrapUtil.getJdbcTemplate().queryForObject(sqlQuery,
				new Object[] { argUsername }, new RowMapper<WrapUser>() {
			@Override
			public WrapUser mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				WrapUser user = new WrapUser();
				user.setUserName(rs.getString("userName"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
		return wrapUSer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wrap.dao.WrapUserDao#createWrapUser(com.wrap.modal.WrapUser)
	 */
	@Override
	public boolean createWrapUser(WrapUser argWrapUser) {
		int res = wrapUtil
				.getJdbcTemplate()
				.update("insert into wrap_user (userName, firstName, lastName, email, password) values (?, ?, ?, ?, ?)",
						argWrapUser.getUserName(), argWrapUser.getFirstName(),
						argWrapUser.getLastName(), argWrapUser.getEmail(), argWrapUser.getPassword());
		return res == 1;
	}

	public boolean createWrapUserCredentials(WrapUser argWrapUser) {
		int res = wrapUtil
				.getJdbcTemplate()
				.update("insert into wrap_usercredentials (username, password, enabled) values (?, ?, ?)",
						argWrapUser.getUserName(), argWrapUser.getPassword(), 1);
		return res == 1;
	}

	public boolean createWrapUserRoles(WrapUser argWrapUser) {
		int res = wrapUtil
				.getJdbcTemplate()
				.update("insert into wrap_userroles (username, role) values (?, ?)",
						argWrapUser.getUserName(), "ROLE_USER");
		return res == 1;
	}

	public int getUserAccountCount() {
		return wrapUtil.getJdbcTemplate().queryForObject(
				"select count(*) from wrap_user", Integer.class);
	}
	
	@Override
	public boolean updateWrapUserInfo(WrapUser argWrapUser) {
		String updateQuery = "update wrap_user " +
				"SET firstName=?, " +
				"lastName=?, " +
				"email=? " +
				"WHERE userName=?";
		int res = wrapUtil
				.getJdbcTemplate()
				.update(updateQuery,new Object[]{
						argWrapUser.getFirstName(),
						argWrapUser.getLastName(),
						argWrapUser.getEmail(),
						argWrapUser.getUserName()});
		return res == 1;
	}
	
	public boolean updateWrapUserPassword(WrapUser argWrapUser, String argPassword) {
		String updateQuery = "update wrap_usercredentials " +
				"SET password=? " +
				"WHERE username=?";
		int res = wrapUtil
				.getJdbcTemplate()
				.update(updateQuery,new Object[]{
						argPassword,
						argWrapUser.getFirstName()});
		return res == 1;
	}

	/* (non-Javadoc)
	 * @see com.wrap.dao.WrapUserDao#getWrapUserByUsername()
	 */
	@Override
	public List<WrapCustomer> getWrapCustomers() {
		String sqlQuery = "SELECT  " +
		" wu.userName, wu.firstName, wu.lastName, wu.email, wu.password," +
		" wuc.username, wuc.enabled," +
		" wur.role," +
		" wua.user_address_id, wua.addresstitle, wua.addressLine1, wua.addressLine2, wua.city, wua.state, wua.country, wua.postalcode, wua.mobilenumber, wua.additionalinfo FROM wrap_user wu INNER JOIN wrap_usercredentials wuc ON wu.userName = wuc.username INNER JOIN wrap_userroles wur ON wur.userName = wuc.username LEFT OUTER JOIN wrap_user_address wua ON wur.username=wua.userName WHERE NOT wur.role='ROLE_ADMIN'";
		List<WrapCustomer> wrapUSer = wrapUtil.getJdbcTemplate().query(sqlQuery,
				new Object[] {}, new RowMapper<WrapCustomer>() {
			@Override
			public WrapCustomer mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				WrapCustomer customer = new WrapCustomer();
				customer.setUserName(rs.getString("userName"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				customer.setActive(rs.getBoolean("enabled"));
				customer.setUser_address_id(rs.getString("user_address_id"));
				customer.setAddresstitle(rs.getString("addresstitle"));
				customer.setAddressLine1(rs.getString("addressLine1"));
				customer.setAddressLine2(rs.getString("addressLine2"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setCountry(rs.getString("country"));
				customer.setPostalcode(rs.getString("postalcode"));
				customer.setMobilenumber(rs.getString("mobilenumber"));
				customer.setAdditionalinfo(rs.getString("additionalinfo"));
				
				return customer;
			}
		});
		return wrapUSer;
	}
	
	// remove
	public boolean removeWrapUser(String userName) {
		if(wrapUtil
				.getJdbcTemplate()
				.update("delete from wrap_user_address where userName=?",
						userName)==1){
			if(wrapUtil
					.getJdbcTemplate()
					.update("delete from wrap_userroles where userName=?",
							userName)==1){
				if(wrapUtil
						.getJdbcTemplate()
						.update("delete from wrap_usercredentials where userName=?",
								userName)==1){
					if(wrapUtil
							.getJdbcTemplate()
							.update("delete from wrap_user where userName=?",
									userName)==1){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean updateUserStatus(boolean status, String userName) {
		String updateQuery = "update wrap_usercredentials " +
				"SET enabled=? " +
				"WHERE username=?";
		int res = wrapUtil
				.getJdbcTemplate()
				.update(updateQuery,new Object[]{
						status,userName});
		return res == 1;
	}
}
