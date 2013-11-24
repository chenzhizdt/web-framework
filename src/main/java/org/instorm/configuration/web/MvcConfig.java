package org.instorm.configuration.web;

import org.instorm.service.LoginService;
import org.instorm.service.impl.LoginServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.instorm"})
public class MvcConfig {
	@Bean  
    public ViewResolver getViewResolver() {  
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
        resolver.setPrefix("/WEB-INF/pages/");  
        resolver.setSuffix(".jsp");
        return resolver;  
    }
	@Bean
	public LoginService loginService(){
		return new LoginServiceImpl();
	}
}
