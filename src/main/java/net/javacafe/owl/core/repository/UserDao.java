package net.javacafe.owl.core.repository;

import net.javacafe.owl.core.domain.User;

public interface UserDao {
	public User findByEmail(final String emailOrUsername);

	public String save(final User u);

	public void updateUsernameByEmail(final String username, final String email);
}
