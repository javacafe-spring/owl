package net.javacafe.owl.core.domain;

/**
 * 로그인 한 사용자에 대한 정보를 구성하는 클래스.
 * 
 * @since 2014.11.06
 * @author 곽대기
 * @see User
 */
public class LoginUser {
	private final User user;

	public LoginUser(final User u) {
		this.user = u;
	}

	public String getUsername() {
		return this.user.getUsername();
	}

	public String getEmail() {
		return this.user.getEmail();
	}
}
