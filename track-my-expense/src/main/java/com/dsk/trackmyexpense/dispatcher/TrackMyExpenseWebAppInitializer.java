package com.dsk.trackmyexpense.dispatcher;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.dsk.trackmyexpense.config.PersistenceConfig;
import com.dsk.trackmyexpense.config.ThymeleafConfig;
import com.dsk.trackmyexpense.filters.RequestLoggingFilter;

/**
 * 
 * @author Krishna
 * This is just a replacement of the traditional, XML-based approach for web.xml 
 * Register the Spring's Dispatcher servlet, filters, controllers etc.
 */
public class TrackMyExpenseWebAppInitializer implements WebApplicationInitializer {

	private static final Logger LOGGER = LogManager.getLogger(TrackMyExpenseWebAppInitializer.class);
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		LOGGER.info("TrackMyExpenseWebAppInitializer.onStartup");
		
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.scan("com.dsk.trackmyexpense");
		appContext.register(ThymeleafConfig.class);
		appContext.register(PersistenceConfig.class);
		appContext.setServletContext(servletContext);
		
		// Spring MVC front controller
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		// Registering Filters - The order of registration determines the order of their execution 
		servletContext.addFilter("RequestLoggingFilter", RequestLoggingFilter.class).addMappingForUrlPatterns(null, true, "/thymeleaf");
		
		/**
		 * This is useful because current browsers typically do not
		 * set a character encoding even if specified in the HTML page or form
		 */
		// Char encoding for all incoming requests. Set to UTF-8 
		FilterRegistration charEncodingfilterReg = servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
		charEncodingfilterReg.setInitParameter("encoding", "UTF-8");
		charEncodingfilterReg.setInitParameter("forceEncoding", "true");
		charEncodingfilterReg.addMappingForUrlPatterns(null, false, "/*");
		
		
	}

}
