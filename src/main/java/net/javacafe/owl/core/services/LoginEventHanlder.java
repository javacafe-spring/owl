package net.javacafe.owl.core.services;

import net.javacafe.owl.core.domain.LoginUser;
import net.javacafe.owl.core.domain.User;
import net.javacafe.owl.core.events.LoginEvent;
import net.javacafe.owl.core.repository.UserDao;

public class LoginEventHanlder implements LoginService {
	UserDao userDao;

	public LoginEventHanlder(final UserDao o) {
		this.userDao = o;
	}

	@Override
	public LoginUser login(final LoginEvent e) {
		User u = userDao.findByEmailOrUsername(e.getEmailOrUsername());
		if (u == null) {
			throw new IllegalArgumentException(
					"not exist user by email or username : ".concat(e
							.getEmailOrUsername()));
		}
		if (!u.isMatchedPassword(e.getHashedPassword())) {
			throw new IllegalArgumentException(
					"not match password. check yours password.");
		}
		return new LoginUser(u);
	}
}
