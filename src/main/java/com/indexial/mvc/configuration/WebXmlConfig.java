package com.indexial.mvc.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXmlConfig implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
		 webCtx.register(SpringConfig.class);
	        
			webCtx.setServletContext(servletContext);
	        
			ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webCtx));
	        
			servlet.setLoadOnStartup(1);
			servlet.addMapping("/");		
		
	}

}
