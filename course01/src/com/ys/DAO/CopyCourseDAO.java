package com.ys.DAO;

import com.ys.bean.CopyCourse;

import java.sql.Connection;
import java.util.List;

public interface CopyCourseDAO {
    void insert(Connection conn, CopyCourse copyCourse);
    void deleteById(Connection conn,String id);
    List<CopyCourse> getAll(Connection conn);
    CopyCourse getOne(Connection conn,String id);
    void updateSum(Connection conn,String id);
    void updateSum1(Connection conn,String id);
}
