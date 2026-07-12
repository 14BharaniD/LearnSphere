package com.learnSphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.learnSphere.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
