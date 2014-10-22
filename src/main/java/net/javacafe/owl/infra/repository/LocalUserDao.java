package net.javacafe.owl.infra.repository;

import net.javacafe.owl.core.domain.User;
import net.javacafe.owl.core.repository.UserDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class LocalUserDao implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User findByEmailOrUsername(String emailOrUsername) {
		return (User) getCurrentSession().get(User.class, emailOrUsername);
	}

	@Override
	public int insert(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUsernameByEmail(String username, String email) {
		// TODO Auto-generated method stub
		return 0;
	}

}
