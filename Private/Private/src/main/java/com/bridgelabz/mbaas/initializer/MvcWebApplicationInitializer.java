package com.bridgelabz.mbaas.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.bridgelabz.mbaas.config.MvcConfig;
import com.bridgelabz.mbaas.config.PersistConfig;
import com.bridgelabz.mbaas.config.SecurityConfig;
import com.bridgelabz.mbaas.config.SocialConfig;

public class MvcWebApplicationInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SecurityConfig.class, SocialConfig.class, PersistConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
