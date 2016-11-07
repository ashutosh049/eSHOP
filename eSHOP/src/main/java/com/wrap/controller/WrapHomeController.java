/**
 * 
 */
package com.wrap.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wrap.daoimpl.WrapCategoryDaoImpl;
import com.wrap.daoimpl.WrapOrderDaoImpl;
import com.wrap.daoimpl.WrapProductDaoImpl;
import com.wrap.daoimpl.WrapUserAddressDaoImpl;
import com.wrap.daoimpl.WrapUserDaoImpl;
import com.wrap.modal.WrapCart;
import com.wrap.modal.WrapCartItem;
import com.wrap.modal.WrapCategory;
import com.wrap.modal.WrapNavModal;
import com.wrap.modal.WrapOrder;
import com.wrap.modal.WrapProduct;
import com.wrap.modal.WrapUser;
import com.wrap.modal.WrapUserAddress;
import com.wrap.modal.WrapUserCard;
import com.wrap.util.WrapCalculator;
import com.wrap.util.WrapUtil;

/**
 * Basic controller class for redirection to home or index.<br>
 * <br>
 * Copyright (c) 2016 kumar.ashutosh@skillnetinc.com
 * 
 * @author ashu
 * @created Oct 10, 2016
 * @version $Revision$
 */

@Component
@ComponentScan("com.wrap.controller")
@RestController
@SessionAttributes({ "wrapCart", "wrapUserSession","wrapOrder" })
public class WrapHomeController {

	@Autowired
	WrapNavModal wrapNavModal;
	@Autowired
	WrapUtil wrapUtil;
	@Autowired
	WrapCalculator wrapCalculator;
	@Autowired
	WrapUserDaoImpl wrapUserDaoImpl;
	@Autowired
	WrapUserAddressDaoImpl wrapUserAddressDaoImpl;
	@Autowired
	private HttpSession httpSession;
	@Autowired
	WrapOrder wrapOrder;
	@Autowired
	WrapOrderDaoImpl wrapOrderDaoImpl;
	@Autowired
	WrapUserDaoImpl WrapUserDaoImpl;
	@Autowired
	WrapCategoryDaoImpl wrapCategoryDaoImpl;
	@Autowired
	WrapProductDaoImpl wrapProductDaoImpl;

	@RequestMapping({ "/", "/index" })
	public ModelAndView indexPage(final Model model, final Locale locale,
			HttpSession argHttpSession) {
		
		wrapNavModal = wrapUtil.getWrapNavModal();
		model.addAttribute("wrapNavModal", wrapNavModal);

		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);
		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		if (wrapCart == null) {
			wrapCart = new WrapCart();
			argHttpSession.setAttribute("wrapCart", wrapCart);
		}
		model.addAttribute("wrapCart", wrapCart);
		
		//New Arrivals-12
		List<WrapProduct> wrapNewAriivalsProductList =  wrapProductDaoImpl.getRandomProucts(12);
		model.addAttribute("wrapNewAriivalsProductList", wrapNewAriivalsProductList);
		//New Features
		List<WrapProduct> wrapNewFeaturesProductList =  wrapProductDaoImpl.getRandomProucts(4);
		model.addAttribute("wrapNewFeaturesProductList", wrapNewFeaturesProductList);
		//Featurred Products
		List<WrapProduct> wrapFeaturesProductList =  wrapProductDaoImpl.getRandomProucts(12);
		model.addAttribute("wrapFeaturesProductList", wrapFeaturesProductList);
		
		String errorMessage = (String) httpSession.getAttribute("errorMessage");
		model.addAttribute("errorMessage", errorMessage);

		return new ModelAndView("index");
	}

	@RequestMapping({ "/category" })
	public ModelAndView showCategory(final Model model, final Locale locale,
			HttpSession argHttpSession, @RequestParam("tabId") String tabId,
			@RequestParam("colId") String colId,
			@RequestParam("catId") String catId) {
		model.addAttribute("wrapNavModal", wrapNavModal);
		List<WrapProduct> wrapProductList = wrapUtil.getWrapProducts(tabId,
				colId, catId);
		model.addAttribute("wrapProductList", wrapProductList);
		
		WrapCategory wrapCategory = wrapCategoryDaoImpl.getWrapCategoryByTabColCatId(tabId, colId, catId);
		model.addAttribute("wrapCategory", wrapCategory);
		
		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		if (wrapCart == null) {
			wrapCart = new WrapCart();
			argHttpSession.setAttribute("wrapCart", wrapCart);
		}
		
		
		model.addAttribute("wrapCart", wrapCart);
		model.addAttribute("titleBar", titleBar);
		return new ModelAndView("category");
	}

	@RequestMapping({ "/productDetails" })
	public ModelAndView productDetails(final Model model, final Locale locale,
			HttpSession argHttpSession, @RequestParam("tabId") String tabId,
			@RequestParam("colId") String colId,
			@RequestParam("catId") String catId,
			@RequestParam("prodId") String prodId) {
		
		model.addAttribute("wrapNavModal", wrapNavModal);
		
		WrapCategory wrapCategory = wrapCategoryDaoImpl.getWrapCategoryByTabColCatId(tabId, colId, catId);
		model.addAttribute("wrapCategory", wrapCategory);
		
		WrapProduct wrapProduct = wrapUtil.getWrapProducts(tabId, colId, catId,prodId);
		model.addAttribute("wrapProduct", wrapProduct);
		
		
		
		/**
		 * ----------------------------
		 * May also like product list
		 * ----------------------------
		 * 
		 * May also like products are the products similar to the product
		 * currently viewed i.e. they are from the same ["TAB","COL","CAT"] as
		 * that of current item.
		 * 
		 * We just have to fetch a specified number of items (say 30 items)
		 * having similar specification as that of item/product currently
		 * viewed.
		 * 
		 * You may add that in future scope, we may collect user interests for
		 * particular items or particular category or group of categories that
		 * he is interested in and therby show him related products from that
		 * category.
		 ***/
		List<WrapProduct> mayAlsoLikeWrapProductList = wrapUtil.getWrapProducts(tabId, colId, catId);
		model.addAttribute("mayAlsoLikeWrapProductList",mayAlsoLikeWrapProductList);
		
		/**
		 * ------------------------------------------------
		 *  Frequently bought together product list(COMBO)
		 * ------------------------------------------------
		 * 
		 * Frequently bought together product list consists of interrelated
		 * items that are bought or may be bought together.
		 * 
		 * This list must contain the current item + 1 or many related items.
		 * These together makes the combo.
		 * 
		 *  An extra discount may be applied to this combo.
		 * 
		 * For our simplicity we have kept the max combo size to 3 i.e. there
		 * may be 1 or 2 extra related item with the current item. And have given an extra discount of 10%.
		 * 
		 * For this, we have taken a random value ranging from 1 to 2. 
		 * 
		 * example :-
		 * 
		 * if: random = 1
		 * 		Original Product + 1st Related Product.
		 * 
		 * if: random = 2
		 * 		Original Product + 1st Related Product + 2nd Related Product.
		 * 
		 * Then, have calculated the price and variables accordingly.
		 * 
		 ***/
		int randReqItemCount = new Random().nextInt(2) + 1;
		
		List<WrapProduct> freqBaughtTogetherWrapProductList = wrapUtil.freqBaughtTogetherWrapProductList(tabId, colId,catId, randReqItemCount);
		
		String freqBaughtTogetherWrapProductListDesc = "By these product together and get extra " + (randReqItemCount * 5) + " % discount";

		model.addAttribute("freqBaughtTogetherWrapProductList",freqBaughtTogetherWrapProductList);
		model.addAttribute("freqBaughtTogetherWrapProductListDesc",	freqBaughtTogetherWrapProductListDesc);

		double freqTotalMarkedPrice = 0;
		double freqTotalDiscountedPrice = 0;
		double freqTotalShipping = 0;
		double freqTotalDiscount = 0;
		double freqTotalotalTax = 0;
		double freqTotal = 0;

		for (WrapProduct freqProduct : freqBaughtTogetherWrapProductList) {
			freqTotalMarkedPrice += freqProduct.getWrapProdMarkedPrice();
			freqTotalDiscountedPrice+=freqProduct.getWrapProdDiscountedPrice();
		}

		freqTotalMarkedPrice += wrapProduct.getWrapProdMarkedPrice();
		freqTotalMarkedPrice = wrapUtil.round(freqTotalMarkedPrice, 2);
		
		freqTotalDiscountedPrice+=wrapProduct.getWrapProdDiscountedPrice();
		freqTotalDiscountedPrice = wrapUtil.round(freqTotalDiscountedPrice, 2);
		
		
		double extraTenPercentDiscountAmount = freqTotalDiscountedPrice*(0.1);
		extraTenPercentDiscountAmount = wrapUtil.round(extraTenPercentDiscountAmount, 2);
		
		freqTotal  = freqTotalDiscountedPrice - extraTenPercentDiscountAmount; 
		freqTotal = wrapUtil.round(freqTotal, 2);

		freqTotalDiscount = freqTotalMarkedPrice-freqTotal;
		freqTotalDiscount = wrapUtil.round(freqTotalDiscount, 2);

		model.addAttribute("freqTotalDiscountedPrice", freqTotalDiscountedPrice);
		model.addAttribute("freqTotalDiscount", freqTotalDiscount);
		model.addAttribute("freqTotalShipping", freqTotalShipping);
		model.addAttribute("freqTotalotalTax", freqTotalotalTax);
		model.addAttribute("freqTotal", freqTotal);
		
		/** frequently bought together product list ***/

		model.addAttribute("wrapCartItem", new WrapCartItem());

		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);
		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		if (wrapCart == null) {
			wrapCart = new WrapCart();
			argHttpSession.setAttribute("wrapCart", wrapCart);
		}
		model.addAttribute("wrapCart", wrapCart);
		return new ModelAndView("product-details");
	}

	@RequestMapping(value = {"/cart" }, method = RequestMethod.GET)
	public ModelAndView addNewItemToCart(final Model model,
			final Locale locale, HttpServletRequest request,
			HttpSession argHttpSession) throws IllegalArgumentException,
			IllegalAccessException {
		
		  WrapCart wrapCart = (WrapCart)
		  argHttpSession.getAttribute("wrapCart"); if(wrapCart==null){ wrapCart
		  = new WrapCart(); argHttpSession.setAttribute("wrapCart", wrapCart);
		  } model.addAttribute("wrapCart", wrapCart);
		  
		  String titleBar = (String)httpSession.getAttribute("titleBar");
		  if(titleBar==null || titleBar==""){ 
			  titleBar = wrapUtil.getGuestUserTitleBar(); 
		  } 
		  model.addAttribute("titleBar",
		  titleBar); model.addAttribute("wrapNavModal", wrapNavModal);
		  
		  return new ModelAndView("cart");		 
	}
	
	@RequestMapping(value = "/*", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView errorPageHandler(final Model model, final Locale locale,
			HttpSession argHttpSession) {
		 String titleBar = (String)httpSession.getAttribute("titleBar");
		  if(titleBar==null || titleBar==""){ 
			  titleBar = wrapUtil.getGuestUserTitleBar(); 
		  } 
		  model.addAttribute("titleBar",
		  titleBar); model.addAttribute("wrapNavModal", wrapNavModal);
		return new ModelAndView("error-page");
	}

	@RequestMapping(value = "/addToCart", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView addNewItemToCart1(final Model model,
			final Locale locale, HttpServletRequest request,
			HttpSession argHttpSession) throws IllegalArgumentException,
			IllegalAccessException {

		String itemTabId = (String) request.getParameter("itemTabId");
		String itemColId = (String) request.getParameter("itemColId");
		String itemCatId = (String) request.getParameter("itemCatId");
		String itemId = (String) request.getParameter("itemId");
		int itemCount = Integer.parseInt(request.getParameter("itemCount"));
		String itemSize = (String) request.getParameter("itemSize");
		String itemColor = (String) request.getParameter("itemColor");
		
		
		model.addAttribute("wrapNavModal", wrapNavModal);

		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		WrapCartItem cartItem = null;
		if (itemTabId != null && itemColId != null && itemCatId != null
				&& itemId != null) {
			WrapProduct wrapProduct = wrapUtil.getWrapProducts(itemTabId,
					itemColId, itemCatId, itemId);
			cartItem = wrapUtil.castWrapProuctToWrapCartItem(wrapProduct,
					itemCount, itemSize, itemColor);
		}
		if (wrapCart == null) {
			wrapCart = new WrapCart();
		}
		wrapCart = wrapCalculator.updateWrapCartItem(wrapCart, cartItem,
				itemCount);
		wrapCart = (WrapCart) wrapUtil.roundObjectVariables(wrapCart);
		model.addAttribute("wrapCart", wrapCart);
		argHttpSession.setAttribute("wrapCart", wrapCart);

		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);
		model.addAttribute("wrapNavModal", wrapNavModal);
		return new ModelAndView("cart");
	}

	@RequestMapping(value = "/removeFromCart", method = RequestMethod.GET)
	public ModelAndView removeFromCart(final Model model, final Locale locale,
			HttpServletRequest request, HttpSession argHttpSession)
			throws IllegalArgumentException, IllegalAccessException {

		String itemTabId = (String) request.getParameter("itemTabId");
		String itemColId = (String) request.getParameter("itemColId");
		String itemCatId = (String) request.getParameter("itemCatId");
		String itemId = (String) request.getParameter("itemId");
		int itemCount = Integer.parseInt(request.getParameter("itemCount"));
		String itemSize = (String) request.getParameter("itemSize");
		model.addAttribute("wrapNavModal", wrapNavModal);

		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		WrapCartItem cartItem = null;
		if (itemTabId != null && itemColId != null && itemCatId != null
				&& itemId != null) {
			WrapProduct wrapProduct = wrapUtil.getWrapProducts(itemTabId,
					itemColId, itemCatId, itemId);
			cartItem = wrapUtil.castWrapProuctToWrapCartItem(wrapProduct,
					itemCount, itemSize, null);
		}

		wrapCart = wrapCalculator.removeWrapCartItem(wrapCart, cartItem,
				itemCount);
		wrapCart = (WrapCart) wrapUtil.roundObjectVariables(wrapCart);
		model.addAttribute("wrapCart", wrapCart);
		argHttpSession.setAttribute("wrapCart", wrapCart);

		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);
		model.addAttribute("wrapNavModal", wrapNavModal);
		return new ModelAndView("cart");
	}

	// checkout

	@RequestMapping({ "/authenticate" })
	public ModelAndView authenticate(final Model model, final Locale locale,
			HttpSession argHttpSession) {
		model.addAttribute("wrapUser", new WrapUser());

		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		
		String errorMessage = (String) httpSession.getAttribute("errorMessage");
		model.addAttribute("errorMessage", errorMessage);
		httpSession.setAttribute("errorMessage",null);
				
		WrapUser wrapUser = (WrapUser) httpSession.getAttribute("wrapUserSession");
		String username = (String) httpSession.getAttribute("username");
		if (wrapUser == null || username == null || username == "") {
					model.addAttribute("titleBar", titleBar);
					model.addAttribute("wrapNavModal", wrapNavModal);
					return new ModelAndView("authenticate");
		}
		return new ModelAndView("redirect:index");
	}

	@RequestMapping(value = "/createUserAccount", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody
	WrapUser createUserAccount(@RequestBody WrapUser argWrapUser) {
		
		System.out.println("argWrapUser" + argWrapUser.getFirstName());
		
		String userName = wrapUtil.createUserName(argWrapUser.getFirstName());
		
		argWrapUser.setUserName(userName);
		
		if (argWrapUser.getFirstName() != null
				&& argWrapUser.getLastName() != null
				&& argWrapUser.getEmail() != null
				&& argWrapUser.getPassword() != null && argWrapUser.getFirstName() != ""
				&& argWrapUser.getLastName() != ""
				&& argWrapUser.getEmail() != ""
				&& argWrapUser.getPassword() != "") {

			if (wrapUserDaoImpl.createWrapUser(argWrapUser)) {
				if (wrapUserDaoImpl.createWrapUserCredentials(argWrapUser)) {
					if (wrapUserDaoImpl.createWrapUserRoles(argWrapUser)) {
						wrapUtil.sendSignupMail(argWrapUser);
						return argWrapUser;
					}
				}
			}
		}
		return null;
	}

	@RequestMapping(value = "/add-address", method = RequestMethod.GET)
	public ModelAndView addAddress(final Model model, final Locale locale,
			HttpSession argHttpSession) {
		wrapNavModal = wrapUtil.getWrapNavModal();
		model.addAttribute("wrapNavModal", wrapNavModal);
		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);
		model.addAttribute("wrapNavModal", wrapNavModal);

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}

		WrapUserAddress userAddress = wrapUserAddressDaoImpl
				.getWrapUserAddress(wrapUser.getUserName());

		if (userAddress == null) {
			userAddress = new WrapUserAddress();
		}
		model.addAttribute("wrapUserAddress", userAddress);

		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		if (wrapCart == null) {
			wrapCart = new WrapCart();
			argHttpSession.setAttribute("wrapCart", wrapCart);
		}
		model.addAttribute("wrapCart", wrapCart);

		return new ModelAndView("add-address");
	}

	@RequestMapping(value = "/addNewAddress", method = RequestMethod.POST)
	public ModelAndView addNewAddress(final Model model, final Locale locale,
			HttpSession argHttpSession,
			@ModelAttribute WrapUserAddress wrapUserAddress) {
		wrapNavModal = wrapUtil.getWrapNavModal();
		model.addAttribute("wrapNavModal", wrapNavModal);
		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);
		model.addAttribute("wrapNavModal", wrapNavModal);

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}

		int i = wrapUserAddressDaoImpl.getUserAccountCount(wrapUser
				.getUserName()) + 1;

		wrapUserAddress.setUserName(wrapUser.getUserName());
		wrapUserAddress.setUser_address_id(wrapUser.getUserName() + "_adrs_"
				+ i);

		WrapUserAddress userAddress = wrapUserAddressDaoImpl
				.getWrapUserAddress(wrapUser.getUserName());

		if (userAddress == null) {
			if (wrapUserAddressDaoImpl.createWrapUserAddress(wrapUserAddress)) {
				return new ModelAndView("account");
			}
		} else {
			if (wrapUserAddressDaoImpl.updateWrapUserAddress(wrapUserAddress)) {
				return new ModelAndView("account");
			}
		}

		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		if (wrapCart == null) {
			wrapCart = new WrapCart();
			argHttpSession.setAttribute("wrapCart", wrapCart);
		}
		model.addAttribute("wrapCart", wrapCart);

		return new ModelAndView("add-address");
	}

	@RequestMapping(value = "/my-address", method = RequestMethod.GET)
	public ModelAndView MyAddress(final Model model, final Locale locale,
			@ModelAttribute WrapUserAddress wrapUserAddress,
			HttpSession argHttpSession) {
		wrapNavModal = wrapUtil.getWrapNavModal();
		model.addAttribute("wrapNavModal", wrapNavModal);
		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);
		model.addAttribute("wrapNavModal", wrapNavModal);

		WrapUser wrapUser = (WrapUser) argHttpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}

		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		if (wrapCart == null) {
			wrapCart = new WrapCart();
			argHttpSession.setAttribute("wrapCart", wrapCart);
		}
		model.addAttribute("wrapCart", wrapCart);

		List<WrapUserAddress> addressList = wrapUserAddressDaoImpl
				.getWrapUserAddressList(wrapUser.getUserName());
		model.addAttribute("addressList", addressList);
		return new ModelAndView("my-address");

	}

	@RequestMapping({ "/account" })
	public ModelAndView myAccount(final Model model, final Locale locale,
			HttpSession argHttpSession) {
		wrapNavModal = wrapUtil.getWrapNavModal();
		model.addAttribute("wrapNavModal", wrapNavModal);
		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);
		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		if (wrapCart == null) {
			wrapCart = new WrapCart();
			argHttpSession.setAttribute("wrapCart", wrapCart);
		}
		model.addAttribute("wrapCart", wrapCart);
		return new ModelAndView("account");
	}

	// checkout----------------

	@RequestMapping({ "/checkout-11" })
	public ModelAndView checkout1(final Model model, final Locale locale,
			HttpSession argHttpSession) {
		wrapNavModal = wrapUtil.getWrapNavModal();
		model.addAttribute("wrapNavModal", wrapNavModal);
		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");

		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}

		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		if (wrapCart == null) {
			wrapCart = new WrapCart();
			argHttpSession.setAttribute("wrapCart", wrapCart);
		}
		model.addAttribute("wrapCart", wrapCart);

		WrapUserAddress wrapUserAddress = wrapUserAddressDaoImpl
				.getWrapUserAddress(wrapUser.getUserName());
		if (wrapUserAddress == null) {
			wrapUserAddress = new WrapUserAddress();
		}
		model.addAttribute("wrapUserAddress", wrapUserAddress);
		return new ModelAndView("checkout-1");
	}

	@RequestMapping({ "/checkout-4" })
	public ModelAndView checkout4(final Model model, final Locale locale,
			@ModelAttribute WrapUserAddress wrapUserAddress,
			HttpSession argHttpSession) {
		wrapNavModal = wrapUtil.getWrapNavModal();
		model.addAttribute("wrapNavModal", wrapNavModal);
		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}

		int i = wrapUserAddressDaoImpl.getUserAccountCount(wrapUser
				.getUserName()) + 1;

		wrapUserAddress.setUserName(wrapUser.getUserName());
		wrapUserAddress.setUser_address_id(wrapUser.getUserName() + "_adrs_"
				+ i);

		WrapUserAddress userAddress = wrapUserAddressDaoImpl
				.getWrapUserAddress(wrapUser.getUserName());

		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		if (wrapCart == null) {
			wrapCart = new WrapCart();
			argHttpSession.setAttribute("wrapCart", wrapCart);
		}
		model.addAttribute("wrapCart", wrapCart);

		wrapOrder= (WrapOrder)argHttpSession.getAttribute("wrapOrder");
		if(wrapOrder==null){
			wrapOrder = new WrapOrder();
		}
		
		if (userAddress == null) {
			if (wrapUserAddressDaoImpl.createWrapUserAddress(wrapUserAddress)) {
				model.addAttribute("wrapUserCard", new WrapUserCard());
				wrapOrder.setWrapUser(wrapUser);
				wrapOrder.setWrapUserAddress(wrapUserAddress);
				argHttpSession.setAttribute("wrapOrder",wrapOrder);
				httpSession.setAttribute("wrapOrder",wrapOrder);
				return new ModelAndView("checkout-4");
			}
		} else {
			if (wrapUserAddressDaoImpl.updateWrapUserAddress(wrapUserAddress)) {
				wrapOrder.setWrapUser(wrapUser);
				wrapOrder.setWrapUserAddress(userAddress);
				model.addAttribute("wrapUserCard", new WrapUserCard());
				argHttpSession.setAttribute("wrapOrder",wrapOrder);
				httpSession.setAttribute("wrapOrder",wrapOrder);
				return new ModelAndView("checkout-4");
			}
		}
		
		

		return new ModelAndView("checkout-1");
	}

	@RequestMapping({ "/checkout-5" })
	public ModelAndView checkout5(final Model model, final Locale locale,
			@ModelAttribute WrapUserCard wrapUserCard,
			HttpSession argHttpSession) {
		wrapNavModal = wrapUtil.getWrapNavModal();
		model.addAttribute("wrapNavModal", wrapNavModal);
		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);

		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		if (wrapCart == null) {
			wrapCart = new WrapCart();
			argHttpSession.setAttribute("wrapCart", wrapCart);
		}
		
		model.addAttribute("wrapCart", wrapCart);
		
		wrapOrder= (WrapOrder)argHttpSession.getAttribute("wrapOrder");
		if(wrapOrder==null){
			wrapOrder= (WrapOrder)httpSession.getAttribute("wrapOrder");
			if(wrapOrder==null){
				wrapOrder = new WrapOrder();
			}
		}
		
//		WrapUserAddress userAddress = argHttpSession.getAttribute("wrapOrder");
		
		argHttpSession.setAttribute("wrapOrder",wrapOrder);
		
		wrapOrder.setWrapCart(wrapCart);

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}

		wrapUserCard.setUserName(wrapUser.getUserName());
		wrapUserCard.setUserCCId("CC_" + wrapUser.getUserName() + "_"
				+ new Date().getTime());
		wrapUserCard.setCcType("CREDIT CARD");
		wrapOrder.setWrapUserCard(wrapUserCard);
		argHttpSession.setAttribute("wrapOrder",wrapOrder);
		httpSession.setAttribute("wrapOrder",wrapOrder);
		return new ModelAndView("checkout-5");
	}

	@RequestMapping({ "/thanks-for-order" })
	public ModelAndView thanksForOrder(final Model model, final Locale locale,
			HttpSession argHttpSession) {
		wrapNavModal = wrapUtil.getWrapNavModal();
		model.addAttribute("wrapNavModal", wrapNavModal);
		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}
		
		wrapOrder= (WrapOrder)argHttpSession.getAttribute("wrapOrder");
		if(wrapOrder==null){
			wrapOrder= (WrapOrder)httpSession.getAttribute("wrapOrder");
			if(wrapOrder==null){
				wrapOrder = new WrapOrder();
			}
		}

		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		if (wrapCart == null) {
			wrapCart = new WrapCart();
			argHttpSession.setAttribute("wrapCart", wrapCart);
		}
		model.addAttribute("wrapCart", wrapCart);
		
		wrapOrder.setWrapCart(wrapCart);
		
		wrapUtil.finalizeOrder(wrapOrder);
		argHttpSession.setAttribute("wrapOrder",wrapOrder);
		argHttpSession.setAttribute("wrapOrder",wrapOrder);
		if (wrapOrderDaoImpl.createWrapOrder(wrapOrder)) {
			for (WrapCartItem wrapCartItem : wrapCart.getWrapCartItemlList()) {
				WrapProduct wrapProduct = wrapProductDaoImpl.getWrapProductsByTabByColByCatByProdIds(wrapCartItem.getItemTabId(),wrapCartItem.getItemColId(),
						wrapCartItem.getItemCatId(),wrapCartItem.getItemId());
				int newCount = wrapProduct.getWrapProdInStockItemsCount()-wrapCartItem.getItemCount();
				wrapProduct.setWrapProdInStockItemsCount(newCount);
				wrapProduct.setWrapProdIsInStock(newCount>=1?true:false);
				wrapProductDaoImpl.updateWrapProductCount(wrapProduct);
			}
			wrapUtil.sendOrderMail(wrapOrder,wrapUser, wrapCart);
			wrapCart = new WrapCart();
			model.addAttribute("wrapOrder", wrapOrder);
			return new ModelAndView("thanks-for-order");
		}
		return new ModelAndView("checkout-5");

	}

	@RequestMapping({ "/order-list" })
	public ModelAndView userOrderList(final Model model, final Locale locale,
			HttpSession argHttpSession) {
		wrapNavModal = wrapUtil.getWrapNavModal();
		model.addAttribute("wrapNavModal", wrapNavModal);
		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);
		model.addAttribute("wrapNavModal", wrapNavModal);
		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		if (wrapCart == null) {
			wrapCart = new WrapCart();
			argHttpSession.setAttribute("wrapCart", wrapCart);
		}
		model.addAttribute("wrapCart", wrapCart);

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}

		List<WrapOrder> wrapOrderList = wrapOrderDaoImpl.getWrapOrder(wrapUser
				.getUserName());
		model.addAttribute("wrapOrderList", wrapOrderList);

		return new ModelAndView("order-list");

	}

	@RequestMapping({ "/user-information" })
	public ModelAndView userPersonalInformation(final Model model,
			final Locale locale, HttpSession argHttpSession) {
		wrapNavModal = wrapUtil.getWrapNavModal();
		model.addAttribute("wrapNavModal", wrapNavModal);
		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);
		model.addAttribute("wrapNavModal", wrapNavModal);
		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		if (wrapCart == null) {
			wrapCart = new WrapCart();
			argHttpSession.setAttribute("wrapCart", wrapCart);
		}
		model.addAttribute("wrapCart", wrapCart);

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}
		model.addAttribute("wrapUser", wrapUser);

		return new ModelAndView("user-information");

	}

	@RequestMapping({ "/updateUserPersonalInfo" })
	public ModelAndView updateUserPersonalInfo(final Model model,
			final Locale locale, HttpSession argHttpSession,
			@ModelAttribute WrapUser argWrapUser) {
		wrapNavModal = wrapUtil.getWrapNavModal();
		model.addAttribute("wrapNavModal", wrapNavModal);
		String titleBar = (String) httpSession.getAttribute("titleBar");
		if (titleBar == null || titleBar == "") {
			titleBar = wrapUtil.getGuestUserTitleBar();
		}
		model.addAttribute("titleBar", titleBar);
		model.addAttribute("wrapNavModal", wrapNavModal);
		WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
		if (wrapCart == null) {
			wrapCart = new WrapCart();
			argHttpSession.setAttribute("wrapCart", wrapCart);
		}
		model.addAttribute("wrapCart", wrapCart);

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}

		if (argWrapUser.getFirstName() != null
				&& argWrapUser.getLastName() != null
				&& argWrapUser.getEmail() != null) {
			argWrapUser.setUserName(wrapUser.getUserName());
			if (WrapUserDaoImpl.updateWrapUserInfo(argWrapUser)) {
				wrapUser = argWrapUser;
				httpSession.setAttribute("wrapUserSession", wrapUser);
			}
		}
		model.addAttribute("wrapUser", wrapUser);

		return new ModelAndView("user-information");

	}
	
	
	@RequestMapping(value="/addComboToCart", method = RequestMethod.POST)
	public ModelAndView addComboToCart(final Model model, final Locale locale,
			HttpSession argHttpSession,
			@RequestBody List<WrapProduct> wrapProductList) {
		
		for (WrapProduct wrapProduct : wrapProductList) {
			WrapCartItem cartItem = null;
			if (wrapProduct.getWrapTabId() != null && wrapProduct.getWrapColId() != null && wrapProduct.getWrapCatId() != null
					&& wrapProduct.getWrapProdId() != null) {
				WrapProduct product = wrapUtil.getWrapProducts(wrapProduct.getWrapTabId(),
						wrapProduct.getWrapColId(), wrapProduct.getWrapCatId(), wrapProduct.getWrapProdId());
				cartItem = wrapUtil.castWrapProuctToWrapCartItem(product,1, product.getWrapProdSize().toString(), product.getWrapProdColor().toString());
			}
			WrapCart wrapCart = (WrapCart) argHttpSession.getAttribute("wrapCart");
			if (wrapCart == null) {
				wrapCart = new WrapCart();
			}
			wrapCart = wrapCalculator.updateWrapCartItem(wrapCart, cartItem,1);
			wrapCart = (WrapCart) wrapUtil.roundObjectVariables(wrapCart);
		}
		
		return null;
	}
	
	//--------ONE PAGE CHECKOUT-----------
	@RequestMapping({ "/checkout-1" })
	public ModelAndView onePageCheckout(final Model model, final Locale locale,HttpSession argHttpSession) {
		
		WrapUser wrapUser = (WrapUser) argHttpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}
		
		List<WrapUserAddress> addressList = wrapUserAddressDaoImpl
				.getWrapUserAddressList(wrapUser.getUserName());
		
		model.addAttribute("addressList", addressList);
		model.addAttribute("wrapBillingAddress",  new WrapUserAddress());
		model.addAttribute("wrapShippingAddress",  new WrapUserAddress());
		
		return new ModelAndView("one-page-checkout");
	}


}
