package net.javacafe.owl.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Column(length = 64)
	private final String username;
	@Id
	private final String email;
	@Column(length = 1024)
	private final String hashedPassword;

	/**
	 * @param username
	 * @param email
	 * @param password
	 */
	public User(final String username, final String email, final String hashedPassword) {
		super();
		this.username = username;
		this.email = email;
		this.hashedPassword = hashedPassword;
	}

	/**
	 * @return the username
	 */
	public final String getUsername() {
		return username;
	}

	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	public boolean isMatchedPassword(final String hashedPassword) {
		return this.hashedPassword.equalsIgnoreCase(hashedPassword);
	}
}
