package com.gh.rsv.Dao;

import com.gh.rsv.bean.Student;
import com.gh.rsv.bean.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiShengXinXiDao {
    //获取全部Student
    public List<Student> getAllStudent();
    //更新特定的Student
    public int updateStudent(String username, String sex, String classes);

    //获取全部Teacher
    public List<Teacher> getAllTeacher();
    //更新特定的Teacher
    public int updateTeacher(String username, String sex, String XueYuan);

    public int updateStudentPersonal(String username, String sex, String classes, String email, String password);

    public int updateTeacherPersonal(String username, String sex, String email, String password);
}
