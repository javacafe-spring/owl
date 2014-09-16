package net.javacafe.owl.user;

public class User {
	private final String username;
	private final String email;
	private final String hashedPassword;

	/**
	 * @param username
	 * @param email
	 * @param password
	 */
	public User(final String username, final String email,
			final String hashedPassword) {
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

	/**
	 * @return the hashedPassword
	 */
	public final boolean equalsHashedPassword(final String hashedPassword) {
		return this.hashedPassword.equalsIgnoreCase(hashedPassword);
	}

}
