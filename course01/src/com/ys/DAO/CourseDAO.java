package com.ys.DAO;

import com.ys.bean.CopyCourse;
import com.ys.bean.Course;

import java.sql.Connection;
import java.util.List;

public interface CourseDAO {
    List<Course>  getAll(Integer page);
    Course getOne(Connection conn, String id);
    Long getCount();
    void insert(Connection conn, Course course);
    void update(Connection conn, Course course);
    List<Course> getAll(Connection conn);
}
