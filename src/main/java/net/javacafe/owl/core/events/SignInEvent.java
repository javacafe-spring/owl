package net.javacafe.owl.core.events;

public class SignInEvent {
	private String email;
	private String hashedPassword;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the hashedPassword
	 */
	public String getHashedPassword() {
		return hashedPassword;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param hashedPassword
	 *            the hashedPassword to set
	 */
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

}
