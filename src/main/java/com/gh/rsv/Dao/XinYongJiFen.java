package com.gh.rsv.Dao;

import com.gh.rsv.bean.Deduction;
import com.gh.rsv.bean.Student;
import com.gh.rsv.bean.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XinYongJiFen {
    //获取全部的扣分信息
    public List<Deduction> getAllDeduction();
    //更新Dedution的kf,state
    public int updateDeduction(int id, int kf);
    //更新Stduents的credit
    public int updateStudents(String bjb, int kf);
    //情况为假，举报人受惩罚
    public int insertDeduction(String jb, String bjb, String date, String info, int kf, int state);
    //获取全部的学生信息
    public List<Student> getAllStudents();
    //获取某个学生的违章信息
    public List<Deduction> getSomeoneDeductions(String username);

    public List<Student> getOneStudent(String username);

    public List<Teacher> getOneTeacher(String username);
}
