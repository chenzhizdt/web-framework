package org.instorm.configuration.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ImportResource(value = { "classpath:applicationContext.xml" })
@ComponentScan(basePackages = {"org.instorm"})
public class MvcConfig {
	@Bean  
    public ViewResolver getViewResolver() {  
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
        resolver.setPrefix("/WEB-INF/pages/");  
        resolver.setSuffix(".jsp");
        return resolver;  
    }
}
