/**
 * 
 */
package com.wrap.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.wrap.dao.WrapOrderDao;
import com.wrap.modal.WrapOrder;
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
public class WrapOrderDaoImpl implements WrapOrderDao {

	@Autowired
	WrapUtil wrapUtil;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wrap.dao.WrapOrderDao#getWrapOrder(java.lang.String)
	 */
	@Override
	public List<WrapOrder> getWrapOrder(String orderUserId) {
		String sqlQuery = "SELECT orderUserId, orderAddressId, orderCardId, "
				+ "orderId, orderDate, orderTotal, orderStatus "
				+ " FROM wrap_order " + " WHERE orderUserId=? ";
		List<WrapOrder> wrapOrderList = null;
		try {
			wrapOrderList = wrapUtil.getJdbcTemplate().query(sqlQuery,
					new Object[] { orderUserId }, new RowMapper<WrapOrder>() {
				@Override
				public WrapOrder mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					WrapOrder order = new WrapOrder();
					order.setOrderUserId(rs.getString("orderUserId"));
					order.setOrderAddressId(rs
							.getString("orderAddressId"));
					order.setOrderCardId(rs.getString("orderCardId"));
					order.setOrderId(rs.getString("orderId"));
					order.setOrderDate(rs.getDate("orderDate"));
					order.setOrderTotal(rs.getDouble("orderTotal"));
					order.setOrderStatus(rs.getString("orderStatus"));
					return order;
				}
			});
		} catch (Exception e) {
			return null;
		}
		return wrapOrderList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wrap.dao.WrapOrderDao#createWrapOrder(com.wrap.modal.WrapOrder)
	 */
	@Override
	public boolean createWrapOrder(WrapOrder argWrapOrder) {
		int res = wrapUtil
				.getJdbcTemplate()
				.update("insert into wrap_order (orderUserId, orderAddressId, orderCardId,orderId, orderDate, orderTotal, orderStatus)"
						+ " values (?, ?, ?, ?, ? ,?, ?)",
						argWrapOrder.getOrderUserId(),
						argWrapOrder.getOrderAddressId(),
						argWrapOrder.getOrderCardId(),
						argWrapOrder.getOrderId(), argWrapOrder.getOrderDate(),
						argWrapOrder.getOrderTotal(),
						argWrapOrder.getOrderStatus());
		return res == 1;
	}

}
