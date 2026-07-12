package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entities.Comment;
import com.learnSphere.entities.Lesson;
import com.learnSphere.services.CommentService;
import com.learnSphere.services.LessonService;

@Controller
public class CommentController {
	@Autowired
	CommentService cservice;
	
	@Autowired
	LessonService lservice;
	
	@PostMapping("/addComment")
	public String addComment(
	        @RequestParam("commentId") int commentId,
	        @RequestParam("comment") String commentText,
	        @RequestParam("lessonId") int lessonId)
	{
	    Lesson lesson =
	            lservice.getLesson(lessonId);

	    Comment	 comment =
	            new Comment();

	    comment.setCommentId(commentId);

	    comment.setComment(commentText);

	    comment.setLesson(lesson);

	    cservice.addComment(comment);

	    return "studenthome";
	}
	
	@GetMapping("/viewComments")
	public String viewComments(@RequestParam("lessonId") int lessonId,
	                           Model model)
	{
	    Lesson lesson = lservice.getLesson(lessonId);

	    List<Comment> commentList =
	            cservice.getComments(lesson);

	    model.addAttribute("commentList", commentList);

	    return "viewcomments";
	}
}
