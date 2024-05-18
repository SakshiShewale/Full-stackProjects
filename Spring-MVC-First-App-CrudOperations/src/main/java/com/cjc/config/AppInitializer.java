package com.cjc.config;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class AppInitializer implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		System.out.println("On Startup: Method Called");
		AnnotationConfigWebApplicationContext Context = new AnnotationConfigWebApplicationContext();
	   Context.register(BeanConfig.class);
	   Context.setServletContext(servletContext);
	   
	   ServletRegistration.Dynamic reg= servletContext.addServlet("dispatcher",new DispatcherServlet(Context)); 
	   reg.addMapping("/");
	
	}

}
