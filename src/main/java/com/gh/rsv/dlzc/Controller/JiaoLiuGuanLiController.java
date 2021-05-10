package com.gh.rsv.dlzc.Controller;


import com.alibaba.fastjson.JSON;
import com.gh.rsv.Dao.JiaoLiuGuanliDao;
import com.gh.rsv.Dao.TongZhiGongGaoDao;
import com.gh.rsv.bean.infoCommunication;
import com.gh.rsv.bean.notiInfo;
import com.gh.rsv.bean.reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JiaoLiuGuanLiController {

        @Autowired
        JiaoLiuGuanliDao jiaoLiuGuanliDao;

        /**
         * 获取全部 InfoCommunication
         */
        @RequestMapping("/getAllInfoCommunication")
        public String getAllInfoCommunication(){

            List<infoCommunication> li = jiaoLiuGuanliDao.getAllInfoCommunication();
            HashMap<String,Object> res = new HashMap<>();
            res.put("listOfInfoCommunication",li);
            String res_json = JSON.toJSONString(res);
            return res_json;
        }

        /**
         * 获取特定 notiInfo
         */
        @RequestMapping("/getSomeoneReply")
        public String getSomeoneReply(@RequestBody Map<String,Object> map){
            String d = map.get("mid").toString();
            System.out.println("mid==="+d);
            int mid = Integer.parseInt(d);
            List<reply> ni = jiaoLiuGuanliDao.getSomeoneReply(mid);
            HashMap<String,Object> res = new HashMap<>();
            res.put("InfoCommunications",ni);
            String res_json = JSON.toJSONString(res);
            return res_json;
        }


        @RequestMapping("/addInfoCommunication")
        public String addInfoCommunication(@RequestBody Map<String,Object> map){
            String title = map.get("title").toString();
            String sendUsername = map.get("sendUsername").toString();
            String dates = new Date().toString();
            int i= jiaoLiuGuanliDao.addInfoCommunication(title,dates,sendUsername);
            return i>0?"success":"error";
        }

        @RequestMapping("/addReply")
        public String addReply(@RequestBody Map<String,Object> map){
            String d = map.get("mid").toString();
            int mid = Integer.parseInt(d);
            String content = map.get("content").toString();
            String replyUsername = map.get("replyUsername").toString();
            String dates = new Date().toString();
            int i= jiaoLiuGuanliDao.addReply(content,dates,replyUsername,mid);
            return i>0?"success":"error";
        }

    }
