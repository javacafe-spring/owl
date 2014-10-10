package net.javacafe.owl.config;

import net.javacafe.owl.core.repository.PostDao;
import net.javacafe.owl.core.repository.UserDao;
import net.javacafe.owl.core.services.LoginUserEventHandler;
import net.javacafe.owl.core.services.LoginUserService;
import net.javacafe.owl.core.services.UserEventHandler;
import net.javacafe.owl.core.services.UserService;
import net.javacafe.owl.infra.repository.FakePostDao;
import net.javacafe.owl.infra.repository.FakeUserDao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RootConfig {

	@Bean
	public UserService userEventService(UserDao o) {
		return new UserEventHandler(o);
	}

	@Bean
	public UserDao userDao() {
		return new FakeUserDao();
	}

	@Bean
	public PostDao postDao() {
		return new FakePostDao();
	}

	@Bean
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public LoginUserService loginUserService(PostDao o) {
		return new LoginUserEventHandler(o);
	}
}
