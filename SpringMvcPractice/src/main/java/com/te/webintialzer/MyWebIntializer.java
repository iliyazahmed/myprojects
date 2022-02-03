package com.te.webintialzer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {AnnotationBasedConfigurationClass.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String [] {"/"};
	}

}
