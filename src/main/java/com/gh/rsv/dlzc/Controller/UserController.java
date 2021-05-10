package com.gh.rsv.dlzc.Controller;

import com.alibaba.fastjson.JSON;
import com.gh.rsv.Dao.UserDao;
import com.gh.rsv.bean.QueryInfo;
import com.gh.rsv.bean.Student;
import com.gh.rsv.bean.Teacher;
import com.gh.rsv.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo){
        int num = userDao.getUserCounts(queryInfo.getQuery());
        List<User> users =  userDao.getAllUser(queryInfo.getQuery(),queryInfo.getPageNum(),queryInfo.getPageSize());
        HashMap<String,Object> res = new HashMap<>();
        res.put("number",num);
        res.put("data",users);

        String res_json = JSON.toJSONString(res);

        return res_json;
    }

    @RequestMapping("/updateUserState")
    public String updateUserState(User user){
        int i = userDao.updateState(user.getId(), user.getState());
        return i>0?"success":"error";
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        int i = userDao.addUser(user);
        String role = user.getRole();
        if(role.equals("Student")){
            Student student = new Student();
            student.setUsername(user.getUsername()).setCredit(100)
                    .setPassword(user.getPassword()).setRole("Student")
                    .setEmail(user.getEmail()).setSex("").setClasses("");
            userDao.insertStudent(student);
        }else if(role.equals("Teacher")){
            Teacher teacher = new Teacher();
            teacher.setUsername(user.getUsername()).
                    setPassword(user.getPassword()).
                    setRole("Teacher").
                    setEmail(user.getEmail()).setSex("").setXueYuan("");
            userDao.insertTeacher(teacher);
        }
        return i>0?"success":"error";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(User user){
        int i = userDao.deleteUser(user.getId());
        return i>0?"success":"error";
    }

    @RequestMapping("/getUserById")
    public String getUserById(User user){
        System.out.println("id=="+user.getId());
        User us = userDao.getUserById(user.getId());
        String res = JSON.toJSONString(us);
        return res;
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user){
        int i = userDao.updateUser(user.getId(),user.getPassword(),user.getEmail());
        return i>0?"success":"error";
    }

}
