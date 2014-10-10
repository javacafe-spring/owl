package net.javacafe.owl.core.services;

import net.javacafe.owl.core.domain.Post;
import net.javacafe.owl.core.events.PostEvent;
import net.javacafe.owl.core.events.RemovePostingEvent;

public interface LoginUserService {
	public Post post(PostEvent e);

	public int remove(RemovePostingEvent e);
}
