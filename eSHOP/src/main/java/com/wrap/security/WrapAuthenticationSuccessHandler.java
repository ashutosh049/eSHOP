package com.wrap.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.wrap.modal.WrapUser;
import com.wrap.util.WrapUtil;

/**
 * @author ashu
 * 
 */
public class WrapAuthenticationSuccessHandler implements
AuthenticationSuccessHandler {
	protected final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	WrapUtil wrapUtil;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	protected WrapAuthenticationSuccessHandler() {
		super();
	}

	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request,
			final HttpServletResponse response,
			final Authentication authentication) throws IOException {
		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
	}

	protected void handle(final HttpServletRequest request,
			final HttpServletResponse response,
			final Authentication authentication) throws IOException {
		final String targetUrl = determineTargetUrl(authentication, request);

		if (response.isCommitted()) {
			logger.debug("Response has already been committed. Unable to redirect to "
					+ targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(final Authentication authentication,
			final HttpServletRequest request) {
		boolean isUser = false;
		boolean isAdmin = false;
		final Collection<? extends GrantedAuthority> authorities = authentication
				.getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
				isUser = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
				break;
			}
		}

		final HttpSession session = request.getSession();

		User authUser = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		WrapUser wrapUser = wrapUtil
				.getLoggedInUserInfo(authUser.getUsername());

		session.setAttribute("username", authUser.getUsername());
		session.setAttribute("authorities", authentication.getAuthorities());
		session.setAttribute("wrapUserSession", wrapUser);

		String titleBar = wrapUtil.getGuestUserTitleBar();

		session.setAttribute("errorMessage", null);

		if (isUser) {
			titleBar = wrapUtil.getLoggedInUserTitleBar(wrapUser.getFirstName());
			session.setAttribute("titleBar", titleBar);
			return "/account";
		} else if (isAdmin) {
			titleBar = wrapUtil.getAdminTitleBar(wrapUser.getFirstName());
			session.setAttribute("titleBar", titleBar);
			session.setAttribute("wrapUserSession", wrapUser);
			return "/admin-panel";
		} else {
			throw new IllegalStateException();
		}
	}

	/**
	 * Removes temporary authentication-related data which may have been stored
	 * in the session during the authentication process.
	 */
	protected final void clearAuthenticationAttributes(
			final HttpServletRequest request) {
		final HttpSession session = request.getSession(false);

		if (session == null) {
			return;
		}

		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public void setRedirectStrategy(final RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}
