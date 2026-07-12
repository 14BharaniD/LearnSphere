package com.learnSphere.services;

import java.util.List;

import com.learnSphere.entities.Comment;
import com.learnSphere.entities.Lesson;

public interface CommentService {
	String addComment(Comment comment);
	
	List<Comment> getComments(Lesson lesson);
	
	void deleteComments(Lesson lesson);
}
