package com.dsk.trackmyexpense.dispatcher;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.dsk.trackmyexpense.config.AppConfig;

/**
 * 
 * @author Krishna
 * This is just a replacement of the traditional, XML-based approach for web.xml to register the Spring's Dispatcher servlet
 */
public class TrackMyExpenseWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.scan("com.dsk.trackmyexpense");
		appContext.register(AppConfig.class);
		appContext.setServletContext(container);

		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
