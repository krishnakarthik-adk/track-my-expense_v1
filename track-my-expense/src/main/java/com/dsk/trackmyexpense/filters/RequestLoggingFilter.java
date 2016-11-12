package com.dsk.trackmyexpense.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestLoggingFilter implements Filter{

	private static final Logger LOGGER = LogManager.getLogger(RequestLoggingFilter.class);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest requestReceived = (HttpServletRequest) request;
		
		// Log the request URI received
		LOGGER.warn("Request URI Received ----> " + requestReceived.getRequestURI());
		
		// Log the IP address from where the request originated
		LOGGER.warn("Request originated from: IP Address ----> " + request.getRemoteAddr());
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		LOGGER.info("Calling request logging filter to service.");
	}

}
