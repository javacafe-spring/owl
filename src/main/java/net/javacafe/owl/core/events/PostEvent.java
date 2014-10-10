package net.javacafe.owl.core.events;

public class PostEvent {
	private final String content;

	/**
	 * @param content
	 */
	public PostEvent(String content) {
		super();
		this.content = content;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

}
