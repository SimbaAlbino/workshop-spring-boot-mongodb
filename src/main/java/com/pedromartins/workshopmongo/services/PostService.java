package com.pedromartins.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedromartins.workshopmongo.domain.Post;
import com.pedromartins.workshopmongo.repository.PostRepository;
import com.pedromartins.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Post Post = repo.findById(id).orElse(null);
		if (Post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return Post;
	}
}
