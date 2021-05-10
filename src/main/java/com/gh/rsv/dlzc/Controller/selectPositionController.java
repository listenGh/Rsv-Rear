package com.gh.rsv.dlzc.Controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gh.rsv.Dao.UserDao;
import com.gh.rsv.Dao.readRoomDao;
import com.gh.rsv.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class selectPositionController {

    private HashMap<String,String> mp = new HashMap<>();

    private void changeMp(){
        mp.put("16","00");mp.put("17","01");mp.put("18","02");mp.put("19","03");
        mp.put("20","04");mp.put("21","05");mp.put("22","06");mp.put("23","07");
        mp.put("00","08");mp.put("01","09");mp.put("02","10");mp.put("03","11");
        mp.put("04","12");mp.put("05","13");mp.put("06","14");mp.put("07","15");
        mp.put("08","16");mp.put("09","17");mp.put("10","18");mp.put("11","19");
        mp.put("12","20");mp.put("13","21");mp.put("14","22");mp.put("15","23");
    }

    @Autowired
    readRoomDao rRD;

    @RequestMapping("/kongYu")
    public String getKongYu(@RequestBody Map<String,Object> map){
        changeMp();
        String date = map.get("date").toString();
        date = changeDate(date);
        String room = map.get("room").toString();
        date = date.substring(0,10);
        String[] times = map.get("times").toString().split(",");
        String startTime = times[0].substring(12,20);
        String endTime = times[1].substring(12,20);

        String str = startTime.substring(0,2);
        String s = mp.get(str);
        startTime = startTime.substring(2);
        startTime = s+startTime;

        str = endTime.substring(0,2);
        s = mp.get(str);
        endTime = endTime.substring(2);
        endTime = s+endTime;

        boolean flags[] = new boolean[1001];
        //桌号为【1，n】,确定n
        readRoomInfo rRI = rRD.getNOfReadRoom(room);
        int n = rRI.getSum();
        //得到在[1,n]中要去除的桌号
        List<hasReserv> list = rRD.getListOfZH(room,date+" "+startTime,date+" "+endTime);
        for(hasReserv h:list) {
            flags[h.getNum()] = true;
        }
        List<CID> li = new ArrayList<CID>();
        for(int i=1;i<=n;i++){
            if(flags[i]!=true){
                CID cid = new CID();
                cid.setId(i);
                li.add(cid);
            }
        }

        HashMap<String,Object> res = new HashMap<>();

        res.put("listOfZH",li);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }

    /**
     * 占用座位
     * @param map
     * @return
     */
    @RequestMapping("/zyPosition")
    public String zyPosition(@RequestBody Map<String,Object> map){
        boolean flag = true;
        String date = map.get("date").toString();
        date = changeDate(date);
        System.out.println("map.num"+map.get("num"));
        String num = map.get("num").toString();
        String room = map.get("room").toString();
        String username = map.get("username").toString();
        date = date.substring(0,10);
        String[] times = map.get("times").toString().split(",");
        String startTime = times[0].substring(12,20);
        String endTime = times[1].substring(12,20);

        changeMp();

        String str = startTime.substring(0,2);
        String s = mp.get(str);
        startTime = startTime.substring(2);
        startTime = s+startTime;

        str = endTime.substring(0,2);
        s = mp.get(str);
        endTime = endTime.substring(2);
        endTime = s+endTime;

        startTime = date+" "+startTime;
        endTime = date+" "+endTime;

        //获取特定阅读室的信用积分标准
        String type = rRD.getTypeOfReadRoom(room);
        int standard = rRD.getStandardOfReadRoom(type);
        int credit = rRD.getCreditOfStudent(username);
        //比较信用积分，产生已占信息，更新positionInfo表
        int a,b;
        if(standard>credit){
            flag=false;
        }else{
            String ts = date+" "+startTime+"---"+date+" "+endTime;
            hasReserv hR = new hasReserv();
            hR.setNum(Integer.parseInt(num)).setReadRoom(room).setStartTime(startTime).setUsername(username).setEndTime(endTime);
            a =  rRD.insertHasReserv(hR);
            if(a>0){
            }else flag = false;
        }

        return flag?"success":"error";
    }

    private String changeDate(String date) {
        String d ="";
        String a = date.substring(5,7);
        String b = date.substring(8,10);
        int bb = Integer.parseInt(b);
        int aa = Integer.parseInt(a);

        if(bb!=31)bb+=1;
        else{
            bb=1;
            aa+=1;
        }

        if(bb>=1 && bb<=9){
            b = "0"+String.valueOf(bb);
        }else{
            b = String.valueOf(bb);
        }

        a = "0"+String.valueOf(aa);

        date = date.substring(0,5);
        date = date+a+"-"+b;

        return date;
    }


    /**
     * 获得阅览室信息
     * @return
     */
    @RequestMapping("/getReadRoom")
    public String getKongYu(){
        List<readRoomInfo> list  =  rRD.getAllReadRoomInfo();
        HashMap<String,Object> res = new HashMap<>();
        res.put("listOfReadRoomInfo",list);
        String res_json = JSON.toJSONString(res);
        return res_json;
    }

    //搜索全部已占记录
    @RequestMapping("/yZJL")
    public String getAllYZJL(){

        List<hasReserv> li = rRD.getListOfAllHasReserv();
        HashMap<String,Object> res = new HashMap<>();
        res.put("listOfZH",li);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }

    /**
     * 获取特定时间和阅览室的已占座位信息
     * @param map
     * @return
     */
    @RequestMapping("/searchYZ")
    public String getYZOfSTime(@RequestBody Map<String,Object> map){
        changeMp();
        String date = map.get("date").toString();
        date = changeDate(date);
        String room = map.get("room").toString();
        date = date.substring(0,10);
        String[] times = map.get("times").toString().split(",");
        String startTime = times[0].substring(12,20);
        String endTime = times[1].substring(12,20);

        String str = startTime.substring(0,2);
        String s = mp.get(str);
        startTime = startTime.substring(2);
        startTime = s+startTime;

        str = endTime.substring(0,2);
        s = mp.get(str);
        endTime = endTime.substring(2);
        endTime = s+endTime;

        startTime = date+" "+startTime;
        endTime = date+" "+endTime;


        List<hasReserv> li = rRD.getListOfSTHasReserv(room,startTime,endTime);
        HashMap<String,Object> res = new HashMap<>();
        res.put("listOfZH",li);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }

    /**
     * 获取并插入举报信息
     * @param
     * @return
     */
    @RequestMapping("/juB")
    public String juB(JBInfo jbInfo){
        Date d = new Date();
        String date = d.toString();
        System.out.println(jbInfo);
        int i = rRD.insertDeduction(jbInfo.getJBusername(),jbInfo.getBJBusername(),jbInfo.getContent(),date);
        return i>0?"success":"error";
    }

    /**
     * 获取个人的占位记录
     */
    @RequestMapping("/yZJLGR")
    public String getYZJLGR(@RequestBody Map<String,Object> map){
        String username = map.get("username").toString();
        List<hasReserv> li = rRD.getListOfGRHasReserv(username);
        HashMap<String,Object> res = new HashMap<>();
        res.put("listOfZH",li);
        String res_json = JSON.toJSONString(res);

        return res_json;
    }

    /**
     * 删除特定个人的占位记录
     */
    @RequestMapping("/cancel")
    public String deleteHasReserv(@RequestBody Map<String,Object> map){
        String id = map.get("id").toString();
        int i = rRD.deleteHasReserv(Integer.parseInt(id));
        return i>0?"success":"error";
    }

}
