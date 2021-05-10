package com.gh.rsv.dlzc.Controller;

import com.alibaba.fastjson.JSON;
import com.gh.rsv.Dao.ShiShengXinXiDao;
import com.gh.rsv.bean.ReadRoomClass;
import com.gh.rsv.bean.Student;
import com.gh.rsv.bean.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShiShengXinXiController {

    @Autowired
    ShiShengXinXiDao shiShengXinXiDao;

    /**
     * 获取全部 Student
     */
    @RequestMapping("/getAllStudent")
    public String getAllStudent(){

        List<Student> li = shiShengXinXiDao.getAllStudent();
        HashMap<String,Object> res = new HashMap<>();
        res.put("listOfStudents",li);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }



    @RequestMapping("/updateStudent")
    public String updateStudent(@RequestBody Map<String,Object> map){
        String username = map.get("username").toString();
        String sex = map.get("sex").toString();
        String classes = map.get("classes").toString();
        int i = shiShengXinXiDao.updateStudent(username,sex,classes);
        return i>0?"success":"error";
    }


    @RequestMapping("/updateStudentPersonal")
    public String updateStudentPersonal(@RequestBody Map<String,Object> map){
        String username = map.get("username").toString();
        String sex = map.get("sex").toString();
        String classes = map.get("classes").toString();
        String email = map.get("email").toString();
        String password = map.get("password").toString();
        int i = shiShengXinXiDao.updateStudentPersonal(username,sex,classes,email,password);
        return i>0?"success":"error";
    }


    @RequestMapping("/getAllTeacher")
    public String getAllTeacher(){

        List<Teacher> li = shiShengXinXiDao.getAllTeacher();
        for(Teacher t :li){
            System.out.println(t);
        }
        HashMap<String,Object> res = new HashMap<>();
        res.put("listOfTeachers",li);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }


    @RequestMapping("/updateTeacher")
    public String updateTeacher(@RequestBody Map<String,Object> map){
        String username = map.get("username").toString();
        String sex = map.get("sex").toString();
        String XueYuan = map.get("XueYuan").toString();
        int i = shiShengXinXiDao.updateTeacher(username,sex,XueYuan);
        return i>0?"success":"error";
    }

    @RequestMapping("/updateTeacherPersonal")
    public String updateTeacherPersonal(@RequestBody Map<String,Object> map){
        String username = map.get("username").toString();
        String sex = map.get("sex").toString();
//        String XueYuan = map.get("XueYuan").toString();
        String email = map.get("email").toString();
        String password = map.get("password").toString();
        int i = shiShengXinXiDao.updateTeacherPersonal(username,sex,email,password);
        return i>0?"success":"error";
    }

}
