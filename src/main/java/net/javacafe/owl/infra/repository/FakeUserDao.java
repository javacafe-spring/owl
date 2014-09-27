package net.javacafe.owl.infra.repository;

import net.javacafe.owl.core.domain.User;
import net.javacafe.owl.core.repository.UserDao;

public class FakeUserDao implements UserDao {

	@Override
	public User findByEmailOrUsername(String emailOrUsername) {
		return new User("Tyler", "placebo2me@gmail.com", "1234");
	}

	@Override
	public int save(User u) {
		return 1;
	}

}
