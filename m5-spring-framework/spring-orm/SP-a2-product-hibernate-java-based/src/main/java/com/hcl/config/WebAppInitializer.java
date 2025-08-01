package com.hcl.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create Dispatching Servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        // Set your configuration class
        dispatcherServlet.setContextConfigLocation(AppConfig.class.getName());

        // Register the DispatcherServlet
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/"); // Mapping the DispatcherServlet to root context
    }
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	
}
