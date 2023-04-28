package com.ani.course.Demo.Dao;

import com.ani.course.Demo.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course,Long>
{

}
