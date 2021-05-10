package com.gh.rsv.dlzc.Controller;

import com.alibaba.fastjson.JSON;
import com.gh.rsv.Dao.TongZhiGongGaoDao;
import com.gh.rsv.bean.Student;
import com.gh.rsv.bean.notiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TongZhiGongGaoController {
    @Autowired
    TongZhiGongGaoDao tongZhiGongGaoDao;

    /**
     * 获取全部 notiInfo
     */
    @RequestMapping("/getAllNotiInfo")
    public String getAllNotiInfo(){

        List<notiInfo> li = tongZhiGongGaoDao.getAllNotiInfo();
        HashMap<String,Object> res = new HashMap<>();
        res.put("listOfnotiInfo",li);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }

    /**
     * 获取特定 notiInfo
     */
    @RequestMapping("/getSomeoneNotiInfo")
    public String getSomeoneNotiInfo(@RequestBody Map<String,Object> map){
        String d = map.get("id").toString();
        int id = Integer.parseInt(d);
        notiInfo ni = tongZhiGongGaoDao.getSomeoneNotiInfo(id);
        HashMap<String,Object> res = new HashMap<>();
        res.put("NotiInfo",ni);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }


    @RequestMapping("/addNoticeInfo")
    public String addNoticeInfo(@RequestBody Map<String,Object> map){
        String title = map.get("title").toString();
        String content = map.get("content").toString();
        String dates = new Date().toString();
        int i= tongZhiGongGaoDao.addNoticeInfo(title,dates,content);
        return i>0?"success":"error";
    }

}
