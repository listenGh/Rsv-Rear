package com.gh.rsv.dlzc.Controller;

import com.gh.rsv.bean.MainMenu;
import com.gh.rsv.bean.SubMenu;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "Test My testController";
    }
}
