package com.ys.DAO.Impl;

import com.ys.DAO.BaseDAO;

import com.ys.DAO.CopyCourseDAO;
import com.ys.bean.CopyCourse;


import java.sql.Connection;
import java.util.List;

public class CopyCourseDAOImpl extends BaseDAO<CopyCourse> implements CopyCourseDAO {

    @Override
    public void insert(Connection conn, CopyCourse copyCourse) {
        String sql = "insert into course_copy(course_id,course_name,teacher,point,time_1,time_2,location,limited)values(?,?,?,?,?,?,?,?)";
        update(conn, sql,copyCourse.getCourse_id(),copyCourse.getCourse_name(),copyCourse.getTeacher(),copyCourse.getPoint(),copyCourse.getTime_1(),copyCourse.getTime_2(),copyCourse.getLocation(),copyCourse.getLimited());
    }


    @Override
    public void deleteById(Connection conn, String id) {
        String sql = "delete from course_copy where course_id = ?";
        update(conn, sql, id);
    }

    @Override
    public List<CopyCourse> getAll(Connection conn) {
        String sql = "select * from course_copy";
        List<CopyCourse> list = getForList(conn,sql) ;
        return list;
    }

    @Override
    public CopyCourse getOne(Connection conn, String id) {
        String sql = "select * from course_copy where course_id =?";
       CopyCourse copyCourse = load(sql,id);
        return copyCourse;
    }

    @Override
    public void updateSum(Connection conn,String id) {
      String sql = "update course set sum_person =sum_person+1 where course_id=?";
      update(conn,sql,id);
    }

    public void updateSum1(Connection conn,String id) {
        String sql = "update course set sum_person =sum_person-1 where course_id=?";
        update(conn,sql,id);
    }

}
