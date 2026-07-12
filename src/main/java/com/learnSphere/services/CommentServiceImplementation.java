package com.learnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnSphere.entities.Comment;
import com.learnSphere.entities.Lesson;
import com.learnSphere.repositories.CommentRepository;

@Service
public class CommentServiceImplementation implements CommentService{

	@Autowired
	CommentRepository repo;
	@Override
	public String addComment(Comment comment) {
		repo.save(comment);
		return "comment added";
	}

	@Override
	public List<Comment> getComments(Lesson lesson) {
		return repo.findByLesson(lesson);
	}

	@Transactional
	@Override
	public void deleteComments(Lesson lesson) {
		repo.deleteByLesson(lesson);
	}

}
