package net.javacafe.owl.infra.repository;

import net.javacafe.owl.core.domain.User;
import net.javacafe.owl.core.repository.UserDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class LocalUserDao implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User findByEmail(final String email) {
		Session s = sessionFactory.openSession();
		try {
			return (User) s.get(User.class, email);
		} finally {
			s.close();
		}
	}

	@Override
	public String save(final User u) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		try {
			return (String) s.save(u);
		} finally {
			tx.commit();
			s.close();
		}
	}

	@Override
	public void updateUsernameByEmail(final String username, final String email) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		try {
			User u = (User) s.get(User.class, email);
			u.setUsername(username);
			s.update(email, username);
		} finally {
			tx.commit();
			s.close();
		}

	}

}
