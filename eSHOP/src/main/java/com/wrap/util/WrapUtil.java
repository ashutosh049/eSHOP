package com.wrap.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.sql.DataSource;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.wrap.daoimpl.WrapCategoryDaoImpl;
import com.wrap.daoimpl.WrapColumnDaoImpl;
import com.wrap.daoimpl.WrapProductDaoImpl;
import com.wrap.daoimpl.WrapTabDaoImpl;
import com.wrap.daoimpl.WrapUserAddressDaoImpl;
import com.wrap.daoimpl.WrapUserDaoImpl;
import com.wrap.imodal.WrapProductColor;
import com.wrap.imodal.WrapProductSize;
import com.wrap.modal.WrapCart;
import com.wrap.modal.WrapCartItem;
import com.wrap.modal.WrapCategory;
import com.wrap.modal.WrapColumn;
import com.wrap.modal.WrapCustomer;
import com.wrap.modal.WrapCustomerManagement;
import com.wrap.modal.WrapNavCat;
import com.wrap.modal.WrapNavCol;
import com.wrap.modal.WrapNavModal;
import com.wrap.modal.WrapNavTab;
import com.wrap.modal.WrapOrder;
import com.wrap.modal.WrapProduct;
import com.wrap.modal.WrapTab;
import com.wrap.modal.WrapUser;
import com.wrap.modal.WrapUserAddress;
import com.wrap.modal.WrapUserCard;

public class WrapUtil {

	private DataSource dataSource;

	@Autowired
	WrapNavModal wrapNavModal;

	@Autowired
	WrapTabDaoImpl wrapTabDaoImpl;

	@Autowired
	WrapColumnDaoImpl wrapColumnDaoImpl;

	@Autowired
	WrapCategoryDaoImpl wrapCategoryDaoImpl;

	@Autowired
	WrapProductDaoImpl wrapProductDaoImpl;

	@Autowired
	WrapUserDaoImpl wrapUserDaoImpl;

	@Autowired
	WrapUserAddressDaoImpl wrapUserAddressDaoImpl;

	@Autowired
	private VelocityEngine velocityEngine;
	@Autowired
	private IWrapMailSender mailsender;

	@Value("${APP_DEPLOY_URL}")
	private String APP_DEPLOY_URL;
	@Value("${SENDER_EMAIL}")
	private String SENDER_EMAIL;
	@Value("${SENDER_EMAIL_PASSWORD}")
	private String SENDER_EMAIL_PASSWORD;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}

	public WrapNavModal getWrapNavModal() {
		WrapNavModal navModal = new WrapNavModal();
		List<WrapNavTab> wrapNavTabList = new ArrayList<WrapNavTab>();
		for (WrapTab wrapTab : wrapTabDaoImpl.getWrapTabs()) {
			WrapNavTab navTab = new WrapNavTab();
			navTab.setWrapTab(wrapTab);
			navTab.setImage1Path(getNavImage1(wrapTab.getWrapTabId()));
			navTab.setImage2Path(getNavImage2(wrapTab.getWrapTabId()));
			List<WrapNavCol> wrapNavColList = new ArrayList<WrapNavCol>();
			for (WrapColumn wrapColumn : wrapColumnDaoImpl
					.getWrapColumnListByTabId(wrapTab.getWrapTabId())) {
				WrapNavCol navCol = new WrapNavCol();
				navCol.setWrapColumn(wrapColumn);
				List<WrapNavCat> wrapNavCatList = new ArrayList<WrapNavCat>();
				for (WrapCategory wrapCategory : wrapCategoryDaoImpl
						.getWrapCategoriesByTabByColIds(
								wrapColumn.getWrapTabId(),
								wrapColumn.getWrapColId())) {
					WrapNavCat navCat = new WrapNavCat();
					navCat.setWrapCategory(wrapCategory);
					wrapNavCatList.add(navCat);
				}
				navCol.setWrapNavCatList(wrapNavCatList);
				wrapNavColList.add(navCol);
			}
			navTab.setWrapNavColList(wrapNavColList);
			wrapNavTabList.add(navTab);
		}
		navModal.setWrapNavTabList(wrapNavTabList);
		return navModal;
	}

	public String getNavImage1(String tabId) {
		if (tabId.equals("WRAPTAB_1")) {
			return "resources/images/wrapit-tab-structure/Books & More/Books/Academics/a-short-history-of-nearly-everything-original-imae39.jpeg";
		} else if (tabId.equals("WRAPTAB_2")) {
			return "resources/images/wrapit-tab-structure/Featured/Laptops/Apple/apple-macbook-air-ultrabook-original-imae6qyjz3j9bx7y.jpeg";
		} else if (tabId.equals("WRAPTAB_3")) {
			return "resources/images/wrapit-tab-structure/Home & Furniture/Furniture/Beds/397-king-mango-wood-dream-furniture-india-grey-grey-original-imaegtg4qqbpacyx.jpeg";
		} else if (tabId.equals("WRAPTAB_4")) {
			return "resources/images/wrapit-tab-structure/Trending/Clothing/Jeans/268106797-grey-ms-newport-32-original-imaehmzn6dhzfmam.jpeg";
		}
		return "";
	}

	public String getNavImage2(String tabId) {
		if (tabId.equals("WRAPTAB_1")) {
			return "resources/images/wrapit-tab-structure/Books & More/Books/Children/the-bro-code-original-imadzmykjvgmcarn.jpeg";
		} else if (tabId.equals("WRAPTAB_2")) {
			return "resources/images/wrapit-tab-structure/Featured/TV/Full HD/sony-bravia-klv-22p413d-original-imaed8jtgujdkq4g.jpeg";
		} else if (tabId.equals("WRAPTAB_3")) {
			return "resources/images/wrapit-tab-structure/Home & Furniture/HomeDecor/Wall Decals/wt-6005-aquire-bedroom-romantic-rose-flowers-120-75cm-original-imae4g4mxbyzbszz.jpeg";
		} else if (tabId.equals("WRAPTAB_4")) {
			return "resources/images/wrapit-tab-structure/Trending/Footwear/Casual Shoes/green-white-goldmt-gazelle-adidas-originals-9-original-imaemawhmhvtzkhf.jpeg";
		}
		return "";
	}

	public List<WrapProduct> getWrapProducts(String argTabId, String argColId,
			String argCatId) {
		List<WrapProduct> wrapProductList = wrapProductDaoImpl
				.getWrapProductsByTabByColByCatIds(argTabId, argColId, argCatId);
		return wrapProductList;
	}

	public WrapProduct getWrapProducts(String argTabId, String argColId,
			String argCatId, String argProdId) {
		WrapProduct wrapProduct = wrapProductDaoImpl
				.getWrapProductsByTabByColByCatByProdIds(argTabId, argColId,
						argCatId, argProdId);
		return wrapProduct;
	}

	public double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public List<WrapProduct> freqBaughtTogetherWrapProductList(
			String argTabId, String argColId, String argCatId, int rowCount) {
		List<WrapProduct> wrapProductsList = wrapProductDaoImpl
				.getAlsoBaughtTogetherWrapProductsByTabByColIds(argTabId,
						argColId, argCatId, rowCount);

		return wrapProductsList;
	}

	public WrapCartItem castWrapProuctToWrapCartItem(
			WrapProduct argWrapProduct, int argItemCount, String argSize,
			String argColor) {
		WrapCartItem cartItem = new WrapCartItem();
		cartItem.setItemTabId(argWrapProduct.getWrapTabId());
		cartItem.setItemColId(argWrapProduct.getWrapColId());
		cartItem.setItemCatId(argWrapProduct.getWrapCatId());
		cartItem.setItemId(argWrapProduct.getWrapProdId());
		cartItem.setItemCount(argItemCount);
		cartItem.setItemName(argWrapProduct.getWrapProdName());
		cartItem.setItemDescription(argWrapProduct.getWrapProdDescription());
		cartItem.setItemSize(WrapProductSize.valueOf(argSize));
		if(argColor!=null && argColor!=""){
			cartItem.setItemColor(WrapProductColor.valueOf(argColor));
		}
		cartItem.setItemImagePath(argWrapProduct.getWrapProdImagePath());

		cartItem.setItemDiscountTotal(round(
				argWrapProduct.getWrapProdDiscountPercent(), 2));
		cartItem.setItemTaxTotal(round(argWrapProduct.getWrapProdTaxPercent(),
				2));
		cartItem.setItemShippingTotal(round(
				argWrapProduct.getWrapProdShippingChargePercent(), 2));
		cartItem.setItemSubToal(round(argWrapProduct.getWrapProdMarkedPrice(),
				2));
		cartItem.setItemMarkedPrice(round(
				argWrapProduct.getWrapProdMarkedPrice(), 2));
		return cartItem;
	}

	public Object roundVariables(Object object)
			throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = object.getClass().getFields();
		for (Field field : fields) {
			if (field.getType() == double.class) {
				field.getDouble(field);
			}
		}
		return object;

	}

	/**
	 * @param argWrapCart
	 * @return
	 */
	public Object roundObjectVariables(Object object) {
		if (object != null && object instanceof WrapCart) {
			WrapCart wrapCart = (WrapCart) object;
			wrapCart.setWrapCartDiscountTotal(round(
					wrapCart.getWrapCartDiscountTotal(), 2));
			wrapCart.setWrapCartPayable(round(wrapCart.getWrapCartPayable(), 2));
			wrapCart.setWrapCartShippingTotal(round(
					wrapCart.getWrapCartShippingTotal(), 2));
			wrapCart.setWrapCartSubToal(round(wrapCart.getWrapCartSubToal(), 2));
			wrapCart.setWrapCartTaxTotal(round(wrapCart.getWrapCartTaxTotal(),
					2));
			return wrapCart;
		} else if (object != null && object instanceof WrapCartItem) {
			WrapCartItem wrapCartItem = (WrapCartItem) object;
			wrapCartItem.setItemDiscountTotal(round(
					wrapCartItem.getItemDiscountTotal(), 2));
			wrapCartItem.setItemMarkedPrice(round(
					wrapCartItem.getItemMarkedPrice(), 2));
			wrapCartItem.setItemTaxTotal(round(wrapCartItem.getItemTaxTotal(),
					2));
			wrapCartItem
			.setItemSubToal(round(wrapCartItem.getItemSubToal(), 2));
			wrapCartItem.setItemShippingTotal(round(
					wrapCartItem.getItemShippingTotal(), 2));
			return wrapCartItem;
		}
		return object;
	}

	public String createUserName(String argFirstName) {
		int i = wrapUserDaoImpl.getUserAccountCount();
		String userName = "user" + (i + 1) + "_" + argFirstName;
		return userName;
	}

	public WrapUser getLoggedInUserInfo(String argUserName) {
		return wrapUserDaoImpl.getWrapUserByUsername(argUserName);
	}

	public List<WrapCustomer> getWrapCustomers() {
		return wrapUserDaoImpl.getWrapCustomers();
	}

	public WrapCustomerManagement getCustomerManagement() {
		WrapCustomerManagement customerManagement = new WrapCustomerManagement();
		customerManagement.setCustomerList(getWrapCustomers());
		customerManagement.setTotalUserCount(0);
		customerManagement.setActiveUserCount(0);
		customerManagement.setInactiveUserCount(0);
		return customerManagement;
	}

	public String getLoggedInUserTitleBar(String argFirstName) {
		return "<ul class='userMenu'> <li><a href='account'><span class='hidden-xs'> My Account</span> <i class='glyphicon glyphicon-user hide visible-xs '></i></a></li> <li class='dropdown hasUserMenu'><a href='#' class='dropdown-toggle' data-toggle='dropdown' aria-expanded='false'> <i class='glyphicon glyphicon-log-in hide visible-xs '></i> Hi, "
				+ argFirstName
				+ " <b class='caret'></b></a> <ul class='dropdown-menu'> <li><a href='account.html'> <i class='fa fa-user'></i> Account</a></li> <li><a href='account.html'><i class='fa fa fa-cog'></i> Profile</a></li> <li><a href='my-address.html'><i class='fa fa-map-marker'></i> Addresses</a></li> <li><a href='order-list.html'><i class='fa  fa-calendar'></i> Orders</a></li> <li><a href='wishlist.html' title='My wishlists'> <i class='fa fa-heart'></i> My wishlists </a></li> <li class='divider'></li> <li><a href='logout'><i class='fa  fa-sign-out'></i> Log Out</a></li> </ul> </li> </ul>";
	}

	public String getAdminTitleBar(String argFirstName) {
		return "<ul class='userMenu'> "
				+ "<li>"
				+ "<a href='account'>"
				+ "<span class='hidden-xs'> My Account</span>"
				+ " <i class='glyphicon glyphicon-user hide visible-xs '></i>"
				+ "</a>"
				+ "</li> "
				+ "<li>"
				+ "<a href='admin-panel'>"
				+ "<span class='hidden-xs'> Switch to Admin View</span>"
				+ " <i class='glyphicon glyphicon-user hide visible-xs '></i>"
				+ "</a>"
				+ "</li> "
				+ "<li class='dropdown hasUserMenu'>"
				+ "<a href='#' class='dropdown-toggle' data-toggle='dropdown' aria-expanded='false'>"
				+ " <i class='glyphicon glyphicon-log-in hide visible-xs '></i> Hi, "
				+ argFirstName
				+ " <b class='caret'></b></a>"
				+ " <ul class='dropdown-menu'> "
				+ "<li>"
				+ "<a href='account.html'><i class='fa fa fa-cog'></i> Profile</a>"
				+ "</li> "
				+ "<li>"
				+ "<a href='order-list.html'><i class='fa  fa-calendar'></i> Orders</a>"
				+ "</li> "
				+ "<li>"
				+ "<a href='wishlist.html' title='My wishlists'> <i class='fa fa-heart'></i> My wishlists </a>"
				+ "</li> "
				+ "<li class='divider'></li> "
				+ "<li>"
				+ "<a href='logout'><i class='fa  fa-sign-out'></i> Log Out</a>"
				+ "</li>" + " </ul>" + " </li>" + " </ul>";
	}

	public String getGuestUserTitleBar() {
		return "<ul class='userMenu'>  <li><a href='#' data-toggle='modal' data-target='#ModalLogin'> <span class='hidden-xs'>Sign In</span> <i class='glyphicon glyphicon-log-in hide visible-xs '> </i> </a></li> <li class='hidden-xs'><a href='#' data-toggle='modal' data-target='#ModalSignup'> Create Account </a> </li> </ul>";
	}

	public WrapOrder finalizeOrder(WrapOrder argWrapOrder) {

		WrapUser wrapUser = argWrapOrder.getWrapUser();
		WrapUserAddress wrapUserAddress = argWrapOrder.getWrapUserAddress();
		WrapUserCard wrapUserCard = argWrapOrder.getWrapUserCard();
		WrapCart wrapCart = argWrapOrder.getWrapCart();

		argWrapOrder.setOrderUserId(wrapUser.getUserName());
		argWrapOrder.setOrderAddressId(wrapUserAddress.getUser_address_id());
		argWrapOrder.setOrderCardId(wrapUserCard.getUserCCId());
		argWrapOrder.setOrderId("WRAP-ORDER_" + wrapUser.getUserName()
				+ new Date().getTime());
		argWrapOrder.setOrderDate(new Date());
		argWrapOrder.setOrderTotal(wrapCart.getWrapCartPayable());
		argWrapOrder.setOrderStatus("PENDING");

		return argWrapOrder;
	}

	/**
	 * @param argWrapUser
	 */
	public void sendSignupMail(WrapUser anEntity) {
		String activationURL = APP_DEPLOY_URL;
		anEntity.getFirstName();
		anEntity.getPassword();
		String path = "welcome.vm";
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("firstname", anEntity.getFirstName());
		model.put("username", anEntity.getUserName());
		model.put("password", anEntity.getPassword());
		model.put("ApplicationURL", activationURL + "/authenticate");

		String text = VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, path, "UTF-8", model);

		try {
			this.mailsender.sendJunkMail(SENDER_EMAIL, SENDER_EMAIL_PASSWORD,
					"Welcome to WRAPit!!", text, anEntity.getEmail(),
					"USER_MANAGEMENT");
		} catch (AddressException e) {

		} catch (MessagingException e) {
		}
	}
	
	/**
	 * @param argWrapUser
	 */
	public void sendOrderMail(WrapOrder wrapOrder,WrapUser anEntity,WrapCart argWrapCart) {
		String activationURL = APP_DEPLOY_URL;
		anEntity.getFirstName();
		anEntity.getPassword();
		String path = "order.vm";
		Map<String, Object> model = new HashMap<String, Object>();
		
		String itemList = "";
		
		for (WrapCartItem wrapCartItem : argWrapCart.getWrapCartItemlList()) {
			/*WrapProduct wrapProduct = wrapProductDaoImpl.getWrapProductsByTabByColByCatByProdIds(wrapCartItem.getItemTabId(),wrapCartItem.getItemColId(),
					wrapCartItem.getItemCatId(),wrapCartItem.getItemId());
			int newCount = wrapProduct.getWrapProdInStockItemsCount()-wrapCartItem.getItemCount();
			wrapProduct.setWrapProdInStockItemsCount(newCount);
			wrapProduct.setWrapProdIsInStock(newCount>=1?true:false);
			wrapProductDaoImpl.updateWrapProductCount(wrapProduct);*/
			
			itemList += "<tr>"+
					"<td"+
					"style='padding-left: 32px; vertical-align: top; font-size: 13px; line-height: 18px; font-family: Arial, sans-serif'>"+
					"<table id='x_itemDetails'"+
						"style='width: 95%; border-collapse: collapse'>"+
						"<tbody>"+
							"<tr>"+
								"<td class='x_photo'"+
									"style='width: 150px; text-align: center; padding: 16px 0 10px 0; vertical-align: top; font-size: 13px; line-height: 18px; font-family: Arial, sans-serif'>"+
									"<a href=''><img src='"+activationURL+"/"+wrapCartItem.getItemImagePath()+"' id='x_asin' style='border: 0'>"+
								"</a>"+
								"</td>"+
								"<td class='x_name'"+
									"style='color: rgb(102, 102, 102); padding: 10px 0 0 0; vertical-align: top; font-size: 13px; line-height: 18px; font-family: Arial, sans-serif'>"+
									"<a href='' target='_blank'"+
										"style='text-decoration: none; color: rgb(0, 102, 153); font: 12px/16px Arial, sans-serif'>"+wrapCartItem.getItemName()+
									"</a>"+
									"<br>"+
									wrapCartItem.getItemSize()+
									  "<br> Description: <a href=''"+
									"target='_blank'"+
									"style='text-decoration: none; color: rgb(0, 102, 153); font: 12px/16px Arial, sans-serif'>"+
									wrapCartItem.getItemDescription()+
										"</a> <br>"+
									"<div style=''>"+
										"<table border='0' cellspacing='4' cellpadding='0'"+
											"style='border-collapse: separate'>"+
											"<tbody style='vertical-align: bottom'>"+
												"<tr>"+
													"<td"+
														"style='vertical-align: top; font-size: 13px; line-height: 18px; font-family: Arial, sans-serif'>"+
													"</td>"+
													"<td"+
														"style='vertical-align: top; font-size: 13px; line-height: 18px; font-family: Arial, sans-serif'>"+
														"<a href='' target='_blank' title='Share on Facebook'"+
														"style='text-decoration: none; color: rgb(0, 102, 153); font: 12px/16px Arial, sans-serif'><i"+
															"class='x_a-icon x_a-icon-share-facebook'></i></a>"+
													"</td>"+
													"<td"+
														"style='vertical-align: top; font-size: 13px; line-height: 18px; font-family: Arial, sans-serif'>"+
														"<a href='' target='_blank' title='Share on Twitter'"+
														"style='text-decoration: none; color: rgb(0, 102, 153); font: 12px/16px Arial, sans-serif'><i"+
															"class='x_a-icon x_a-icon-share-twitter'></i></a>"+
													"</td>"+
													"<td"+
														"style='vertical-align: top; font-size: 13px; line-height: 18px; font-family: Arial, sans-serif'>"+
														"<a href='"+
							"target='"+
														"_blank' title='Pin it on Pinterest'"+
														"style='text-decoration: none; color: rgb(0, 102, 153); font: 12px/16px Arial, sans-serif'><i"+
															"class='x_a-icon x_a-icon-share-pinterest'></i></a>"+
													"</td>"+
												"</tr>"+
											"</tbody>"+
										"</table>"+
									"</div>"+
								"</td>"+
								"<td class='x_price'"+
									"style='width: 110px; text-align: right; font-size: 14px; padding: 10px 10px 0 0; vertical-align: top; line-height: 18px; font-family: Arial, sans-serif'>"+
									"<strong>$ "+wrapCartItem.getItemSubToal()+"</strong> <br>"+
								"</td>"+
							"</tr>"+
						"</tbody>"+
					"</table>"+
				"</td>"+
			"</tr>";
			
		}
		String jsp =  "<table border='0' cellpadding='10' cellspacing='0' width='800'>"+
	"<tr>"+
		"<td valign='top' style='padding-left: 0;'>"+
			"<div"+
				"style='background-color: #F9F9F9; border: 1px solid #BFBFBF; padding: 15px;'>"+
				"<h2 style='color: #1A4977'>WRAPit Order "+wrapOrder.getOrderId()+"</h2>"+

				"<h3 style='color: #1A4977'>"+
					"<strong>Dear "+anEntity.getFirstName()+",</strong>"+
				"</h3>"+
				"<p>Thank you for your order. We’ll send a confirmation when your"+
					"order ships.</p>"+

				"<h2>Order details</h2>"+
				"<table border='0' cellpadding='10' cellspacing='0' width='800'>"+
					"<tbody>"+
							itemList+
					"</tbody>"+

				"</table>"+
				"<p>"+
					"We appreciate your interest in WRAPit If you have any queries,"+
					"please write to us at <a href='mailto:support@wrapit.com'"+
						"style='font-style: italic' target='_blank'>support@wrapit.com</a><br>"+
					"<br>Regards,<br> WRAPit Team"+
				"</p>"+
			"</div>"+
		"</td>"+
	"</tr>"+
"</table>";
		
		
		model.put("WrapProductList", argWrapCart.getWrapCartItemlList());
		model.put("firstname", anEntity.getFirstName());
		model.put("username", anEntity.getUserName());
		model.put("password", anEntity.getPassword());
		model.put("ApplicationURL", activationURL + "/authenticate");

		String text = VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, path, "UTF-8", model);

		try {
			this.mailsender.sendJunkMail(SENDER_EMAIL, SENDER_EMAIL_PASSWORD,
					"Your order details.", jsp, anEntity.getEmail(),
					"USER_MANAGEMENT");
		} catch (AddressException e) {

		} catch (MessagingException e) {
		}
	}

}
