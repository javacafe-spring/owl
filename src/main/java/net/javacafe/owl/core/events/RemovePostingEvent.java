package net.javacafe.owl.core.events;

public class RemovePostingEvent {
	private final String id;

	/**
	 * @param id
	 */
	public RemovePostingEvent(String id) {
		super();
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

}
