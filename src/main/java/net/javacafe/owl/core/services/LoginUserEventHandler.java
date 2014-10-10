package net.javacafe.owl.core.services;

import net.javacafe.owl.core.domain.Post;
import net.javacafe.owl.core.events.PostEvent;
import net.javacafe.owl.core.events.RemovePostingEvent;
import net.javacafe.owl.core.repository.PostDao;

public class LoginUserEventHandler implements LoginUserService {
	private final PostDao postDao;

	public LoginUserEventHandler(PostDao o) {
		this.postDao = o;
	}

	@Override
	public Post post(PostEvent e) {
		Post p = new Post(e.getContent());
		postDao.insert(p);
		return p;
	}

	@Override
	public int remove(RemovePostingEvent e) {
		return postDao.delete(e.getId());
	}

}
