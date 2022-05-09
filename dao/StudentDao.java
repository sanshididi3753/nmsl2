package com.nmsl2.dao;

import com.nmsl2.bean.Student;
import java.util.ArrayList;

public interface StudentDao {

    /**
     * 保存学生对象
     * @param student
     */
    void save (Student student);

    /**
     * 删除指定学生
     * @param student
     */
    void delete(Student student);

    /**
     * 根据主键删除学生
     * @param id
     */
    void delete(String id);

    /**
     * 更新指定学生信息
     * @param id
     * @param student
     */
    void update(String id ,Student student);

    /**
     * 查询指定id学信息
     * @param id
     * @return
     */
    Student get(String id);

    /**
     * 查询所有学生信息
     * @return
     */
    ArrayList<Student> list();
}
