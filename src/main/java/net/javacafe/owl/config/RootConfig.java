package net.javacafe.owl.config;

import net.javacafe.owl.core.repository.UserDao;
import net.javacafe.owl.core.services.UserEventHandler;
import net.javacafe.owl.core.services.UserService;
import net.javacafe.owl.infra.repository.FakeUserDao;

import org.springframework.context.annotation.Bean;

public class RootConfig {

	@Bean
	public UserService loginService(UserDao o) {
		return new UserEventHandler(o);
	}

	@Bean
	public UserDao userDao() {
		return new FakeUserDao();
	}
}
