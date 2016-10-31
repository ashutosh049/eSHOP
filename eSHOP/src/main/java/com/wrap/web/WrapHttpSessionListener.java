package com.wrap.web;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


import com.codahale.metrics.Counter;
import com.wrap.monitoring.WrapMetricRegistrySingleton;

/**
 * @author ashu
 * 
 */
public class WrapHttpSessionListener implements HttpSessionListener {

	private final AtomicInteger activeSessions;

	private final Counter counterOfActiveSessions;

	public WrapHttpSessionListener() {
		super();

		activeSessions = new AtomicInteger();
		counterOfActiveSessions = WrapMetricRegistrySingleton.metrics
				.counter("web.sessions.active.count");
	}

	// API

	public final int getTotalActiveSession() {
		return activeSessions.get();
	}

	@Override
	public final void sessionCreated(final HttpSessionEvent event) {
		activeSessions.incrementAndGet();
		counterOfActiveSessions.inc();
	}

	@Override
	public final void sessionDestroyed(final HttpSessionEvent event) {
		activeSessions.decrementAndGet();
		counterOfActiveSessions.dec();
	}

}