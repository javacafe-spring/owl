package net.javacafe.owl.core.repository;

import net.javacafe.owl.core.domain.User;

public interface UserDao {
	public User findByEmailOrUsername(final String emailOrUsername);
}
