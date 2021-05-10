package com.gh.rsv.dlzc.Controller;

import com.alibaba.fastjson.JSON;
import com.gh.rsv.Dao.YueLanShiDao;
import com.gh.rsv.bean.Deduction;
import com.gh.rsv.bean.ReadRoomClass;
import com.gh.rsv.bean.readRoomInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class YueLanShiController {

    @Autowired
    YueLanShiDao yueLanShiDao;

    /**
     * 获取全部readRoomClass信息
     */
    @RequestMapping("/getAllReadClass")
    public String getAllReadClass(){

        List<ReadRoomClass> li = yueLanShiDao.getAllReadClass();
        HashMap<String,Object> res = new HashMap<>();
        res.put("listOfReadClass",li);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }

    /**
     * 新增 ReadRoomClass
     */
    @RequestMapping("/addReadRoomClass")
    public String addReadRoomClass(ReadRoomClass readRoomClass){
        int i = yueLanShiDao.addReadRoomClass(readRoomClass.getType(),readRoomClass.getLimit());
        return i>0?"success":"error";
    }

    /**
     * 获取全部ReadRoomInfo信息
     */
    @RequestMapping("/getAllReadRoomInfo")
    public String getAllReadRoomInfo(){
        List<ReadRoomClass> types = yueLanShiDao.getAllReadClass();
        List<readRoomInfo> li = yueLanShiDao.getAllreadRoomInfo();
        HashMap<String,Object> res = new HashMap<>();
        res.put("listOfReadRoomInfo",li);
        res.put("types",types);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }



    /**
     * 新增 ReadRoomInfo
     */
    @RequestMapping("/addReadRoomInfo")
    public String addReadRoomInfo(readRoomInfo rRI){
        int i = yueLanShiDao.addReadRoomInfo(rRI);
        int n = rRI.getSum();
        for(int j=1;j<=n;j++){
            yueLanShiDao.addpositionInfo(j,rRI.getName());
        }
        return i>0?"success":"error";
    }
}
