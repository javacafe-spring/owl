package net.javacafe.owl.infra.repository;

import net.javacafe.owl.core.domain.User;
import net.javacafe.owl.core.repository.UserDao;

public class FakeUserDao implements UserDao {

	@Override
	public User findByEmailOrUsername(final String emailOrUsername) {
		return new User("DEX", "tech@skyaperture.com", "1234");
	}

	@Override
	public int insert(final User u) {
		return 1;
	}

	@Override
	public int updateUsernameByEmail(final String username, String email) {
		return 1;
	}

}
