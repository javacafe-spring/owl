package net.javacafe.owl.config;

import net.javacafe.owl.core.repository.UserDao;
import net.javacafe.owl.core.services.LoginEventHanlder;
import net.javacafe.owl.core.services.LoginService;
import net.javacafe.owl.infra.repository.FakeUserDao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {

	@Bean
	public LoginService loginService(UserDao o) {
		return new LoginEventHanlder(o);
	}

	@Bean
	public UserDao userDao() {
		return new FakeUserDao();
	}
}
