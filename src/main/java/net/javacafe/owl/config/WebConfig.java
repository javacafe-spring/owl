package net.javacafe.owl.config;

import net.javacafe.owl.core.services.LoginService;
import net.javacafe.owl.restapi.controller.LoginController;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
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
	LoginController loginController(LoginService l) {
		return new LoginController(l);
	}
}
