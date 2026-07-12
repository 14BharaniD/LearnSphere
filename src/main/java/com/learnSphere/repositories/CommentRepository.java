package com.learnSphere.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.learnSphere.entities.Comment;
import com.learnSphere.entities.Lesson;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
		List<Comment> findByLesson(Lesson lesson);
		
		@Modifying
		@Transactional
		void deleteByLesson(Lesson lesson);
		
}
