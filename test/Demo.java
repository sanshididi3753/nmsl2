package com.nmsl2.test;

import com.nmsl2.bean.Student;
import com.nmsl2.daoImpl.StudentDaoImpl;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Student> list = new StudentDaoImpl().list();
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }
}
