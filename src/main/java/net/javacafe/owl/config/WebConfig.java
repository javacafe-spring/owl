package net.javacafe.owl.config;

import java.util.ArrayList;
import java.util.List;

import net.javacafe.owl.core.services.UserService;
import net.javacafe.owl.restapi.controller.LoginUserController;
import net.javacafe.owl.restapi.controller.UserController;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true).defaultContentType(MediaType.TEXT_HTML);
	}

	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager m) {
		List<ViewResolver> l = new ArrayList<ViewResolver>();
		l.add(new JsonViewResolver());

		InternalResourceViewResolver rs = new InternalResourceViewResolver();
		rs.setPrefix("WEB-INF/views/");
		rs.setSuffix(".jsp");
		rs.setOrder(2);
		l.add(rs);

		ContentNegotiatingViewResolver r = new ContentNegotiatingViewResolver();
		r.setContentNegotiationManager(m);
		r.setViewResolvers(l);
		return r;
	}

	@Bean
	UserController userController(UserService s) {
		return new UserController(s);
	}

	@Bean
	LoginUserController loginUserController() {
		return new LoginUserController();
	}
}
