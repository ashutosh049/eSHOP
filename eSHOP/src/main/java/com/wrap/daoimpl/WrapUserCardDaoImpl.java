/**
 * 
 */
package com.wrap.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.wrap.dao.WrapUserCardDao;
import com.wrap.modal.WrapUserCard;
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
public class WrapUserCardDaoImpl implements WrapUserCardDao {

	@Autowired
	WrapUtil wrapUtil;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wrap.dao.WrapUserCardDao#saveUserCardInfo(com.wrap.modal.WrapUserCard
	 * )
	 */
	@Override
	public boolean saveUserCardInfo(WrapUserCard argWrapUserCard) {
		int res = wrapUtil
				.getJdbcTemplate()
				.update("insert into wrap_user_card (userName, userCCId, ccType, ccNumber, ccOnName, ccExpirationMonth, ccExpirationYear, ccCvvNumber)"
						+ " values (?, ?, ?, ?, ?,?, ?, ?)",
						argWrapUserCard.getUserName(),
						argWrapUserCard.getUserCCId(),
						argWrapUserCard.getCcType(),
						argWrapUserCard.getCcNumber(),
						argWrapUserCard.getCcOnName(),
						argWrapUserCard.getCcExpirationMonth(),
						argWrapUserCard.getCcExpirationYear(),
						argWrapUserCard.getCcCvvNumber());

		return res == 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wrap.dao.WrapUserCardDao#getUserCardInfo(java.lang.String)
	 */
	@Override
	public WrapUserCard getUserCardInfo(String argUserName) {
		String sqlQuery = "SELECT userName, userCCId, ccType, ccNumber, ccOnName, ccExpirationMonth, ccExpirationYear, ccCvvNumber "
				+ " FROM wrap_user_card " + " WHERE userName=?";
		WrapUserCard wrapUserCard = wrapUtil.getJdbcTemplate().queryForObject(
				sqlQuery, new Object[] { argUserName },
				new RowMapper<WrapUserCard>() {
					@Override
					public WrapUserCard mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						WrapUserCard card = new WrapUserCard();
						card.setUserName(rs.getString("userName"));
						card.setUserCCId(rs.getString("userCCId"));
						card.setCcType(rs.getString("ccType"));
						card.setCcNumber(rs.getString("ccNumber"));
						card.setCcOnName(rs.getString("ccOnName"));
						card.setCcExpirationMonth(rs
								.getString("ccExpirationMonth"));
						card.setCcExpirationYear(rs
								.getString("ccExpirationYear"));
						card.setCcCvvNumber(rs.getString("ccCvvNumber"));
						return card;
					}
				});
		return wrapUserCard;
	}

}
