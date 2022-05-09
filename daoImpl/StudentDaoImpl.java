package com.nmsl2.daoImpl;

import com.nmsl2.bean.Student;
import com.nmsl2.connection.JDBCUtils;
import com.nmsl2.dao.StudentDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void save(Student student) {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO stu_student(id,name,sex,date,classnum) VALUES ("+student.getId()+",'"+student.getName()+"',"+student.getSex()+",'"+student.getDate()+",'"+student.getClassnum()+")";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        }catch (SQLException throwables){
            throwables.getStackTrace();
        }finally {
            JDBCUtils.close(stmt,conn);
        }

    }

    @Override
    public void delete(Student student) {
        delete(student.getId());
    }

    @Override
    public void delete(String id) {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "DELETE FROM stu_student WHERE id="+id;
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        }catch (SQLException throwables){
            throwables.getStackTrace();
        }finally {
            JDBCUtils.close(stmt,conn);
        }
    }

    @Override
    public void update(String id, Student student) {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "UPDATE stu_student SET name='"+student.getName()+"',sex='"+student.getSex()+"',date='"+student.getDate()+"',classnum="+student.getClassnum()+"WHERE id="+student.getId();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }catch (SQLException throwables){
            throwables.getStackTrace();
        }finally {
            JDBCUtils.close(stmt,conn);
        }
    }

    @Override
    public Student get(String id) {
        Connection conn = null;
        Statement stmt = null;
        Student student = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM stu_student WHERE id="+id;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getString("id").trim());
                student.setName(rs.getString("name").trim());
                student.setSex(rs.getString("sex").trim());
                student.setDate(rs.getString("date").trim());
                student.setClassnum(rs.getInt("classnum"));
            }
        }catch (SQLException throwables){
            throwables.getStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return student;
    }

    @Override
    public ArrayList<Student> list() {
        ArrayList<Student> list = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM stu_student";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("id").trim());
                student.setName(rs.getString("name").trim());
                student.setSex(rs.getString("sex").trim());
                student.setDate(rs.getString("date").trim());
                student.setClassnum(rs.getInt("classnum"));
                list.add(student);
            }
        }catch (SQLException throwables){
            throwables.getStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }
}
