package net.javacafe.owl.infra.repository;

import net.javacafe.owl.core.domain.User;
import net.javacafe.owl.core.repository.UserDao;

public class FakeUserDao implements UserDao {

	@Override
	public User findByEmail(final String emailOrUsername) {
		return new User("Tyler", "placebo2me@gmail.com", "1234");
	}

	@Override
	public String save(final User u) {
		return null;
	}

	@Override
	public void updateUsernameByEmail(final String username, String email) {
	}

}
