package com.gh.rsv.dlzc.Controller;

import com.alibaba.fastjson.JSON;
import com.gh.rsv.Dao.XinYongJiFen;
import com.gh.rsv.bean.Deduction;
import com.gh.rsv.bean.Student;
import com.gh.rsv.bean.Teacher;
import com.gh.rsv.bean.hasReserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class XinYongJiFenController {
    @Autowired
    XinYongJiFen xinYongJiFenDao;


    /**
     * 获取全部违章信息
     */
    @RequestMapping("/getAllDeduction")
    public String getAllDeduction(){

        List<Deduction> li = xinYongJiFenDao.getAllDeduction();
        HashMap<String,Object> res = new HashMap<>();
        res.put("listOfDeduction",li);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }

    /**
     * 举报情况为真
     */
    @RequestMapping("/isTrue")
    public String isTrue(@RequestBody Map<String,Object> map){

        String k = map.get("kf").toString();
        int kf = Integer.parseInt(k);
        String ii = map.get("id").toString();
        int id = Integer.parseInt(ii);
        String  bjb= map.get("bJb").toString();

        int i = xinYongJiFenDao.updateDeduction(id,kf);
        int j = xinYongJiFenDao.updateStudents(bjb,kf);
        return (i>0 && j>0)?"success":"error";
    }
    /**
     * 举报情况为假
     */
    @RequestMapping("/isFalse")
    public String isFalse(@RequestBody Map<String,Object> map){

        String  jb= map.get("jb").toString();
        String  bjb= map.get("bjb").toString();

        int i = xinYongJiFenDao.insertDeduction(jb,bjb,new Date().toString(),"虚假举报",5,1);
        int j = xinYongJiFenDao.updateStudents(bjb,5);
        return (i>0 && j>0)?"success":"error";
    }

    /**
     * 获取全部学生的信息
     */
    @RequestMapping("/getAllStudents")
    public String getAllStudents(){

        List<Student> li = xinYongJiFenDao.getAllStudents();
        HashMap<String,Object> res = new HashMap<>();
        res.put("listOfStudents",li);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }

    /**
     * 获取一个学生的信息
     */
    @RequestMapping("/getOneStudent")
    public String getOneStudent(@RequestBody Map<String,Object> map){
        String username = map.get("username").toString();
        List<Student> li = xinYongJiFenDao.getOneStudent(username);
        HashMap<String,Object> res = new HashMap<>();
        res.put("listOfStudents",li);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }


    @RequestMapping("/getOneTeacher")
    public String getOneTeacher(@RequestBody Map<String,Object> map){
        String username = map.get("username").toString();
        List<Teacher> li = xinYongJiFenDao.getOneTeacher(username);
        HashMap<String,Object> res = new HashMap<>();
        res.put("listOfStudents",li);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }


    /**
     * 获取某个学生的违章信息
     */
    @RequestMapping("/getSomeoneDeductions")
    public String getSomeoneDeductions(@RequestBody Map<String,Object> map){
        String username = map.get("username").toString();
        List<Deduction> li = xinYongJiFenDao.getSomeoneDeductions(username);
        HashMap<String,Object> res = new HashMap<>();
        res.put("listOfDeduction",li);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }
}
