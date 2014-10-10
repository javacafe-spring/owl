package net.javacafe.owl.config;

import net.javacafe.owl.core.services.UserService;
import net.javacafe.owl.restapi.controller.UserController;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver configureViewResolver() {
		InternalResourceViewResolver c = new InternalResourceViewResolver();
		c.setPrefix("/WEB-INF/views/");
		c.setSuffix(".jsp");
		return c;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer c) {
		c.enable();
	}

	@Bean
	UserController userController(UserService l) {
		return new UserController(l);
	}
}
