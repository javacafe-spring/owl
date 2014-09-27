package net.javacafe.owl.core.services;

import net.javacafe.owl.core.domain.LoginUser;
import net.javacafe.owl.core.domain.User;
import net.javacafe.owl.core.events.SignInEvent;
import net.javacafe.owl.core.events.SignUpEvent;
import net.javacafe.owl.core.repository.UserDao;

public class UserEventHanlder implements UserService {
	UserDao userDao;

	public UserEventHanlder(final UserDao o) {
		this.userDao = o;
	}

	@Override
	public LoginUser signIn(final SignInEvent e) {
		User u = userDao.findByEmailOrUsername(e.getEmailOrUsername());
		if (u == null) {
			throw new IllegalArgumentException("not exist user by email or username : ".concat(e.getEmailOrUsername()));
		}
		if (!u.isMatchedPassword(e.getHashedPassword())) {
			throw new IllegalArgumentException("not match password. check yours password.");
		}
		return new LoginUser(u);
	}

	@Override
	public User signUp(SignUpEvent e) {
		User u = new User(e.getEmail(), e.getUsername(), e.getHashedPassword());
		if (userDao.save(u) > 0) {
			return u;
		}
		return null;
	}
}
