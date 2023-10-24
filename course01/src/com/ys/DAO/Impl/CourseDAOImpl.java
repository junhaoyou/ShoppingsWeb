package com.ys.DAO.Impl;

import com.ys.DAO.BaseDAO;
import com.ys.DAO.CourseDAO;
import com.ys.DAO.JDBCUtils;
import com.ys.bean.CopyCourse;
import com.ys.bean.Course;
import java.sql.Connection;
import java.util.List;

public class CourseDAOImpl extends BaseDAO<Course> implements CourseDAO {


    /*@Override
    public List<Course> getAll1(Integer page) {
        List<Course> list=executeQuery("select * from course limit ? , 5" , (page-1)*5);
        return list;
    }*/
    public List<Course> getAll(Integer page) {
        Connection conn =null;
        try {
            conn=JDBCUtils.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<Course> list = getForList(conn,"select * from course order by course_id asc limit ?, 5" , (page-1)*5) ;
        return list;
    }

    public List<Course> getAll(Connection conn){
        String sql = "select * from course";
        List<Course> list = getForList(conn,sql) ;
        return list;
    }
    @Override
    public Course getOne(Connection conn, String id) {
        String sql = "select * from course where course_id =?";
        Course course = load(sql,id);
        return course;
    }
    @Override
    public Long getCount() {
        Connection conn =null;
        try {
            conn=JDBCUtils.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String sql = "select count(*) from course";
        return getValue(conn, sql);
    }
    @Override
    public void insert(Connection conn, Course course) {
        String sql = "insert into course(course_id,course_name,teacher,point,time_1,time_2,location,limited,sum_person)values(?,?,?,?,?,?,?,?,?)";
        update(conn, sql,course.getCourse_id(),course.getCourse_name(),course.getTeacher(),course.getPoint(),course.getTime_1(),course.getTime_2(),course.getLocation(),course.getLimited(),course.getSum_person());
    }

    @Override
    public void update(Connection conn, Course course) {
        String sql = "update course set course_name = ?,teacher = ?,point = ?,time_1 = ?,time_2 = ?,location = ?,limited = ?,sum_person = ? where course_id = ?";
        update(conn, sql,course.getCourse_name(),course.getTeacher(),course.getPoint(),course.getTime_1(),course.getTime_2(),course.getLocation(),course.getLimited(),course.getSum_person(),course.getCourse_id());
    }
}
