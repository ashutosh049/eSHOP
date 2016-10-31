package com.wrap.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wrap.daoimpl.WrapCategoryDaoImpl;
import com.wrap.daoimpl.WrapColumnDaoImpl;
import com.wrap.daoimpl.WrapOrderDaoImpl;
import com.wrap.daoimpl.WrapProductDaoImpl;
import com.wrap.daoimpl.WrapTabDaoImpl;
import com.wrap.daoimpl.WrapUserAddressDaoImpl;
import com.wrap.daoimpl.WrapUserDaoImpl;
import com.wrap.modal.MultipartWrapProduct;
import com.wrap.modal.WrapCategory;
import com.wrap.modal.WrapColumn;
import com.wrap.modal.WrapCustomerManagement;
import com.wrap.modal.WrapNavModal;
import com.wrap.modal.WrapOrder;
import com.wrap.modal.WrapProduct;
import com.wrap.modal.WrapTab;
import com.wrap.modal.WrapUser;
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
@SessionAttributes({ "wrapCart", "wrapUserSession" })
public class WrapAdminController {

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
	WrapCustomerManagement wrapCustomerManagement;
	@Autowired
	WrapTabDaoImpl wrapTabDaoImpl;
	@Autowired
	WrapColumnDaoImpl wrapColumnDaoImpl;
	@Autowired
	WrapCategoryDaoImpl wrapCategoryDaoImpl;
	@Autowired
	WrapProductDaoImpl wrapProductDaoImpl;
	@Autowired
	private ApplicationContext appContext;

	/*
	 * @Autowired WrapProductDaoImpl wrapProductDaoImpl;
	 */

	@RequestMapping({ "/admin-panel" })
	public ModelAndView helloWorld(final Model model, final Locale locale,
			HttpSession argHttpSession) {

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}

		model.addAttribute("wrapUser", wrapUser);

		return new ModelAndView("admin-panel");
	}

	@RequestMapping({ "/customer-management" })
	public ModelAndView customerManagement(final Model model,
			final Locale locale, HttpSession argHttpSession) {

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}

		model.addAttribute("wrapUser", wrapUser);

		wrapCustomerManagement = wrapUtil.getCustomerManagement();
		model.addAttribute("wrapCustomerManagement", wrapCustomerManagement);

		return new ModelAndView("customer-management");
	}

	@RequestMapping(value = "/removeCustomer", method = RequestMethod.POST)
	public String removeCustomer(@RequestParam("custName") String custName) {
		if (wrapUserDaoImpl.removeWrapUser(custName)) {
			// return new ModelAndView("");
			// return new ResponseEntity(HttpStatus.OK);
			return "SUCCESS";
		}
		// return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
		// return null;
		return "SUCCESS";
	}

	@RequestMapping(value = "/deactivateCustomer", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	public String deactivateCustomer(@RequestParam("custName") String custName) {
		if (wrapUserDaoImpl.updateUserStatus(false, custName)) {
			return "de-activated";
		}
		return null;
	}

	@RequestMapping(value = "/activateCustomer", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	public Object activateCustomer(@RequestParam("custName") String custName) {
		if (wrapUserDaoImpl.updateUserStatus(true, custName)) {
			return "activated";
		}
		return null;
	}

	@RequestMapping({ "/manageProductCategories" })
	public ModelAndView manageProductCategories(final Model model,
			final Locale locale, HttpSession argHttpSession) {

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}
		model.addAttribute("wrapUser", wrapUser);

		List<WrapTab> wrapTabList = wrapTabDaoImpl.getWrapTabs();
		model.addAttribute("wrapTabList", wrapTabList);

		return new ModelAndView("prod-cat-management");
	}

	@RequestMapping(value = "/updateProductCategories", method = RequestMethod.POST)
	public ResponseEntity<?> updateProductCategories(
			HttpSession argHttpSession, @RequestBody List<WrapTab> argWrapTab) {

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}
		boolean successTabUpdate = false;
		for (WrapTab tab : argWrapTab) {
			if (tab.getWrapTabId() != null && tab.getWrapTabName() != null
					&& String.valueOf(tab.getWrapTabSortOrder()) != null
					&& tab.getWrapTabId() != "" && tab.getWrapTabName() != ""
					&& String.valueOf(tab.getWrapTabSortOrder()) != "") {
				if (wrapTabDaoImpl.updateWrapTab(tab)) {
					successTabUpdate = true;
				} else {
					successTabUpdate = false;
				}
			}
		}
		if (successTabUpdate) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/createProductCategories", method = RequestMethod.POST)
	public @ResponseBody
	ResponseEntity<?> createProductCategories(final Model model,
			final Locale locale, HttpSession argHttpSession,
			@RequestBody List<WrapTab> argWrapTab) {

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}
		model.addAttribute("wrapUser", wrapUser);
		boolean successTabCreate = false;
		model.addAttribute("status", "ERROR");
		for (WrapTab tab : argWrapTab) {
			if (tab.getWrapTabId() != null && tab.getWrapTabName() != null
					&& String.valueOf(tab.getWrapTabSortOrder()) != null
					&& tab.getWrapTabId() != "" && tab.getWrapTabName() != ""
					&& String.valueOf(tab.getWrapTabSortOrder()) != "") {

				tab.setWrapTabId(tab.getWrapTabId()
						+ wrapTabDaoImpl.getWrapTabCount());

				if (wrapTabDaoImpl.createWrapTab(tab)) {
					successTabCreate = true;
				} else {
					successTabCreate = false;
				}
			}
		}
		if (successTabCreate) {
			model.addAttribute("status", "SUCCESS");
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	/************ | TAB | ****************/
	@RequestMapping(value = "/tabManagement", method = RequestMethod.GET)
	public ModelAndView tabManagement(final Model model, final Locale locale,
			HttpSession argHttpSession, @ModelAttribute WrapColumn argWrapColumn) {

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}
		model.addAttribute("wrapUser", wrapUser);

		List<WrapTab> wrapTabList = wrapTabDaoImpl.getWrapTabs();
		model.addAttribute("wrapTabList", wrapTabList);

		return new ModelAndView("prod-tab-management");
	}

	// create - createWrapTab
	@RequestMapping(value = "/createWrapTab", method = RequestMethod.POST)
	public ModelAndView createWrapTab(final Model model, final Locale locale,
			HttpSession argHttpSession, @ModelAttribute WrapTab argWrapTab) {
		if (argWrapTab.getWrapTabId() != null
				&& argWrapTab.getWrapTabId() != "") {
			wrapTabDaoImpl.createWrapTab(argWrapTab);
		}
		return new ModelAndView("redirect:tabManagement");
	}

	// updateWrapTab
	@RequestMapping(value = "/updateWrapTab", method = RequestMethod.POST)
	public ModelAndView updateWrapTab(final Model model, final Locale locale,
			HttpSession argHttpSession, @ModelAttribute WrapTab argWrapTab) {
		if (argWrapTab.getWrapTabId() != null
				&& argWrapTab.getWrapTabId() != "") {
			if (wrapTabDaoImpl.updateWrapTab(argWrapTab)) {
				if (wrapColumnDaoImpl.updateWrapColBYTabId(argWrapTab
						.getWrapTabId())) {
					if (wrapCategoryDaoImpl.updateWrapCat_TabId(argWrapTab
							.getWrapTabId())) {
						if (wrapProductDaoImpl
								.updateWrapProduct_TabId(argWrapTab
										.getWrapTabId())) {
						}
					}
				}
			}
		}
		return new ModelAndView("redirect:tabManagement");
	}

	@RequestMapping(value = "/deleteTab", method = RequestMethod.GET)
	public ModelAndView deleteTab(final Model model, final Locale locale,
			HttpSession argHttpSession,
			@RequestParam("wrapTabId") String wrapTabId) {
		wrapProductDaoImpl.deleteWrapProductByTabId(wrapTabId);
		wrapCategoryDaoImpl.deleteWrapCatByTabId(wrapTabId);
		wrapColumnDaoImpl.deleteWrapColByTabId(wrapTabId);
		wrapTabDaoImpl.deleteWrapTab(wrapTabId);
		return new ModelAndView("redirect:tabManagement");
	}

	/************ | TAB | ****************/

	/************ | COL(Section) | ****************/
	@RequestMapping({ "/manageProductSection" })
	public ModelAndView manageProductSection(final Model model,
			final Locale locale, HttpSession argHttpSession,
			@RequestParam("wrapTabId") String wrapTabId) {

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}
		model.addAttribute("wrapUser", wrapUser);
		model.addAttribute("wrapTabId", wrapTabId);
		List<WrapColumn> wrapColumnList = wrapColumnDaoImpl
				.getWrapColumnListByTabId(wrapTabId);
		model.addAttribute("wrapColumnList", wrapColumnList);

		return new ModelAndView("prod-sec-management");
	}

	@RequestMapping(value = "/updateWrapColForm", method = RequestMethod.POST)
	public ModelAndView updateWrapColForm(final Model model,
			final Locale locale, HttpSession argHttpSession,
			@ModelAttribute WrapColumn argWrapColumn) {

		if (argWrapColumn.getWrapTabId() != null
				&& argWrapColumn.getWrapColName() != null
				&& argWrapColumn.getWrapColId() != null
				&& String.valueOf(argWrapColumn.getWrapColSortOrder()) != null
				&& argWrapColumn.getWrapTabId() != ""
				&& argWrapColumn.getWrapColName() != ""
				&& argWrapColumn.getWrapColId() != ""
				&& String.valueOf(argWrapColumn.getWrapColSortOrder()) != "") {
			wrapColumnDaoImpl.updateWrapCol(argWrapColumn);
		}
		return new ModelAndView("redirect:manageProductSection?wrapTabId="
				+ argWrapColumn.getWrapTabId());
	}

	@RequestMapping(value = "/deleteCol", method = RequestMethod.GET)
	public ModelAndView deleteCol(final Model model, final Locale locale,
			HttpSession argHttpSession,
			@RequestParam("wrapTabId") String wrapTabId,
			@RequestParam("wrapColId") String wrapColId) {
		wrapProductDaoImpl.deleteWrapProductByTabColId(wrapTabId, wrapColId);
		wrapCategoryDaoImpl.deleteWrapCatByTabColId(wrapTabId, wrapColId);
		wrapColumnDaoImpl.deleteWrapColByTabColId(wrapTabId, wrapColId);
		return new ModelAndView("redirect:manageProductSection?wrapTabId="
				+ wrapTabId);
	}

	// create -
	@RequestMapping(value = "/createWrapCol", method = RequestMethod.POST)
	public ModelAndView createWrapCol(final Model model, final Locale locale,
			HttpSession argHttpSession, @ModelAttribute WrapColumn argWrapColumn) {
		if (argWrapColumn.getWrapTabId() != null
				&& argWrapColumn.getWrapColName() != null
				&& argWrapColumn.getWrapColId() != null
				&& String.valueOf(argWrapColumn.getWrapColSortOrder()) != null
				&& argWrapColumn.getWrapTabId() != ""
				&& argWrapColumn.getWrapColName() != ""
				&& argWrapColumn.getWrapColId() != ""
				&& String.valueOf(argWrapColumn.getWrapColSortOrder()) != "") {
			wrapColumnDaoImpl.createWrapCol(argWrapColumn);
		}
		return new ModelAndView("redirect:manageProductSection?wrapTabId="
				+ argWrapColumn.getWrapTabId());
	}

	/**************** | Category (carton) | *********************************/
	@RequestMapping("/viewProductCarton")
	public ModelAndView viewProductCarton(final Model model,
			final Locale locale, HttpSession argHttpSession,
			@RequestParam("wrapTabId") String wrapTabId,
			@RequestParam("wrapColId") String wrapColId) {

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}
		model.addAttribute("wrapUser", wrapUser);

		model.addAttribute("wrapTabId", wrapTabId);
		model.addAttribute("wrapColId", wrapColId);

		List<WrapCategory> wrapCategoryList = wrapCategoryDaoImpl
				.getWrapCategoriesByTabByColIds(wrapTabId, wrapColId);
		model.addAttribute("wrapCategoryList", wrapCategoryList);

		return new ModelAndView("prod-crtn-management");
	}

	@RequestMapping(value = "/createWrapCat", method = RequestMethod.POST)
	public ModelAndView createWrapCat(final Model model, final Locale locale,
			HttpSession argHttpSession,
			@ModelAttribute WrapCategory argWrapCategory) {

		wrapCategoryDaoImpl.createWrapCat(argWrapCategory);
		return new ModelAndView("redirect:viewProductCarton?wrapTabId="
				+ argWrapCategory.getWrapTabId() + "&wrapColId="
				+ argWrapCategory.getWrapColId());
	}

	@RequestMapping(value = "/updateWrapCat", method = RequestMethod.POST)
	public ModelAndView updateWrapCat(final Model model, final Locale locale,
			HttpSession argHttpSession,
			@ModelAttribute WrapCategory argWrapCategory) {
		wrapCategoryDaoImpl.updateWrapCat(argWrapCategory);
		return new ModelAndView("redirect:viewProductCarton?wrapTabId="
				+ argWrapCategory.getWrapTabId() + "&wrapColId="
				+ argWrapCategory.getWrapColId());
	}

	@RequestMapping(value = "/deleteWrapCat", method = RequestMethod.GET)
	public ModelAndView deleteWrapCat(final Model model, final Locale locale,
			HttpSession argHttpSession,
			@RequestParam("wrapTabId") String wrapTabId,
			@RequestParam("wrapColId") String wrapColId,
			@RequestParam("wrapCatId") String wrapCatId) {
		wrapProductDaoImpl.deleteWrapProductByTabColCatId(wrapTabId, wrapColId,
				wrapCatId);
		wrapCategoryDaoImpl.deleteWrapCatByTabColCatId(wrapTabId, wrapColId,
				wrapCatId);
		return new ModelAndView("redirect:viewProductCarton?wrapTabId="
				+ wrapTabId + "&wrapColId=" + wrapColId);
	}

	/******************** | CATEGORY | ***********************/

	/******************** | PRODUCT | ***********************/
	@RequestMapping("/viewProductCrtnItem")
	public ModelAndView viewProductCrtnItem(final Model model,
			final Locale locale, HttpSession argHttpSession,
			@RequestParam("wrapTabId") String wrapTabId,
			@RequestParam("wrapColId") String wrapColId,
			@RequestParam("wrapCatId") String wrapCatId) {

		WrapUser wrapUser = (WrapUser) httpSession
				.getAttribute("wrapUserSession");
		if (wrapUser == null) {
			String username = (String) httpSession.getAttribute("username");
			wrapUser = wrapUtil.getLoggedInUserInfo(username);
		}
		model.addAttribute("wrapUser", wrapUser);

		model.addAttribute("wrapTabId", wrapTabId);
		model.addAttribute("wrapColId", wrapColId);
		model.addAttribute("wrapCatId", wrapCatId);

		List<WrapProduct> WrapProductList = wrapProductDaoImpl
				.getWrapProductsByTabByColByCatIds(wrapTabId, wrapColId,
						wrapCatId);

		model.addAttribute("WrapProductList", WrapProductList);

		return new ModelAndView("prod-crtn-itm-management");
	}

	@RequestMapping("/updateProductCrtnItem")
	public ModelAndView updateProductCrtnItem(final Model model,
			final Locale locale, HttpSession argHttpSession,
			HttpServletRequest request,
			@ModelAttribute MultipartWrapProduct argWrapProduct)
					throws IllegalStateException, IOException {

		String filePath = "resources/images/wrapit-tab-structure/";

		String relPath = argWrapProduct.getWrapTabId() + "/"
				+ argWrapProduct.getWrapColId() + "/"
				+ argWrapProduct.getWrapCatId() + "/"
				+ argWrapProduct.getWrapProdImagePath();

		String newCompletePath = request.getServletContext().getRealPath("")
				+ "/" + filePath + relPath;

		File files = new File(newCompletePath);

		if (!files.exists()) {
			if (files.mkdirs()) {
				((MultipartFile) argWrapProduct.getWrapProdImage())
				.transferTo(new File(newCompletePath));
				argWrapProduct.setWrapProdImagePath(filePath + relPath);
				wrapProductDaoImpl.createWrapProduct(argWrapProduct);
			} else {
				System.out.println("Failed to create multiple directories!");
			}
		}

		// argWrapProduct.setWrapProdImagePath(filePath + relPath);
		wrapProductDaoImpl.updateWrapProduct(argWrapProduct);

		return new ModelAndView("redirect:viewProductCrtnItem?wrapTabId="
				+ argWrapProduct.getWrapTabId() + "&" + "wrapColId="
				+ argWrapProduct.getWrapColId() + "&wrapCatId="
				+ argWrapProduct.getWrapCatId());
	}

	@RequestMapping("/deleteProductCrtnItem")
	public ModelAndView deleteProductCrtnItem(final Model model,
			final Locale locale, HttpSession argHttpSession,
			@RequestParam("wrapTabId") String wrapTabId,
			@RequestParam("wrapColId") String wrapColId,
			@RequestParam("wrapCatId") String wrapCatId,
			@RequestParam("wrapProdId") String wrapProdId) {

		wrapProductDaoImpl.deleteWrapProduct(wrapProductDaoImpl
				.getWrapProductsByTabByColByCatByProdIds(wrapTabId, wrapColId,
						wrapCatId, wrapProdId));

		return new ModelAndView("redirect:viewProductCrtnItem?wrapTabId="
				+ wrapTabId + "&" + "wrapColId=" + wrapColId + "&wrapCatId="
				+ wrapCatId);
	}

	@RequestMapping("/createProductCrtnItem")
	public ModelAndView createProductCrtnItem(final Model model,
			final Locale locale, HttpSession argHttpSession,
			HttpServletRequest request,
			@ModelAttribute MultipartWrapProduct argWrapProduct)
					throws IllegalStateException, IOException {

		String filePath = "resources/images/wrapit-tab-structure/";

		String relPath = argWrapProduct.getWrapTabId() + "/"
				+ argWrapProduct.getWrapColId() + "/"
				+ argWrapProduct.getWrapCatId() + "/"
				+ argWrapProduct.getWrapProdImagePath();

		String newCompletePath = request.getServletContext().getRealPath("")
				+ "/" + filePath + relPath;

		File files = new File(newCompletePath);

		if (!files.exists()) {
			if (files.mkdirs()) {
				((MultipartFile) argWrapProduct.getWrapProdImage())
				.transferTo(new File(newCompletePath));
				argWrapProduct.setWrapProdImagePath(filePath + relPath);
				wrapProductDaoImpl.createWrapProduct(argWrapProduct);
			} else {
				System.out.println("Failed to create multiple directories!");
			}
		}
		return new ModelAndView("redirect:viewProductCrtnItem?wrapTabId="
				+ argWrapProduct.getWrapTabId() + "&" + "wrapColId="
				+ argWrapProduct.getWrapColId() + "&wrapCatId="
				+ argWrapProduct.getWrapCatId());
	}

	/******************** | PRODUCT | ***********************/

	/********************* | ADMIN PROFILE | ******************/
	/*
	 * @RequestMapping({ "/admin-profile" }) public ModelAndView
	 * adminProfile(final Model model, final Locale locale, HttpSession
	 * argHttpSession) {
	 * 
	 * WrapUser wrapUser = (WrapUser) httpSession
	 * .getAttribute("wrapUserSession"); if (wrapUser == null) { String username
	 * = (String) httpSession.getAttribute("username"); wrapUser =
	 * wrapUtil.getLoggedInUserInfo(username); } model.addAttribute("wrapUser",
	 * wrapUser);
	 * 
	 * wrapNavModal = wrapUtil.getWrapNavModal();
	 * model.addAttribute("wrapNavModal", wrapNavModal); String titleBar =
	 * (String) httpSession.getAttribute("titleBar"); if (titleBar == null ||
	 * titleBar == "") { titleBar = wrapUtil.getGuestUserTitleBar(); }
	 * model.addAttribute("titleBar", titleBar); WrapCart wrapCart = (WrapCart)
	 * argHttpSession.getAttribute("wrapCart"); if (wrapCart == null) { wrapCart
	 * = new WrapCart(); argHttpSession.setAttribute("wrapCart", wrapCart); }
	 * model.addAttribute("wrapCart", wrapCart); return new
	 * ModelAndView("admin-profile"); }
	 */

}
