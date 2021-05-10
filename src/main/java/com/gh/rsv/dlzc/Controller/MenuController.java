package com.gh.rsv.dlzc.Controller;

import com.alibaba.fastjson.JSON;
import com.gh.rsv.Dao.MenuDao;
import com.gh.rsv.bean.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuDao menuDao;

    @RequestMapping("/menus")
    public String getMenus(){
        HashMap<String,Object> menu = new HashMap<>();
        List<MainMenu> list = menuDao.getMainMennu();
        if(list!=null){
            menu.put("menu",list);
            menu.put("flag",200);
        }else{
            menu.put("flag",404);
        }
        String s = JSON.toJSONString(menu);
        return s;
    }

    @RequestMapping("/menusOfStudent")
    public String getMenusOfStudent(){
        HashMap<String,Object> menu = new HashMap<>();
        List<MainMenu> list = menuDao.getMainMennuOfStudent();
        if(list!=null){
            menu.put("menu",list);
            menu.put("flag",200);
        }else{
            menu.put("flag",404);
        }
        String s = JSON.toJSONString(menu);
        return s;
    }

    @RequestMapping("/menusOfTeacher")
    public String getMenusOfTeacher(){
        HashMap<String,Object> menu = new HashMap<>();
        List<MainMenu> list = menuDao.getMainMennuOfTeacher();
        if(list!=null){
            menu.put("menu",list);
            menu.put("flag",200);
        }else{
            menu.put("flag",404);
        }
        String s = JSON.toJSONString(menu);
        return s;
    }
}
