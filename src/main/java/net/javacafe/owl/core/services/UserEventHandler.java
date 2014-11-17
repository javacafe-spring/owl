package net.javacafe.owl.core.services;

import net.javacafe.owl.core.domain.LoginUser;
import net.javacafe.owl.core.domain.User;
import net.javacafe.owl.core.events.ModifyUsernameEvent;
import net.javacafe.owl.core.events.SignInEvent;
import net.javacafe.owl.core.events.SignUpEvent;
import net.javacafe.owl.core.repository.UserDao;

public class UserEventHandler implements UserService {
	UserDao userDao;

	public UserEventHandler(final UserDao o) {
		this.userDao = o;
	}

	@Override
	public LoginUser signIn(final SignInEvent e) {
		User u = userDao.findByEmail(e.getEmail());
		if (u == null) {
			throw new IllegalArgumentException("not exist user by email or username : ".concat(e.getEmail()));
		}
		if (!u.isMatchedPassword(e.getHashedPassword())) {
			throw new IllegalArgumentException("not match password. check yours password.");
		}
		return new LoginUser(u);
	}

	@Override
	public String signUp(final SignUpEvent e) {
		User u = new User(e.getEmail(), e.getUsername(), e.getHashedPassword());
		return userDao.save(u);
	}

	@Override
	public void modifyUsername(final ModifyUsernameEvent e) {
		userDao.updateUsernameByEmail(e.getUpdatableUsername(), e.getEmail());
	}
}
